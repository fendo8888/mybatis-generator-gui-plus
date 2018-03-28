/**   
 * projectName: mybatis-generator-oracle   
 * fileName: IconNodeRenderer.java   
 * packageName: com.fendo.gui.ui.trees   
 * date: 2018年3月1日下午6:51:10   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.ui.tree;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**     
 * @title: IconNodeRenderer.java   
 * @package com.fendo.gui.ui.trees   
 * @description: 继承DefaultTreeCellRenderer类 ,自定义树描述类,将树的每个节点设置成不同的图标
 * @author: fendo  
 * @date: 2018年3月1日 下午6:51:10   
 * @version: V1.0     
*/
public class IconNodeRenderer extends DefaultTreeCellRenderer {   
    
	/**
	 * 
	 * @title: getTreeCellRendererComponent  
	 * @description: 重写该方法  
	 * @param tree
	 * @param value
	 * @param sel
	 * @param expanded
	 * @param leaf
	 * @param row
	 * @param hasFocus
	 * @return     
	 */
    public Component getTreeCellRendererComponent(JTree tree, Object value,boolean sel, boolean expanded, boolean leaf, int row,boolean hasFocus){   
       super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,row, hasFocus); //调用父类的该方法   
       Icon icon = ((IconNode) value).getIcon();//从节点读取图片
       String txt = ((IconNode) value).getText(); //从节点读取文本
       setIcon(icon);//设置图片
       setText(txt);//设置文本
       return this;   
     }
}
