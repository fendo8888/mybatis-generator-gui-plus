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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**     
 * @title: JList_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: JList列表框示例   
 * @author: fendo  
 * @date: 2018年2月25日 下午12:22:58   
 * @version: V1.0     
*/
public class JList_3 {

	
	public JList_3() {
	     JFrame f=new JFrame("JList");
  	     //设置居中
         f.setLocationRelativeTo(null);
 		 //设置窗体大小
 		 f.setSize(600, 600);
	     Container contentPane=f.getContentPane();
	     ListModel mode=new DataModel();
	     JList list=new JList(mode);//利用ListModel建立一个JList.
	     list.setVisibleRowCount(5);//设置程序一打开时所能看到的数据项个数。   
	     list.setBorder(BorderFactory.createTitledBorder("配置一台电脑需要的组件"));

	     contentPane.add(new JScrollPane(list));
	     //f.pack();

	     f.setVisible(true);
	     f.addWindowListener(new WindowAdapter(){
	         public void windowClosing(WindowEvent e){
	           System.exit(0);  
	         }
	     });
	}
	
	//创建一个类，实现抽象类AbstractListModel，这个类用来创建一个列表框
	class DataModel extends AbstractListModel{
		  String[] s={"主板","显示器","内存","CPU","硬盘","电源","键盘","鼠标"};
		  public Object getElementAt(int index){                                       
		     return (index+1)+"."+s[index++];   
		  } 
		  public int getSize(){
		     return s.length;
		  }
	}
	
    public static void main(String args[])
    {
    	new JList_3();
    }

}
