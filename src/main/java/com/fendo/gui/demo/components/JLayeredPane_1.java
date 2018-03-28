/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JLayeredPane_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午2:18:41   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**     
 * @title: JLayeredPane_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: TODO  
 * @author: fendo  
 * @date: 2018年2月25日 下午2:18:41   
 * @version: V1.0     
*/
public class JLayeredPane_1 extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    static final int WIDTH=300;
    static final int HEIGHT=150;
    JLayeredPane lp=new JLayeredPane();
    static JButton b1=new JButton("确定");
    static JButton b2=new JButton("取消");
    
    public JLayeredPane_1() {
    	///设置顶层容器的标题
        super("测试窗口");
		//设置居中
        setLocationRelativeTo(null);
        ///将新建的JLayeredPane放到顶层容器内
        super.setContentPane(lp);
        b1.addActionListener(this); // 按钮事件
        b2.addActionListener(this);

        lp.add(b1, new Integer(200));
        lp.add(b2, new Integer(300));
        b1.setBounds(new Rectangle(100, 100, 100, 100));
        b1.setVisible(true);
        b2.setBounds(new Rectangle(50, 50, 100, 100));
        b2.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(360, 260);
        this.setVisible(true);
	}
    
	public static void main(String[] args) {
		new JLayeredPane_1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	  if (e.getActionCommand().equals("确定")) { // 判断是哪个按钮的动作
	      lp.setLayer(b1, 300); // 重新设置组件层数
	      lp.setLayer(b2, 200);
	    } else if (e.getActionCommand().equals("取消")){
	      lp.setLayer(b1, 200);
	      lp.setLayer(b2, 300);
	    }
	}	
}


