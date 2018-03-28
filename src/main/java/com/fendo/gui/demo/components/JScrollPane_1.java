/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JScrollPane_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午2:15:25   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**     
 * @title: JScrollPane_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: 滚动条面板  
 * @author: fendo  
 * @date: 2018年2月25日 下午2:15:25   
 * @version: V1.0     
*/
public class JScrollPane_1 {

    static final int WIDTH=300;
    static final int HEIGHT=150;
    
    public static void main(String[] args){
        JFrame jf=new JFrame("测试程序");
        jf.setSize(WIDTH,HEIGHT);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置居中
        jf.setLocationRelativeTo(null);
        JTextArea ta=new JTextArea("我们是某某软件公司的骨干开发人员，我们会竭诚为您服务！！！");//创建一个文本域组件和一个滚动条面板，并且将滚动条面板添加到顶层容器内
        JScrollPane sp=new JScrollPane(ta,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS  );
        jf.setContentPane(sp);
        jf.setVisible(true);
    }

}
