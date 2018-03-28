/**   
 * projectName: mybatis-generator-oracle   
 * fileName: Test.java   
 * packageName: com.fendo.gui.ui.trees   
 * date: 2018年3月1日下午6:53:50   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.ui.tree;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.fendo.gui.ui.treebak.TreeCellRenderer;
import com.fendo.gui.ui.treebak.TreeNode;

/**     
 * @title: Test.java   
 * @package com.fendo.gui.ui.trees   
 * @description: TODO  
 * @author: fendo  
 * @date: 2018年3月1日 下午6:53:50   
 * @version: V1.0     
*/
public class Test implements ActionListener{

    static JFrame frame = null; 
    static JPopupMenu popMenu; //菜单
    static JMenuItem addItem;   //各个菜单项
    static JMenuItem delItem;
    static JMenuItem editItem;
    static JTree tree;
	
	public static void main(String[] args) {

        try{
		      UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
		      SwingUtilities.updateComponentTreeUI(frame);   
		   }catch(Exception e){
			  
		 }
		 frame=new JFrame("树");
		 frame.setSize(150,300);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

		 IconNode root1=new IconNode(new ImageIcon("src/main/resources/icon/databaseList.png"),"高中同学");
		 IconNode root2=new IconNode(new ImageIcon("src/main/resources/icon/databaseList.png"),"初中同学");
		    
		 root1.add(new IconNode(new ImageIcon("src/main/resources/icon/openSystem.png"),"雅君"));
		 root1.add(new IconNode(new ImageIcon("src/main/resources/icon/openSystem.png"),"伟旭"));
		 root1.add(new IconNode(new ImageIcon("src/main/resources/icon/openSystem.png"),"宜群"));
		 root2.add(new IconNode(new ImageIcon("src/main/resources/icon/openSystem.png"),"彬强"));
		 root2.add(new IconNode(new ImageIcon("src/main/resources/icon/openSystem.png"),"小强"));
		    
		 IconNode Root=new IconNode(null,null);//定义根节点
		 Root.add(root1);//定义二级节点
		 Root.add(root2);//定义二级节点

        
		 tree = new JTree(Root);//定义树   
		 tree.setCellRenderer(new IconNodeRenderer()); //设置单元格描述    
		 tree.setEditable(false); //设置树是否可编辑
		 tree.setRootVisible(false);//设置树的根节点是否可视
		 tree.setToggleClickCount(1);//设置单击几次展开数节点
		 
		 DefaultTreeCellRenderer cellRenderer=(DefaultTreeCellRenderer)tree.getCellRenderer();//获取该树的Renderer
		 cellRenderer.setClosedIcon(new ImageIcon("2.gif"));//关闭打开图标
		 cellRenderer.setOpenIcon(new ImageIcon("2.gif"));//设置展开图标
		    
		 //测试事件
		 tree.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e){
					System.out.println("鼠标松开"); 
				 	TreePath paths = tree.getPathForLocation(e.getX(), e.getY()); // 关键是这个方法的使用
				 	if (tree == null) {  //JTree上没有任何项被选中
				 		return;
				 	}
				 	tree.setSelectionPath(paths);
				 	if (e.getButton() == 3) {
				 		popMenu.show(tree, e.getX(), e.getY());
				 	}
			      //双击节点
			     if(e.getClickCount()==2){
			       TreePath path = tree.getSelectionPath();//获取选中节点路径
			       IconNode node=(IconNode)path.getLastPathComponent();//通过路径将指针指向该节点
			       //如果该节点是叶子节点
			       if(node.isLeaf()){
			        //DefaultTreeModel model=(DefaultTreeModel)tree.getModel();//获取该树的模型
			           //model.removeNodeFromParent(node);//从本树删除该节点     
			           node.setIcon(new ImageIcon("src/main/resources/icon/databaseManage.png"));//修改该节点的图片
			           node.setText("双击");//修改该节点的文本
			           tree.repaint();//重绘更新树
			           System.out.println(node.getText());
			           //不是叶子节点
			       }else {  
			    	   
			       }
			       
			     }
		     }
		});
		   
		 
		popMenu = new JPopupMenu();
     	editItem = new JMenuItem("修改");
     	editItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//jtree.startEditingAtPath(jtree.getSelectionPath());
				TreePath selectedPath = tree.getSelectionPath();
				System.out.println("点击了修改: " + selectedPath);
				if (selectedPath != null) {
					// 编辑选中节点
					tree.startEditingAtPath(selectedPath);
				}
			}
		});
     	
     	addItem = new JMenuItem("添加");
     	addItem.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
			 	DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();  //获得右键选中的节点
			 	((DefaultTreeModel) tree.getModel()).insertNodeInto(
					 	new DefaultMutableTreeNode("Test"), node, node.getChildCount());
			 			tree.expandPath(tree.getSelectionPath());
			}
		});
     	delItem = new JMenuItem("删除");
     	delItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 	DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();  //获得右键选中的节点
			 	if (node.isRoot()) {
			 		return;
			 	}
			 	((DefaultTreeModel) tree.getModel()).removeNodeFromParent(node);
			}
		});

     	//editItem.addActionListener(this);
     	popMenu.add(addItem);
     	popMenu.add(delItem);
     	popMenu.add(editItem);
		 
	    JScrollPane sp = new JScrollPane(tree);   
	    frame.getContentPane().add(sp, BorderLayout.CENTER); 
	    frame.setVisible(true);
	}

	/**
	 * 
	 * @title: actionPerformed  
	 * @description: 弹出菜单的事件处理程序（需要实现ActionListener接口)  
	 * @param e     
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
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
