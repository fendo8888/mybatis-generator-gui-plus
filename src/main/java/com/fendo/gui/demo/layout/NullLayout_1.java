/**   
 * projectName: mybatis-generator-oracle   
 * fileName: NullLayout_1.java   
 * packageName: com.fendo.gui.demo.nulllayout   
 * date: 2018年2月25日上午11:44:20   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.layout;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**     
 * @title: NullLayout_1.java   
 * @package com.fendo.gui.demo.nulllayout   
 * @description: 空布局  
 * @author: fendo  
 * @date: 2018年2月25日 上午11:44:20   
 * @version: V1.0     
*/
public class NullLayout_1 extends JFrame {

	public NullLayout_1() {
		this.setSize(400, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//设置空布局
		this.setLayout(null);

		MyPanel jpl = new MyPanel("images/user.jpg");
		
		jpl.setBounds(0, 0, 400, 500);
		this.add(jpl);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {

		new NullLayout_1();
		
	}
	
	public class MyPanel extends JPanel{

		private String path;
		
		public MyPanel(String path) {
			this.path = path;
		}
		
		@Override
		public void paint(Graphics g) {
			//Graphics:画家
			g.drawImage(new ImageIcon(path).getImage(), 0, 0, 400, 500, null);
		}
	}	

}
