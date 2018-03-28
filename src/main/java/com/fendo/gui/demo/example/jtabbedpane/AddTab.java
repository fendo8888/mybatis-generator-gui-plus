/**   
 * projectName: mybatis-generator-oracle   
 * fileName: AddTab.java   
 * packageName: com.fendo.gui.demo.example.jtabbedpane   
 * date: 2018年3月5日上午9:52:00   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.example.jtabbedpane;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @title: AddTab.java
 * @package com.fendo.gui.demo.example.jtabbedpane
 * @description: TODO
 * @author: fendo
 * @date: 2018年3月5日 上午9:52:00
 * @version: V1.0
 */
public class AddTab implements MouseListener {

	JPanel jp;

	JLabel lab;

	JLabel lab3 = new JLabel();

	public AddTab(){  
	  
	       lab= new JLabel("选项卡1");  
	  
	       JLabel lab1 = new JLabel("选项卡");  
	  
	       jp=new JPanel();  
	  
	       GridLayout gl= new GridLayout(1,1,10,0);  
	  
	       jp.setLayout(gl);  
	  
	       lab1.setHorizontalAlignment(JLabel.LEFT);//设置文字显示在最左边  
	  
	       lab3.setHorizontalAlignment(JLabel.RIGHT);// 设置文字显示在最右边  
	  
	       jp.add(lab1);  
	  
	       jp.add(lab3);  
	  
	       Tab.pane.addTab("i",lab);  
	  
	       Tab.pane.setTabComponentAt(Tab.pane.indexOfComponent(lab),jp);//实现这个功能的就这一条最重要的语句  
	  
	       lab3.addMouseListener(this);  
	  
	    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Tab.pane.remove(Tab.pane.indexOfTabComponent(jp));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		lab3.setText("x ");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		lab3.setText("");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
