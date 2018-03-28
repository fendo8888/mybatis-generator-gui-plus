package com.fendo.gen.start;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**   
 * @Title: Start.java 
 * @Package com.fendo.test 
 * @Description: TODO
 * @author fendo
 * @date 2017年10月16日 下午6:08:44 
 * @version V1.0   
*/
public class Start {
	
	public static void main(String[] args) throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("D:\\Source_Work\\mybatis-generator-oracle\\src\\main\\resources\\generatorConfig.xml");
		
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback, warnings);
		myBatisGenerator.generate(null);
	}

}
