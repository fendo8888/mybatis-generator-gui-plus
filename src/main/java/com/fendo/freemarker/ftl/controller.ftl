/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package ${controllerPackage};

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;


import ${modelPackage}.${beanName};
import ${servicePackage}.${beanName}Service;

/**
 * @version V1.0
 * @Author ${author}
 * @ClassName ${beanName}Controller
 * @PackageName ${controllerPackage}
 * @Description ${tableRemark} Controller
 * @Data ${date}
 **/
@Controller
@RequestMapping("${beanName?lower_case}")
public class ${beanName}Controller {

	public static final Logger LOGGER = Logger.getLogger(${beanName}Controller.class);

    @Autowired
    private ${beanName}Service ${beanName?uncap_first}Service;

    /**
     *
     *@Title findById
     *@Description: 根据ID获取${tableRemark}
     *@Author ${author}
     *@Date ${date}
     *@param id(主键)
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/${beanName?lower_case}/findById?id=xxxx
     */
    @RequestMapping(value="findById",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult findById(String id){
        LOGGER.info("[/${beanName}Controller/findById]");
		SimpleResult simpleResult;
		${beanName} ${beanName?uncap_first};
        try {
            simpleResult = new SimpleResult();
            simpleResult.put("code","000");
            simpleResult.put("message","成功");
            ${beanName?uncap_first} = ${beanName?uncap_first}Service.find(id);
            simpleResult.put("data",${beanName?uncap_first});
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }
    
    
    /**
     *
     *@Title getPage
     *@Description: 分页查询
     *@Author ${author}
     *@Date ${date}
     *@param page(分页数据)
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/${beanName?lower_case}/getPage?pageNo=2&pageSize=1
     */
    @RequestMapping(value="getPage",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult getPage(PageModel page){
        LOGGER.info("[/${beanName}Controller/getPage]");
        SimpleResult simpleResult;
        Page p;
        try {
            simpleResult = new SimpleResult();
            simpleResult.put("code","000");
            simpleResult.put("message","成功");
            p = ${beanName?uncap_first}Service.getPage(page);
            simpleResult.put("data",p);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    /**
     *
     *@Title create
     *@Description: 新建${tableRemark}
     *@Author ${author}
     *@Date ${date}
     *@param ${beanName?uncap_first}
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/${beanName?lower_case}/create?xxx
     */
    @RequestMapping(value="create",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult create(${beanName} ${beanName?uncap_first}){
    	SimpleResult simpleResult;
	    LOGGER.info("[/${beanName}Controller/create]");
        try {
            simpleResult=SimpleResult.success();
            ${beanName?uncap_first}Service.insert(${beanName?uncap_first});
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult; 
    }

    /**
     *
     *@Title deleteById
     *@Description: 根据主键删除${tableRemark}
     *@Author ${author}
     *@Date ${date}
     *@param id
     *@return SimpleResult
     *@throws
     */
    @RequestMapping(value = "deleteById", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
    public SimpleResult deleteById(String id) throws Exception {
        SimpleResult simpleResult;
	    LOGGER.info("[/${beanName}Controller/deleteById]");
        try {
            simpleResult=SimpleResult.success();
            ${beanName?uncap_first}Service.delete(id);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    /**
     *
     *@Title update
     *@Description: 更新${tableRemark}
     *@Author ${author}
     *@Date ${date}
     *@param ${beanName?uncap_first}
     *@return SimpleResult
     *@throws
     */
    @RequestMapping(value = "update", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult update(${beanName} ${beanName?uncap_first}) throws Exception {
        SimpleResult simpleResult;
	    LOGGER.info("[/${beanName}Controller/update]");
        try {
            simpleResult=SimpleResult.success();
            ${beanName?uncap_first}Service.update(${beanName?uncap_first});
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

}