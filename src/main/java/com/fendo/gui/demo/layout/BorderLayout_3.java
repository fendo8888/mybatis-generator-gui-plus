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
 * @description: BorderLayout布局示例3 
 * @author: fendo  
 * @date: 2018年2月25日 上午11:22:53   
 * @version: V1.0
 */
public class BorderLayout_3 {

	static final int WIDTH=300;
    static final int HEIGHT=200;
    
    public static void main(String[] args) {
         JFrame jf=new JFrame("测试程序");
         jf.setSize(WIDTH,HEIGHT);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     //设置居中
	     jf.setLocationRelativeTo(null);
         JPanel contentPane=new JPanel();
         jf.setContentPane(contentPane);
         JButton b1=new JButton("港币");//创建了二十五个普通按钮组件
         JButton b2=new JButton("人民币");
         JButton b3=new JButton("美元");
         JButton b4=new JButton("欧元");
         JButton b5=new JButton("英镑");
         JButton b6=new JButton("主板");
         JButton b7=new JButton("内存");
         JButton b8=new JButton("硬盘");
         JButton b9=new JButton("显示器");
         JButton b10=new JButton("鼠标");
         JButton b11=new JButton("大米");
         JButton b12=new JButton("蔬菜");
         JButton b13=new JButton("稻子");
         JButton b14=new JButton("猪肉");
         JButton b15=new JButton("牛肉");
         JButton b16=new JButton("面包");
         JButton b17=new JButton("蛋糕");
         JButton b18=new JButton("巧克力");
         JButton b19=new JButton("奶酪");
         JButton b20=new JButton("苹果派");
         JButton b21=new JButton("笔记本");
         JButton b22=new JButton("电话");
         JButton b23=new JButton("办公桌");
         JButton b24=new JButton("钢笔");
         JButton b25=new JButton("文件夹");
         jf.setLayout(new BorderLayout());
         JPanel p1=new JPanel();//创建了五个中间容器，并且将它们的布局管理器都设置成BorderLayout方式。
         JPanel p2=new JPanel();
         JPanel p3=new JPanel();
         JPanel p4=new JPanel();
         JPanel p5=new JPanel();
         p1.setLayout(new BorderLayout());
         p2.setLayout(new BorderLayout());
         p3.setLayout(new BorderLayout());
         p4.setLayout(new BorderLayout());
         p5.setLayout(new BorderLayout());
         contentPane.add(p1,"North");//将五个中间容器对象分别加入到上层中间容器中，并且是按照BorderLayout的方式进行布局
         contentPane.add(p2,"South");
         contentPane.add(p3,"East");
         contentPane.add(p4,"West");
         contentPane.add(p5,"Center");
         p1.add(b1,"North");///将从第一个到第五个普通按钮组件按照BorderLayout方式布局到p1中间容器中
         p1.add(b2,"West");
         p1.add(b3,"South");
         p1.add(b4,"East");
         p1.add(b5,"Center");
         p2.add(b6,"North");//将从第六个到第十个普通按钮组件按照BorderLayout方式布局到p2中间容器中
         p2.add(b7,"West");
         p2.add(b8,"South");
         p2.add(b9,"East");
         p2.add(b10,"Center");
         p3.add(b11,"North");//将从第十一个到第十五个普通按钮组件按照BorderLayout方式布局到p3中间容器中
         p3.add(b12,"West");
         p3.add(b13,"South");
         p3.add(b14,"East");
         p3.add(b15,"Center");
         p4.add(b16,"North");//将从第十六个到第二十个普通按钮组件按照BorderLayout方式布局到p4中间容器中
         p4.add(b17,"West");
         p4.add(b18,"South");
         p4.add(b19,"East");
         p4.add(b20,"Center");
         p5.add(b21,"North");//将从第二十一个到第二十五个普通按钮组件按照BorderLayout方式布局到p5中间容器中
         p5.add(b22,"West");
         p5.add(b23,"South");
         p5.add(b24,"East");
         p5.add(b25,"Center");
         jf.setVisible(true);
     }  
	
}
