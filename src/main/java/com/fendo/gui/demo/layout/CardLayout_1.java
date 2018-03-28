/**   
 * projectName: mybatis-generator-oracle   
 * fileName: CardLayout_1.java   
 * packageName: com.fendo.gui.demo.layout   
 * date: 2018年2月25日下午2:35:36   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**     
 * @title: CardLayout_1.java   
 * @package com.fendo.gui.demo.layout   
 * @description: CardLayout将容器中的每一个组件当做一个卡片，每次仅有一个卡片可见，卡片之间可以来回切换。  
 * @author: fendo  
 * @date: 2018年2月25日 下午2:35:36   
 * @version: V1.0     
*/
public class CardLayout_1 extends JFrame {

    private JPanel pane = null; // 主要的JPanel，该JPanel的布局管理将被设置成CardLayout
    private JPanel p = null; // 放按钮的JPanel
    private CardLayout card = null; // CardLayout布局管理器
    private JButton button_1 = null; // 上一步
    private JButton button_2 = null; // 下一步
    private JButton b_1 = null, b_2 = null, b_3 = null; // 三个可直接翻转到JPanel组件的按钮
    private JPanel p_1 = null, p_2 = null, p_3 = null; // 要切换的三个JPanel
	
    public CardLayout_1() {
        super("CardLayout Test");
        try {
           // 将LookAndFeel设置成Windows样式
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        card = new CardLayout(5, 5); //创建一个具有指定的水平和垂直间隙的新卡片布局
        pane = new JPanel(card); // JPanel的布局管理将被设置成CardLayout
        p = new JPanel(); // 构造放按钮的JPanel
        button_1 = new JButton("< 上一步");
        button_2 = new JButton("下一步 >");
        b_1 = new JButton("1");
        b_2 = new JButton("2");
        b_3 = new JButton("3");
        b_1.setMargin(new Insets(2,2,2,2));
        b_2.setMargin(new Insets(2,2,2,2));
        b_3.setMargin(new Insets(2,2,2,2));
        p.add(button_1);
        p.add(b_1);
        p.add(b_2);
        p.add(b_3);
        p.add(button_2);
        p_1 = new JPanel();
        p_2 = new JPanel();
        p_3 = new JPanel();
        p_1.setBackground(Color.RED);
        p_2.setBackground(Color.BLUE);
        p_3.setBackground(Color.GREEN);
        p_1.add(new JLabel("JPanel_1"));
        p_2.add(new JLabel("JPanel_2"));
        p_3.add(new JLabel("JPanel_3"));
        pane.add(p_1, "p1");
        pane.add(p_2, "p2");
        pane.add(p_3, "p3");
         //下面是翻转到卡片布局的某个组件的动作事件处理，当单击某个普通按钮组件，就会触发出现下一个组件
        button_1.addActionListener(new ActionListener() { 
        	/// 上一步的按钮动作
            public void actionPerformed(ActionEvent e) {
                card.previous(pane);
            }
        });
        button_2.addActionListener(new ActionListener(){
        	// 下一步的按钮动作
            public void actionPerformed(ActionEvent e) {
                card.next(pane);
            }
        });
        b_1.addActionListener(new ActionListener() {
        	// 直接翻转到p_1
            public void actionPerformed(ActionEvent e) {
                card.show(pane, "p1");
            }
        });
        b_2.addActionListener(new ActionListener() { 
        	// 直接翻转到p_2
            public void actionPerformed(ActionEvent e) {
                card.show(pane, "p2");
            }
        });
        b_3.addActionListener(new ActionListener() { 
        	// 直接翻转到p_3
            public void actionPerformed(ActionEvent e) {
                card.show(pane, "p3");
            }
        });
        this.getContentPane().add(pane);
        this.getContentPane().add(p, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(300, 200);
        this.setVisible(true);
    }
    
	public static void main(String[] args) {
		new CardLayout_1();
	}

}
