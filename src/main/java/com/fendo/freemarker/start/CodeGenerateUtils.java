package com.fendo.freemarker.start;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.fendo.freemarker.util.ColumnClass;
import com.fendo.freemarker.util.DataSourceUtils;
import com.fendo.freemarker.util.FreeMarkerTemplateUtils;

import freemarker.template.Template;

/**   
 * @Title: Snippet.java 
 * @Package com.fendo.Generate 
 * @Description: TODO
 * @author fendo
 * @date 2017年12月2日 下午10:40:54 
 * @version V1.0   
*/

public class CodeGenerateUtils {

    private final String AUTHOR = "fendo";  //作者
    SimpleDateFormat dateformat2=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");   
    private final String CURRENT_DATE = dateformat2.format(new Date()); //创建时间
    private final String tableName = "test";					//表名
    private final String packageName = "com.fendo";            //包名
    private final String tableAnnotation = "质量问题";           //表注释
    private final String diskPath = "D://generator/";          //生成代码地址
    private final String changeTableName = replaceUnderLineAndUpperCase(tableName); //更改表名
    private Connection connection;
    
    public static void main(String[] args) throws Exception{
        CodeGenerateUtils codeGenerateUtils = new CodeGenerateUtils();
        codeGenerateUtils.generate();
    }
   
    public void generate() throws Exception{
    	connection = DataSourceUtils.getConnection();//获取连接
    	DatabaseMetaData databaseMetaData = connection.getMetaData();//获取元数据
    	ResultSet resultSet = databaseMetaData.getColumns(null,"%", tableName,"%");//获取表数据
    	
    	 //生成Mapper文件
        generateMapperFile(resultSet);
        
        
        //生成Dao文件
        //generateDaoFile(resultSet);
        
        //生成Repository文件
//        generateRepositoryFile(resultSet);
        
        //生成服务层接口文件
        //generateServiceInterfaceFile(resultSet);
        
        //生成Controller层文件
        generateControllerFile(resultSet);
        
        //生成DTO文件
//        generateDTOFile(resultSet);
        
        
        //生成Model文件
        generateModelFile(resultSet);
        
        DataSourceUtils.closeConn(connection);
    }
    
    
    
    

    
    
    /**
     * 
     *@Title generateMapperFile 
     *@Description: 生成Mapper文件
     *@Author fendo
     *@Date 2017年12月2日 下午11:04:41
     *@param resultSet
     *@throws Exception
     *@throws
     */
    private void generateMapperFile(ResultSet resultSet) throws Exception{
        final String suffix = "Mapper.xml";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Mapper.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }
    
    /**
     * 
     *@Title generateDaoFile 
     *@Description: 生成Dao文件
     *@Author fendo
     *@Date 2017年12月2日 下午11:04:31
     *@param resultSet
     *@throws Exception
     *@throws
     */
    private void generateDaoFile(ResultSet resultSet) throws Exception{
        final String suffix = "DAO.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "DAO.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }
    
    /**
     * 
     *@Title generateRepositoryFile 
     *@Description: 生成Repository文件
     *@Author fendo
     *@Date 2017年12月2日 下午11:05:36
     *@param resultSet
     *@throws Exception
     *@throws
     */
    private void generateRepositoryFile(ResultSet resultSet) throws Exception{
        final String suffix = "Repository.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Repository.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }
    
    /**
     * 
     *@Title generateControllerFile 
     *@Description: 生成Controller层文件
     *@Author fendo
     *@Date 2017年12月2日 下午11:07:07
     *@param resultSet
     *@throws Exception
     *@throws
     */
    private void generateControllerFile(ResultSet resultSet) throws Exception{
        final String suffix = "Controller.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Controller.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }
    
    
    /**
     * 
     *@Title generateDTOFile 
     *@Description: 生成DTO文件
     *@Author fendo
     *@Date 2017年12月2日 下午11:07:54
     *@param resultSet
     *@throws Exception
     *@throws
     */
    private void generateDTOFile(ResultSet resultSet) throws Exception{
        final String suffix = "DTO.java";
        //final String path = "D://" + changeTableName + suffix;
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "DTO.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }
    
    /**
     * 
     *@Title generateModelFile 
     *@Description: 生成Model文件
     *@Author fendo
     *@Date 2017年12月2日 下午11:08:28
     *@param resultSet
     *@throws Exception
     *@throws
     */
    private void generateModelFile(ResultSet resultSet) throws Exception{

        final String suffix = ".java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Model.ftl";
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass = null;
        while(resultSet.next()){
            //id字段略过
            if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            columnClass.setChangeColumnName(replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            columnClassList.add(columnClass);
        }
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("model_column",columnClassList);
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }
    
    /**
     * 
     *@Title generateServiceInterfaceFile 
     *@Description: 生成服务层接口文件
     *@Author fendo
     *@Date 2017年12月2日 下午11:06:20
     *@param resultSet
     *@throws Exception
     *@throws
     */
    private void generateServiceInterfaceFile(ResultSet resultSet) throws Exception{
        final String prefix = "I";
        final String suffix = "Service.java";
        final String path = diskPath + prefix + changeTableName + suffix;
        final String templateName = "ServiceInterface.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }
    
    
    private void generateFileByTemplate(final String templateName,File file,Map<String,Object> dataMap) throws Exception{
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small",tableName);
        dataMap.put("table_name",changeTableName);
        dataMap.put("author",AUTHOR);
        dataMap.put("date",CURRENT_DATE);
        dataMap.put("package_name",packageName);
        dataMap.put("table_annotation",tableAnnotation);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);
    }
    
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
}
