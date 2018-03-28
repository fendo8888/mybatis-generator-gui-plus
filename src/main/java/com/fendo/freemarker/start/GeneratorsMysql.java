package com.fendo.freemarker.start;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fendo.freemarker.base.Column;
import com.fendo.freemarker.base.Constants;
import com.fendo.freemarker.util.DataSourceUtils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import oracle.jdbc.driver.OracleConnection;  

/**   
 * @Title: Generator.java 
 * @Package com.fendo.Generate 
 * @Description: TODO
 * @author fendo
 * @date 2017年12月3日 下午1:25:01 
 * @version V1.0   
*/
public class GeneratorsMysql {

    private Configuration cfg;  
    private Connection connection;  
    

    private void initial() {  
        try {  
            if (null == cfg) {  
                cfg = new Configuration();  
            }  
            cfg.setDirectoryForTemplateLoading(new File(  
                    "src/main/java/com/fendo/ftl"));  
           
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        cfg.setObjectWrapper(new DefaultObjectWrapper());  
    }  
	

    
    
    private List<Map<String, Object>> generatorTemplateData(String table) throws Exception { 
    	connection = DataSourceUtils.getConnection();  
        DatabaseMetaData dbmd = connection.getMetaData();  
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();  
        String[] tables = { "Table" };  
        if(!StringUtils.isNotBlank(table)){
        	table="%";
        }
        ResultSet tableSet = dbmd.getTables(null, null, table, tables);// 
        String priKeyName="";
        Column columnPri = null;  
        while (tableSet.next()) {  
            Map<String, Object> map = new HashMap<String, Object>();  
            String tableName = tableSet.getString("TABLE_NAME");
            String tableRemark=tableSet.getString("REMARKS"); 
            ResultSet columnSet = dbmd.getColumns(null, "%", tableName, "%");  
            ResultSet primaryKeySet=dbmd.getPrimaryKeys(null, null, tableName);
            if (primaryKeySet.next()) {
            	columnPri=new Column();
            	priKeyName = primaryKeySet.getString("COLUMN_NAME");
            	columnPri.setColumnName(priKeyName);
    			String attributeName = handlerColumnName(priKeyName);;
    			columnPri.setAttributeName(attributeName);
    		}
            List<Column> columns = new ArrayList<Column>();//   
            while (columnSet.next()) {  
                String columnName = columnSet.getString("COLUMN_NAME");  
                String attributeName = handlerColumnName(columnSet.getString("COLUMN_NAME"));  
                String columnType = columnSet.getString("TYPE_NAME");  
                int columnDataType=columnSet.getInt("DATA_TYPE");
                String attributeType = handlerColumnType(columnSet.getString("TYPE_NAME"));
                String columnRemark=columnSet.getString("REMARKS");
                /** 
                 * 指示此列是否是自动递增 
                 * 是---如果该列是自动递增 
                 * 无---如果不是自动递增列 
                 * 空字串---如果不能确定它是否 
                 * 列是自动递增的参数是未知 
                 */  
                String autoIncrement=columnSet.getString("IS_AUTOINCREMENT"); 
                Column column = new Column();  
                column.setJdbcType(getJDBCType(columnDataType));
                column.setComment(columnRemark);
                if(priKeyName.equals(columnName)){
                	columnPri.setColumnType(columnType);
                	columnPri.setAttributeType(attributeType);
                	columnPri.setJdbcType(getJDBCType(columnDataType));
                	columnPri.setFullAttributeType(getFullDataType(columnDataType));
                	column.setPrimaryKey(true);
                    column.setAutoIncrement(true);
                }else{
                	column.setPrimaryKey(false);
                    column.setAutoIncrement(false);
                }
                
                column.setColumnName(columnName);  
                column.setColumnType(columnType);  
                column.setAttributeName(attributeName);  
                column.setAttributeType(attributeType); 
                column.setFullAttributeType(getFullDataType(columnDataType));
                columns.add(column);  
            } 
            map.put("basePackage", Constants.packagePath);
            map.put("modelPackage", Constants.packagePath+".model");
            map.put("daoPackage", Constants.packagePath+".dao");
            map.put("servicePackage", Constants.packagePath+".service");
            map.put("tableName", tableName);  
            map.put("tableRemark", tableRemark);
            map.put("beanName", handlerTableName(tableName));  
            map.put("columns", columns);
            if(columnPri!=null)
            map.put("primKey", columnPri);
            map.put("deleteFlag", Constants.deleteFlag);
            lists.add(map);  
        }  
       // connection.close(); 
        
        return lists;  
    }  
    
    
    public static String handlerColumnName(String oldName) {  
        String[] arrays = oldName.split("_");  
        String newName = "";  
        if (arrays.length > 0) {  
            newName = arrays[0];  
        }  
        for (int i = 1; i < arrays.length; i++) {  
            newName += (arrays[i].substring(0, 1).toUpperCase() + arrays[i]  
                    .substring(1, arrays[i].length()));  
        }  
        return newName;  
    }  
  
    public static String handlerTableName(String oldName) {  
        String[] arrays = oldName.split("_");  
        String newName = "";  
        for (int i = 0; i < arrays.length; i++) {  
            newName += (arrays[i].substring(0, 1).toUpperCase() + arrays[i]  
                    .substring(1, arrays[i].length()));  
        }  
        return newName;  
    } 
    
    public static String handlerColumnType(String oldType) {  
        if (oldType.toUpperCase().startsWith("VARCHAR")) {  
            return "String";  
        }  
        if (oldType.toUpperCase().startsWith("INT")) {  
            return "int";  
        }  
        if (oldType.toUpperCase().startsWith("DATETIME")) {  
            return "Date";  
        }if (oldType.toUpperCase().startsWith("CHAR")) {  
            return "String";  
        }  
        if (oldType.toUpperCase().startsWith("TINYINT")) {  
            return "int";  
        }  
        if (oldType.toUpperCase().startsWith("BIT")) {  
            return "int";  
        }  
        if (oldType.toUpperCase().startsWith("BIGINT")) {  
            return "Long";  
        }  
        return oldType;  
    }  
	
	public static String getDataType(int iDataType) {
		String dataType = "";
		if (iDataType == Types.VARCHAR || iDataType == Types.CHAR || iDataType == Types.LONGVARCHAR || iDataType == Types.CLOB) {
			dataType = "String";
		} else if (iDataType == Types.INTEGER || iDataType == Types.BIT || iDataType == Types.TINYINT || iDataType == Types.SMALLINT
				|| iDataType == Types.SMALLINT) {
			dataType = "Integer";
		} else if (iDataType == Types.BIGINT) {
			dataType = "Long";
		} else if (iDataType == Types.DOUBLE || iDataType == Types.FLOAT || iDataType == Types.REAL) {
			dataType = "Double";
		} else if (iDataType == Types.DECIMAL || iDataType == Types.NUMERIC) {
			dataType = "BigDecimal";
		} else if (iDataType == Types.DATE || iDataType == Types.TIMESTAMP || iDataType == Types.TIME) {
			dataType = "Date";
		} else if (iDataType == Types.BLOB || iDataType == Types.BINARY || iDataType == Types.VARBINARY || iDataType == Types.LONGVARBINARY) {
			dataType = "byte[]";
		}
		return dataType;
	}
	
	
	/**
	 * 数据库类型转Java类型
	 */
	public static String getFullDataType(int iDataType) {
		String dataType = "";
		if (iDataType == Types.VARCHAR || iDataType == Types.NVARCHAR || iDataType == Types.CHAR || iDataType == Types.LONGVARCHAR || iDataType == Types.CLOB) {
			dataType = "java.lang.String";
		} else if (iDataType == Types.INTEGER || iDataType == Types.BIT || iDataType == Types.TINYINT || iDataType == Types.SMALLINT
				|| iDataType == Types.SMALLINT) {
			dataType = "java.lang.Integer";
		} else if (iDataType == Types.BIGINT) {
			dataType = "java.lang.Long";
		} else if (iDataType == Types.DOUBLE || iDataType == Types.FLOAT || iDataType == Types.REAL) {
			dataType = "java.lang.Double";
		} else if (iDataType == Types.DECIMAL || iDataType == Types.NUMERIC) {
			dataType = "java.math.BigDecimal";
		} else if (iDataType == Types.DATE || iDataType == Types.TIMESTAMP || iDataType == Types.TIME) {
			dataType = "java.util.Date";
		} else if (iDataType == Types.BLOB || iDataType == Types.BINARY || iDataType == Types.VARBINARY || iDataType == Types.LONGVARBINARY) {
			dataType = "java.lang.Byte";
		}
		return dataType;
	}

	/**
	 * 数据库类型转JDBC类型
	 */
	public static String getJDBCType(int iDataType) {
		String jdbcType = "";
		if (iDataType == Types.VARCHAR) {
			jdbcType = "VARCHAR";
		} else if (iDataType == Types.NVARCHAR) {
			jdbcType = "NVARCHAR";
		} else if (iDataType == Types.CHAR) {
			jdbcType = "CHAR";
		} else if (iDataType == Types.LONGVARCHAR) {
			jdbcType = "LONGVARCHAR";
		} else if (iDataType == Types.CLOB) {
			jdbcType = "CLOB";
		} else if (iDataType == Types.INTEGER) {
			jdbcType = "INTEGER";
		} else if (iDataType == Types.BIT) {
			jdbcType = "BIT";
		} else if (iDataType == Types.TINYINT) {
			jdbcType = "TINYINT";
		} else if (iDataType == Types.SMALLINT) {
			jdbcType = "SMALLINT";
		} else if (iDataType == Types.BIGINT) {
			jdbcType = "BIGINT";
		} else if (iDataType == Types.DOUBLE) {
			jdbcType = "DOUBLE";
		} else if (iDataType == Types.DECIMAL) {
			jdbcType = "DECIMAL";
		} else if (iDataType == Types.FLOAT) {
			jdbcType = "FLOAT";
		} else if (iDataType == Types.REAL) {
			jdbcType = "REAL";
		} else if (iDataType == Types.NUMERIC) {
			jdbcType = "NUMERIC";
		} else if (iDataType == Types.DATE) {
			jdbcType = "DATE";
		} else if (iDataType == Types.TIMESTAMP) {
			jdbcType = "TIMESTAMP";
		} else if (iDataType == Types.TIME) {
			jdbcType = "TIME";
		} else if (iDataType == Types.BLOB) {
			jdbcType = "BLOB";
		} else if (iDataType == Types.BINARY) {
			jdbcType = "BINARY";
		} else if (iDataType == Types.VARBINARY) {
			jdbcType = "VARBINARY";
		} else if (iDataType == Types.LONGVARBINARY) {
			jdbcType = "LONGVARBINARY";
		}
		return jdbcType;
	}
	
	
	
    private void  buildFile(String dir,String path,Template t,Object o){
 	    File dirPath = new File(dir);  
        if (!dirPath.exists())  
        {  
     	   dirPath.mkdirs();  
        } 
        File filePath=new File(dir+path);
        System.out.println("生成文件:"+dir+path);
        try {
			Writer sqlWriter = new FileWriter(filePath);
			try {
				t.process(o, sqlWriter);
				   sqlWriter.close(); 
			} catch (TemplateException e) {
				e.printStackTrace();
			}    
	     
		} catch (IOException e) {
			e.printStackTrace();
		} 
 }
    
    
    public void generatestart() throws Exception{
    	initial();  
        cfg.setDefaultEncoding("utf-8");  
        Template entityTemplate = cfg.getTemplate("entity.ftl");  
        Template sqlTemplate = cfg.getTemplate("xml.ftl");  
        Template daoTemplate = cfg.getTemplate("dao.ftl");  
        Template serviceTemplate = cfg.getTemplate("service.ftl"); 
        List<Map<String, Object>> templates=new ArrayList<Map<String,Object>>();
        if(Constants.tables!=null&&Constants.tables.length>0){
        	for(String table:Constants.tables){
        		templates.addAll(generatorTemplateData(table));
        	}
        }else{
        	templates = generatorTemplateData("");
        } 
        connection.close(); 
        for (Map<String, Object> o : templates) {  
        	buildFile(Constants.srcFile + (Constants.packagePath+".model").replaceAll("\\.", "\\/") + "/",o.get("beanName") + ".java",entityTemplate,o);
        	buildFile(Constants.srcFile + (Constants.packagePath+".dao").replaceAll("\\.", "\\/") + "/",o.get("beanName") + "Dao.java",daoTemplate,o);
        	buildFile(Constants.srcFile + (Constants.packagePath+".service").replaceAll("\\.", "\\/") + "/",o.get("beanName") + "Service.java",serviceTemplate,o);
            buildFile(Constants.srcFile + (Constants.packagePath).replaceAll("\\.", "\\/") + "/",o.get("beanName") + "Mapper.xml",sqlTemplate,o);
        }  
    }

    
    public static void main(String args[]) throws Exception{
    	GeneratorsMysql generator = new GeneratorsMysql();
    	generator.generatestart();
    }
    
}
