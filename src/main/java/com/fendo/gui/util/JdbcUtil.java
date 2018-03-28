package com.fendo.gui.util;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;
import java.sql.SQLException;  
import java.sql.Statement;
import java.util.Properties;


/**   
 * @Title: JdbcUtil.java 
 * @Package com.fendo.utils 
 * @Description: JDBC操作元数据示例-- DatabaseMetaData接口
 * @author fendo
 * @date 2017年12月3日 下午2:11:38 
 * @version V1.0   
*/
public class JdbcUtil {

    public static Connection getConnection(String driver,String url,String userName,String passWord) throws Exception{    
        Connection conn = null;       
        //初始化JDBC驱动并让驱动加载到jvm中    
        Class.forName(driver); 
        //连接数据库    
        conn = DriverManager.getConnection(url,userName,passWord);    
        conn.setAutoCommit(true); 
        return conn;    
    }  
    
    public static Connection getConnection(String driver,String url,Properties properties) throws Exception{    
        Connection conn = null;   
        //初始化JDBC驱动并让驱动加载到jvm中    
        Class.forName(driver); 
        conn = DriverManager.getConnection(url, properties);   
        conn.setAutoCommit(true); 
        return conn;    
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
      
      
    public static void close(ResultSet rs, Statement stmt,     
            Connection conn){    
        close(rs);    
        close(stmt);    
        close(conn);    
    }    
      
    public static void close(ResultSet rs,     
            Connection conn){    
        close(rs);     
        close(conn);    
    }    
      
}
