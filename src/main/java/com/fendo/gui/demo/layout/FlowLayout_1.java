/**   
 * projectName: mybatis-generator-oracle   
 * fileName: FlowLayout_1.java   
 * packageName: com.fendo.gui.demo.layout   
 * date: 2018年2月25日下午2:24:51   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**     
 * @title: FlowLayout_1.java   
 * @package com.fendo.gui.demo.layout   
 * @description: TODO  
 * @author: fendo  
 * @date: 2018年2月25日 下午2:24:51   
 * @version: V1.0     
*/
public class FlowLayout_1 {

	static final int WIDTH=300;
    static final int HEIGHT=200;
    
    public static void main(String[] args){
         JFrame jf=new JFrame("测试程序");
         jf.setSize(WIDTH,HEIGHT);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     //设置居中
	     jf.setLocationRelativeTo(null);         
         
         JPanel contentPane=new JPanel();
         jf.setContentPane(contentPane);
         JButton b1=new JButton("港币");
         JButton b2=new JButton("人民币");
         JButton b3=new JButton("美元");
         JButton b4=new JButton("欧元");
         JButton b5=new JButton("英镑");
         contentPane.setLayout(new FlowLayout());//将中间容器的布局管理器设置为FlowLayout
         contentPane.add(b1); //将五个按钮分别按照FlowLayout布局管理器方式添加到中间容器中
         contentPane.add(b2);
         contentPane.add(b3);
         contentPane.add(b4);
         contentPane.add(b5);
         jf.pack();
         jf.setVisible(true);
    }  

}
