/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JCheckBox_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午12:09:12   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**     
 * @title: JCheckBox_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: 复选框示例  
 * @author: fendo  
 * @date: 2018年2月25日 下午12:09:12   
 * @version: V1.0     
*/
public class JCheckBox_1 extends JPanel{

    static final int WIDTH=300;
    static final int HEIGHT=200;
    
    public JCheckBox_1()
    {
        JFrame frame=new JFrame();
        frame.setTitle("如何使用按钮的测试程序");
        frame.setSize(WIDTH,HEIGHT);
		//设置居中
        frame.setLocationRelativeTo(null);
        frame.setContentPane(this);
        JLabel name=new JLabel("王鹏");
        JRadioButton jr1=new JRadioButton("男");
        JRadioButton jr2=new JRadioButton("女");
        ButtonGroup  bg=new ButtonGroup();
        bg.add(jr1); //将两个单选按钮划分到同一个单选按钮组bg中
        bg.add(jr2);
        JLabel interesting=new JLabel("兴趣爱好");
        JCheckBox jc1=new JCheckBox("羽毛球");
        JCheckBox jc2=new JCheckBox("足球");
        JCheckBox jc3=new JCheckBox("电脑书");
        JCheckBox jc4=new JCheckBox("数学书");
        JCheckBox jc5=new JCheckBox("电影");
        JCheckBox jc6=new JCheckBox("录像");
        add(name);
        add(jr1);
        add(jr2);
        add(interesting);
        add(jc1);
        add(jc2);
        add(jc3);
        add(jc4);
        add(jc5);
        add(jc6);
        frame.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new JCheckBox_1();
    }

}
