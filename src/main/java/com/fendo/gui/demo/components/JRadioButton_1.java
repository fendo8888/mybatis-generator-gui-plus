/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JRadioButton_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午12:07:42   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**     
 * @title: JRadioButton_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: 单选按钮示例  
 * @author: fendo  
 * @date: 2018年2月25日 下午12:07:42   
 * @version: V1.0     
*/
public class JRadioButton_1 {

    static final int WIDTH=300;
    static final int HEIGHT=200;
    
    public static void main(String[] args){
         JFrame jf=new JFrame("测试程序");
         jf.setSize(WIDTH,HEIGHT);
		 //设置居中
         jf.setLocationRelativeTo(null);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JPanel contentPane=new JPanel( );
         //创建六个单选按钮，并且将之分成三组按钮组
         JRadioButton jr1=new JRadioButton("羽毛球");
         JRadioButton jr2=new JRadioButton("足球");
         JRadioButton jr3=new JRadioButton("电脑书");
         JRadioButton jr4=new JRadioButton("数学书");
         JRadioButton jr5=new JRadioButton("电影");
         JRadioButton jr6=new JRadioButton("录像");
         ButtonGroup  bg1=new ButtonGroup();
         ButtonGroup  bg2=new ButtonGroup();
         ButtonGroup  bg3=new ButtonGroup();
         bg1.add(jr1);
         bg1.add(jr2);
         bg2.add(jr3);
         bg2.add(jr4);
         bg3.add(jr5);
         bg3.add(jr6);
         //将六个单选按钮添加到内容面板中
         contentPane.add(jr1);
         contentPane.add(jr2);
         contentPane.add(jr3);
         contentPane.add(jr4);
         contentPane.add(jr5);
         jf.setContentPane(contentPane);
         jf.setVisible(true);
    }  

}
