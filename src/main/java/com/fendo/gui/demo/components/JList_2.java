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
public class JList_2 {

    public static void main(String args[])
    {
        JFrame f = new JFrame("JList");
  	    //设置居中
        f.setLocationRelativeTo(null);
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(1,3));//设置面板为GridLayout布局方式
        //创建两个数组，s1和s2，分别存储国家名和姓名
        String[] s1 = {"美国","日本","大陆","英国","法国","意大利","澳洲","韩国"};
        String[] s2 = {"范志毅","符兵","周宁","杨晨","高锋","南方","其他"};
        Vector v = new Vector();//创建一个Vector数据结构
        //将数据存储到Vector数据结构中
        v.addElement("Nokia 3310");
        v.addElement("Nokia 8850");
        v.addElement("Nokia 8250");
        v.addElement("Motorola V8088");
        v.addElement("Motorola V3688x");
        v.addElement("Panasonic GD92");
        v.addElement("Panasonic GD93");
        v.addElement("NEC DB2100");
        v.addElement("Alcatel OT500");
        v.addElement("Philips Xenium 9@9 ");
        v.addElement("Ericsson T29sc");
        v.addElement("其他");

        JList list1 = new JList(s1);//创建一个列表框
        list1.setBorder(BorderFactory.createTitledBorder("您最喜欢到哪个国家玩呢？"));//设置主题

        JList list2 = new JList(s2); //创建一个列表框
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 一次只能选择一个列表索引
        list2.setBorder(BorderFactory.createTitledBorder("您最喜欢哪个运动员呢？"));//设置主题

        JList list3 = new JList(v); //创建一个列表框
        list3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);// 一次只能选择一个列表索引
        list3.setBorder(BorderFactory.createTitledBorder("您最喜欢哪一种手机？"));
        contentPane.add(new JScrollPane(list1));
        contentPane.add(new JScrollPane(list2));
        contentPane.add(new JScrollPane(list3));
        f.pack();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }

}
