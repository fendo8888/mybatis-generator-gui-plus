package com.fendo.freemarker.util;

import java.io.IOException;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**   
 * @Title: FreeMarkerTemplateUtils.java 
 * @Package com.fendo.utils 
 * @Description: FreeMarkerTemplateUtils工具类用来配置模板所在的路径
 * @author fendo
 * @date 2017年12月2日 下午11:00:14 
 * @version V1.0   
*/
public class FreeMarkerTemplateUtils {

	 private FreeMarkerTemplateUtils(){}
	 private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

     static{
        //这里比较重要，用来指定加载模板所在的路径
        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtils.class, "/templates"));
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
     }

	public static Template getTemplate(String templateName) throws IOException {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            throw e;
        }
	}

	public static void clearCache() {
	     CONFIGURATION.clearTemplateCache();
	}
}
