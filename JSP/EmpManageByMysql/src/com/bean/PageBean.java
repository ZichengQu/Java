package com.bean;

public class PageBean {
	private int pageIndex;//ҳ����
	private int pageSize;//ҳ��С
	private int totalPages;//��ҳ��
	private int prev;//��һҳ
	private int next;//��һҳ
	
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
