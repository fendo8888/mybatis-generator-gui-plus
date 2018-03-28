/**   
 * projectName: mybatis-generator-oracle   
 * fileName: BaseController.java   
 * packageName: com.fendo.common.web   
 * date: 2018年2月28日下午4:20:01   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.common.web;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**     
 * @title: BaseController.java   
 * @package com.fendo.common.web   
 * @description: Controller基类  
 * @author: fendo  
 * @date: 2018年2月28日 下午4:20:01   
 * @version: V1.0     
*/
public abstract class BaseController {

    @Autowired
    public Validator validator;

    protected Logger logger = LoggerFactory.getLogger(getClass());

	
}
