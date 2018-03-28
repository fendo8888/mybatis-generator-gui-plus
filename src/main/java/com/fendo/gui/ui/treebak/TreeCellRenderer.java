/**   
 * projectName: mybatis-generator-oracle   
 * fileName: TreeCellRenderer.java   
 * packageName: com.fendo.gui.ui   
 * date: 2018年2月27日下午1:29:55   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.ui.treebak;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * @title: TreeCellRenderer.java
 * @package com.fendo.gui.ui
 * @description: 自定义树描述类,将树的每个节点设置成不同的图标
 * @author: fendo
 * @date: 2018年2月27日 下午1:29:55
 * @version: V1.0
 */
public class TreeCellRenderer extends DefaultTreeCellRenderer {

	private static final long serialVersionUID = 1L;

	/**
	 * 重写父类DefaultTreeCellRenderer的方法
	 */
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean isLeaf, int row, boolean hasFocus) {
		// 选中
		if (selected) {
			setForeground(getTextSelectionColor());
		} else {
			setForeground(getTextNonSelectionColor());
		}
		// TreeNode
		DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) value;

		Object obj = treeNode.getUserObject();

		if (obj instanceof TreeNode) {
			TreeNode node = (TreeNode) obj;
			DefaultTreeCellRenderer tempCellRenderer = new DefaultTreeCellRenderer();
			tempCellRenderer.setLeafIcon(new ImageIcon(node.getImagePath()));
			return tempCellRenderer.getTreeCellRendererComponent(tree, node.toString(), selected, expanded, true, row,
					hasFocus);
		} else if (obj instanceof String) {
			String text = (String) obj;
			DefaultTreeCellRenderer tempCellRenderer = new DefaultTreeCellRenderer();
			tempCellRenderer.setOpenIcon(new ImageIcon("Image/open.jpg"));
			tempCellRenderer.setClosedIcon(new ImageIcon("Image/close.jpg"));
			return tempCellRenderer.getTreeCellRendererComponent(tree, text, selected, expanded, false, row, hasFocus);
		}
		return super.getTreeCellRendererComponent(tree, value, selected, expanded, isLeaf, row, hasFocus);
	}

}
