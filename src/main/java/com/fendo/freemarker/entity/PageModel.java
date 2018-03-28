package com.fendo.freemarker.entity;
/**   
 * @Title: PageModel.java 
 * @Package com.fendo.bean 
 * @Description: TODO
 * @author fendo
 * @date 2017年12月2日 下午6:05:06 
 * @version V1.0   
*/
public class PageModel {
	
    private int pageNo = 1;//页码，默认是第一页
    private int pageSize = 15;//每页显示的记录数，默认是15
    private int totalRecord;//总记录数
    private int totalPage;//总页数
    private Page page;

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
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

}
