package com.fendo.freemarker.start;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fendo.freemarker.base.Column;
import com.fendo.freemarker.util.JdbcUtil;

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
public class GeneratorsOracle {

    private Configuration cfg;  
    private Connection connection;  
	public static String srcFile = "D:\\gencode\\";
	public static String packagePath = "com.gz.medicine.yun.doctor";
	public static String author = "fendo";
    SimpleDateFormat dateformat2=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");   
    private final String current_date = dateformat2.format(new Date()); //创建时间
	/**
	 *  true:物理删除 false:逻辑删除
	 */
	public static boolean deleteFlag = false;
    public static String[] tables = {"DIAGNOSIS_RECORDS"};   //需要生成的表
    public static String[] tablesConversion = {"DiagnosisRecords"};   //生成的文件
    
    private void initial() {  
        try {  
            if (null == cfg) {  
                cfg = new Configuration();  
            }  
            cfg.setDirectoryForTemplateLoading(new File(  
                    "src/main/java/com/fendo/freemarker/ftl")); 
            // 编码设置1  
            cfg.setDefaultEncoding("UTF-8");
           
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        cfg.setObjectWrapper(new DefaultObjectWrapper());  
    }  
	

    
    
    private List<Map<String, Object>> generatorTemplateData(String table,int index) throws Exception { 
    	/**
    	 * 获取数据库连接
    	 */
    	connection = JdbcUtil.getConnection();
        /** 
         * 设置连接属性,使得可获取到表的REMARK(备注) 
         */  
        ((OracleConnection)connection).setRemarksReporting(true);  
        DatabaseMetaData dbmd = connection.getMetaData();  
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();  
        String[] tables = { "TABLE" };  
        if(!StringUtils.isNotBlank(table)){
        	table="%";
        }
        
        /**获取表信息**/
        ResultSet tableSet = dbmd.getTables(null, null, table, tables);// 
        String priKeyName="";     //主键名称
        Column columnPri = null;  //数据库表元数据
        while (tableSet.next()) {  
            Map<String, Object> map = new HashMap<String, Object>();  
            String tableName = tableSet.getString("TABLE_NAME");  //表名称
            String tableRemark=tableSet.getString("REMARKS");     //注释
            String tableType = tableSet.getString("TABLE_TYPE");  //表类型    
            System.out.println(tableName + " - " + tableType + " - " + tableRemark);    
            
            /**获取表字段**/
            ResultSet columnSet = dbmd.getColumns(null, "%", tableName, "%"); 
            /**获取表主键**/
            ResultSet primaryKeySet=dbmd.getPrimaryKeys(null, null, tableName);
            /**遍历表主键**/
            if (primaryKeySet.next()) {
            	columnPri=new Column();
                String columnName = primaryKeySet.getString("COLUMN_NAME");//列名 
                short keySeq = primaryKeySet.getShort("KEY_SEQ");//序列号(主键内值1表示第一列的主键，值2代表主键内的第二列)    
                priKeyName = primaryKeySet.getString("COLUMN_NAME"); //主键名称
            	columnPri.setColumnName(priKeyName);  //数据库字段名称
    			String attributeName = handlerColumnName(priKeyName); //处理表列名
    			columnPri.setAttributeName(attributeName);
                System.out.println(tableName + " - " + columnName + " - "  
                        + keySeq + " - " + priKeyName + " - " + keySeq);   
    		}
            List<Column> columns = new ArrayList<Column>();//  
            /**遍历字段集合**/
            while (columnSet.next()) {  
                String columnName = columnSet.getString("COLUMN_NAME");      //数据库字段名称
                String attributeName = handlerColumnName(columnSet.getString("COLUMN_NAME"));    
                String columnType = handerColumnType(columnSet.getString("TYPE_NAME"));       //数据库字段类型
                int columnDataType=columnSet.getInt("DATA_TYPE");
                String attributeType = handlerColumnType(columnSet.getString("TYPE_NAME"));  //数据库类型转JAVA类型
                System.out.println("数据库类型转JAVA类型: " + columnSet.getString("TYPE_NAME") + "----" +attributeType);
                String columnRemark=columnSet.getString("REMARKS"); //注释
                Column column = new Column();  
                String jdbctypes = getJDBCType(columnDataType);
                System.out.println("数据库类型转JDBC类型" + jdbctypes);
                column.setJdbcType(jdbctypes);  //类型转换
                column.setComment(columnRemark);   //注释
                System.out.println("columnDataType : " + columnDataType + " - " + jdbctypes);
                if(priKeyName.equals(columnName)){  //判断当前的字段是否是主键
                	columnPri.setColumnType(columnType);
                	columnPri.setAttributeType(attributeType);
                	columnPri.setJdbcType(jdbctypes);
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
            map.put("author", author);
            map.put("date", current_date);
            map.put("basePackage", packagePath);
            map.put("modelPackage", packagePath+".bean");
            map.put("daoPackage", packagePath+".mapper");
            map.put("servicePackage", packagePath+".service");
            map.put("serviceimplPackage", packagePath+".serviceImpl");
            map.put("controllerPackage", packagePath+".controller");
            map.put("tableName", tablesConversion[index]);  
            map.put("tableRemark", tableRemark);
            //map.put("beanName", handlerTableName(tableName));  
            map.put("beanName", tablesConversion[index]);  
            map.put("columns", columns);
            if(columnPri!=null)
            map.put("primKey", columnPri);
            map.put("deleteFlag", deleteFlag);
            lists.add(map);  
        }  
        connection.close(); 
        
        return lists;  
    }  
    
    
    
    
    /**
     * 
     *@Title handerColumnType 
     *@Description: 处理字段类型,如果是varchar2转换成varchar
     *@Author fendo
     *@Date 2017年12月3日 下午9:33:11
     *@param columnType
     *@return
     *@throws
     */
    public static String handerColumnType(String columnType) {
       if("VARCHAR2".equals(columnType)) {
    	   return "VARCHAR";
       }
       return columnType;	
    }
    
    /**
     * 
     *@Title handlerColumnName 
     *@Description: 处理表列名
     *@Author fendo
     *@Date 2017年12月3日 下午2:35:06
     *@param oldName
     *@return
     *@throws
     */
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
  
    
    /**
     * 
     *@Title handlerTableName 
     *@Description: 数据库表名处理
     *@Author fendo
     *@Date 2017年12月3日 下午7:54:39
     *@param oldName
     *@return
     *@throws
     */
    public static String handlerTableName(String oldName) {  
        String[] arrays = oldName.split("_");  
        String newName = "";  
        for (int i = 0; i < arrays.length; i++) {  
            newName += (arrays[i].substring(0, 1).toUpperCase() + arrays[i]  
                    .substring(1, arrays[i].length()));  
        }  
        return newName;  
    } 

    
    /**
     * 
     *@Title handlerColumnType 
     *@Description: 数据库字段类型处理(数据库类型转JAVA类型)
     *@Author fendo
     *@Date 2017年12月3日 下午7:55:01
     *@param oldType
     *@return
     *@throws
     */
    public static String handlerColumnType(String oldType) {  
        if (oldType.toUpperCase().startsWith("VARCHAR")) {  
            return "String";  
        }  
        if (oldType.toUpperCase().startsWith("INT")) {  
            return "int";  
        }if (oldType.toUpperCase().startsWith("DATETIME")) {  
            return "Date";  
        }if (oldType.toUpperCase().startsWith("DATE")) {  
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
        if (oldType.toUpperCase().startsWith("NUMBER")) {  
            return "BigDecimal";  
        }  
        return oldType;  
    }  
	
    
    /**
     * 
     *@Title getDataType 
     *@Description: 数据库类型转Java类型
     *@Author fendo
     *@Date 2017年12月3日 下午7:55:18
     *@param iDataType
     *@return
     *@throws
     */
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
	
	/**
	 * 
	 *@Title replaceUnderLineAndUpperCase 
	 *@Description: 转换字段名称，如 sys_name 变成 SysName
	 *@Author fendo
	 *@Date 2017年12月3日 下午6:15:53
	 *@param str
	 *@return
	 *@throws
	 */
    public String replaceUnderLineAndUpperCase(String str){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while(count!=0){
            int num = sb.indexOf("_",count);
            count = num + 1;
            if(num != -1){
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count , count + 1,ia + "");
            }
        }
        String result = sb.toString().replaceAll("_","");
        return StringUtils.capitalize(result);
    }
	
    
    /**
     * 
     *@Title buildFile 
     *@Description: 开始生成文件
     *@Author fendo
     *@Date 2017年12月3日 下午7:55:51
     *@param dir
     *@param path
     *@param t
     *@param o
     *@throws
     */
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
        
        /**实体类模板**/
        Template entityTemplate = cfg.getTemplate("bean.ftl");
        
        /**mapper.xml模板**/
        Template sqlTemplate = cfg.getTemplate("xml.ftl");
        
        /**mapper模板**/
        Template daoTemplate = cfg.getTemplate("mapper.ftl");  
        
        /**service模板**/
        Template serviceTemplate = cfg.getTemplate("service.ftl"); 
        
        /**serviceimpl模板**/
        Template serviceimplTemplate = cfg.getTemplate("serviceimp.ftl"); 
        
        /**Controller模板**/
        Template controllerTemplate = cfg.getTemplate("controller.ftl"); 
        
        
        List<Map<String, Object>> templates=new ArrayList<Map<String,Object>>();
        if(tables!=null&&tables.length>0){
        	
        	for (int i = 0; i < tables.length; i++) {
        		templates.addAll(generatorTemplateData(tables[i],i));
			}
        	

        }else{
        	templates = generatorTemplateData("",0);
        } 
        connection.close(); 
        for (Map<String, Object> o : templates) { 
        	String className = replaceUnderLineAndUpperCase(o.get("beanName").toString());
        	System.out.println(className);
        	buildFile(srcFile + (packagePath+".bean").replaceAll("\\.", "\\/") + "/",className + ".java",entityTemplate,o);
        	buildFile(srcFile + (packagePath+".mapper").replaceAll("\\.", "\\/") + "/",className + "Mapper.java",daoTemplate,o);
        	buildFile(srcFile + (packagePath+".service").replaceAll("\\.", "\\/") + "/",className + "Service.java",serviceTemplate,o);
            buildFile(srcFile + (packagePath+".service.impl").replaceAll("\\.", "\\/") + "/",className + "ServiceImpl.java",serviceimplTemplate,o);
            buildFile(srcFile + (packagePath+".mapper").replaceAll("\\.", "\\/") + "/",className + "Mapper.xml",sqlTemplate,o);
            buildFile(srcFile + (packagePath+".controller").replaceAll("\\.", "\\/") + "/",className + "Controller.java",controllerTemplate,o);
        }  
    }

    
    public static void main(String args[]) throws Exception{
    	GeneratorsOracle generator = new GeneratorsOracle();
    	generator.generatestart();
    }
    
}
