package com.fendo.gui.start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import javax.sound.midi.Soundbank;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.apache.commons.lang3.StringUtils;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch8_toolbar.BEToolBarUI;

import com.fendo.gui.constant.ConstantsUI;
import com.fendo.gui.entity.DbConnection;
import com.fendo.gui.ui.treebak.TreeCellRenderer;
import com.fendo.gui.ui.treebak.TreeInit;
import com.fendo.gui.ui.treebak.TreeNode;
import com.fendo.gui.util.IdGen;
import com.fendo.gui.util.JdbcUtil;

/**
 * 
 * @title: Start_Beautyeye.java   
 * @package com.fendo.gui.start   
 * @description: Beautyeye启动类  
 * @author: fendo  
 * @date: 2018年2月25日 上午9:57:03   
 * @version: V1.0
 */
public class Start_Beautyeye1 {

     private JFrame jframe = null;  

	 public static JPopupMenu popMenu;  //菜单
	 public static JMenuItem addItem;   //各个菜单项
	 public static JMenuItem delItem;
	 public static JMenuItem editItem;
	 
     private static JTextField aTextField;
     private static JTextField bTextField;
	
	public static void main(String[] args) {
        try {  
            //设置本属性将改变窗口边框样式定义
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            
    		//创建一个主窗体
    		JFrame  jframe = new JFrame();
    		//设置标题
    		jframe.setTitle("Mybatis辅助工具");
    		//设置窗体大小
    		jframe.setSize(800, 600);
    		//设置布局方式
    		jframe.setLayout(new BorderLayout());
    		//设置窗体居中显示
    		jframe.setLocationRelativeTo(null);
    		//设置关闭窗体的时候退出程序
    		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		jframe.setLocationRelativeTo(null);
    		//设置窗体不能改变大小
    		jframe.setResizable(false);

    		//垂直分割面板   HORIZONTAL:水平      VERTICAL:垂直
    		JSplitPane verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    		
    		//水平分割面板
    		JSplitPane horizontalSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    		
    		//初始化树
//    	    JTree tree = new JTree(TreeInit.getTreeNode());
//            tree.setCellRenderer(new TreeCellRenderer());
//            tree.putClientProperty("JTree.lineStyle", "None");
//            tree.setRootVisible(false);
 
            // 创建没有父节点和子节点、但允许有子节点的树节点，并使用指定的用户对象对它进行初始化。
            // public DefaultMutableTreeNode(Object userObject)
            DefaultMutableTreeNode group1 = new DefaultMutableTreeNode("软件部");
            TreeNode node1 = new TreeNode();
            node1.setName("王雨");
            node1.setNickName("漫天飞舞");
            group1.add(new DefaultMutableTreeNode(node1));

            TreeNode node2 = new TreeNode();
            node2.setName("陈梦");
            node2.setNickName("梦");
            group1.add(new DefaultMutableTreeNode(node2));

            TreeNode node3 = new TreeNode();
            node3.setName("上官飞儿");
            node3.setNickName("飞儿");
            group1.add(new DefaultMutableTreeNode(node3));

            DefaultMutableTreeNode group2 = new DefaultMutableTreeNode("销售部");

            TreeNode node4 = new TreeNode();
            node4.setName("上官婉儿");
            node4.setNickName("婉儿");
            group2.add(new DefaultMutableTreeNode(node4));

            TreeNode node5 = new TreeNode();
            node5.setName("上官巧儿");
            node5.setNickName("巧儿");
            group2.add(new DefaultMutableTreeNode(node5));

            DefaultMutableTreeNode top = new DefaultMutableTreeNode("职员管理");

            top.add(group1);
            top.add(group2);

            //实例化一个树
            JTree jtree = new JTree(top);
            jtree.setBackground(Color.white);
            //设置树可编辑
            jtree.setEditable(true);
            jtree.getSelectionModel().setSelectionMode(
                 	TreeSelectionModel.SINGLE_TREE_SELECTION);
            jtree.setCellEditor(new DefaultTreeCellEditor(jtree,
         	     	new DefaultTreeCellRenderer()));
            
            //添加菜单项以及为菜单项添加事件
         	popMenu = new JPopupMenu();
         	
         	editItem = new JMenuItem("修改");
         	editItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//jtree.startEditingAtPath(jtree.getSelectionPath());
					TreePath selectedPath = jtree.getSelectionPath();
					System.out.println("点击了修改: " + selectedPath);
					if (selectedPath != null) {
						// 编辑选中节点
						jtree.startEditingAtPath(selectedPath);
					}
				}
			});
         	
         	addItem = new JMenuItem("添加");
         	addItem.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					
				 	DefaultMutableTreeNode node = (DefaultMutableTreeNode) jtree.getLastSelectedPathComponent();  //获得右键选中的节点
				 	((DefaultTreeModel) jtree.getModel()).insertNodeInto(
						 	new DefaultMutableTreeNode("Test"), node, node.getChildCount());
				 			jtree.expandPath(jtree.getSelectionPath());
				}
			});
         	delItem = new JMenuItem("删除");
         	delItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				 	DefaultMutableTreeNode node = (DefaultMutableTreeNode) jtree.getLastSelectedPathComponent();  //获得右键选中的节点
				 	if (node.isRoot()) {
				 		return;
				 	}
				 	((DefaultTreeModel) jtree.getModel()).removeNodeFromParent(node);
				}
			});

    		
         	popMenu.add(addItem);
         	popMenu.add(delItem);
         	popMenu.add(editItem);
         	
         	
    		//水平分割面板-左部面板
    		JPanel leftPanel = new JPanel();
    		leftPanel.setBorder(new TitledBorder(null, "数据库表", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
    		//leftPanel.setBackground(Color.blue);
    		leftPanel.add(jtree);
    		
            
    		//水平分割面板-右部面板
    		//JPanel rightPanel = new JPanel();
    		//rightPanel.setBackground(Color.pink);
    		
    		//选项卡面板
    		JTabbedPane rightTabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.CENTER);
    		
    		//字段管理面板
    		JPanel rightTabbedPaneColumn = new JPanel();
    		
    		//列名  		
            String[] columnNames = {"A","B"};   
            //数据
            String [][]tableVales={{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"},{"A5","B5"}}; 
    		
            //表格模型对象  
            DefaultTableModel tableModel = new DefaultTableModel(tableVales,columnNames);
            JTable table = new JTable(tableModel);
            
            JScrollPane scrollPane = new JScrollPane(table);   //支持滚动
            
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
            table.addMouseListener(new MouseAdapter(){    //鼠标事件
                public void mouseClicked(MouseEvent e){
                    int selectedRow = table.getSelectedRow(); //获得选中行索引
                    Object oa = tableModel.getValueAt(selectedRow, 0);
                    Object ob = tableModel.getValueAt(selectedRow, 1);
                    aTextField.setText(oa.toString());  //给文本框赋值
                    bTextField.setText(ob.toString());
                }
            });
            
            scrollPane.setViewportView(table);
            
    		rightTabbedPaneColumn.add(scrollPane);
    		
    		
    		//代码生成面板
    		JPanel rightTabbedPaneCodeGen = new JPanel();

    		//将面板加入到选项卡面板中
    		rightTabbedPane.add("字段管理", rightTabbedPaneColumn);
    		rightTabbedPane.add("代码生成", rightTabbedPaneCodeGen);
    		
    		//按钮面板
    		JPanel buttonPanel = new JPanel();
    		//buttonPanel.setBackground(Color.gray);
    		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));//流式布局,控件左对齐
    		
    		//首页
    	    JLabel home =new JLabel("首页",JLabel.CENTER);//创建指定文本的标签对象
    	    home.setIcon(ConstantsUI.ICON_HOME);//添加图像
    	    home.setHorizontalTextPosition(JLabel.CENTER);//设置文本相对于图像的水平位置
    	    home.setVerticalTextPosition(JLabel.BOTTOM);//设置文本相对于图像的垂直位置
    	    home.setEnabled(false);//设置标签为不可用
    	    home.setDisabledIcon(ConstantsUI.ICON_HOME);//设置标签在不可用情况下显示的图像
    		
    		//数据库
    	    JLabel database =new JLabel("数据库",JLabel.CENTER);//创建指定文本的标签对象
    	    database.setIcon(ConstantsUI.ICON_DATABASE);//添加图像
    	    database.setHorizontalTextPosition(JLabel.CENTER);//设置文本相对于图像的水平位置
    	    database.setVerticalTextPosition(JLabel.BOTTOM);//设置文本相对于图像的垂直位置
    	    database.setEnabled(false);//设置标签为不可用
    	    database.setDisabledIcon(ConstantsUI.ICON_DATABASE);//设置标签在不可用情况下显示的图像
    	    database.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					
				}
				
				// 处理鼠标点击
				@Override
				public void mouseClicked(MouseEvent e) {
					//创建模式窗体
					JDialog jd = new JDialog();
					//设置标题
					jd.setTitle("数据库连接");
					//设置大小
					jd.setSize(500, 300);
					//设置居中
					jd.setLocationRelativeTo(null);
					//设置关闭的方式
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					//设置窗口大小是否可变
					jd.setResizable(true);
					
					BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
					
					//面板
					JPanel jPanel = new JPanel();
										
					//创建一个水平箱子
					Box boxHorizonta_1 = Box.createHorizontalBox();
					
					JLabel jLabelName = new JLabel();
					jLabelName.setText("保存名称: ");
					JTextField jTextFieldName = new JTextField();
					//jTextFieldName.setSize(30, 30);
					jTextFieldName.setColumns(30); //设置长度
					jTextFieldName.setMaximumSize(jTextFieldName.getPreferredSize());
					

				    //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
				    boxHorizonta_1.add(jLabelName);
				    boxHorizonta_1.add(Box.createHorizontalStrut(20));
				    boxHorizonta_1.add(jTextFieldName);
				
					//数据库类型
					Box boxHorizonta_2 = Box.createHorizontalBox();
					JLabel jLabelDbType = new JLabel();
					jLabelDbType.setText("数据库类型  ");
					
					Vector v=new Vector();//创建一个Vector，用来构造下拉列表框
				    //往Vector中添加元素
				    v.addElement("MySQL");
				    v.addElement("Oracle");
				    
				    JComboBox dbtype = new JComboBox(v); //利用Vector创建下拉列表框
				    //dbtype.setSize(30, 30);
				    dbtype.setMaximumSize(dbtype.getPreferredSize());
				    
				    //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
				    boxHorizonta_2.add(jLabelDbType);
				    boxHorizonta_2.add(Box.createHorizontalStrut(110));
				    boxHorizonta_2.add(dbtype);
				    
				    
					//主机名或IP
					Box boxHorizonta_3 = Box.createHorizontalBox();
					JLabel JlabellocalhostName = new JLabel();
					JlabellocalhostName.setText("主机名或IP");
					
					JTextField JtextFieldlocalhostName = new JTextField();
					JtextFieldlocalhostName.setColumns(30); //设置长度
					JtextFieldlocalhostName.setMaximumSize(JtextFieldlocalhostName.getPreferredSize());
				    
				    //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
				    boxHorizonta_3.add(JlabellocalhostName);
				    boxHorizonta_3.add(Box.createHorizontalStrut(20));
				    boxHorizonta_3.add(JtextFieldlocalhostName);
				    
				    
					//端口号
					Box boxHorizonta_4 = Box.createHorizontalBox();
					JLabel JlabelHostName = new JLabel();
					JlabelHostName.setText("端口号");
					
					JTextField JtextFieldHostName = new JTextField();
					JtextFieldHostName.setColumns(30); //设置长度
					JtextFieldHostName.setMaximumSize(JtextFieldHostName.getPreferredSize());
				    
				    //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
					boxHorizonta_4.add(JlabelHostName);
					boxHorizonta_4.add(Box.createHorizontalStrut(20));
					boxHorizonta_4.add(JtextFieldHostName);
				    
					
					//用户名
					Box boxHorizonta_5 = Box.createHorizontalBox();
					JLabel JlabelUserName = new JLabel();
					JlabelUserName.setText("用户名");
					
					JTextField JtextFieldUserName = new JTextField();
					JtextFieldUserName.setColumns(30); //设置长度
					JtextFieldUserName.setMaximumSize(JtextFieldUserName.getPreferredSize());
				    
				    //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
					boxHorizonta_5.add(JlabelUserName);
					boxHorizonta_5.add(Box.createHorizontalStrut(20));
					boxHorizonta_5.add(JtextFieldUserName);
					
					
					//密码
					Box boxHorizonta_6 = Box.createHorizontalBox();
					JLabel JlabelPasswordName = new JLabel();
					JlabelPasswordName.setText("密码");
					
					JTextField JtextFieldPasswordName = new JTextField();
					JtextFieldPasswordName.setColumns(30); //设置长度
					JtextFieldPasswordName.setMaximumSize(JtextFieldUserName.getPreferredSize());
				    
				    //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
					boxHorizonta_6.add(JlabelPasswordName);
					boxHorizonta_6.add(Box.createHorizontalStrut(20));
					boxHorizonta_6.add(JtextFieldPasswordName);
				    
					
					
					//Schema/数据库
					Box boxHorizonta_7 = Box.createHorizontalBox();
					JLabel JlabelSchemadName = new JLabel();
					JlabelSchemadName.setText("Schema/数据库");
					
					JTextField JtextFieldSchemadName = new JTextField();
					JtextFieldSchemadName.setColumns(30); //设置长度
					JtextFieldSchemadName.setMaximumSize(JtextFieldUserName.getPreferredSize());
				    
				    //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
					boxHorizonta_7.add(JlabelSchemadName);
					boxHorizonta_7.add(Box.createHorizontalStrut(20));
					boxHorizonta_7.add(JtextFieldSchemadName);
					
					
					//编码
					Box boxHorizonta_8 = Box.createHorizontalBox();
					JLabel jLabelGkType = new JLabel();
					jLabelGkType.setText("编码");
					
					Vector v1 = new Vector();//创建一个Vector，用来构造下拉列表框
				    //往Vector中添加元素
					v1.addElement("UTF-8");
					v1.addElement("GBK");
				    
				    JComboBox gkType = new JComboBox(v1); //利用Vector创建下拉列表框
				    //dbtype.setSize(30, 30);
				    gkType.setMaximumSize(gkType.getPreferredSize());
				    
				    //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
				    boxHorizonta_8.add(jLabelGkType);
				    boxHorizonta_8.add(Box.createHorizontalStrut(110));
				    boxHorizonta_8.add(gkType);
					

					//确定
					Box boxHorizonta_9 = Box.createHorizontalBox();
					
					JButton jButtonTest = new JButton("测试连接");
					jButtonTest.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String Message = null;
							
							//数据库名
							String SchemadName = JtextFieldSchemadName.getText();
							if(StringUtils.isEmpty(SchemadName)) {
								Message = "数据库名";
							}	
							//用户名
							String UserName = JtextFieldUserName.getText();
							if(StringUtils.isEmpty(UserName)) {
								Message = "用户名";
							}	
							//端口号
							String hostName = JtextFieldHostName.getText();
							if(StringUtils.isEmpty(hostName)) {
								Message = "端口号";
							}	
							//密码
							String passwordName = JtextFieldPasswordName.getText();
							if(StringUtils.isEmpty(passwordName)) {
								Message = "密码";
							}
							//主机名
							String localhostName = JtextFieldlocalhostName.getText();
							if(StringUtils.isEmpty(localhostName)) {
								Message = "主机名";
							}
							// 保存名称
							String saveName = jTextFieldName.getText();
							if(StringUtils.isEmpty(saveName)) {
								Message = "保存名称";
							}
							
							

							if(StringUtils.isNotEmpty(Message)) {
								JOptionPane.showMessageDialog(null, Message + "不能为空!","提示",JOptionPane.ERROR_MESSAGE); 
							}

							String driver = null;
							String url = null;
							//数据库类型
						    int dbtypeIndex = dbtype.getSelectedIndex()+1;  
						    String dbtypeValue = (String)dbtype.getSelectedItem();  
						    System.out.println("你选中的是第" + dbtypeIndex + "项" + ",内容是:" + dbtypeValue); 
						    if("MySQL".equals(dbtypeValue)) {
						    	driver = "com.mysql.jdbc.Driver";
						    	url = "jdbc:mysql://" + localhostName + ":" + hostName + "/" + SchemadName + "?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8";
						    }else {
						    	driver = "oracle.jdbc.driver.OracleDriver";
						    	url = "jdbc:oracle:thin:@" + localhostName + ":" + hostName + ":" + SchemadName;
						    }
						    
						    if(StringUtils.isEmpty(Message)) {
							    try {
								    Connection connection = JdbcUtil.getConnection(driver,url,UserName,passwordName);
									if(!connection.isClosed()) {
										JOptionPane.showMessageDialog(null, "连接成功!","提示",JOptionPane.INFORMATION_MESSAGE); 
									}
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(null, "连接失败!","提示",JOptionPane.ERROR_MESSAGE); 
								}	

						    }
						}
					});
					
					
					JButton jButtonOK = new JButton("确定");
					jButtonOK.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
	
							String Message = null;
							
							//数据库名
							String SchemadName = JtextFieldSchemadName.getText();
							if(StringUtils.isEmpty(SchemadName)) {
								Message = "数据库名";
							}	
							//用户名
							String UserName = JtextFieldUserName.getText();
							if(StringUtils.isEmpty(UserName)) {
								Message = "用户名";
							}	
							//端口号
							String hostName = JtextFieldHostName.getText();
							if(StringUtils.isEmpty(hostName)) {
								Message = "端口号";
							}	
							//密码
							String passwordName = JtextFieldPasswordName.getText();
							if(StringUtils.isEmpty(passwordName)) {
								Message = "密码";
							}
							//主机名
							String localhostName = JtextFieldlocalhostName.getText();
							if(StringUtils.isEmpty(localhostName)) {
								Message = "主机名";
							}
							// 保存名称
							String saveName = jTextFieldName.getText();
							if(StringUtils.isEmpty(saveName)) {
								Message = "保存名称";
							}

							if(StringUtils.isNotEmpty(Message)) {
								JOptionPane.showMessageDialog(null, Message + "不能为空!","提示",JOptionPane.ERROR_MESSAGE); 
							}

							//数据库类型
						    int dbtypeIndex = dbtype.getSelectedIndex()+1;  
						    String dbtypeValue = (String)dbtype.getSelectedItem();  
						    System.out.println("你选中的是第" + dbtypeIndex + "项" + ",内容是:" + dbtypeValue); 

							//编码
						    int gkTypeIndex = gkType.getSelectedIndex() + 1;  
						    String gkTypeIndexValue=(String)gkType.getSelectedItem();  
						    System.out.println("你选中的是第" + gkTypeIndex + "项" + ",内容是:" + gkTypeIndexValue); 
						    
						    if(StringUtils.isEmpty(Message)) {
						    	
								String driver = null;
								String url = null;

							    if("MySQL".equals(dbtypeValue)) {
							    	driver = "com.mysql.jdbc.Driver";
							    	url = "jdbc:mysql://" + localhostName + ":" + hostName + "/" + SchemadName + "?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8";
							    }else {
							    	driver = "oracle.jdbc.driver.OracleDriver";
							    	url = "jdbc:oracle:thin:@" + localhostName + ":" + hostName + ":" + SchemadName;
							    }
							    
							    if(StringUtils.isEmpty(Message)) {
							    	
								    try {
								    	
									    Connection connection = JdbcUtil.getConnection(driver,url,UserName,passwordName);
										if(!connection.isClosed()) {
											JOptionPane.showMessageDialog(null, "连接成功!","提示",JOptionPane.INFORMATION_MESSAGE); 
										}
										
									    DbConnection dbConnection = new DbConnection();
									    dbConnection.setId(IdGen.getUUID());
									    dbConnection.setSaveName(saveName);
									    dbConnection.setLocalhostName(localhostName);
									    dbConnection.setPassword(passwordName);
									    dbConnection.setPort(hostName);
									    dbConnection.setUserName(UserName);
									    dbConnection.setPort(SchemadName);
									    dbConnection.setCoding(gkTypeIndexValue);
									    dbConnection.setDbType(dbtypeValue);
									    
									    jd.dispose();
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(null, "连接失败!","提示",JOptionPane.ERROR_MESSAGE); 
									}	

							    }
						    	
						    }
						}
					});
				    
				    //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
				    boxHorizonta_9.add(jButtonTest);
				    boxHorizonta_9.add(Box.createHorizontalStrut(20));
					boxHorizonta_9.add(jButtonOK);
				    
				    
				    //创建一个垂直箱子，这个箱子将两个水平箱子添加到其中，创建一个横向 glue 组件。
			        Box boxVertical = Box.createVerticalBox();
			        boxVertical.add(boxHorizonta_1);
			        boxVertical.add(boxHorizonta_2);
			        boxVertical.add(boxHorizonta_3);
			        boxVertical.add(boxHorizonta_4);
			        boxVertical.add(boxHorizonta_5);
			        boxVertical.add(boxHorizonta_6);
			        boxVertical.add(boxHorizonta_7);
			        boxVertical.add(boxHorizonta_8);
			        boxVertical.add(boxHorizonta_9);
			        
					jd.setContentPane(boxVertical);
					//设置可见
					jd.setVisible(true);
					
				}
			});
    	    
    		//开发工具
    	    JLabel development =new JLabel("开发工具",JLabel.CENTER);//创建指定文本的标签对象
    	    development.setIcon(ConstantsUI.ICON_DEVELOPMENT);//添加图像
    	    development.setHorizontalTextPosition(JLabel.CENTER);//设置文本相对于图像的水平位置
    	    development.setVerticalTextPosition(JLabel.BOTTOM);//设置文本相对于图像的垂直位置
    	    development.setEnabled(false);//设置标签为不可用
    	    development.setDisabledIcon(ConstantsUI.ICON_DEVELOPMENT);//设置标签在不可用情况下显示的图像
    	    
    	    //设置
       	    JLabel setting = new JLabel("设置",JLabel.CENTER);//创建指定文本的标签对象
       	    setting.setIcon(ConstantsUI.ICON_SETTING);//添加图像
       	    setting.setHorizontalTextPosition(JLabel.CENTER);//设置文本相对于图像的水平位置
       	    setting.setVerticalTextPosition(JLabel.BOTTOM);//设置文本相对于图像的垂直位置
       	    setting.setEnabled(false);//设置标签为不可用
       	    setting.setDisabledIcon(ConstantsUI.ICON_SETTING);//设置标签在不可用情况下显示的图像
    	    
    		//设置垂直分割面板属性
    		verticalSplit.setDividerLocation(90);//按照百分比设置分割条的位置
    		verticalSplit.setDividerSize(5);//设置分割条的大小。
    		
    		//第二个分割面板的分割线的属性
    		horizontalSplit.setDividerLocation(200);//按照百分比设置分割条的位置
    		horizontalSplit.setDividerSize(4);//设置分割条的大小。
    		
    		//将面板加入到水平分割面板中
    		horizontalSplit.setLeftComponent(leftPanel);
    		horizontalSplit.setRightComponent(rightTabbedPane);
    		
    		//将按钮加入到分割面板中
    		buttonPanel.add(home);
    		buttonPanel.add(database);
    		buttonPanel.add(development);
    		buttonPanel.add(setting);
    		
    		//设置垂直分割面板上侧组件
    		verticalSplit.setLeftComponent(buttonPanel);
    		//设置垂直分割面板下侧组件
    		verticalSplit.setRightComponent(horizontalSplit);
    		
    		//为jtree设置鼠标监听器
    		jtree.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					System.out.println("鼠标松开"); 
				 	TreePath path = jtree.getPathForLocation(e.getX(), e.getY()); // 关键是这个方法的使用
				 	if (path == null) {  //JTree上没有任何项被选中
				 		return;
				 	}
				 	jtree.setSelectionPath(path);
				 	if (e.getButton() == 3) {
				 		popMenu.show(jtree, e.getX(), e.getY());
				 	}					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					System.out.println("鼠标按下");  
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					System.out.println("鼠标已经移出窗体");
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					System.out.println("鼠标已经进入窗体");
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.print("鼠标点击----" + "\t");
			        if (e.getClickCount()==1) {  
			            System.out.println("单击！");  
			        } else if (e.getClickCount()==2) {  
			            System.out.println("双击！");  
			        } else if (e.getClickCount()==3) {  
			            System.out.println("三连击！！");  
			        }  
				}
			});
    		
    		//将垂直分割面板设置为内容面板
    		jframe.setContentPane(verticalSplit);
    		jframe.setVisible(true);
    		
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}


}
