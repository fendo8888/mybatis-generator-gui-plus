/**   
 * projectName: mybatis-generator-oracle   
 * fileName: JComboBox_1.java   
 * packageName: com.fendo.gui.demo.components   
 * date: 2018年2月25日下午2:00:32   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.demo.components;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**     
 * @title: JComboBox_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: JComboBox示例   选择事件
 * @author: fendo  
 * @date: 2018年2月25日 下午2:00:32   
 * @version: V1.0     
*/
public class JComboBox_3 implements ItemListener,ActionListener{

    String[] fontsize={"12","14","16","18","20","22","24","26","28"};
    String defaultMessage="请选择或直接输入文字大小!";
    Font font=null;
    JComboBox combo=null;
    JLabel label=null;
	
	public JComboBox_3(){
	      JFrame f=new JFrame("JComboBox"); 
		  //设置居中
	      f.setLocationRelativeTo(null);
	      Container contentPane=f.getContentPane();
	      contentPane.setLayout(new GridLayout(2,1));
	      label=new JLabel("Swing",JLabel.CENTER);
	      font=new Font("SansSerif",Font.PLAIN,12);
	      label.setFont(font);
	      combo=new JComboBox(fontsize);
	      combo.setBorder(BorderFactory.createTitledBorder("请选择你要的文字大小:"));
	      combo.setEditable(true);
	      ComboBoxEditor editor=combo.getEditor();
	      combo.configureEditor(editor,defaultMessage);// 返回用于绘制和编辑 JComboBox 字段中所选项的编辑器
	      combo.addItemListener(this);
	      combo.addActionListener(this);

	      contentPane.add(label);
	      contentPane.add(combo);
	       f.pack();
	       f.show();
	       f.addWindowListener(new WindowAdapter(){
	          public void windowClosing(WindowEvent e){
	        	  System.exit(0);   
	        }
	      });     
	}
	
   public void actionPerformed(ActionEvent e) {
         boolean isaddItem=true;
         int fontsize=0;
         String tmp=(String)combo.getSelectedItem();
         try{//判断用户所输入的项目是否有重复，若有重复则不增加到JComboBox中。
             fontsize=Integer.parseInt(tmp);
             for(int i=0;i<combo.getItemCount();i++){
                 if (combo.getItemAt(i).equals(tmp)){
                    isaddItem=false;
                    break;
                 }
             }
             if (isaddItem){
               combo.insertItemAt(tmp,0);//插入项目tmp到0索引位置(第一列中).
             }
             font=new Font("SansSerif",Font.PLAIN,fontsize);
             label.setFont(font);            
         }catch(NumberFormatException ne){
             combo.getEditor().setItem("你输入的值不是整数值，请重新输入!");
         }
      }
   
      //ItemListener界面只有itemStateChanged()一个方法，在此实现它。
      public void itemStateChanged(ItemEvent e) {
    	 //当用户的选择改变时，则在JLabel上会显示出Swing目前字形大小信息
         if (e.getStateChange() == ItemEvent.SELECTED){
             int fontsize=0;
             try{
                fontsize=Integer.parseInt((String)e.getItem());
                label.setText("Swing 目前字形大小:"+fontsize);                
             }catch(NumberFormatException ne){//若所输入的值不是整数，则不作任何的操作.

             }
         }
      }
	
    public static void main(String[] args){
    	new JComboBox_3();
    }

}
