/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JPopupMenu.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午3:22:32   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**     
 * @title: JPopupMenu.java   
 * @package com.fendo.gui.demo.components   
 * @description: TODO  
 * @author: fendo  
 * @date: 2018年2月25日 下午3:22:32   
 * @version: V1.0     
*/
public class JPopupMenu_1 extends JFrame{

	public JPopupMenu_1() {
        super();
        setTitle("MenuTest");
        setBounds(100,100,350,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final   JLabel   jLabel=new   JLabel("JPopupMenu",JLabel.CENTER); 
        final JPopupMenu popupMenu = new JPopupMenu();  //弹出式菜单
        JMenuItem menuItem = new JMenuItem("菜单项名称");
        popupMenu.add(menuItem);
        getContentPane().addMouseListener(new MouseAdapter(){   //鼠标事件
            /*public void mouseRelease(MouseEvent e){  //释放鼠标事件
                if(e.isPopupTrigger()){
                    //popupMenu.show(e.getComponent(),e.getX(),e.getY());
                    popupMenu.show(jLabel,e.getX(),e.getY());
                }
            }*/
            //public void mouseRelease(MouseEvent e){  //释放鼠标事件
            //if(e.isPopupTrigger()){
                //popupMenu.show(e.getComponent(),e.getX(),e.getY());
                //popupMenu.show(jLabel,e.getX(),e.getY());
            //}
            //}
            public   void   mousePressed(MouseEvent   e) 
            { 
                //popupMenu.show(e.getComponent(),e.getX(),e.getY());
                //popupMenu.show(jLabel,e.getX(),e.getY()); 
            }
        });
        jLabel.addMouseListener(new MouseAdapter(){   //鼠标事件
            
            public   void   mousePressed(MouseEvent   e) 
            { 
                //if(e.getButton()==3)   //1左键,2中键，在这里可以设置键值，这里可设置的不正确，请核实下
                //{
                popupMenu.show(e.getComponent(),e.getX(),e.getY());
                //}
                //popupMenu.show(jLabel,e.getX(),e.getY()); 
            }
        });
        this.getContentPane().add(jLabel); 
        //popupMenu.show(jLabel,e.getX(),e.getY());
        //getContentPane().add(popupMenu);
	}

	public static void main(String[] args) {
		JPopupMenu_1 jPopupMenuTest= new JPopupMenu_1();
        jPopupMenuTest.setVisible(true);
	}

}
