/**   
 * projectName: mybatis-generator-oracle   
 * fileName: BaseEntity.java   
 * packageName: com.fendo.common.persistence   
 * date: 2018年2月28日下午4:18:21   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.common.persistence;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**     
 * @title: BaseEntity.java   
 * @package com.fendo.common.persistence   
 * @description: 实体类基类  
 * @author: fendo  
 * @date: 2018年2月28日 下午4:18:21   
 * @version: V1.0     
*/
public class BaseEntity <T extends Model> extends Model<T>{

    /**
     *  主键
     */
    @TableId(value="ID")
    private String id;

    /**
     * @Fields createTime 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * @Fields createName 创建名称
     */
    @TableField("CREATE_NAME")
    private String createName;

    /**
     * @Fields updateTime 更新时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * @Fields updateName 更新名称
     */
    @TableField("UPDATE_NAME")
    private String updateName;

    /**
     * @Fields state 删除标记位 0已删除 1未删除
     */
    private String state;

    @Override
    protected Serializable pkVal() {
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
	
}
