/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package ${serviceimplPackage};

import java.util.List;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import ${modelPackage}.${beanName};
import ${servicePackage}.${beanName}Service;
import ${daoPackage}.${beanName}Mapper;

/**   
 * @Title: ${beanName}Impl.java 
 * @Package ${serviceimplPackage}
 * @Description: ${tableRemark} ServiceImpl
 * @author ${author}
 * @date ${date}
 * @version V1.0   
*/
@Service
public class ${beanName}ServiceImpl implements ${beanName}Service{

    public static final Logger LOGGER = Logger.getLogger(${beanName}Service.class);

	@Autowired
	public ${beanName}Mapper ${beanName?uncap_first}Mapper;

	@Override
	public ${beanName} find(String id) throws CommonException{
	    LOGGER.info("[/${beanName}Impl/find]");
	    ${beanName} ${beanName?uncap_first};
	    try {
            ${beanName?uncap_first} = ${beanName?uncap_first}Mapper.selectByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.error("${beanName?uncap_first}-find()-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","${beanName?uncap_first}-find()-Service层出现异常",e);
        }
		return ${beanName?uncap_first};
	}

	@Override
	public List<${beanName}> findList(${beanName} bean) throws CommonException{
	    LOGGER.info("[/${beanName}Impl/findList]");
	    List<${beanName}> ${beanName?uncap_first}List;
	    try {
            ${beanName?uncap_first}List = ${beanName?uncap_first}Mapper.selectAll(bean);
        }catch (Exception e){
            LOGGER.error("${beanName?uncap_first}-findList-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","${beanName?uncap_first}-findList()-Service层出现异常",e);
        }
		return ${beanName?uncap_first}List;
	}

	@Override
	public Page getPage(PageModel page) throws CommonException{
	    LOGGER.info("[/${beanName}Impl/getPage]");
	    Page p=page.getPage();
	    try {
             List<${beanName}> pageList = ${beanName?uncap_first}Mapper.queryPage(p);
		     p.setParameterType(pageList);
        }catch (Exception e){
            LOGGER.error("${beanName?uncap_first}-getPage-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","${beanName?uncap_first}-getPage()-Service层出现异常",e);
        }
		return p;
	}

	@Override
	public ${beanName} update(${beanName} bean) throws CommonException{
	    LOGGER.info("[/${beanName}Impl/update]");
	    try {
           ${beanName?uncap_first}Mapper.updateByPrimaryKeySelective(bean);
        }catch (Exception e){
            LOGGER.error("${beanName?uncap_first}-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","${beanName?uncap_first}-update()-Service层出现异常",e);
        }
		return null;
	}

	@Override
	public int insert(${beanName} bean) throws CommonException{
	    LOGGER.info("[/${beanName}Impl/insert]");
	    int flag;
	    try {
           flag = ${beanName?uncap_first}Mapper.insertSelective(bean);
        }catch (Exception e){
            LOGGER.error("${beanName?uncap_first}-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","${beanName?uncap_first}-insert()-Service层出现异常",e);
        }
		return flag;
	}

	@Override
	public int delete(String id) throws CommonException{
	    LOGGER.info("[/${beanName}Impl/delete]");
	    int flag;
	    try {
           flag = ${beanName?uncap_first}Mapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.error("${beanName?uncap_first}-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","${beanName?uncap_first}-delete()-Service层出现异常",e);
        }
		return flag;
	}

}
