package com.fendo.gui.demo.layout;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @title: BorderLayout_1.java   
 * @package com.fendo.gui.demo.borderlayout   
 * @description: BorderLayout布局示例1  
 * @author: fendo  
 * @date: 2018年2月25日 上午11:22:53   
 * @version: V1.0
 */
public class BorderLayout_1 extends JFrame{

	public BorderLayout_1() throws HeadlessException {
		this.setSize(400, 500);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		//面板
		JPanel jpl = new JPanel();
		//设置为边框布局
		this.setLayout(new BorderLayout());
		//按钮
		JButton btnA = new JButton("按钮A");
		JButton btnB = new JButton("按钮B");
		JButton btnC = new JButton("按钮C");
		JButton btnD = new JButton("按钮D");
		JButton btnE = new JButton("麻将桌");
		//添加   北：North  南：South  西：West 东：East  中：Center
		this.add(btnA, "North");
		this.add(btnB, "South");
		this.add(btnC,"West");
		this.add(btnD,"East");
		this.add(btnE,"Center");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayout_1();
	}
	
}
