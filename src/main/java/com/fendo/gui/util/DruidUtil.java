/**   
 * projectName: mybatis-generator-oracle   
 * fileName: DruidUtil.java   
 * packageName: com.fendo.gui.util   
 * date: 2018年2月27日上午9:15:55   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**     
 * @title: DruidUtil.java   
 * @package com.fendo.gui.util   
 * @description: Druid工具类  
 * @author: fendo  
 * @date: 2018年2月27日 上午9:15:55   
 * @version: V1.0     
*/
public class DruidUtil {

    private static Connection connection = null;
    
    //获取元数据
    public static DataSource getDatasource() {
        DataSource dataSource = DruidConnection.getInstace().getDataSource();
        return dataSource;
    }

    //获取链接
    public static Connection getConnection() {
        connection = DruidConnection.getInstace().getConnection();
        return connection;
    }

    //归还资源
    public void close() {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void close(ResultSet rs,Connection conn){    
        close(rs);     
        close(conn);    
    }  
    
    public static void close(ResultSet rs, Statement stmt,Connection conn){    
        close(rs);    
        close(stmt);    
        close(conn);    
    }  
    
    //关闭连接  
    public static void close(Object o){    
        if (o == null){    
            return;    
        }    
        if (o instanceof ResultSet){    
            try {    
                ((ResultSet)o).close();    
            } catch (SQLException e) {    
                e.printStackTrace();    
            }    
        } else if(o instanceof Statement){    
            try {    
                ((Statement)o).close();    
            } catch (SQLException e) {    
                e.printStackTrace();    
            }    
        } else if (o instanceof Connection){    
            Connection c = (Connection)o;    
            try {    
                if (!c.isClosed()){    
                    c.close();    
                }    
            } catch (SQLException e) {    
                e.printStackTrace();    
            }    
        }      
    }    
	
}
