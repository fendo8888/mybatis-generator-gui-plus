/**   
 * projectName: mybatis-generator-oracle   
 * fileName: Option_1.java   
 * packageName: com.fendo.gui.demo.option   
 * date: 2018年2月25日上午11:38:50   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.option;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**     
 * @title: Option_1.java   
 * @package com.fendo.gui.demo.option   
 * @description: 提示框示例1  
 * @author: fendo  
 * @date: 2018年2月25日 上午11:38:50   
 * @version: V1.0     
*/
public class Option_1 {


	public static void main(String[] args) throws Exception {
		//提示窗体/提示框
		JOptionPane jp = new JOptionPane();
		//确定对话框
		int  a  = jp.showConfirmDialog(null, "确定要删除吗?");
		String str = jp.showInputDialog(null, "请输入值：");
		jp.showMessageDialog(null, "已经删除了哦！");
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		System.out.println(str);
	}

}
