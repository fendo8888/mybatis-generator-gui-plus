package com.fendo.gui.util;

import java.util.Random;
import java.util.UUID;

/**
 * 
 * @title: IdGen.java   
 * @package com.fendo.gui.util   
 * @description: ID工具类  
 * @author: fendo  
 * @date: 2018年3月1日 下午3:47:07   
 * @version: V1.0
 */
public class IdGen {
	
	/**  
     * 生成32位编码  
     * @return string  
     */    
    public static String getUUID(){    
        String uuid =  UUID.randomUUID().toString().trim().replaceAll("-", "");    
        return uuid;    
    }

    /**
     * 生成19位的纯数字编码
     * @return
     */
    public static String getUUIDNumber(){
        int random = (int) (Math.random()*10000);
        if(random < 10000){
            random =random +1000000000;
        }
       String ran = System.currentTimeMillis() + random + getFixLenthString(6);  //19位
       return  ran;
    }

    /*
     * 返回长度为【strLength】的随机数，在前面补0
     */
    private static String getFixLenthString(int strLength) {

        Random rm = new Random();

        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);

        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);

        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1);
    }

}
