/**   
 * projectName: mybatis-generator-oracle   
 * fileName: BoxLayout_1.java   
 * packageName: com.fendo.gui.demo.layout   
 * date: 2018年2月25日下午2:39:28   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.layout;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**     
 * @title: BoxLayout_1.java   
 * @package com.fendo.gui.demo.layout   
 * @description: BoxLayout是箱式布局，它可以创建水平箱和垂直箱两种箱子。  
 * @author: fendo  
 * @date: 2018年2月25日 下午2:39:28   
 * @version: V1.0     
*/
public class BoxLayout_1 {

	public static void main(String[] args) {
        BoxLayoutFrame frame1=new BoxLayoutFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
	}

}

class BoxLayoutFrame extends JFrame{

    private static final int WIDTH=300;
    private static final int HEIGHT=200;
    
    public BoxLayoutFrame() {
        setTitle("测试箱式布局管理器");//设置顶层容器名称、大小
        setLocationRelativeTo(null);
        setSize(WIDTH,HEIGHT);
        Container con=getContentPane();//创建一个中间容器
        JLabel label1=new JLabel(" 姓名：");//创建标签组件、文本框组件
        JTextField textField1=new JTextField(10);
        textField1.setMaximumSize(textField1.getPreferredSize());
        Box hbox1=Box.createHorizontalBox();//创建一个水平箱子
        hbox1.add(label1); //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
        hbox1.add(Box.createHorizontalStrut(20));
        hbox1.add(textField1);  
        JLabel label2=new JLabel(" 密码：");//创建标签组件、文本框组件
        JTextField textField2=new JTextField(10);
        textField2.setMaximumSize(textField2.getPreferredSize());
        Box hbox2=Box.createHorizontalBox();//创建一个水平箱子
        hbox2.add(label2); //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
        hbox2.add(Box.createHorizontalStrut(20));
        hbox2.add(textField2);  
        JButton button1=new JButton("确定");//创建两个普通按钮组件，并且创建一个水平箱子，将两个按钮添加到箱子中
        JButton button2=new JButton("取消");
        Box hbox3=Box.createHorizontalBox();
        hbox3.add(button1);
        hbox3.add(button2);
        Box vbox=Box.createVerticalBox();//创建一个垂直箱子，这个箱子将两个水平箱子添加到其中，创建一个横向 glue 组件。
        vbox.add(hbox1);
        vbox.add(hbox2);
        vbox.add(Box.createVerticalGlue());
        vbox.add(hbox3);
        con.add(vbox,BorderLayout.CENTER); // 将垂直箱子添加到BorderLayout布局管理器中的中间位置  
    }

}