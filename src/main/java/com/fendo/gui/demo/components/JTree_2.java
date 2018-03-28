/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JTree_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午3:12:38   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**     
 * @title: JTree_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: 带右键菜单的树  
 * @author: fendo  
 * @date: 2018年2月25日 下午3:12:38   
 * @version: V1.0     
*/
public class JTree_2 extends JFrame implements MouseListener,ActionListener{

	 public JTree tree;
	 public JPopupMenu popMenu; //菜单
	 public JMenuItem addItem;   //各个菜单项
	 public JMenuItem delItem;
	 public JMenuItem editItem;
    
    public JTree_2() {
    	tree = new JTree();
     	tree.setEditable(true);
     	tree.getSelectionModel().setSelectionMode(
     	TreeSelectionModel.SINGLE_TREE_SELECTION);
     	tree.addMouseListener(this);
     	tree.setCellEditor(new DefaultTreeCellEditor(tree,
     	new DefaultTreeCellRenderer()));
     	getContentPane().add(tree);
     	setSize(200, 200);
        //添加菜单项以及为菜单项添加事件
     	popMenu = new JPopupMenu();
     	addItem = new JMenuItem("添加");
     	addItem.addActionListener(this);
     	delItem = new JMenuItem("删除");
     	delItem.addActionListener(this);
     	editItem = new JMenuItem("修改");
     	editItem.addActionListener(this);
     	popMenu.add(addItem);
     	popMenu.add(delItem);
     	popMenu.add(editItem);
     	getContentPane().add(new JScrollPane(tree));
	}
    
	public static void main(String[] args) {
				
		JTree_2 frame = new JTree_2();
	 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	frame.setLocationRelativeTo(null);
	 	frame.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	 	TreePath path = tree.getPathForLocation(e.getX(), e.getY()); // 关键是这个方法的使用
	 	if (path == null) {  //JTree上没有任何项被选中
	 		return;
	 	}
	 	tree.setSelectionPath(path);
	 	if (e.getButton() == 3) {
	 		popMenu.show(tree, e.getX(), e.getY());
	 	}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	//弹出菜单的事件处理程序（需要实现ActionListener接口)
	public void actionPerformed(ActionEvent e) {

	 	DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();  //获得右键选中的节点
	 	if (e.getSource() == addItem) {
		 	((DefaultTreeModel) tree.getModel()).insertNodeInto(
		 	new DefaultMutableTreeNode("Test"), node, node.getChildCount());
		 	tree.expandPath(tree.getSelectionPath());
	 	} else if (e.getSource() == delItem) {
		 	if (node.isRoot()) {
		 		return;
		 	}
	 	    ((DefaultTreeModel) tree.getModel()).removeNodeFromParent(node);
	 	} else if (e.getSource() == editItem) {
	 		tree.startEditingAtPath(tree.getSelectionPath());
	 	}

	 }

}
