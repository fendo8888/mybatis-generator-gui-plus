package com.fendo.gui.demo.components;

import java.awt.BorderLayout;
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
 * @description: 表格示例1  选中行及取消选中
 * @author: fendo  
 * @date: 2018年2月25日 下午12:03:02   
 * @version: V1.0
 */
public class Jtable_2 extends JFrame{

    private DefaultTableModel tableModel;   //表格模型对象
    private JTable table;
    private JTextField aTextField;
    private JTextField bTextField;
    
    public Jtable_2() {
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
        final JTable table = new MyTable(tableValueV,columnNameV);   //自定义的表格
        table.setRowSelectionInterval(1, 3); //设置选择中行
        table.addRowSelectionInterval(5, 5);  //追加
        scrollPane.setViewportView(table);
        JPanel buttonPanel =new JPanel();   //按钮面板
        getContentPane().add(buttonPanel,BorderLayout.SOUTH);  //在下方。
        JButton selectAllButton = new JButton("全部选择");
        selectAllButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                table.selectAll();    //选中所有的行
            }
        });
        
        buttonPanel.add(selectAllButton);
        JButton clearSelectionButton = new JButton("取消选择");
        clearSelectionButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                table.clearSelection();  //取消选择
            }
        });
        buttonPanel.add(clearSelectionButton);
        System.out.println("表格共有："+table.getRowCount()+"行 "+ table.getColumnCount()+"列");
        System.out.println("共有："+table.getSelectedRowCount()+"行被选中");
        System.out.println("第三行的状态："+table.isRowSelected(2)); //第三行
        System.out.println("第5行的状态："+table.isRowSelected(4));//第5行
        System.out.println("被选中的第一行的索引："+table.getSelectedRow());   //被选中的第一行的索引,没有选中返回-1
        int [] selectRows = table.getSelectedRows();  //获得所有被选中的索引
        System.out.println("以下为所有被选中的行:");
        for(int i=0;i<selectRows.length;i++){
            System.out.println(selectRows[i]+" ");
        }
        
        System.out.println();
        System.out.println("列移动前第2列的名称是："+table.getColumnName(1));  //第2列
        System.out.println("列移动前第2行第2列的值："+table.getValueAt(1, 1)); //2,2
        table.moveColumn(1, 5);
        System.out.println("列移动后第2列的名称："+table.getColumnName(1));
        System.out.println("列移动后第2行第2列的值："+table.getValueAt(1, 1));
	}
	
    public static void main(String[] args) {
    	Jtable_2 jTableDefaultTableModelTest = new Jtable_2();
        jTableDefaultTableModelTest.setVisible(true);
    }
    
}

/**
 * 
 * @title: Jtable_2.java   
 * @package com.fendo.gui.demo.components   
 * @description: 实现自定义类  
 * @author: fendo  
 * @date: 2018年2月25日 下午3:29:26   
 * @version: V1.0
 */
class MyTable extends JTable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public MyTable()
    {
        
    }
    public MyTable(Vector rowData ,Vector columnNames)
    {
        super(rowData,columnNames);
    }
    
    /**
     * @Override
     */
    public JTableHeader getTableHeader()
    {
        JTableHeader tableHeader = super.getTableHeader();
        tableHeader.setReorderingAllowed(false);   //设置表格列不可重排
        DefaultTableCellRenderer hr =(DefaultTableCellRenderer)tableHeader.getDefaultRenderer();  //获得表格头的单元格对象
        hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);  //列名居中
        return tableHeader;
        
    }
    /**
     * @Override
     */
    public TableCellRenderer getDefaultRenderer(Class<?>columnClass)
    {
        DefaultTableCellRenderer cr =(DefaultTableCellRenderer)super.getDefaultRenderer(columnClass);
        cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);  //单元格内容居中
        return cr;
    }
    /**
     * @Override
     */
    public boolean isCellEditable(int row,int column)
    {
        return false;   //单元格不可修改
    }
}
