/**
 *    Copyright 2006-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.plugins;

import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * This plugin adds the java.io.Serializable marker interface to all generated
 * model objects.
 * <p>
 * This plugin demonstrates adding capabilities to generated Java artifacts, and
 * shows the proper way to add imports to a compilation unit.
 * <p>
 * Important: This is a simplistic implementation of serializable and does not
 * attempt to do any versioning of classes.
 * 
 * 这个插件主要用来为生成的Java模型类添加序列化接口，并生成serialVersionUID字段
 * 有两个配置项
 * addGWTInterface：这个是针对GWT的，我们忽略
 * suppressJavaInterface：这个参数是必须要填的，我们设置为false就可以了
 * 
 * @author Jeff Butler
 * 
 */
public class SerializablePlugin extends PluginAdapter {

    private FullyQualifiedJavaType serializable;      //对应java.io.Serializable的java类型
    private FullyQualifiedJavaType gwtSerializable;   //对应com.google.gwt.user.client.rpc.IsSerializable的java类型
    private boolean addGWTInterface;                  //是否实现com.google.gwt.user.client.rpc.IsSerializable接口      
    private boolean suppressJavaInterface;            //是否实现java.io.Serializable接口

    public SerializablePlugin() {
        super();
        serializable = new FullyQualifiedJavaType("java.io.Serializable"); //$NON-NLS-1$ 实例化
        gwtSerializable = new FullyQualifiedJavaType("com.google.gwt.user.client.rpc.IsSerializable"); //$NON-NLS-1$ 实例化  
    }

    public boolean validate(List<String> warnings) {
        // this plugin is always valid
        return true;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        addGWTInterface = Boolean.valueOf(properties.getProperty("addGWTInterface")); //$NON-NLS-1$
        suppressJavaInterface = Boolean.valueOf(properties.getProperty("suppressJavaInterface")); //$NON-NLS-1$
    }
    
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        makeSerializable(topLevelClass, introspectedTable);
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        makeSerializable(topLevelClass, introspectedTable);
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(
            TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        makeSerializable(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 
     *@Title makeSerializable 
     *@Description: 添加序列化
     *@Author fendo
     *@Date 2017年12月2日 下午4:15:20
     *@param topLevelClass
     *@param introspectedTable
     *@throws
     */
    protected void makeSerializable(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
    	
        if (addGWTInterface) {  //是否要实现com.google.gwt.user.client.rpc.IsSerializable接口 
            topLevelClass.addImportedType(gwtSerializable);   //import com.google.gwt.user.client.rpc.IsSerializable;
            topLevelClass.addSuperInterface(gwtSerializable); //实现接口
        }
        
        if (!suppressJavaInterface) {                      //不禁止实现java.io.Serializable 
            topLevelClass.addImportedType(serializable);   //import java.io.Serializable;
            topLevelClass.addSuperInterface(serializable); //实现java.io.Serializable接口

            //添加serialVersionUID字段  
            //最终生成代码private static final long serialVersionUID = 1L;
            Field field = new Field();
            field.setFinal(true);    //添加final修饰
            field.setInitializationString("1L"); //$NON-NLS-1$  赋值为1L
            field.setName("serialVersionUID"); //$NON-NLS-1$    设置字段名称为serialVersionUID
            field.setStatic(true);  //添加static关键字 
            field.setType(new FullyQualifiedJavaType("long")); //$NON-NLS-1$  声明类型  
            field.setVisibility(JavaVisibility.PRIVATE);//声明为私有
            context.getCommentGenerator().addFieldComment(field, introspectedTable); //生成注解 

            //把拼装好的方法DOM添加到topLevelClass中，完成接口的实现和字段的添加 
            topLevelClass.addField(field);
        }
    }
}
