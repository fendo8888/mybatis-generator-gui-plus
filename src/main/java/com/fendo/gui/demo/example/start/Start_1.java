/**   
 * projectName: mybatis-generator-oracle   
 * fileName: Start_1.java   
 * packageName: com.fendo.gui.demo.example.start   
 * date: 2018年2月25日下午4:03:36   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.example.start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JDialog;

/**
 * @title: Start_1.java
 * @package com.fendo.gui.demo.example.start
 * @description: TODO
 * @author: fendo
 * @date: 2018年2月25日 下午4:03:36
 * @version: V1.0
 */
public class Start_1 {

	private Map<String, String> feaMap = null;
	private TipWindow tw = null;// 提示框
	private ImageIcon img = null;// 图像组件
	private JLabel imgLabel = null; // 背景图片标签
	private JPanel headPan = null;
	private JPanel feaPan = null;
	private JPanel btnPan = null;
	private JLabel title = null;
	private JLabel close = null;// 关闭按钮
	private JTextArea feature = null;
	private JScrollPane jfeaPan = null;
	private JLabel releaseLabel = null;
	private SimpleDateFormat sdf = null;

	{
	  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  feaMap = new HashMap<String, String>(); 
	  feaMap.put("release", sdf.format(new Date()));
	}
	
	public Start_1() {
	  init();   
	  handle();
	  tw.setAlwaysOnTop(true);    
	  tw.setUndecorated(true);
	  tw.setResizable(false);
	  tw.setVisible(true);
	  tw.run();
	}
	
	public void init() {
		// 新建300x220的消息提示框
		tw = new TipWindow(300, 220);
		img = new ImageIcon("images/user.jpg");
		imgLabel = new JLabel(img);
		// 设置各个面板的布局以及面板中控件的边界
		headPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		feaPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		btnPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		title = new JLabel("提示您");
		close = new JLabel("x");// 关闭按钮

		jfeaPan = new JScrollPane(feature);
		releaseLabel = new JLabel(feaMap.get("release"));

		// 将各个面板设置为透明，否则看不到背景图片
		((JPanel) tw.getContentPane()).setOpaque(false);
		headPan.setOpaque(false);
		feaPan.setOpaque(false);
		btnPan.setOpaque(false);

		// 设置JDialog的整个背景图片
		tw.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		headPan.setPreferredSize(new Dimension(300, 60));

		// 设置提示框的边框,宽度和颜色
		title.setPreferredSize(new Dimension(260, 26));
		title.setVerticalTextPosition(JLabel.CENTER);
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setFont(new Font("宋体", Font.PLAIN, 19));
		title.setForeground(Color.red);

		close.setFont(new Font("Arial", Font.BOLD, 19));
		close.setPreferredSize(new Dimension(20, 20));
		close.setVerticalTextPosition(JLabel.CENTER);
		close.setHorizontalTextPosition(JLabel.CENTER);
		close.setCursor(new Cursor(12));
		close.setToolTipText("关闭");

		jfeaPan.setBorder(null);
		jfeaPan.setBackground(Color.black);

		releaseLabel.setForeground(Color.WHITE);
		releaseLabel.setFont(new Font("宋体", Font.PLAIN, 20));

		// 设置标签鼠标手形

		headPan.add(title);
		headPan.add(close);

		feaPan.add(jfeaPan);
		feaPan.add(releaseLabel);

		tw.add(headPan, BorderLayout.NORTH);
		tw.add(feaPan, BorderLayout.CENTER);
		tw.add(btnPan, BorderLayout.SOUTH);
	}

	public void handle() {
		// 右上角关闭按钮事件
		close.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tw.close();
			}

			public void mouseEntered(MouseEvent e) {
				close.setBorder(BorderFactory.createLineBorder(Color.gray));
			}

			public void mouseExited(MouseEvent e) {
				close.setBorder(null);
			}
		});

	}

	public static void main(String[] args) {
		new Start_1();
	}

}

class TipWindow extends JDialog {
	private static final long serialVersionUID = 8541659783234673950L;
	private static Dimension dim;
	private int x, y;
	private int width, height;
	private static Insets screenInsets;

	public TipWindow(int width, int height) {
		this.width = width;
		this.height = height;
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
		x = (int) (dim.getWidth() - width - 3);
		y = (int) (dim.getHeight() - screenInsets.bottom - 3);
		initComponents();
	}

	public void run() {
		for (int i = 0; i <= height; i += 10) {
			try {
				this.setLocation(x, y - i);
				Thread.sleep(5);
			} catch (InterruptedException ex) {
			}
		}
		// 此处代码用来实现让消息提示框X秒后自动消失
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		close();
	}

	private void initComponents() {
		this.setSize(width, height);
		this.setLocation(x, y);
		this.setBackground(Color.black);
	}

	public void close() {
		x = this.getX();
		y = this.getY();
		int ybottom = (int) dim.getHeight() - screenInsets.bottom;
		for (int i = 0; i <= ybottom - y; i += 10) {
			try {
				setLocation(x, y + i);
				Thread.sleep(5);
			} catch (InterruptedException ex) {
			}
		}
		dispose();
	}
}
