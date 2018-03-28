package com.fendo.gui.demo.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * @title: Jtable_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: 表格示例1  自定义表格
 * @author: fendo  
 * @date: 2018年2月25日 下午12:03:02   
 * @version: V1.0
 */
public class Jtable_3 extends JFrame{

    private DefaultTableModel tableModel;   //表格模型对象
    private JTable table;
    private JTextField aTextField;
    private JTextField bTextField;
    
    public Jtable_3() {
        super();
        setTitle("表格");
        setBounds(100,100,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane();   //支持滚动
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        String[] columnNames = {"A","B","C","D","E","F","G"};
        Vector columnNameV = new Vector();    //获得表头
        for(int column = 0;column<columnNames.length;column++)
        {
            columnNameV.add(columnNames[column]);
        }
        Vector tableValueV = new Vector();
        for(int row = 1;row<21;row++)    //获得数据
        {
            Vector rowV = new Vector();
            for(int column = 0;column<columnNames.length;column++)
            {
                rowV.add(columnNames[column]+row);  //数据
            }
            tableValueV.add(rowV);
        }
        JTable table = new MyTable(tableValueV,columnNameV);   //自定义的表格
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  //关闭表格列的自动调整功能。
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //单选
        table.setSelectionBackground(Color.YELLOW);
        table.setSelectionForeground(Color.RED);
        table.setRowHeight(30);
        scrollPane.setViewportView(table);   //支持滚动
	}
	
    public static void main(String[] args) {
    	Jtable_3 jTableDefaultTableModelTest = new Jtable_3();
        jTableDefaultTableModelTest.setVisible(true);
    }
    
}