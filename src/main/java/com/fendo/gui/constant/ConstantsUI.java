/**   
 * projectName: mybatis-generator-oracle   
 * fileName: ConstantsUI.java   
 * packageName: com.fendo.gui.constant   
 * date: 2018年2月27日上午11:36:52   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.constant;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import com.fendo.gui.start.Start_Beautyeye1;

/**     
 * @title: ConstantsUI.java   
 * @package com.fendo.gui.constant   
 * @description: UI相关的常量  
 * @author: fendo  
 * @date: 2018年2月27日 上午11:36:52   
 * @version: V1.0     
*/
public class ConstantsUI {

    /**
     * 软件名称,版本
     */
    public final static String APP_NAME = "mybatis-generator-tools";
    public final static String APP_VERSION = "v_1.0";
    
    
    /**
     * 主窗口大小
     */
    public final static int MAIN_WINDOW_X = 240;
    public final static int MAIN_WINDOW_Y = 100;
    public final static int MAIN_WINDOW_WIDTH = 885;
    public final static int MAIN_WINDOW_HEIGHT = 636;
    
    /**
     * 主窗口图标
     */
    public final static Image IMAGE_ICON = Toolkit.getDefaultToolkit()
            .getImage(ConstantsUI.class.getResource("/icon/database.png"));
    
    /**
     * 主图标
     */
    public final static ImageIcon ICON_DATA_SYNC = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/user.jpg"));
    
    
    /**
     * 工具栏图标
     */
    
    // 首页
    public final static ImageIcon ICON_HOME = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/home.png"));
    
    // 状态 默认
    public final static ImageIcon ICON_STATUS = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/status.png"));
    // 状态 激活
    public final static ImageIcon ICON_STATUS_ENABLE = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/statusEnable.png"));
    // 数据库 默认
    public final static ImageIcon ICON_DATABASE = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/database.png"));
    
    // 开发工具
    public final static ImageIcon ICON_DEVELOPMENT = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/development.png"));
    
    // 数据库 激活
    public final static ImageIcon ICON_DATABASE_ENABLE = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/databaseEnable.png"));
    // 执行计划 默认
    public final static ImageIcon ICON_SCHEDULE = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/schedule.png"));
    // 执行计划 激活
    public final static ImageIcon ICON_SCHEDULE_ENABLE = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/scheduleEnable.png"));
    // 设置 默认
    public final static ImageIcon ICON_SETTING = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/setting.png"));
    // 设置 激活
    public final static ImageIcon ICON_SETTING_ENABLE = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/settingEnable.png"));
    // 备份 默认
    public final static ImageIcon ICON_BACKUP = new ImageIcon(
    		ConstantsUI.class.getResource("/icon/backup.png"));
    // 备份 激活
    public final static ImageIcon ICON_BACKUP_ENABLE = new ImageIcon(
    		Start_Beautyeye1.class.getResource("/icon/backupEnable.png"));
    
}
