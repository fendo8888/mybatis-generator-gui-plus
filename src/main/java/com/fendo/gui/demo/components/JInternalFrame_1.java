/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JInternalFrame_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午2:17:01   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import java.awt.FlowLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**     
 * @title: JInternalFrame_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: 内部窗体  
 * @author: fendo  
 * @date: 2018年2月25日 下午2:17:01   
 * @version: V1.0     
*/
public class JInternalFrame_1 {

	  static final int WIDTH=300;
	  static final int HEIGHT=150;
	  
	  public static void main(String[] args){
	        JFrame jf=new JFrame("测试程序");
			//设置居中
	        jf.setLocationRelativeTo(null);
	        jf.setSize(WIDTH,HEIGHT);
	        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        jf.setVisible(true);
	        JPanel contentPane=new JPanel();//创建一个中间容器，并且将之添加到顶层容器内，将之设置为流布局。
	        jf.setContentPane(contentPane);
	        contentPane.setLayout(new FlowLayout());
	        JDesktopPane dp=new JDesktopPane();//创建一个虚拟桌面容器，将dp添加到以上创建的中间容器中
	        dp.setLayout(new FlowLayout());
	        contentPane.add(dp);
	        JInternalFrame jif=new JInternalFrame("第一个窗口",true,true,true); //创建两个JIntenaFrame容器，并且创建六个标签组件，分别将它们添加到两个JInternaFrame容器内
	        JInternalFrame jif1=new JInternalFrame("第二个窗口",true,true,true);
	        JLabel l1=new JLabel("这是我第一个窗口");
	        JLabel l2=new JLabel("这也是你第一个窗口");
	        JLabel l3=new JLabel("这同时是他第一个窗口");
	        JLabel l4=new JLabel("这是我第二个窗口");
	        JLabel l5=new JLabel("这也是你第二个窗口");
	        JLabel l6=new JLabel("这同时是他第二个窗口");
	        jif.setLayout(new FlowLayout());
	        jif1.setLayout(new FlowLayout());
	        jif.add(l1);
	        jif.add(l2);
	        jif.add(l3);
	        jif1.add(l4);
	        jif1.add(l5);
	        jif1.add(l6);
	        dp.add(jif);
	        dp.add(jif1);
	        jif.setVisible(true);
	        jif1.setVisible(true);
	    }

}
