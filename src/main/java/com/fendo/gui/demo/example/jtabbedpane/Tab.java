/**   
 * projectName: mybatis-generator-oracle   
 * fileName: Tab.java   
 * packageName: com.fendo.gui.demo.example.jtabbedpane   
 * date: 2018年3月5日上午9:53:01   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.example.jtabbedpane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 * @title: Tab.java
 * @package com.fendo.gui.demo.example.jtabbedpane
 * @description: TODO
 * @author: fendo
 * @date: 2018年3月5日 上午9:53:01
 * @version: V1.0
 */
public class Tab extends JFrame implements ActionListener {

	JMenuItem mi;

	static JTabbedPane pane;

	public Tab(){  
		super("选项卡窗格");   
		setVisible(true);    
		setSize(800,600);    
		setLocationRelativeTo(null);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		mi=new JMenuItem("增加");  
		JMenu menu=new JMenu("增加");  
		menu.add(mi);  
		JMenuBar bar=new JMenuBar();  
		bar.add(menu);  
		setJMenuBar(bar);  
		pane = new JTabbedPane();   
		add(pane);  
		new AddTab();   
		mi.addActionListener(this);  
  
	}

	public static void main(String[] args) throws Exception

	{

		new Tab();
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mi) {

			new AddTab();

		}

	}

}
