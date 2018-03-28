/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JComboBox_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午2:00:32   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**     
 * @title: JComboBox_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: JComboBox示例   利用ComboxModel模型来创建下拉列表框
 * @author: fendo  
 * @date: 2018年2月25日 下午2:00:32   
 * @version: V1.0     
*/
public class JComboBox_2 {

	String[] s= {"王鹏","朱雪莲","王宸博","朱广兴","朱广莲","马力","欧海","黎明"};
	
	public JComboBox_2(){
	    JFrame f=new JFrame("JComboBox");  
	    //设置居中
        f.setLocationRelativeTo(null);
	    Container contentPane=f.getContentPane();
	    ComboBoxModel mode=new UserDefineComboBoxModel();//创建一个UserDefineComboBoxModel对象
	    JComboBox combo=new JComboBox(mode);//通过UserDefineComboBoxModel对象来创建一个下拉列表框
	    combo.setBorder(BorderFactory.createTitledBorder("你的好朋友是谁?"));
	    contentPane.add(combo);
	    f.pack();
	    f.setVisible(true);
	    f.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent e){
	          System.exit(0);   
	        }
	    });   
	}
	
	//创建一个继承AbstractListModel 同时实现ComboBoxModel这个接口的类UserDefineComboBoxModel
	public class UserDefineComboBoxModel extends AbstractListModel implements ComboBoxModel {
		
	     String item=null;
	     
	     //由于继承AbstractListModel抽象类。因此我们分别在程序中实作了getElementAt()与getSize()方法。
	     public Object getElementAt(int index) {
	       return s[index++];   
	     }
	     
	     public int getSize(){
	        return s.length;    
	     }
	     
	     //由于我们实现了ComboBoxModel interface.因此我们必须在程序中实作setSelectedItem()与getSelectedItem()方法.
	     public void setSelectedItem(Object anItem) {
	          item=(String)anItem;  
	     }
	     
	     public Object getSelectedItem(){
	        return item;    
	     }
    }
	
    public static void main(String[] args){
    	new JComboBox_2();
    }

}
