/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JTabbedPane_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日上午11:52:56   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**     
 * @title: JTabbedPane_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: 选项卡面板示例1  
 * @author: fendo  
 * @date: 2018年2月25日 上午11:52:56   
 * @version: V1.0     
*/
public class JTabbedPane_1 extends JFrame{

	//选项卡面板
	private  JTabbedPane jtb = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.CENTER);
	//面板
	JPanel jplA = new JPanel();
	JPanel jplB = new JPanel();
	JPanel jplC = new JPanel();
	JPanel jplD = new JPanel();
	JPanel jplE = new JPanel();
	
	//第一个面板中的组件
	JButton btnAdd = new JButton("增加");
	JButton btnRemove = new JButton("移除");
	
	//第二个面板中的组件
	JTextField jtfa = new JTextField(15);
	JTextField jtfb = new JTextField(15);
	//下拉列表
	JComboBox jcb = new JComboBox();
	
	
	public void  init(){
		//将按钮加入到jplA
		jplA.add(btnAdd);
		jplA.add(btnRemove);
		//将组件加入到jplB
		jcb.addItem("长沙");
		jcb.addItem("益阳");
		jcb.addItem("郴州");
		jcb.addItem("低下头的");
		jplB.add(jtfa);
		jplB.add(jtfb);
		jplB.add(jcb);
		//将面板加入到选项卡面板中
		jtb.add("计算机名", jplA);
		jtb.add("硬件", jplB);
		jtb.add("高级", jplC);
		jtb.add("系统保护", jplD);
		jtb.add("远程", jplE);
	}

	public JTabbedPane_1() {
		this.setSize(400, 500);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		//
		init();
		jtfa.setText("请输入地址.....");
		//添加选项
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtb.add("新建的选项", new JPanel());
			}
		});
		//移除
		btnRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取选项卡面板的面板数
				int count = jtb.getTabCount();
				//System.out.println(count);
				//从最后一个开始移除
				jtb.remove(count-1);
			}
		});
		//选项改变事件
		jcb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//获取下拉框的值
				String str = jcb.getSelectedItem().toString();
				//将值放入到文本框中
				jtfa.setText(str);
			}
		});
		//给第一个文本框添加焦点事件
		jtfa.addFocusListener(new FocusListener() {
			//focusLost:焦点失去的时候调用
			@Override
			public void focusLost(FocusEvent e) {
				//获取第一个文本框的值
				String str = jtfa.getText();
				//将值放入到第二个文本框中
				jtfb.setText(str);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				jtfa.setText("");
			}
		});
		//设置选项卡面板为内容面板
		this.setContentPane(jtb);
		this.setVisible(true);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		//设置风格
		//WindowsLookAndFeel
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		new JTabbedPane_1();
	}

}
