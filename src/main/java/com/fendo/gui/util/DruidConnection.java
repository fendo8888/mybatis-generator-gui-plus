/**   
 * projectName: mybatis-generator-oracle   
 * fileName: DruidConnection.java   
 * packageName: com.fendo.gui.util   
 * date: 2018年2月27日上午9:16:36   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * @title: DruidConnection.java
 * @package com.fendo.gui.util
 * @description: Druid连接类
 * @author: fendo
 * @date: 2018年2月27日 上午9:16:36
 * @version: V1.0
 */
public class DruidConnection {

	private static Properties properties = null;
	private static DataSource dataSource = null;
	private volatile static DruidConnection instatce = null;
	private Connection connection = null;
	public static String dbType = null;

	// 私有构造函数,防止实例化对象
	private DruidConnection() {

	}

	static {
		try {
			properties = new Properties();
						
			// 1.加载properties文件
			InputStream is = DruidConnection.class.getClassLoader().getResourceAsStream("druid.properties");
			
			// 2.加载输入流
			properties.load(is);
			
			String propertiesString = properties.toString();
			
			if(propertiesString.contains("oracle")) {
				dbType = "oracle";
				properties.put("remarksReporting","true");
			}else {
				dbType = "mysql";
			}			
			// 3.获取数据源
			dataSource = getDatasource();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用简单单例模式确保只返回一个链接对象
	 * 
	 * @return
	 */
	public static DruidConnection getInstace() {
		if (instatce == null) {
			synchronized (DruidConnection.class) {
				if (instatce == null) {
					instatce = new DruidConnection();
				}
			}
		}
		return instatce;
	}

	// 返回一个数据源
	public DataSource getDataSource() {
		return dataSource;
	}

	// 返回一个链接
	public Connection getConnection() {
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// 加载数据源
	private static DataSource getDatasource() {
		DataSource source = null;
		try {
			source = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return source;
	}

	/**
	 * 配置文件获取
	 * @param string
	 *            配置文件名
	 * @return Properties对象
	 */
	private static Properties loadPropertiesFile(String fullFile) {
		String webRootPath = null;
		if (null == fullFile || fullFile.equals("")) {
			throw new IllegalArgumentException("Properties file path can not be null" + fullFile);
		}
		webRootPath = DruidConnection.class.getClassLoader().getResource("").getPath();
		webRootPath = new File(webRootPath).getParent();
		InputStream inputStream = null;
		Properties p = null;
		try {
			inputStream = new FileInputStream(new File(webRootPath + File.separator + fullFile));
			p = new Properties();
			p.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != inputStream) {
					inputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return p;
	}

}
