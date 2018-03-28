package com.fendo.freemarker.entity;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

/**   
 * @Title: Page.java 
 * @Package com.fendo.bean 
 * @Description: TODO
 * @author fendo
 * @date 2017年12月2日 下午6:00:09 
 * @version V1.0   
*/
public class Page <T> extends HashMap{

    private int pageNo = 1;//页码，默认是第一页
    private int pageSize = 15;//每页显示的记录数，默认是15
    private int totalRecord;//总记录数
    private int totalPage;//总页数
    private T parameterType;//返回记录parameterType


    private Map<String, Object> params = new HashMap<String, Object>();//其他的参数我们把它分装成一个Map对象
    public Page() {

    }
    public Page(T t) {
        this.parameterType=t;

    }
    public int copyMapValue (T t){
        int result=0;
        Gson gn=new Gson();
        Map<String,Object> mp=gn.fromJson( gn.toJson(t),Map.class);
        if(mp!=null&mp.size()>0){
            for (Map.Entry<String, Object> entry : mp.entrySet()) {
                if(!StringUtils.isEmpty(entry.getKey())){
                    result++;
                    this.put(entry.getKey(),entry.getValue());
                }
            }
        }
       return  result;

    }
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
        int totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
        this.setTotalPage(totalPage);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public T getParameterType() {
        return parameterType;
    }

    public void setParameterType(T parameterType) {
        this.parameterType = parameterType;
        //参数格式化
        this.clear();
        this.put("pageNo",this.pageNo);
        this.put("pageSize",this.pageSize);
        this.put("totalRecord",this.totalRecord);
        this.put("totalPage",this.totalPage);
        this.put("parameterType",this.parameterType);

    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{pageNo:"+this.pageNo+",pageSize:"+this.pageSize+",totalRecord:"+this.totalRecord+",totalPage:"+this.totalPage+",parameterType:"+this.parameterType+"}");

        return builder.toString();
    }
}
