/**   
 * projectName: mybatis-generator-oracle   
 * fileName: SwaggerCommentGenerator.java   
 * packageName: org.mybatis.generator.comment   
 * date: 2018年2月25日下午4:27:33   
 * copyright(c) 2017-2020 fendo公司  
 */
package org.mybatis.generator.comment;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

/**     
 * @title: SwaggerCommentGenerator.java   
 * @package org.mybatis.generator.comment   
 * @description: SwaggerUI注解生成  
 * @author: fendo  
 * @date: 2018年2月25日 下午4:27:33   
 * @version: V1.0     
*/
public class SwaggerCommentGenerator implements CommentGenerator{

	/** properties配置文件 */
	private Properties properties;
	
	/** properties配置文件 */
    private Properties systemPro;
    
    /** 父类时间 */
    private boolean suppressDate;
    
    /** 父类所有注释 */
    private boolean suppressAllComments;
    
    /** 表备注的补充  如果suppressAllComments为真，则忽略此选项 */
    private boolean addRemarkComments;
    
    /** 日期格式化 */
    private SimpleDateFormat dateFormat;
    
    /** 是否在get、set方法里添加final关键字 */
    private boolean addMethodFinal;
    
    /** 作者 */
    private String author;
    
    /** 当前版本号 */
    private String version;
    
    /** 版权 */
    private String copyright;

    public SwaggerCommentGenerator() {
        super();
        properties = new Properties();
        systemPro = System.getProperties();
        suppressDate = false;
        suppressAllComments = false;
    }
    
    /**
     * 
     * @title: addJavaFileComment  
     * @description: 给Java文件加注释，这个注释是在文件的顶部，也就是package上面。  
     * @param compilationUnit     
     * @see org.mybatis.generator.api.CommentGenerator#addJavaFileComment(org.mybatis.generator.api.dom.java.CompilationUnit)
     */
    public void addJavaFileComment(CompilationUnit compilationUnit) {
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	compilationUnit.addFileCommentLine("/*");
    	compilationUnit.addFileCommentLine("* " + compilationUnit.getType().getShortName() + ".java");
    	compilationUnit.addFileCommentLine("* Copyright(C) " + copyright);
    	compilationUnit.addFileCommentLine("* @date " + sdf.format(new Date()) + "");
    	compilationUnit.addFileCommentLine("*/");
    }

    /**
     * 
     * @title: addComment  
     * @description: 给生成的XML文件加注释,添加一个合适的注释来警告用户生成元素，以及何时生成元素。  
     * @param xmlElement     
     * @see org.mybatis.generator.api.CommentGenerator#addComment(org.mybatis.generator.api.dom.xml.XmlElement)
     */
    public void addComment(XmlElement xmlElement) {
        if (suppressAllComments) {
            return;
        }
    }

    /**
     * 
     * @title: addRootComment  
     * @description: 为调用此方法作为根元素的第一个子节点添加注释。  
     * @param rootElement     
     * @see org.mybatis.generator.api.CommentGenerator#addRootComment(org.mybatis.generator.api.dom.xml.XmlElement)
     */
    public void addRootComment(XmlElement rootElement) {
       
    }


    /**
     * 
     * @title: addConfigurationProperties  
     * @description: 从该配置中的任何属性添加此实例的属性CommentGenerator配置。这个方法将在任何其他方法之前被调用。  
     * @param properties     
     * @see org.mybatis.generator.api.CommentGenerator#addConfigurationProperties(java.util.Properties)
     */
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        suppressDate = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        
        suppressAllComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

        addRemarkComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));
        
        addMethodFinal = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_METHOD_FINAL));
        
        /** 时间格式化 **/
        String dateFormatString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);
        if (StringUtility.stringHasValue(dateFormatString)) {
            dateFormat = new SimpleDateFormat(dateFormatString);
        }
        
        /** 作者 **/
        String authorString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_AUTHOR);
        if (StringUtility.stringHasValue(authorString)) {
            author = authorString;
        }
        
        /** 版本 **/
        String versionString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_VERSION);
        if (StringUtility.stringHasValue(versionString)) {
        	version = versionString;
        }
        
        /** 版权 **/
        String copyrightString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_COPYRIGHT);
        if (StringUtility.stringHasValue(copyrightString)) {
        	copyright = copyrightString;
        }
    }

    /**
     * 
     *@title addJavadocTag   
     *@description: 此方法为其添加了自定义javadoc标签。  
     *@author: fendo  
     *@date: 2018年2月24日 下午2:30:17  
     *@param javaElement
     *@param markAsDoNotDelete  
     *@throws
     */
    protected void addJavadocTag(JavaElement javaElement,
            boolean markAsDoNotDelete) {
        javaElement.addJavaDocLine(" *"); //$NON-NLS-1$
        StringBuilder sb = new StringBuilder();
        sb.append(" * "); //$NON-NLS-1$
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        if (markAsDoNotDelete) {
            sb.append(" do_not_delete_during_merge"); //$NON-NLS-1$
        }
        String s = getDateString();
        if (s != null) {
            sb.append(' ');
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());
    }

    /**
     * 
     *@title getDateString   
     *@description: 此方法返回格式化的日期字符串以包含在Javadoc标记中和XML注释。 如果您不想要日期，则可以返回null在这些文档元素中。  
     *@author: fendo  
     *@date: 2018年2月24日 下午2:29:49  
     *@return  
     *@throws
     */
    protected String getDateString() {
        if (suppressDate) {
            return null;
        } else if (dateFormat != null) {
            return dateFormat.format(new Date());
        } else {
            return new Date().toString();
        }
    }


    /**
     * 
     * @title: addModelClassComment  
     * @description: 为模型类添加注释  
     * @param topLevelClass
     * @param introspectedTable     
     * @see org.mybatis.generator.api.CommentGenerator#addModelClassComment(org.mybatis.generator.api.dom.java.TopLevelClass, org.mybatis.generator.api.IntrospectedTable)
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
		
        //添加导入类的信息
        topLevelClass.addJavaDocLine("import org.springframework.format.annotation.DateTimeFormat;"); 
        //topLevelClass.addJavaDocLine("import com.fasterxml.jackson.annotation.JsonFormat;");
        topLevelClass.addJavaDocLine("import io.swagger.annotations.ApiModel;");
        topLevelClass.addJavaDocLine("import io.swagger.annotations.ApiModelProperty;");
		
        topLevelClass.addJavaDocLine("/**");
		topLevelClass.addJavaDocLine(" * @title " + introspectedTable.getFullyQualifiedTable() + "表的实体类");
		topLevelClass.addJavaDocLine(" * @description " + introspectedTable.getFullyQualifiedTable().getRemarks());
		topLevelClass.addJavaDocLine(" * @version " + version);
		topLevelClass.addJavaDocLine(" * @author " + author);
		topLevelClass.addJavaDocLine(" * @date " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		topLevelClass.addJavaDocLine(" */");
		topLevelClass.addJavaDocLine("@ApiModel(value =\"" + introspectedTable.getFullyQualifiedTable() + "\")");
    }

    /**
     * 
     * @title: addEnumComment  
     * @description: 为枚举添加注释  
     * @param innerEnum
     * @param introspectedTable     
     * @see org.mybatis.generator.api.CommentGenerator#addEnumComment(org.mybatis.generator.api.dom.java.InnerEnum, org.mybatis.generator.api.IntrospectedTable)
     */
    public void addEnumComment(InnerEnum innerEnum,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerEnum.addJavaDocLine("/**"); //$NON-NLS-1$
        innerEnum
                .addJavaDocLine(" * This enum was generated by MyBatis Generator."); //$NON-NLS-1$

        sb.append(" * This enum corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(sb.toString());

        addJavadocTag(innerEnum, false);

        innerEnum.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 
     * @title: addFieldComment  
     * @description: Java属性注释  
     * @param field
     * @param introspectedTable
     * @param introspectedColumn     
     * @see org.mybatis.generator.api.CommentGenerator#addFieldComment(org.mybatis.generator.api.dom.java.Field, org.mybatis.generator.api.IntrospectedTable, org.mybatis.generator.api.IntrospectedColumn)
     */
    public void addFieldComment(Field field,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments || !addRemarkComments) {
            return;
        }
        //字段备注信息
        String remarks = introspectedColumn.getRemarks();
        field.addJavaDocLine("@ApiModelProperty(value = \"" + remarks + "\")");
        
        //当字段数据类型为date时添加日期注释
        StringBuffer sb = new StringBuffer();
        if(introspectedColumn.getJdbcType() == 93) {
			sb.append("@DateTimeFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")");
        }
        
        if(sb.length() > 0) {
        	field.addJavaDocLine(sb.toString());
        }
    }

    /**
     * 
     * @title: addFieldComment  
     * @description: 为字段添加注释  
     * @param field
     * @param introspectedTable     
     * @see org.mybatis.generator.api.CommentGenerator#addFieldComment(org.mybatis.generator.api.dom.java.Field, org.mybatis.generator.api.IntrospectedTable)
     */
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (suppressAllComments || !addRemarkComments) {
            return;
        }
    }

    /**
     * 
     * @title: addGeneralMethodComment  
     * @description: Mapper方法注释  
     * @param method
     * @param introspectedTable     
     * @see org.mybatis.generator.api.CommentGenerator#addGeneralMethodComment(org.mybatis.generator.api.dom.java.Method, org.mybatis.generator.api.IntrospectedTable)
     */
    public void addGeneralMethodComment(Method method,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        method.addJavaDocLine("/**"); 
        sb.append(" * ");
        if (method.isConstructor()) {
            sb.append(" 构造查询条件");
        }
        String method_name = method.getName();
        if ("setOrderByClause".equals(method_name)) {
            sb.append(" 设置排序字段");
        } else if ("setDistinct".equals(method_name)) {
            sb.append(" 设置过滤重复数据");
        } else if ("getOredCriteria".equals(method_name)) {
            sb.append(" 获取当前的查询条件实例");
        } else if ("isDistinct".equals(method_name)) {
            sb.append(" 是否过滤重复数据");
        } else if ("getOrderByClause".equals(method_name)) {
            sb.append(" 获取排序字段");
        } else if ("createCriteria".equals(method_name)) {
            sb.append(" 创建一个查询条件");
        } else if ("createCriteriaInternal".equals(method_name)) {
            sb.append(" 内部构建查询条件对象");
        } else if ("clear".equals(method_name)) {
            sb.append(" 清除查询条件");
        } else if ("countByExample".equals(method_name)) {
            sb.append(" 根据指定的条件获取数据库记录数");
        } else if ("deleteByExample".equals(method_name)) {
            sb.append(" 根据指定的条件删除数据库符合条件的记录");
        } else if ("deleteByPrimaryKey".equals(method_name)) {
            sb.append(" 根据主键删除数据库的记录");
        } else if ("insert".equals(method_name)) {
            sb.append(" 新写入数据库记录");
        } else if ("insertSelective".equals(method_name)) {
            sb.append(" 动态字段,写入数据库记录");
        } else if ("selectByExample".equals(method_name)) {
            sb.append(" 根据指定的条件查询符合条件的数据库记录");
        } else if ("selectByPrimaryKey".equals(method_name)) {
            sb.append(" 根据指定主键获取一条数据库记录");
        } else if ("updateByExampleSelective".equals(method_name)) {
            sb.append(" 动态根据指定的条件来更新符合条件的数据库记录");
        } else if ("updateByExample".equals(method_name)) {
            sb.append(" 根据指定的条件来更新符合条件的数据库记录");
        } else if ("updateByPrimaryKeySelective".equals(method_name)) {
            sb.append(" 动态字段,根据主键来更新符合条件的数据库记录");
        } else if ("updateByPrimaryKey".equals(method_name)) {
            sb.append(" 根据主键来更新符合条件的数据库记录");
        }
        sb.append(":");
        sb.append(introspectedTable.getFullyQualifiedTable());
        method.addJavaDocLine(sb.toString());

        final List<Parameter> parameterList = method.getParameters();
        if (!parameterList.isEmpty()) {
            method.addJavaDocLine(" *");
            if ("or".equals(method_name)) {
                sb.append(" 增加或者的查询条件,用于构建或者查询");
            }
        } else {
            if ("or".equals(method_name)) {
                sb.append(" 创建一个新的或者查询条件");
            }
        }
        String paramterName;
        for (Parameter parameter : parameterList) {
            sb.setLength(0);
            sb.append(" * @param "); //$NON-NLS-1$
            paramterName = parameter.getName();
            sb.append(paramterName);
            if ("orderByClause".equals(paramterName)) {
                sb.append(" 排序字段"); //$NON-NLS-1$
            } else if ("distinct".equals(paramterName)) {
                sb.append(" 是否过滤重复数据");
            } else if ("criteria".equals(paramterName)) {
                sb.append(" 过滤条件实例");
            }
            method.addJavaDocLine(sb.toString());
        }

        method.addJavaDocLine(" */"); 
    }

    /**
     * 
     * @title: addGetterComment  
     * @description: get方法注释  
     * @param method
     * @param introspectedTable
     * @param introspectedColumn     
     * @see org.mybatis.generator.api.CommentGenerator#addGetterComment(org.mybatis.generator.api.dom.java.Method, org.mybatis.generator.api.IntrospectedTable, org.mybatis.generator.api.IntrospectedColumn)
     */
    public void addGetterComment(Method method,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        
        method.setFinal(addMethodFinal);
        method.addJavaDocLine("/** "); //$NON-NLS-1$
        StringBuilder sb = new StringBuilder();
        sb.append(" * 获取 "); //$NON-NLS-1$
        if (introspectedColumn.getRemarks() != null
                && !introspectedColumn.getRemarks().equals("")) {
            sb.append(introspectedColumn.getRemarks())
                    .append(" ");
        }
        sb.append(introspectedTable.getFullyQualifiedTable())
                .append('.')
                .append(introspectedColumn.getActualColumnName());

        method.addJavaDocLine(sb.toString());

        sb.setLength(0);

        sb.append(" * @return "); //$NON-NLS-1$
        if (introspectedColumn.getRemarks() != null
                && !introspectedColumn.getRemarks().equals("")) {
            sb.append(introspectedColumn.getRemarks());
        } else {
            sb.append(introspectedTable.getFullyQualifiedTable())
                    .append('.')
                    .append(introspectedColumn.getActualColumnName());
        }
        method.addJavaDocLine(sb.toString());
        method.addJavaDocLine(" */"); //$NON-NLS-1$
        
    }

    /**
     * 
     * @title: addSetterComment  
     * @description: set方法注释
     * @param method
     * @param introspectedTable
     * @param introspectedColumn     
     * @see org.mybatis.generator.api.CommentGenerator#addSetterComment(org.mybatis.generator.api.dom.java.Method, org.mybatis.generator.api.IntrospectedTable, org.mybatis.generator.api.IntrospectedColumn)
     */
    public void addSetterComment(Method method,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
          if (suppressAllComments) {
            return;
          }
          method.setFinal(addMethodFinal);
          method.addJavaDocLine("/** "); //$NON-NLS-1$

          StringBuilder sb = new StringBuilder();
          sb.append(" * 设置 ");  //$NON-NLS-1$
          if (introspectedColumn.getRemarks() != null
                && !introspectedColumn.getRemarks().equals("")) {
             sb.append(introspectedColumn.getRemarks())
                    .append(" ");
          }
          sb.append(introspectedTable.getFullyQualifiedTable())
                .append('.')
                .append(introspectedColumn.getActualColumnName());

          method.addJavaDocLine(sb.toString());

          // 参数
          Parameter parm = method.getParameters().get(0);
          sb.setLength(0);
          sb.append(" * @param ").append(parm.getName() + " ");
          if (introspectedColumn.getRemarks() != null
                && !introspectedColumn.getRemarks().equals("")) {
             sb.append(introspectedColumn.getRemarks());
          } else {
            sb.append(introspectedTable.getFullyQualifiedTable())
                    .append('.')
                    .append(introspectedColumn.getActualColumnName());
          }
          method.addJavaDocLine(sb.toString());
          method.addJavaDocLine(" */"); //$NON-NLS-1$        
    }

    /**
     * 类注释
     */
    public void addClassComment(InnerClass innerClass,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
    }
    
    /**
     * 类注释
     * 删除生成Criteria对象的注释信息的注释
     */
    public void addClassComment(InnerClass innerClass,
            IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        if (suppressAllComments) {
            return;
        } 	
    }

    /**
     * 我的类注释,用于非实体类Criteria的注释
     * @param javaElement
     */
    @Override
    public void addExampleClassComment(JavaElement javaElement,IntrospectedTable introspectedTable,String comment) {
        if (suppressAllComments) {
            return;
        }
        javaElement.addJavaDocLine("/**");
        javaElement.addJavaDocLine(" * @title "+introspectedTable.getFullyQualifiedTable());
        javaElement.addJavaDocLine(" * @description "+introspectedTable.getFullyQualifiedTable().getRemarks() + comment);
        javaElement.addJavaDocLine(" * @version " + version);
        javaElement.addJavaDocLine(" * @author " + author);
        javaElement.addJavaDocLine(" * @date " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        javaElement.addJavaDocLine(" */");
    }

}
