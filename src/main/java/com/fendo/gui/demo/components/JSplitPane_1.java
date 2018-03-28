/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JSplitPane.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日上午11:48:51   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**     
 * @title: JSplitPane.java   
 * @package com.fendo.gui.demo.components   
 * @description: 分割面板示例1
 * @author: fendo  
 * @date: 2018年2月25日 上午11:48:51   
 * @version: V1.0     
*/
public class JSplitPane_1 extends JFrame{

	//分割面板   HORIZONTAL:水平      VERTICAL：垂直
	private JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	//第二个分割面板
	private JSplitPane jsp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	JPanel jplb = new JPanel();
	JPanel jplc = new JPanel();
	
	//按钮
	JPanel jpla = new JPanel();
	JButton btnSatrt = new JButton("开始");
	JButton btnEnd = new JButton("停止");
	
	//进度条  Progress：进程
	JProgressBar  jpb = new JProgressBar();
	
	MyThread mt = null;
	
	public void init(){
		//设置分割线属性
		jsp.setDividerLocation(100);//设置位置
		jsp.setDividerSize(5);//设置大小
		jsp.setBackground(Color.BLACK);
		
		//第二个分割面板的分割线的属性
		jsp2.setDividerLocation(115);//设置位置
		jsp2.setDividerSize(4);//设置大小
		//jsp2.setBackground(Color.BLACK);
		//将面板加入到第二个分割面板中
		jsp2.setLeftComponent(jplb);
		jsp2.setRightComponent(jplc);
		//将按钮加入到分割面板中
		jpla.add(jpb);
		jpla.add(btnSatrt);
		jpla.add(btnEnd);
		jsp.setLeftComponent(jpla);
		jsp.setRightComponent(jsp2);
		
	}
	
	public JSplitPane_1() {
		this.setSize(400, 500);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		init();
		//设置进度条的基本属性
		//jpb.setValue(10);
		jpb.setSize(50, 40);
		//jpb.setString("50%");
		jpb.setStringPainted(true);//让文本信息显示出来
		//设置最大、最小值
		jpb.setMaximum(100);
		jpb.setMinimum(0);
		//实现进度条增加
		btnSatrt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mt = new MyThread();
				//跑起来
				mt.start();
			}
		});
		//实现停止
		btnEnd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mt.stop();
			}
		});
		//将第一个分割面板设置为内容面板
		this.setContentPane(jsp);
		this.setVisible(true);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		new JSplitPane_1();
	}
	
	/**
	 * 内部类
	 */
	class MyThread extends Thread{
		@Override
		public void run() {
			//获取原来的value值
			int value = jpb.getValue();
			for(int i=value;i<=100;i++){
				jpb.setValue(i);
				jpb.setString(jpb.getValue()+"%");
				try {
					//休眠
					new Thread().sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
