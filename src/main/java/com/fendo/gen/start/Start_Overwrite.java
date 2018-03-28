/**   
 * projectName: mybatis-generator-oracle   
 * fileName: Start_Overwrite.java   
 * packageName: com.fendo.gen.start   
 * date: 2018年2月25日下午5:50:56   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gen.start;

import org.mybatis.generator.api.ShellRunner;

/**     
 * @title: Start_Overwrite.java   
 * @package com.fendo.gen.start   
 * @description: TODO  
 * @author: fendo  
 * @date: 2018年2月25日 下午5:50:56   
 * @version: V1.0     
*/
public class Start_Overwrite {


    public static void main(String[] args) throws Exception {
        // 调试初始化参数
    	Start_Overwrite test = new Start_Overwrite();
        //取得根目录路径
        String rootPath = test.getClass().getResource("/").getFile().toString();
        //当前目录路径
        //String currentPath1=test.getClass().getResource(".").getFile().toString();
        //String currentPath2=test.getClass().getResource("").getFile().toString();
        //当前目录的上级目录路径
        //   String parentPath=test.getClass().getResource("../").getFile().toString();
        //String[] arg = new String[]{"-configfile", rootPath + "test/generatorConfig.xml", "-overwrite"};
        String[] arg = new String[]{"-configfile", rootPath + "test/generatorConfigForMySql.xml", "-overwrite"};
        ShellRunner.main(arg);
    }

}
