/**   
 * projectName: mybatis-generator-oracle   
 * fileName: Dialog_1.java   
 * packageName: com.fendo.gui.demo.dialog   
 * date: 2018年2月25日上午11:37:44   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.dialog;

import java.awt.Color;

import javax.swing.JDialog;

/**     
 * @title: Dialog_1.java   
 * @package com.fendo.gui.demo.dialog   
 * @description: Dialog弹窗框_1  
 * @author: fendo  
 * @date: 2018年2月25日 上午11:37:44   
 * @version: V1.0     
*/
public class Dialog_1 {


	public static void main(String[] args) {
		//创建模式窗体
		JDialog jd = new JDialog();
		//设置标题
		jd.setTitle("这个是我的第一个模式窗体");
		//设置大小
		jd.setSize(500, 300);
		//设置居中
		jd.setLocationRelativeTo(null);
		//设置关闭的方式
		jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//设置窗口大小是否可变
		jd.setResizable(true);
		//设置底色
		jd.getContentPane().setBackground(Color.GREEN);
		//设置可见
		jd.setVisible(true);
	}

}
