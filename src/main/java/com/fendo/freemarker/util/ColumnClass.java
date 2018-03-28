package com.fendo.freemarker.util;
/**   
 * @Title: ColumnClass.java 
 * @Package com.fendo.utils 
 * @Description: 数据库字段封装类
 * @author fendo
 * @date 2017年12月2日 下午11:08:58 
 * @version V1.0   
*/
public class ColumnClass {

	  /** 数据库字段名称 **/
    private String columnName;
    /** 数据库字段类型 **/
    private String columnType;
    /** 数据库字段首字母小写且去掉下划线字符串, 转换字段名称,如 sys_name变成 SysName**/
    private String changeColumnName;
    /** 数据库字段注释 **/
    private String columnComment;

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

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

    public String getChangeColumnName() {
        return changeColumnName;
    }

    public void setChangeColumnName(String changeColumnName) {
        this.changeColumnName = changeColumnName;
    }
	
}
