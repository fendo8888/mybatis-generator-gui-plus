/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JList_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午12:22:58   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**     
 * @title: JList_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: JList列表框示例  双击事件
 * @author: fendo  
 * @date: 2018年2月25日 下午12:22:58   
 * @version: V1.0     
*/
public class JList_4 extends MouseAdapter{

    JList list1=null; 
    JList list2=null; 
    DefaultListModel mode1=null;
    DefaultListModel mode2=null;
    String[] s = {"Java入门书","C语言书","Hibernate书","Visual Basic书","ASP书","Dephi书","电脑组装书","Photoshop书"};
    
	public JList_4() {
		
	    JFrame f=new JFrame("JList");
  	    //设置居中
        f.setLocationRelativeTo(null);
	    Container contentPane=f.getContentPane();
	    contentPane.setLayout(new GridLayout(1,2));
	    mode1=new DataModel(1);
	    list1=new JList(mode1);
	    list1.setBorder(BorderFactory.createTitledBorder("图书种类!"));
	    list1.addMouseListener(this);//一遇到鼠标事件立即执行.

	    mode2=new DataModel(2);
	    list2=new JList(mode2);
	    list2.setBorder(BorderFactory.createTitledBorder("你所需要选择的书："));
	    list2.addMouseListener(this);//一遇到鼠标事件立即执行.

	    contentPane.add(new JScrollPane(list1));
	    contentPane.add(new JScrollPane(list2));
	   f.pack();
	   f.setVisible(true);
	   f.addWindowListener(new WindowAdapter(){
	      public void windowClosing(WindowEvent e){
	         System.exit(0);
	      }
	   });    
	}
	
	
	//处理鼠标双击事件.
	public void mouseClicked(MouseEvent e){
	     int index;
	     if (e.getSource()==list1){
		      if (e.getClickCount()==2){
		      //当双击左边列表框中选项，会在左边将此项去掉，在右边列表框中将此项添加
		      index=list1.locationToIndex(e.getPoint());
		      String tmp=(String)mode1.getElementAt(index);
		      mode2.addElement(tmp);
		      list2.setModel(mode2);
		      mode1.removeElementAt(index);
		      list1.setModel(mode1);
		   }    
	    }
	    if (e.getSource()==list2){
		   if (e.getClickCount()==2){
		          //当双击右边列表框中选项，会在右边将此项去掉，在左边列表框中将此项添加
		          index=list2.locationToIndex(e.getPoint());
		          String tmp=(String)mode2.getElementAt(index);
		          mode1.addElement(tmp);
		          list1.setModel(mode1);
		          mode2.removeElementAt(index);
		          list2.setModel(mode2);
		       }    
	     }
	}
		  
	//让DateModel继承DefaultListModel类，创建一个列表框类
	public class DataModel extends DefaultListModel{
	     public DataModel(int flag){
	          if (flag==1){
	             for (int i=0;i<s.length;i++)  
	            	 addElement(s[i]);                
	          }
	      }
	}	
	
    public static void main(String args[])
    {
    	new JList_4();
    }

}
