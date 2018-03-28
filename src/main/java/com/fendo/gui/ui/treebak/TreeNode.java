/**   
 * projectName: mybatis-generator-oracle   
 * fileName: TreeNode.java   
 * packageName: com.fendo.gui.ui   
 * date: 2018年2月27日上午10:34:36   
 * copyright(c) 2017-2020 fendo公司  
 */
package com.fendo.gui.ui.treebak;

import javax.swing.JFrame;

/**     
 * @title: TreeNode.java   
 * @package com.fendo.gui.ui   
 * @description: TreeNode  
 * @author: fendo  
 * @date: 2018年2月27日 上午10:34:36   
 * @version: V1.0     
*/
public class TreeNode {

    private String nickName = "";
    private String name = "";
    private String phone = "";
    private int age;
    private String imagePath = "";

    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // 重点在toString，节点的显示文本就是toString  
    public String toString()
    {
        return name + "["+nickName+"]";
    }
	
}
