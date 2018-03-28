/**   
 * projectName: mybatis-generator-oracle   
 * fileName: PropertiesFileUtil.java   
 * packageName: com.fendo.gen.util   
 * date: 2018年2月26日下午8:25:22   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gen.util;

import java.util.Date;
import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**     
 * @title: PropertiesFileUtil.java   
 * @package com.fendo.gen.util   
 * @description: 资源文件读取工具  
 * @author: fendo  
 * @date: 2018年2月26日 下午8:25:22   
 * @version: V1.0     
*/
public class PropertiesFileUtil {

	// 当打开多个资源文件时，缓存资源文件
    private static HashMap<String, PropertiesFileUtil> configMap = new HashMap<String, PropertiesFileUtil>();
    // 打开文件时间，判断超时使用
    private Date loadTime = null;
    // 资源文件
    private ResourceBundle resourceBundle = null;
    // 默认资源文件名称
    private static final String NAME = "config";
    // 缓存时间
    private static final Integer TIME_OUT = 60 * 1000;

    // 私有构造方法，创建单例
    private PropertiesFileUtil(String name) {
        this.loadTime = new Date();
        this.resourceBundle = ResourceBundle.getBundle(name);
    }

    public static synchronized PropertiesFileUtil getInstance() {
        return getInstance(NAME);
    }

    public static synchronized PropertiesFileUtil getInstance(String name) {
        PropertiesFileUtil conf = configMap.get(name);
        if (null == conf) {
            conf = new PropertiesFileUtil(name);
            configMap.put(name, conf);
        }
        // 判断是否打开的资源文件是否超时1分钟
        if ((System.currentTimeMillis() - conf.getLoadTime().getTime()) > TIME_OUT) {
            conf = new PropertiesFileUtil(name);
            configMap.put(name, conf);
        }
        return conf;
    }

    // 根据key读取value
    public String get(String key) {
        try {
            String value = resourceBundle.getString(key);
            return value;
        } catch (MissingResourceException e) {
            return "";
        }
    }

    // 根据key读取value(整形)
    public Integer getInt(String key) {
        try {
            String value = resourceBundle.getString(key);
            return Integer.parseInt(value);
        } catch (MissingResourceException e) {
            return null;
        }
    }

    // 根据key读取value(布尔)
    public boolean getBool(String key) {
        try {
            String value = resourceBundle.getString(key);
            if ("true".equals(value)) {
                return true;
            }
            return false;
        } catch (MissingResourceException e) {
            return false;
        }
    }

    public Date getLoadTime() {
        return loadTime;
    }

    
}
