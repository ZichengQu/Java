package com.bean;

public class PageBean {
	private int pageIndex;//页索引
	private int pageSize;//页大小
	private int totalPages;//总页数
	private int prev;//上一页
	private int next;//下一页
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPrev() {
		prev = pageIndex-1;
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		next = pageIndex+1;
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	
	
	
}
