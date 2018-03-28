/**   
 * projectName: mybatis-generator-oracle   
 * fileName: GridBagLayout_1.java   
 * packageName: com.fendo.gui.demo.gridbaglayout   
 * date: 2018年2月25日上午11:41:12   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.gridbaglayout;

import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**     
 * @title: GridBagLayout_1.java   
 * @package com.fendo.gui.demo.gridbaglayout   
 * @description: 网带布局示例1  
 * @author: fendo  
 * @date: 2018年2月25日 上午11:41:12   
 * @version: V1.0     
*/
public class GridBagLayout_1 extends JFrame{

	
	
	public GridBagLayout_1() {
		this.setSize(400, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//面板
		JPanel jpl = new JPanel();
		//设置jpl的布局布局
		//GridLayout:网格布局
		//GridBagLayout:网带布局
		GridBagLayout gbl = new GridBagLayout();
		//创建网带布局约束对象
		GridBagConstraints  gbc = new GridBagConstraints();
		jpl.setLayout(gbl);
		
		//用户名
		JLabel jlbUser = new JLabel("用户名：");
		gbc.gridx = 0;
		gbc.gridy = 0;
		//将约束跟要添加的对象相关联
		gbl.setConstraints(jlbUser, gbc);
		jpl.add(jlbUser);
		
		JTextField jtfUser = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbl.setConstraints(jtfUser, gbc);
		jpl.add(jtfUser);
		//密码
		JLabel jlbPwd = new JLabel("密   码：");
		gbc.gridx = 0;
		gbc.gridy = 1;
		//设置上下左右对齐方式
		gbc.insets = new Insets(10, 0, 0, 0);
		gbl.setConstraints(jlbPwd, gbc);
		jpl.add(jlbPwd);
		
		JPasswordField jpfPwd = new JPasswordField(15);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbl.setConstraints(jpfPwd, gbc);
		jpl.add(jpfPwd);
		//使用网带布局的步骤
		//1、创建网带布局对象GridBagLoyout  
		//2、创建网带布局的约束对象
		//3、设置约束的内容
		//4、将要添加的组件跟约束相关联
		
		//退出
		JButton btnExit = new JButton("退出");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(btnExit, gbc);
		jpl.add(btnExit);
		//给退出按钮添加功能（内部类的方式）
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//MyF.this.dispose();
				int a = JOptionPane.showConfirmDialog(null, "确定要退出吗？");
				if(a==0){
					System.exit(0);
				}
			}
		});
		
		this.setContentPane(jpl);
		this.setVisible(true);	
	}

	public static void main(String[] args) {
		
		new GridBagLayout_1();

	}

}
