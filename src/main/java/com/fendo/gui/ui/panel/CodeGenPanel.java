/**   
 * projectName: mybatis-generator-oracle   
 * fileName: CodeGenPanel.java   
 * packageName: com.fendo.gui.ui.panel   
 * date: 2018年3月2日下午3:42:27   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.asm.Label;

import com.fendo.gui.demo.components.JPanel_1;

/**     
 * @title: CodeGenPanel.java   
 * @package com.fendo.gui.ui.panel   
 * @description: 代码生成面板  
 * @author: fendo  
 * @date: 2018年3月2日 下午3:42:27   
 * @version: V1.0     
*/
public class CodeGenPanel extends JPanel{

	//表名
	public JLabel tableNameLabel;
	public JTextField tableNameJTextField;
	
	//JAVA实体类名
	public JLabel beanNameLabel;
	public JTextField beanNameJTextField;
	
	//主键(选填)
	public JLabel primaryLabel;
	public JTextField primaryJTextField;
	
	//项目所在目录
	public JLabel projectLabel;
	public JTextField projectJTextField;
	
	//实体类名包名
	public JLabel entityLabel;
	public JTextField entityJTextField;
	
	//实体类存放目录
	public JLabel entityCatalogLabel;
	public JTextField entityCatalogJTextField;
	
	//接口包名
	public JLabel interfaceLabel;
	public JTextField interfaceJTextField;
	
	//接口存放目录
	public JLabel interfaceCatalogLabel;
	public JTextField interfaceCatalogJTextField;
	
	//Mapper映射文件包名
	public JLabel mapperMappingLabel;
	public JTextField mapperMappingJTextField;
	
	//Mapper存放目录
	public JLabel mapperCatalogLabel;
	public JTextField mapperCatalogJTextField;
	
	public CodeGenPanel() {
		
		setLayout(new FlowLayout());
	
		JPanel jPanel_1 = new JPanel();
		//jPanel_1.setBackground(Color.black);
		jPanel_1.setPreferredSize(new Dimension(800, 149));
		jPanel_1.setLayout(new FlowLayout());
		
		//表名
		JPanel tablePanelLeft = new JPanel();
		tablePanelLeft.setBackground(Color.black);
		tablePanelLeft.setPreferredSize(new Dimension(400, 149));
		tableNameLabel = new JLabel("表名:");
		tablePanelLeft.add(tableNameLabel);
		
		JPanel tablePanelRight = new JPanel();
		tablePanelRight.setBackground(Color.black);
		tablePanelRight.setPreferredSize(new Dimension(400, 149));
		tableNameJTextField = new JTextField();
		tableNameJTextField.setColumns(30); // 设置长度
		tableNameJTextField.setMaximumSize(tableNameJTextField.getPreferredSize());

		tablePanelRight.add(tableNameJTextField);
		
		jPanel_1.add(tablePanelLeft);
		jPanel_1.add(tablePanelRight);
		
		//JAVA实体类名
		
		//主键(选填)
		
		//项目所在目录
		
		//实体类名包名
		
		//实体类存放目录
		
		//接口包名
		
		//接口存放目录
		
		//Mapper映射文件包名
		
		//Mapper存放目录
		
		JPanel JPanel_1_1 = new JPanel();
		
		JPanel jPanel_2 = new JPanel();
		jPanel_2.setBackground(Color.blue);
		jPanel_2.setPreferredSize(new Dimension(800, 149));
		
		JPanel jPanel_3 = new JPanel();
		jPanel_3.setBackground(Color.cyan);
		jPanel_3.setPreferredSize(new Dimension(800, 149));
		
		JPanel jPanel_4 = new JPanel();
		jPanel_4.setBackground(Color.gray);
		jPanel_4.setPreferredSize(new Dimension(800, 149));
		
		
		add(jPanel_1);
		add(jPanel_2);
		add(jPanel_3);
		add(jPanel_4);
	}
	
	public static void main(String[] args) {
		// 创建一个主窗体
		JFrame jframe = new JFrame();
		// 设置标题
		jframe.setTitle("代码生成面板");
		// 设置窗体大小
		jframe.setSize(800, 600);
		// 设置布局方式
		jframe.setLayout(new BorderLayout());
		// 设置窗体居中显示
		jframe.setLocationRelativeTo(null);
		// 设置关闭窗体的时候退出程序
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		// 设置窗体不能改变大小
		jframe.setResizable(false);
		jframe.add(new CodeGenPanel());
		jframe.setVisible(true);
	}
	
}
