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

import javax.swing.BorderFactory;
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
 * @description: JList列表框示例  
 * @author: fendo  
 * @date: 2018年2月25日 下午12:22:58   
 * @version: V1.0     
*/
public class JList_1 {


    public static void main(String[] args){
        JFrame f=new JFrame("测试窗口");
        f.setSize(400,300);
        f.setLocation(0,0);
  	    //设置居中
        f.setLocationRelativeTo(null);
        
        JPanel p=new JPanel();
        f.setContentPane(p);
        p.setLayout(new BorderLayout());
        //将数据存储到数组name中
        String[] name = {"王鹏","王宸博","朱雪莲","王棋淋","项西云","文日珍","宋丽","田秀"};
        JList l = new JList(name);//通过JList(String text)构造器将数组中的数据直接列举在列表框中
        l.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				do_list_valueChanged(e,f,l);
			}
		});
        p.add(l,"North");
        f.setVisible(true);
        
    }

	protected static void do_list_valueChanged(ListSelectionEvent e,JFrame jFrame,JList l) {
	    JOptionPane.showMessageDialog(jFrame, "点击的是：" +l.getSelectedValue(), null, JOptionPane.INFORMATION_MESSAGE);
	}

}
