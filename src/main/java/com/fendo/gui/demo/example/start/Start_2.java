/**   
 * projectName: mybatis-generator-oracle   
 * fileName: Start_1.java   
 * packageName: com.fendo.gui.demo.example.start   
 * date: 2018年2月25日下午4:03:36   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.example.start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * @title: Start_1.java
 * @package com.fendo.gui.demo.example.start
 * @description: TODO
 * @author: fendo
 * @date: 2018年2月25日 下午4:03:36
 * @version: V1.0
 */
public class Start_2 extends JFrame{

	JPanel jpl = new JPanel();
	//中转界面图片   超管界面
	JLabel jlb = new JLabel(new ImageIcon("D:\\Users\\Administrator\\Workspaces\\MyEclipse Professional 2014\\Xianmu\\src\\photo\\zz.gif"));
	//图片上的字体数组
	JLabel[] a = {new JLabel("超级程序启动."),new JLabel("超级程序启动.."), new JLabel("超级程序启动..."),new JLabel("超级程序启动...."),new JLabel("超级程序启动....."),new JLabel("超级程序启动......"),
				  new JLabel("数据启动."),new JLabel("数据启动.."), new JLabel("数据启动..."),new JLabel("数据启动...."),new JLabel("数据启动....."),new JLabel("数据启动......"),
				  new JLabel("加载成功."),new JLabel("加载成功.."), new JLabel("加载成功..."),new JLabel("加载成功...."),new JLabel("加载成功....."),new JLabel("加载成功......"),
				  new JLabel("跳转超级管理员页面."),new JLabel("跳转超级管理员页面.."), new JLabel("跳转超级管理员页面..."),new JLabel("跳转超级管理员页面...."),new JLabel("跳转超级管理员页面....."),new JLabel("跳转超级管理员页面......"),	
				  new JLabel(""), new JLabel("")
	};
	
	MyThread mt = null;
	
	private void init() {
		jpl.setLayout(null);
		//将中转界面放入面板
		jlb.setBounds(0, 0, 376, 172);
		jpl.add(jlb);
	}
	
	/**
	 * 中转界面
	 */
	public Start_2() {
		this.setSize(376, 172);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		init();
		mt = new MyThread();
		mt.start();
		this.add(jpl);
		this.setVisible(true);
	}
	
	public class MyThread extends Thread{
		@Override
		public void run() {
			for(int i=0;i<=25;i++){
					a[i].setFont(new Font("宋体", 1, 20));//更改字体设置
					a[i].setForeground(Color.BLACK);//更改字体颜色
					a[i].setBounds(10, 100, 150, 100);
					if(i!=0){
						jlb.remove(a[i-1]);
					}
					jlb.repaint();
					jlb.add(a[i]);
					if(i==25){
						Start_2.this.setVisible(false);
						new Start_1();
					}
				
				try {
					//休眠
					new Thread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		new Start_2();
	}
	
}
