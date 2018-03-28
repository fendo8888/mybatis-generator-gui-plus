/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JLabel_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午12:04:58   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**     
 * @title: JLabel_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: 标签示例1
 * JLabel标签用于标识名称和说明性文字，一般来说，标签显示的文本是不变的，也是禁止编辑的，但是可以通过代码进行修改。  
 * @author: fendo  
 * @date: 2018年2月25日 下午12:04:58   
 * @version: V1.0     
*/
public class JLabel_1 {

    static final int WIDTH=300;
    static final int HEIGHT=200;
    
    public static void main(String[] args){
      JFrame jf=new JFrame("测试程序");
      jf.setSize(WIDTH,HEIGHT);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  //设置居中
      jf.setLocationRelativeTo(null);
      JPanel contentPane=new JPanel( );
      JLabel label1=new JLabel();
      JLabel label2=new JLabel();
      label1.setText("标签是用来标示某个控件的控件");
      label2.setText("标签是用来标示说明性文件的控件");
      contentPane.add(label1);
      contentPane.add(label2);
      jf.setContentPane(contentPane);
      jf.setVisible(true);
    }

}
