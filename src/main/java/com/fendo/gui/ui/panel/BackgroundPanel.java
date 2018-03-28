/**   
 * projectName: mybatis-generator-oracle   
 * fileName: BackgroundPanel.java   
 * packageName: com.fendo.gui.ui.panel   
 * date: 2018年3月2日上午9:40:37   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.ui.panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @title: BackgroundPanel.java
 * @package com.fendo.gui.ui.panel
 * @description: 有背景图片的Panel类
 * @author: fendo
 * @date: 2018年3月2日 上午9:40:37
 * @version: V1.0
 */
public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = -6352788025440244338L;

	private ImageIcon image = null;

	public BackgroundPanel(ImageIcon image) {
		this.image = image;
	}

	/**
	 * 
	 * @title: paintComponent  
	 * @description: 固定背景图片，允许这个JPanel可以在图片上添加其他组件  
	 * @param g     
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		//g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		System.out.println(""+image.getIconWidth() + image.getIconHeight());
		g.drawImage(image.getImage(), 0, 0, image.getIconWidth(), image.getIconHeight(), this);
	}

}
