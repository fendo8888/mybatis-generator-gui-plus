/**   
 * projectName: mybatis-generator-oracle   
 * fileName: GeneratorStart.java   
 * packageName: com.fendo.mybatisplus.start   
 * date: 2018年2月28日下午4:08:29   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.mybatisplus.start;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**     
 * @title: GeneratorStart.java   
 * @package com.fendo.mybatisplus.start   
 * @description: Mybatis-plus代码生成器  
 * @author: fendo  
 * @date: 2018年2月28日 下午4:08:29   
 * @version: V1.0     
*/
public class GeneratorStart {

    public static void main(String[] args) {
        String packageName = "com.gzsys.modules.yun";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName, "USER_LOGIN");
    }

    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        // 全局配置
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:oracle:thin:@//106.14.160.67:1521/test";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.ORACLE)
                .setUrl(dbUrl)
                .setUsername("test")
                .setPassword("Eru43wPo")
                .setDriverName("oracle.jdbc.driver.OracleDriver");
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true) // 全局大写命名 ORACLE 注意
                .setEntityLombokModel(false) //实体 是否为lombok模型（默认 false）
                .setDbColumnUnderline(true) //表名、字段名、是否使用下划线命名
                .setNaming(NamingStrategy.underline_to_camel) //表名生成策略
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        // strategyConfig.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        strategyConfig.setSuperEntityClass("com.fendo.common.persistence.BaseEntity");
        // 自定义实体，公共字段
        strategyConfig.setSuperEntityColumns(new String[] { "ID", "CREATE_TIME", "CREATE_NAME" , "UPDATE_TIME", "UPDATE_NAME", "STATE"});
        // 自定义 mapper 父类
        // strategyConfig.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        //strategyConfig.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        //strategyConfig.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        strategyConfig.setSuperControllerClass("com.fendo.common.web.BaseController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategyConfig.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategyConfig.setEntityBuliderModel(true);


        config.setActiveRecord(true) //是否 开启 ActiveRecord 模式
                .setAuthor("fendo")
                .setOutputDir("d:\\codeGen")
                .setFileOverride(true)
                .setActiveRecord(true)
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(false);// XML columList

        if (!serviceNameStartWithI) {
            config.setServiceName("%sService"); //自定义Service后戳,注意 %s 会自动填充表实体属性！
        }


        //生成文件 配置
        new AutoGenerator().setGlobalConfig(config)  //全局 相关配置
                .setDataSource(dataSourceConfig) //数据源配置
                .setStrategy(strategyConfig) //数据库表配置
                .setPackageInfo( //包 相关配置
                        new PackageConfig()  //跟包相关的配置项
                                .setParent(packageName)  //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
                                .setController("controller") //Controller包名
                                .setEntity("entity") //entity包名
                                //.setXml("/")
                )
                .execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }

}
