package com.ctgu.utils;

import java.util.List;

/**
 * 封装分页的参数
 * @author chenjun
 *
 */
public class PageBean<T> {
	private int currentPage = 1; 	//当前页,默认第一页
	private int pageCount = 4;		//每页显示的行数
	private int totalCount; 		//总记录数
	private int totalPage; 			//总页数 = 总记录数 / 每页显示行数 (+1)
	private List<T> pageData;			//分页查询的数据
	
	public int getTotalPage() {
		if(totalCount % pageCount == 0){
			totalPage = totalCount / pageCount;
		}
		else{
			totalPage = totalCount / pageCount + 1;
		}
		return totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	
}
