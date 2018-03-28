/**   
 * projectName: mybatis-generator-oracle   
 * fileName: GroupLayout_1.java   
 * packageName: com.fendo.gui.demo.layout   
 * date: 2018年2月25日下午2:44:55   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.layout;

import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**     
 * @title: GroupLayout_1.java   
 * @package com.fendo.gui.demo.layout   
 * @description: GroupLayout是以组为单位来管理布局的，把多个组件划分到不容的组，再根据各个组相对于水平轴和垂直轴的排列方式来进行组的管理。  
 * @author: fendo  
 * @date: 2018年2月25日 下午2:44:55   
 * @version: V1.0     
*/
public class GroupLayout_1 extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public GroupLayout_1() {
	   Container c = getContentPane();//创建一个中间容器，并且创建一个GroupLayout布局管理器对象
	   GroupLayout layout = new GroupLayout(c);
	   JButton b1 = new JButton("按钮 1");//创建两个普通按钮组件、文本框组件
	   JButton b2 = new JButton("按钮 2");
	   JTextField text = new JTextField("文本"); 
	   GroupLayout.SequentialGroup hsg = layout.createSequentialGroup();//创建一个hsg组，将两个按钮一个一个的添加到组里面
	   hsg.addComponent(b1);
	   hsg.addComponent(b2);
	   GroupLayout.ParallelGroup hpg = 
	   layout.createParallelGroup(GroupLayout.Alignment.CENTER); //创建一个hpg组，将文本框组件和上面的那个组添加到其中，并且居中排列
	   hpg.addComponent(text).addGroup(hsg); 
	   layout.setHorizontalGroup(hpg); //沿水平线来确定hpg组中两个按钮组件的位置
	   GroupLayout.ParallelGroup vpg = layout.createParallelGroup();//创建一个vpg组，按照水平线来排列两个按钮组件的位置  
	   vpg.addComponent(b1); 
	   vpg.addComponent(b2); 
	   GroupLayout.SequentialGroup vsg = layout.createSequentialGroup();// 将文本框组件和前面的容纳两个按钮组件的组同时添加到vsg组中
	   vsg.addComponent(text).addGroup(vpg);
	   layout.setVerticalGroup(vsg); //沿垂直线来确定vsg中vpg和文本框组件的位置
	   this.setLayout(layout); 
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setLocationRelativeTo(null);
	   pack();
	}
	

	public static void main(String[] args) {
		GroupLayout_1 demo = new GroupLayout_1();
		demo.setVisible(true);
	}

}
