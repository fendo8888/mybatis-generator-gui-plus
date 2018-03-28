/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package ${modelPackage};

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @Title ${tableName}表的实体类
 * @Description ${tableRemark}
 * @version 1.0
 * @Author ${author}
 * @Date ${date}
 */
public class ${beanName} implements Serializable{ 


    private static final long serialVersionUID = 1L;
 
    <#list columns as item>  
    /**
    *  <#if (item.comment)?exists>${item.comment}</#if>
    */  
    private ${item.attributeType} ${item.attributeName?lower_case};
    </#list>
     
    public ${beanName}(){
    } 
    
    <#list columns as item>    
    public ${item.attributeType} get${item.attributeName?capitalize}(){    
      return this.${item.attributeName?lower_case};    
    }

    public void set${item.attributeName?capitalize}(${item.attributeType} ${item.attributeName?lower_case}){    
      this.${item.attributeName?lower_case} = ${item.attributeName?lower_case};    
    }    
    </#list>
  
      
}  