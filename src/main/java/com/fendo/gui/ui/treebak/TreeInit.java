/**   
 * projectName: mybatis-generator-oracle   
 * fileName: TreeInit.java   
 * packageName: com.fendo.gui.ui.tree   
 * date: 2018年2月27日下午1:33:01   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.ui.treebak;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.fendo.gui.ui.tree.IconNode;

/**     
 * @title: TreeInit.java   
 * @package com.fendo.gui.ui.tree   
 * @description: 树初始化  
 * @author: fendo  
 * @date: 2018年2月27日 下午1:33:01   
 * @version: V1.0     
*/
public class TreeInit {
	
	public static DefaultMutableTreeNode getTreeNode() {
		
        // 创建没有父节点和子节点、但允许有子节点的树节点，并使用指定的用户对象对它进行初始化。
        // public DefaultMutableTreeNode(Object userObject)
        DefaultMutableTreeNode group1 = new DefaultMutableTreeNode("软件部");

        TreeNode node1 = new TreeNode();
        node1.setName("王雨");
        node1.setNickName("漫天飞舞");
        node1.setImagePath("src/main/resources/icon/openSystem.png");
        group1.add(new DefaultMutableTreeNode(node1));

        TreeNode node2 = new TreeNode();
        node2.setName("陈梦");
        node2.setNickName("梦");
        node2.setImagePath("src/main/resources/icon/openSystem.png");
        group1.add(new DefaultMutableTreeNode(node2));

        TreeNode node3 = new TreeNode();
        node3.setName("上官飞儿");
        node3.setNickName("飞儿");
        node3.setImagePath("src/main/resources/icon/openSystem.png");
        group1.add(new DefaultMutableTreeNode(node3));

        DefaultMutableTreeNode group2 = new DefaultMutableTreeNode("xxx");
        
        
        TreeNode node4 = new TreeNode();
        node4.setName("上官婉儿");
        node4.setNickName("婉儿");
        node4.setImagePath("src/main/resources/icon/openSystem.png");
        group2.add(new DefaultMutableTreeNode(node4));

        TreeNode node5 = new TreeNode();
        node5.setName("上官巧儿");
        node5.setNickName("巧儿");
        node5.setImagePath("src/main/resources/icon/openSystem.png");
        group2.add(new DefaultMutableTreeNode(node5));
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        root.add(group1);
        root.add(group2);
		
        return root;
	}
	
	public static void main(String[] args) {
	        final JTree tree = new JTree(getTreeNode());
	        tree.setCellRenderer(new TreeCellRenderer());
	        tree.putClientProperty("JTree.lineStyle", "None");
	        tree.setRootVisible(false);
        
	        JFrame frame = new JFrame("JTreeDemo");
	        frame.add(tree);
	        frame.setSize(300, 300);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	        // 添加选择事件
	        tree.addTreeSelectionListener(new TreeSelectionListener() 
	        {
	            @Override
	            public void valueChanged(TreeSelectionEvent e) 
	            {
	                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
	                if (node == null){
	                    return;
	                }//if

	                Object object = node.getUserObject();
	                if(object instanceof TreeNode)
	                {
	                    TreeNode user = (TreeNode) object;
	                    System.out.println("你点击了：" + user.toString());
	                }
	                else if(object instanceof String)
	                {
	                    String text = (String)object;
	                    System.out.println("你点击了：" + text);
	                }
	            }
	        });
	}

}
