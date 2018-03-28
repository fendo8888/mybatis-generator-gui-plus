#说明

该项目是基于MyBatis-Generator+SQLite+beautyeye_lnf+freemarker开发的一款图形化代码生成器，有三种生成模式:

1.MyBatis-Generator(自定义)

2.MyBatis-Plus代码生成器

3.FreeMarker模板自定义代码生成

#界面

首页

![alt text](/images/1.png "首页")
![alt text](/images/2.png "首页")
![alt text](/images/3.png "首页")

#一、Swing主要容器

1.JFrame(一般操作的窗体)

2.JPanel（面板）

3.JDialog(模式窗体)(关闭时一般使用dispose选项)

4.JOptionPane（做提示）

	a:消息对话框（只有确定）

	b:确认对话框（有是否取消）

	c:输入对话框（有是否以及接收输入值）
   
   
#二、布局管理器

所属类包 			   布局管理器名称  		             说明

Java.awt        FlowLayout(流式布局)      组件按照加入的先后顺序按照设置的对齐方式从左向右排列，一行排满到下一行开始继续排列
                BorderLayout(边界布局)    容器划分为东、西、南、北、中五个区域，每个区域只能放置一个组件。
			    GridLayout(网格布局)      容器的空间划分成M×N列的网格区域, 每个区域只能放置一个组件。
			    CardLayout(卡片布局)      如同一叠牌，每个牌对应一个组件，但每次只能显示其中的一张牌。适用于在一个空间中防止多个组件的情况
			    GridBagLayout(网格包布局)  GridLayout的升级版，组件仍然是按照行、列放置，但是每个组件可以占据多个网格
			    
Java.swing      BoxLayout(箱式布局)		 允许在容器中纵向或者横向防止多个控件
			          空布局				            不使用布局管理器，按照控件自身提供的大小、位置信息放置控件	    
			 			    
#三、容器的默认布局管理器

		   容器			     默认布局方式

顶层容器   JFrame     BorderLayout(边界布局)
	      JDialog    BorderLayout(边界布局)
	      JApplet    FlowLayout(流式布局)
中间容器   JPanel     FlowLayout（流式布局）