package com.fendo.freemarker.base;
/**
 * 
 * @title: Column.java   
 * @package com.fendo.freemarker.base   
 * @description: 数据库表元数据  
 * @author: fendo  
 * @date: 2018年2月28日 下午5:11:10   
 * @version: V1.0
 */
public class Column {

	/** 字段名称 **/
    private String columnName;  
    /** 字段类型 **/
    private String columnType;  
    /** 字段属性名称 **/
    private String attributeName;  
    /** 字段属性 **/
    private String attributeType;
    /** jdbc类型 **/
    private String jdbcType;
    /** 所有字段属性 **/
    private String fullAttributeType;
    /** 注释 **/
	private String comment;
	/** 主键 **/
	private boolean primaryKey;
	/** 是否自动递增  **/
	private boolean isAutoIncrement = false;
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getAttributeType() {
		return attributeType;
	}
	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}
	public String getJdbcType() {
		return jdbcType;
	}
	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}
	public String getFullAttributeType() {
		return fullAttributeType;
	}
	public void setFullAttributeType(String fullAttributeType) {
		this.fullAttributeType = fullAttributeType;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	public boolean isAutoIncrement() {
		return isAutoIncrement;
	}
	public void setAutoIncrement(boolean isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}
	public Column() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Column(String columnName, String columnType, String attributeName, String attributeType, String jdbcType,
			String fullAttributeType, String comment, boolean primaryKey, boolean isAutoIncrement) {
		super();
		this.columnName = columnName;
		this.columnType = columnType;
		this.attributeName = attributeName;
		this.attributeType = attributeType;
		this.jdbcType = jdbcType;
		this.fullAttributeType = fullAttributeType;
		this.comment = comment;
		this.primaryKey = primaryKey;
		this.isAutoIncrement = isAutoIncrement;
	}
	@Override
	public String toString() {
		return "Column [columnName=" + columnName + ", columnType=" + columnType + ", attributeName=" + attributeName
				+ ", attributeType=" + attributeType + ", jdbcType=" + jdbcType + ", fullAttributeType="
				+ fullAttributeType + ", comment=" + comment + ", primaryKey=" + primaryKey + ", isAutoIncrement="
				+ isAutoIncrement + "]";
	}

	
}

