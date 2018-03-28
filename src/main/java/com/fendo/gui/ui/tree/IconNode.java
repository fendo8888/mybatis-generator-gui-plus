/**   
 * projectName: mybatis-generator-oracle   
 * fileName: IconNode.java   
 * packageName: com.fendo.gui.ui.trees   
 * date: 2018年3月1日下午6:51:54   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.ui.tree;

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @title: IconNode.java
 * @package com.fendo.gui.ui.trees
 * @description: 定义节点类
 * @author: fendo
 * @date: 2018年3月1日 下午6:51:54
 * @version: V1.0
 */
public class IconNode extends DefaultMutableTreeNode {

	protected Icon icon;
	protected String txt;
	private String nickName;

	// 只包含文本的节点构造
	public IconNode(String txt) {
		super();
		this.txt = txt;
	}

	// 包含文本和图片的节点构造
	public IconNode(Icon icon, String txt) {
		super();
		this.icon = icon;
		this.txt = txt;
	}
	
	// 包含文本和图片的节点构造
	public IconNode(Icon icon, String txt,String nickName) {
		super();
		this.icon = icon;
		this.txt = txt;
		this.nickName = nickName;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setText(String txt) {
		this.txt = txt;
	}

	public String getText() {
		return txt + "["+nickName+"]";
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "IconNode [icon=" + icon + ", txt=" + txt + ", nickName=" + nickName + "]";
	}

	
	
}
