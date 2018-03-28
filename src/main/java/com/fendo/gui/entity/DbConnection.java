/**   
 * projectName: mybatis-generator-oracle   
 * fileName: DbConnection.java   
 * packageName: com.fendo.gui.entity   
 * date: 2018年2月28日下午2:18:26   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.entity;

import java.io.Serializable;

/**     
 * @title: DbConnection.java   
 * @package com.fendo.gui.entity   
 * @description: 数据库连接信息  
 * @author: fendo  
 * @date: 2018年2月28日 下午2:18:26   
 * @version: V1.0     
*/
public class DbConnection implements Serializable{

	/**
	 * 唯一标识
	 */
	public String id;
	
	/**
	 * 保存名称
	 */
	public String saveName;
	
	/**
	 * 数据库类型
	 */
	public String dbType;
	
	/**
	 * 主机名或IP
	 */
	public String localhostName;
	
	/**
	 * 端口
	 */
	public String port;
	
	/**
	 * 用户名
	 */
	public String userName;
	
	/**
	 * 密码
	 */
	public String password;
	
	/**
	 * 数据库名称
	 */
	public String dbName;
	
	/**
	 * 编码
	 */
	public String coding;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getLocalhostName() {
		return localhostName;
	}

	public void setLocalhostName(String localhostName) {
		this.localhostName = localhostName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getCoding() {
		return coding;
	}

	public void setCoding(String coding) {
		this.coding = coding;
	}

	public DbConnection() {
		super();
	}
	
}
