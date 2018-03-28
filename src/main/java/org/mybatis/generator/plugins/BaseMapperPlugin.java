package org.mybatis.generator.plugins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.JavaFormatter;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * 
 * @title: BaseMapperPlugin.java   
 * @package org.mybatis.generator.plugins   
 * @description: BaseMapper插件  
 * @author: fendo  
 * @date: 2018年2月25日 下午8:38:49   
 * @version: V1.0
 */
public class BaseMapperPlugin extends PluginAdapter{

	private String superClass;
    private String mapperTargetDir;  
    private String mapperTargetPackage;
    // 扩展  
    private String expandMapperTargetPackage;  
    private String expandMapperSuperClass; 
    
    private ShellCallback shellCallback = null;  
    
    
    public BaseMapperPlugin() {  
        shellCallback = new DefaultShellCallback(false);  
    }  
    
	@Override
	public boolean validate(List<String> warnings) {
		superClass = this.properties.getProperty("superClass");
		mapperTargetDir = properties.getProperty("targetProject");  
		mapperTargetPackage = properties.getProperty("targetPackage");
		expandMapperTargetPackage = properties.getProperty("expandTargetPackage");  
		expandMapperSuperClass = properties.getProperty("expandDaoSuperClass");  
		
		boolean superClassValid = StringUtility.stringHasValue(superClass);
		boolean mapperTargetDirValid = StringUtility.stringHasValue(mapperTargetDir);
		boolean mapperTargetPackageValid = StringUtility.stringHasValue(mapperTargetPackage);
		boolean expandMapperTargetPackageValid = StringUtility.stringHasValue(expandMapperTargetPackage);
		boolean expandMapperSuperClassValid = StringUtility.stringHasValue(expandMapperSuperClass);
		
		return superClassValid && mapperTargetDirValid && mapperTargetPackageValid && expandMapperTargetPackageValid && expandMapperSuperClassValid;
	}  
    
    /**   
     * 生成mapping 添加自定义sql   
     */   
    @Override  
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {  
          
        //创建Select查询  
        XmlElement select = new XmlElement("select");  
        select.addAttribute(new Attribute("id", "selectAll"));  
        select.addAttribute(new Attribute("resultMap", "BaseResultMap"));  
        select.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));  
        select.addElement(new TextElement("select * from "+ introspectedTable.getFullyQualifiedTableNameAtRuntime()));  
  
        XmlElement queryPage = new XmlElement("select");  
        queryPage.addAttribute(new Attribute("id", "queryPage"));  
        queryPage.addAttribute(new Attribute("resultMap", "BaseResultMap"));  
        queryPage.addAttribute(new Attribute("parameterType", "com.fendo.bean.Page"));  
        queryPage.addElement(new TextElement("select * from "+ introspectedTable.getFullyQualifiedTableNameAtRuntime()));  
          
        XmlElement parentElement = document.getRootElement();  
        parentElement.addElement(select);  
        parentElement.addElement(queryPage);  
        return super.sqlMapDocumentGenerated(document, introspectedTable);  
    }  
    
    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {  
        JavaFormatter javaFormatter = context.getJavaFormatter();  
        List<GeneratedJavaFile> mapperJavaFiles = new ArrayList<GeneratedJavaFile>();  
        for (GeneratedJavaFile javaFile : introspectedTable.getGeneratedJavaFiles()) {  
            CompilationUnit unit = javaFile.getCompilationUnit();  
            FullyQualifiedJavaType baseModelJavaType = unit.getType();  
            String shortName = baseModelJavaType.getShortName();  
            GeneratedJavaFile mapperJavafile = null;  
            if (shortName.endsWith("Mapper")) { // 扩展Mapper  
                if (StringUtility.stringHasValue(expandMapperTargetPackage)) {  
                    Interface mapperInterface = new Interface(  
                            expandMapperTargetPackage + "." + shortName.replace("Mapper", "ExpandMapper"));  
                    mapperInterface.setVisibility(JavaVisibility.PUBLIC);  
                    mapperInterface.addJavaDocLine("/**");  
                    mapperInterface.addJavaDocLine(" * " + shortName + "扩展");  
                    mapperInterface.addJavaDocLine(" */");  
  
                    FullyQualifiedJavaType daoSuperType = new FullyQualifiedJavaType(expandMapperSuperClass);  
                    mapperInterface.addImportedType(daoSuperType);  
                    mapperInterface.addSuperInterface(daoSuperType);  
  
                    mapperJavafile = new GeneratedJavaFile(mapperInterface, mapperTargetDir, javaFormatter);  
                    try {  
                        File mapperDir = shellCallback.getDirectory(mapperTargetDir, mapperTargetPackage);  
                        File mapperFile = new File(mapperDir, mapperJavafile.getFileName());  
                        // 文件不存在  
                        if (!mapperFile.exists()) {  
                            mapperJavaFiles.add(mapperJavafile);  
                        }  
                    } catch (ShellException e) {  
                        e.printStackTrace();  
                    }  
                }  
            } else if (!shortName.endsWith("Example")) { // CRUD Mapper  
                Interface mapperInterface = new Interface(mapperTargetPackage + "." + shortName + "Mapper");  
  
                mapperInterface.setVisibility(JavaVisibility.PUBLIC);  
                mapperInterface.addJavaDocLine("/**");  
                mapperInterface.addJavaDocLine(" * MyBatis Generator工具自动生成");  
                mapperInterface.addJavaDocLine(" */");  
  
                FullyQualifiedJavaType daoSuperType = new FullyQualifiedJavaType(superClass);  
                // 添加泛型支持  
                daoSuperType.addTypeArgument(baseModelJavaType);  
                mapperInterface.addImportedType(baseModelJavaType);  
                mapperInterface.addImportedType(daoSuperType);  
                mapperInterface.addSuperInterface(daoSuperType);  
  
                mapperJavafile = new GeneratedJavaFile(mapperInterface, mapperTargetDir, javaFormatter);  
                mapperJavaFiles.add(mapperJavafile);  
  
            }  
        }  
        return mapperJavaFiles;  
    }  
    
}
