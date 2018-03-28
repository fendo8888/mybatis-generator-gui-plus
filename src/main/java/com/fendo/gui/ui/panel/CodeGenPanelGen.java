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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;


/**     
 * @title: CodeGenPanel.java   
 * @package com.fendo.gui.ui.panel   
 * @description: 代码生成面板  
 * @author: fendo  
 * @date: 2018年3月2日 下午3:42:27   
 * @version: V1.0     
*/
public class CodeGenPanelGen extends JPanel{

    // Variables declaration - do not modify                     
    private JButton jButton1;
    private JButton jButton2;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField jTextField1;
    private JTextField jTextField10;
    private JTextField jTextField11;
    private JTextField jTextField12;
    private JTextField jTextField13;
    private JTextField jTextField14;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;
    private JTextField jTextField9;
    // End of variables declaration   
	
	public CodeGenPanelGen() {
		initComponents();
	}
	
	
    private void jTextField7ActionPerformed(ActionEvent evt) {                                            
    }                                           

    private void jButton1ActionPerformed(ActionEvent evt) {                                         
    }                                        

    private void jCheckBox1ActionPerformed(ActionEvent evt) {                                           
    }  
	
    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {                                             
    }    
    
    private void initComponents() {

        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jLabel4 = new JLabel();
        jTextField5 = new JTextField();
        jLabel5 = new JLabel();
        jTextField6 = new JTextField();
        jLabel6 = new JLabel();
        jTextField7 = new JTextField();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jTextField8 = new JTextField();
        jLabel9 = new JLabel();
        jTextField9 = new JTextField();
        jLabel10 = new JLabel();
        jTextField10 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jCheckBox1 = new JCheckBox();
        jCheckBox2 = new JCheckBox();
        jCheckBox3 = new JCheckBox();
        jLabel11 = new JLabel();
        jTextField11 = new JTextField();
        jLabel12 = new JLabel();
        jTextField12 = new JTextField();
        jLabel13 = new JLabel();
        jTextField13 = new JTextField();
        jLabel14 = new JLabel();
        jTextField14 = new JTextField();

        jLabel1.setText("表名");

        jTextField1.setText("User");

        jTextField2.setText("src/main/java");

        jLabel2.setText("JAVA实体类名");

        jLabel3.setText("主键(选填)");

        jTextField3.setText("Id");

        jTextField4.setText("src/main/java");

        jLabel4.setText("项目所在目录");

        jTextField5.setText("com.fendo.demo");

        jLabel5.setText("实体类包名");

        jTextField6.setText("src/main/java");

        jLabel6.setText("实体类存放目录");

        jTextField7.setText("src/main/java");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel7.setText("接口包名");

        jLabel8.setText("接口存放目录");

        jTextField8.setText("src/main/java");

        jLabel9.setText("Mapper映射文件包名");

        jTextField9.setText("src/main/resources");

        jLabel10.setText("Mapper存放目录");

        jTextField10.setText("src/main/resources");
        jTextField10.setToolTipText("");

        jButton1.setText("保存配置");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("生成代码");

        jCheckBox1.setText("分页");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("实体类注释");

        jCheckBox3.setText("生成toString/hashCode/equals方法");

        jLabel11.setText("Service类存放目录");

        jTextField11.setText("com.fendo.service");
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jLabel12.setText("Service类包名");

        jTextField12.setText("src/main/java");

        jLabel13.setText("ServiceImp类包名");

        jTextField13.setText("service.impl");

        jLabel14.setText("ServiceImp类存放目录");

        jTextField14.setText("src/main/java");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(83, 83, 83)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField3, GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextField4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField13, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jCheckBox2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField14, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(jLabel9)
                    .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(41, 41, 41))
        );
    }  
	
	public static void main(String[] args) {
		// 创建一个主窗体
		JFrame jframe = new JFrame();
		// 设置标题
		jframe.setTitle("代码生成面板");
		// 设置窗体大小
		jframe.setSize(650, 450);
		// 设置布局方式
		jframe.setLayout(new BorderLayout());
		// 设置窗体居中显示
		jframe.setLocationRelativeTo(null);
		// 设置关闭窗体的时候退出程序
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		// 设置窗体不能改变大小
		jframe.setResizable(false);
		jframe.add(new CodeGenPanelGen());
		jframe.setVisible(true);
	}
	
}
