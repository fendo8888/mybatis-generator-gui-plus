/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JFileChooser_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午3:25:49   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**     
 * @title: JFileChooser_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: 文件选择器  
 * @author: fendo  
 * @date: 2018年2月25日 下午3:25:49   
 * @version: V1.0     
*/
public class JFileChooser_1 extends JFrame{

	public JFileChooser_1() {
        super();
        setTitle("JFileChooserTest");
        setBounds(100,100,350,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JButton button = new JButton();
        final JLabel label = new JLabel();
        button.addActionListener(new ActionListener(){  //监听事件
            public void actionPerformed(ActionEvent e){
                JFileChooser fileChooser = new JFileChooser();  //对话框
                int i = fileChooser.showOpenDialog(getContentPane());  //opendialog
                if(i==JFileChooser.APPROVE_OPTION)  //判断是否为打开的按钮
                {
                    File selectedFile = fileChooser.getSelectedFile();  //取得选中的文件
                    label.setText(selectedFile.getPath());   //取得路径
                }
            }
        });
        getContentPane().add(button,BorderLayout.NORTH);  //布局处理
        getContentPane().add(label,BorderLayout.CENTER);
        button.setText("上传");
	}

    public static void main(String[] args) {
    	JFileChooser_1 jFileChooserTest = new JFileChooser_1();
        jFileChooserTest.setVisible(true);
    }

}
