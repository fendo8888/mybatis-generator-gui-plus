/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JooqDao.java   
 * packageName: com.fendo.gui.jooq   
 * date: 2018年2月27日上午9:27:02   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.jooq;

import java.util.Map;
import java.util.Set;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectQuery;
import org.jooq.Table;
import org.jooq.UpdateQuery;
import org.jooq.impl.DSL;

import com.fendo.gui.util.DruidUtil;

/**     
 * @title: JooqDao.java   
 * @package com.fendo.gui.jooq   
 * @description: Jooq简单的增删改查  
 * @author: fendo  
 * @date: 2018年2月27日 上午9:27:02   
 * @version: V1.0     
*/
public class JooqDao {

    private DSLContext dslContext= null; 
    
    /**
     * 
     *@title getdslContext   
     *@description: 获取DSLContext对象  
     *@author: fendo  
     *@date: 2018年2月27日 上午9:30:55  
     *@return  
     *@throws
     */
    private DSLContext getdslContext()  
    {  
    	//获取连接
        dslContext = DSL.using(DruidUtil.getConnection());  
        return dslContext;  
    }
    
    /**
     * 
     *@title select   
     *@description: 简单实体查询 - 根据用户名
     *@author: fendo  
     *@date: 2018年2月27日 上午10:01:35  
     *@param add  
     *@throws
     */
    public void select(String add)  
    {  
        DSLContext getdslContext = getdslContext();  
        Table<Record> table = DSL.table("user");  
        SelectQuery<Record> selectQuery = getdslContext.selectQuery(table);//获取查询对象  
        Condition eq = DSL.field("name").eq(add);//查询条件  
        selectQuery.addConditions(eq);//添加查询条件  
        Result<Record> fetch = selectQuery.fetch();  
        for (Object aResult : fetch) {  
            Record record = (Record) aResult;  
            System.out.println(record);  
            System.out.println(record.getValue("name"));  
        }  
      }  
    
    
    /**
     * 
     *@title update   
     *@description: 实体更新   
     *@author: fendo  
     *@date: 2018年2月27日 上午10:01:07  
     *@param name  
     *@throws
     */
    public void update(String name)  
    {  
        DSLContext getdslContext = getdslContext();  
        Table<Record> table = DSL.table("user");  
        UpdateQuery<Record> updateQuery = getdslContext.updateQuery(table);//获取更新对象  
        updateQuery.addValue(DSL.field("name"), "new-name");//更新email字段的值为new-email  
        Condition eq = DSL.field("name").eq(name);//更新username为name的email字段  
        updateQuery.addConditions(eq);  
        int execute = updateQuery.execute();  
        System.out.println(execute);  
        select("dreamlu");  
    }  
    
    
    /**
     * 
     *@title getVal   
     *@description: 原生态的sql查询  
     *@author: fendo  
     *@date: 2018年2月27日 上午10:01:15    
     *@throws
     */
    public void getVal()  
    {  
        DSLContext getdslContext = getdslContext();  
        Table<Record> table = DSL.table("user");//表名  
//        Result<Record> fetch = getdslContext.select().from(table).where("status = 0").and("id > 1").orderBy(DSL.field("create_time").asc()).fetch();  
//        for (Object aResult : fetch) {  
//            Record record = (Record) aResult;  
//            System.out.println(record);  
//        }  
        Map<String, Object> fetchAnyMap = getdslContext.select().from(table).where("status = 0").and("id > 1").orderBy(DSL.field("create_time").asc()).fetchAnyMap(); 
        Set<String> keySet = fetchAnyMap.keySet(); 
        for(String s:keySet) 
        { 
            System.out.println("key--"+s+"--val:"+fetchAnyMap.get(s)); 
        } 
    }  
    
    
    /**
     * 
     *@title exits   
     *@description: 验证DSL.exists方法  
     *@author: fendo  
     *@date: 2018年2月27日 上午10:01:24    
     *@throws
     */
    public void exits()  
    {  
        DSLContext getdslContext = getdslContext();  
        
        Condition condition = DSL.exists(DSL.select(DSL.field("name")));  
        Table<Record> table = DSL.table("user");  
        SelectQuery<Record> selectQuery = getdslContext.selectQuery(table);  
        selectQuery.addConditions(condition);  
        Result<Record> fetch = selectQuery.fetch();  
        for (Object aResult : fetch) {  
            Record record = (Record) aResult;  
            System.out.println(record);  
            System.out.println(record.getValue("name"));  
        }  
    }  
    public static void main(String[] args) {  
        JooqDao jooqDao = new JooqDao();  
        jooqDao.select("admin");  
//        jooqDao.update("shangfox1");  
//        jooqDao.exits();  
//        jooqDao.getVal();  
    }  
	
}
