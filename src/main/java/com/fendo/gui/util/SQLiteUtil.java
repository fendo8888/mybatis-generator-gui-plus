/**   
 * projectName: mybatis-generator-oracle   
 * fileName: SQLiteUtil.java   
 * packageName: com.fendo.gui.util   
 * date: 2018年2月27日上午10:15:45   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.fendo.gui.entity.DbConnection;
import com.fendo.gui.ui.tree.IconNode;
import com.fendo.gui.ui.treebak.TreeNode;

/**
 * @title: SQLiteUtil.java
 * @package com.fendo.gui.util
 * @description: SQLite工具类
 * @author: fendo
 * @date: 2018年2月27日 上午10:15:45
 * @version: V1.0
 */
public class SQLiteUtil {

	// 建立一个数据库名fendo.db的连接，如果不存在就在当前目录下创建之
	public static Connection connection = null;
	public static Statement statement;

	/**
	 * 
	 * @title getConnection @description: 获取SQLite数据库连接 @author: fendo @date:
	 *        2018年2月27日 上午10:22:42 @return @throws
	 */
	public static Connection getConnection() {
		try {
			// 加载驱动类
			Class.forName("org.sqlite.JDBC");
			// 连接SQLite的JDBC
			connection = DriverManager.getConnection("jdbc:sqlite:fendo.db");
			System.out.println("Opened database successfully");
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 
	 * @title closeConnectin @description: 关闭连接 @author: fendo @date: 2018年2月27日
	 * 上午10:26:42 @throws
	 */
	public static void closeConnectin() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @title init @description: 初始化表 @author: fendo @date: 2018年3月1日
	 * 下午3:56:41 @throws
	 */
	public static void init() {
		getConnection();
		// 查询值
		ResultSet rs;
		// 创建表
		StringBuffer sql = new StringBuffer();
		sql.append(" CREATE TABLE \"DBCONNECTION\" ( ").append(" \"ID\"  TEXT(255) NOT NULL, ")
				.append(" \"SAVENAME\"  TEXT(255) NOT NULL, ").append(" \"DBTYPE\"  TEXT(255) NOT NULL, ")
				.append(" \"LOCALHOSTNAME\"  TEXT(255) NOT NULL, ").append(" \"PORT\"  TEXT(255) NOT NULL, ")
				.append(" \"USERNAME\"  TEXT(255) NOT NULL, ").append(" \"PASSWORD\"  TEXT(255) NOT NULL, ")
				.append(" \"DBNAME\"  TEXT(255) NOT NULL, ").append(" \"CODING\"  TEXT(255) NOT NULL, ")
				.append(" PRIMARY KEY (\"ID\") ").append(" ); ");

		try {
			rs = statement.executeQuery("SELECT * FROM DBCONNECTION;");
			if (rs.next()) {
				System.out.println("表已存在!");

			} else {
				statement.executeUpdate(sql.toString());
				System.out.println("创建表成功!");
			}
			rs.close();
		} catch (SQLException e) {
			try {
				statement.executeQuery(sql.toString());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		closeConnectin();
	}

	public static void insert(DbConnection dbConnection) {
		getConnection();
		// 插入值
		try {
			connection.setAutoCommit(false);
			StringBuffer sb = new StringBuffer();
			sb.append(
					"INSERT INTO DBCONNECTION (ID,SAVENAME,DBTYPE,LOCALHOSTNAME,PORT,USERNAME,PASSWORD,DBNAME,CODING) "
							+ "VALUES (" + dbConnection.getId() + ", '" + dbConnection.getSaveName() + "','"
							+ dbConnection.getDbType() + "', '" + dbConnection.getLocalhostName() + "', '"
							+ dbConnection.getPort() + "' , '" + dbConnection.getUserName() + "', '"
							+ dbConnection.getPassword() + "','" + dbConnection.dbName + "','"
							+ dbConnection.getCoding() + "');\n");
			statement.executeUpdate(sb.toString());
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnectin();
	}

	public static List<DbConnection> selectAll() {
		getConnection();
		// 查询值
		ResultSet rs;
		List<DbConnection> dbList = new ArrayList<DbConnection>();
		try {
			rs = statement.executeQuery("SELECT * FROM DBCONNECTION;");
			while (rs.next()) {
				DbConnection dbConnection = new DbConnection();
				dbConnection.setId(rs.getString("id"));
				dbConnection.setSaveName(rs.getString("saveName"));
				dbConnection.setDbType(rs.getString("dbType"));
				dbConnection.setLocalhostName(rs.getString("localhostName"));
				dbConnection.setPort(rs.getString("port"));
				dbConnection.setUserName(rs.getString("userName"));
				dbConnection.setPassword(rs.getString("password"));
				dbConnection.setDbName(rs.getString("dbName"));
				dbConnection.setCoding(rs.getString("coding"));
				dbList.add(dbConnection);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnectin();
		return dbList;
	}

	public static IconNode selectAllTreeNode() {
		getConnection();
		// 查询值
		ResultSet rs;
		IconNode dbList = null;
		IconNode Root = new IconNode(null, null);// 定义根节点
		try {
			rs = statement.executeQuery("SELECT * FROM DBCONNECTION;");
			while (rs.next()) {
				dbList = new IconNode(new ImageIcon("src/main/resources/icon/databaseList.png"),
						rs.getString("localhostName"),rs.getString("saveName"));
				
				DbConnection dbConnection = new DbConnection();
				dbConnection.setId(rs.getString("id"));
				dbConnection.setSaveName(rs.getString("saveName"));
				dbConnection.setDbType(rs.getString("dbType"));
				dbConnection.setLocalhostName(rs.getString("localhostName"));
				dbConnection.setPort(rs.getString("port"));
				dbConnection.setUserName(rs.getString("userName"));
				dbConnection.setPassword(rs.getString("password"));
				dbConnection.setDbName(rs.getString("dbName"));
				dbConnection.setCoding(rs.getString("coding"));
				IconNode icons = GetMetaData(dbList,dbConnection);
						
				Root.add(icons);

			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnectin();
		return Root;
	}

	public static IconNode GetMetaData(IconNode iconNode,DbConnection dbConnection) {
		String driver = null;
		String url = null;
		Properties properties = new Properties();
		// 数据库类型
		if ("MySQL".equals(dbConnection.getDbType().trim())) {
			driver = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://"+dbConnection.getLocalhostName().trim()+":"+dbConnection.getPort().trim()+"/"+dbConnection.getDbName().trim()+"?useUnicode=true&useSSL=false&characterEncoding=utf8&characterSetResults=utf8";
			properties.setProperty("user", dbConnection.getUserName().trim());
			properties.setProperty("password", dbConnection.getPassword().trim());
			properties.setProperty("remarks", "true"); //设置可以获取remarks信息 
			properties.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息
		} else if("Oracle".equals(dbConnection.getDbType().trim())){
			driver = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@"+dbConnection.getLocalhostName().trim()+":"+dbConnection.getPort().trim()+":"+dbConnection.getDbName().trim();
			properties.setProperty("remarks", "true");
		}
		try {
			Connection connection = JdbcUtil.getConnection(driver,url,properties);
			//连接成功
			if (!connection.isClosed()) {
				ResultSet rs = null; 
				DatabaseMetaData dbmd = connection.getMetaData(); 
	            String[] types = { "TABLE" };    
	            rs = dbmd.getTables(null, null, "%", types);    
	            while (rs.next()) {    
	                String tableName = rs.getString("TABLE_NAME");  //表名    
	                String tableType = rs.getString("TABLE_TYPE");  //表类型    
	                String remarks = rs.getString("REMARKS");       //表备注    
	                System.out.println("表详细信息: " + tableName + " - " + tableType + " - " + remarks);    
					IconNode treeNode = new IconNode(new ImageIcon("src/main/resources/icon/openSystem.png"),
							tableName,remarks);
					iconNode.add(treeNode);
	            }    
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return iconNode;
	}

	@Test
	public void Test() {
		init();
		for (int i = 0; i < 3; i++) {
			DbConnection dbConnection = new DbConnection();
			dbConnection.setId("" + i);
			dbConnection.setSaveName(" " + i + "fendo");
			dbConnection.setLocalhostName(" " + i + "fendo");
			dbConnection.setPassword(" " + i + "fendo");
			dbConnection.setPort(" " + i + "fendo");
			dbConnection.setUserName(" " + i + "fendo");
			dbConnection.setPort(" " + i + "fendo");
			dbConnection.setCoding(" " + i + "fendo");
			dbConnection.setDbType(" " + i + "fendo");
			insert(dbConnection);
		}
		List<DbConnection> dbList = selectAll();
		System.out.println(dbList.size());
	}

	public static void main(String[] args) throws SQLException {
		// getConnection();
		// //创建表
		// String sql = "CREATE TABLE COMPANY "
		// + "(ID INT PRIMARY KEY NOT NULL,"
		// + " NAME TEXT NOT NULL,"
		// + " AGE INT NOT NULL,"
		// + " ADDRESS CHAR(50),"
		// + " SALARY REAL)";
		// statement.executeUpdate(sql);
		// //插入值
		// connection.setAutoCommit(false);
		// StringBuffer sb = new StringBuffer();
		// sb.append("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
		// + "VALUES (1, 'Paul', 32, 'California', 20000.00 );\n");
		// sb.append("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
		// + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );\n");
		// sb.append("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
		// + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );\n");
		// sb.append("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
		// + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );");
		// statement.executeUpdate(sb.toString());
		// connection.commit();
		// //查询值
		// ResultSet rs = statement.executeQuery("SELECT * FROM COMPANY;");
		// while (rs.next()) {
		// int id = rs.getInt("id");
		// String name = rs.getString("name");
		// int age = rs.getInt("age");
		// String address = rs.getString("address");
		// float salary = rs.getFloat("salary");
		// System.out.println("ID = " + id);
		// System.out.println("NAME = " + name);
		// System.out.println("AGE = " + age);
		// System.out.println("ADDRESS = " + address);
		// System.out.println("SALARY = " + salary);
		// System.out.println("--------");
		// }
		// rs.close();
		// closeConnectin();

//		init();
//		for (int i = 0; i < 3; i++) {
//			DbConnection dbConnection = new DbConnection();
//			dbConnection.setId("" + i);
//			dbConnection.setSaveName(" " + i + "fendo");
//			dbConnection.setLocalhostName(" " + i + "fendo");
//			dbConnection.setPassword(" " + i + "fendo");
//			dbConnection.setPort(" " + i + "fendo");
//			dbConnection.setUserName(" " + i + "fendo");
//			dbConnection.setPort(" " + i + "fendo");
//			dbConnection.setCoding(" " + i + "fendo");
//			dbConnection.setDbName(" " + i + "fendo");
//			dbConnection.setDbType(" " + i + "fendo");
//			insert(dbConnection);
//		}
//		List<DbConnection> dbList = selectAll();
//		System.out.println(dbList.size());
		
		IconNode iconNodes = selectAllTreeNode();

	}

}
