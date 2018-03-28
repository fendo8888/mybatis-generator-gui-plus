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
 * @description: BorderLayout布局示例2  
 * @author: fendo  
 * @date: 2018年2月25日 上午11:22:53   
 * @version: V1.0
 */
public class BorderLayout_2 extends JFrame{

	public BorderLayout_2() throws HeadlessException {
		this.setSize(400, 500);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		//设置内容面板的布局
		this.setLayout(new BorderLayout());
		//上半部分
		JPanel jpla = new JPanel();
		jpla.setLayout(new BorderLayout());
		JButton btnA = new JButton("按钮A");
		JButton btnB = new JButton("按钮B");
		JButton btnC = new JButton("按钮C");
		JButton btnD = new JButton("按钮D");
		JButton btnE = new JButton("麻将桌");
		//添加
		jpla.add(btnA, "North");
		jpla.add(btnB, "South");
		jpla.add(btnC,"West");
		jpla.add(btnD,"East");
		jpla.add(btnE,"Center");
		//左半部分
		//上半部分
		JPanel jplb = new JPanel();
		jplb.setLayout(new BorderLayout());
		JButton btnAa = new JButton("按钮A");
		JButton btnBb = new JButton("按钮B");
		JButton btnCc = new JButton("按钮C");
		JButton btnDd = new JButton("按钮D");
		JButton btnEe = new JButton("麻将桌");
		//添加
		jplb.add(btnAa, "North");
		jplb.add(btnBb, "South");
		jplb.add(btnCc,"West");
		jplb.add(btnDd,"East");
		jplb.add(btnEe,"Center");

		this.add(jpla, "North");
		this.add(jplb,"West");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayout_2();
	}
	
}
