package com.fendo.gui.demo.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.table.TableColumn;

/**
 * 
 * @title: Jtable_1.java   
 * @package com.fendo.gui.demo.components   
 * @description: 表格示例1  带下拉框的表格
 * @author: fendo  
 * @date: 2018年2月25日 下午12:03:02   
 * @version: V1.0
 */
public class Jtable_4 extends JFrame{

    private JPanel panel;  
    private JTable table; //定义个二维数据表格  
    private JScrollPane scrollPane; //定义带有滚动条的面板  
    private DefaultTableModel dtm; //定义表格模型，该模型可以存放数据  
      
    //初始化数据  
    Object[][] rowData = {  
        {"1001", "李汉", "软件部", new Double(3000)},  
        {"1002", "朱泽", "软件部", new Double(3100)},  
        {"1003", "刘宇", "经理部", new Double(3000)},  
        {"1004", "张斌", "软件部", new Double(4000)},  
        {"1005", "秦小", "人事部", new Double(4000)}  
    };  
      
    //初始化列名  
    Object[] columnNames = {"编号", "姓名", "部门", "月薪"};  
    
    public Jtable_4() {
        super("单元格具有下拉框的表格");  
        init(); 
	}
	
    public void init() {  
        setSize(500, 300);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
          
        //利用TableModel重新覆盖isCellEditable方法，将第一列变成不可编辑状态  
        dtm = new DefaultTableModel(rowData, columnNames) {  
            public boolean isCellEditable(int rowIndex, int columnIndex) {  
                boolean f = (0 <= rowIndex && rowIndex < getRowCount() && columnIndex == 0) ? false : true;  
                return f;  
            }  
        };  
        table = new JTable(dtm);  
        JComboBox comboBox = new JComboBox();  
        comboBox.addItem("软件部");  
        comboBox.addItem("经理部");  
        comboBox.addItem("人事部");  
        comboBox.addItem("后勤部");  
        comboBox.addItem("财务部");  
          
        //TableColumn主要作用可以对表格中的某一列的属性进行编辑  
        TableColumn tableColumn = table.getColumn("部门");  
          
        //利用TableColumn类中的setCellEditor()方法来设置单元格的编辑器  
        //DefaultCellEditor类可以将表格中的单元格设置成下拉框  
        tableColumn.setCellEditor(new DefaultCellEditor(comboBox));  
          
        //DefaultTableCellRenderer类可以绘制单元格的背景、字体颜色等功能  
        DefaultTableCellRenderer backGroundColor = new DefaultTableCellRenderer();  
        //绘制部门列的背景为黄色  
        backGroundColor.setBackground(Color.yellow);  
        tableColumn.setCellRenderer(backGroundColor);  
          
          
        TableColumn moneyColumn = table.getColumn("月薪");  
        //绘制月薪列的字体颜色  
        DefaultTableCellRenderer fontColor = new DefaultTableCellRenderer() {  
            public void setValue(Object value) { //重写setValue方法，从而可以动态设置列单元字体颜色  
              
                double a = (value instanceof Double) ? ((Double) value).doubleValue() : 0.0; //获取月薪列中的值  
                  
                setForeground((a  > 3099.0) ? Color.red : Color.black); //如果月薪大于3099元，就将字体设置为红色  
                  
                setText((value == null) ? "" : value.toString());  
            }  
        };  
        moneyColumn.setCellRenderer(fontColor);  
          
          
        panel = new JPanel();  
        panel.setLayout(new BorderLayout());  
          
        scrollPane = new JScrollPane();  
        scrollPane.getViewport().setView(table); //把二维数据表格放到滚动面板中  
        panel.add(scrollPane, BorderLayout.CENTER); //把滚动面板添加到底层面板上  
          
        this.getContentPane().add(panel, BorderLayout.CENTER);  
          
        setVisible(true);  
    }  
    
    public static void main(String[] args) {
    	Jtable_4 jTableDefaultTableModelTest = new Jtable_4();
    	jTableDefaultTableModelTest.setLocationRelativeTo(null);
        jTableDefaultTableModelTest.setVisible(true);
    }
    
}