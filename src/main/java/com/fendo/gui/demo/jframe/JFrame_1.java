/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JFrame_1.java   
 * packageName: com.fendo.gui.demo.jframe   
 * date: 2018年2月25日上午11:25:11   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.jframe;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**     
 * @title: JFrame_1.java   
 * @package com.fendo.gui.demo.jframe   
 * @description: JFrame窗体示例1  
 * @author: fendo  
 * @date: 2018年2月25日 上午11:25:11   
 * @version: V1.0     
*/
public class JFrame_1 {


	public static void main(String[] args) {
		//创建一个主窗体
		JFrame  jf = new JFrame();
		//设置标题
		jf.setTitle("这个是我们的第一个窗体哦");
		
		//设置图标
		ImageIcon ii = new ImageIcon("images/user.jpg");
		Image image = ii.getImage();
		jf.setIconImage(image);
		
		//设置窗体大小
		jf.setSize(500, 400);
		//设置窗体居中显示
		jf.setLocationRelativeTo(null);
		//设置关闭窗体的时候退出程序
		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setDefaultCloseOperation(3);
		//设置窗体不能改变大小
		jf.setResizable(false);
		//设置窗体的的底色getContentPane():获取内容面板
		jf.getContentPane().setBackground(new Color(255,0,0));
		//设置边框是否可见
		jf.setUndecorated(false);
		
		//让窗体可见
		jf.setVisible(true);
	}

}
