/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JTree_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午3:12:38   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**     
 * @title: JTree_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: TODO  
 * @author: fendo  
 * @date: 2018年2月25日 下午3:12:38   
 * @version: V1.0     
*/
public class JTree_1 {

    public JFrame f;   
    public Box box;  
    public JTree jTree1,jTree2; 
    
    public JTree_1() {
	    f = new JFrame(" JTreeDemo1 ");  
	    box = Box.createHorizontalBox(); //创建Box 类对象  
	      
	    jTree1 = new JTree();  
	    jTree2 = new JTree();  
	    
	    jTree1.addTreeSelectionListener(new TreeSelectionListener() {
	    	   public void valueChanged(TreeSelectionEvent e) {
	    	    DefaultMutableTreeNode note = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
	    	    String name = note.toString();//获得这个结点的名称
	    	    System.out.println(name);
	    	   }
	   });
	    
	      
	    //向此组件添加任意的键/值  
	    jTree1.putClientProperty("JTree.lineStyle", "Angled");   
	      
	    //向Box 容器添加滚动面板  
	    box.add(new JScrollPane(jTree1), BorderLayout.WEST);  
	    box.add(new JScrollPane(jTree2), BorderLayout.EAST);  
	      
	    f.getContentPane().add(box, BorderLayout.CENTER);  
	      
	    f.setSize(300, 240);  
	    //f.pack();  
	    f.setLocation(300, 200);  
	    f.setVisible(true);  
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
    
	public static void main(String[] args) {
		
		new JTree_1();

	}

}
