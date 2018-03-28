package com.fendo.gen.mapper;

import java.util.List;

import com.fendo.gen.bean.BaseModel;
import com.fendo.gen.bean.Page;
import com.fendo.gen.bean.PageModel;



/**   
 * @Title: BaseMapper.java 
 * @Package com.fendo.gen.mapper 
 * @Description: mapper基类
 * @author fendo
 * @date 2017年12月2日 下午5:33:05 
 * @version V1.0   
*/
public interface  BaseMapper<T extends BaseModel> {

	List<T> selectAll();

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKey(T record);
    
    int updateByPrimaryKeySelective(T record);
    
    Page queryPage(PageModel page);

}
