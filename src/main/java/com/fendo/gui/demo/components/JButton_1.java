/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JButton_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午12:06:16   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**     
 * @title: JButton_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: TODO  
 * @author: fendo  
 * @date: 2018年2月25日 下午12:06:16   
 * @version: V1.0     
*/
public class JButton_1 {

	    static final int WIDTH=300;
	    static final int HEIGHT=200;
	    
	    public static void main(String[] args){
	        JFrame jf=new JFrame("测试程序");
	        jf.setSize(WIDTH,HEIGHT);
	        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//设置居中
	        jf.setLocationRelativeTo(null);
	        JPanel contentPane=new JPanel( );
	        //创建两个按钮，并且将按钮添加到内容面板中
	        JButton b1=new JButton("确定");
	        JButton b2=new JButton("取消");
	        contentPane.add(b1);
	        contentPane.add(b2);
	        jf.setVisible(true);
	        jf.setContentPane(contentPane);
	    }

}
