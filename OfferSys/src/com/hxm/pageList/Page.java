package com.hxm.pageList;

import java.util.List;

public class Page {
	private List records;//显示的分页记录
	private int pageSize = 50;//页面显示的记录条数
	private int currentPageNum;//当前页码
	private int totalPageNum;//总页数
	
	private int startIndex;//每页开始记录的索引
	private int totalRecordsNum;//总记录的条数
	
	
	private int proviousPageNum;//上一页页码
	private int nextPageNum;//下一页页码
	
	private int startPage;//页码：开始
	private int endPage;//页码：结束
	
	private String url;//查询记录的Servlet的url地址
	public static String NumCursor="numCursor";
	
	public Page(int currentPageNum, int totalRecords) {
		this.currentPageNum = currentPageNum;
		this.totalRecordsNum = totalRecords;
		//计算总页数
		totalPageNum = totalRecordsNum%pageSize == 0 ? totalRecordsNum/pageSize :totalRecordsNum/pageSize +1;
		//每页开始记录的索引
		startIndex = (currentPageNum-1)*pageSize;
	}
	public Page(int currentPageNum, int totalRecords,String model,int cursorSize) {
		//调用本类的构造方法
		this(currentPageNum,totalRecords);
		
		if(model.equals("numCursor")){
			//页码计算
			if(totalPageNum<=cursorSize){
				startPage = 1;
				endPage = totalPageNum;
			}else{
				//偏移位置 
				int offset = (int) (cursorSize%2==0 ? Math.floor((cursorSize+1)/2) : Math.floor(cursorSize/2));
				startPage = currentPageNum - offset;
				endPage = currentPageNum + offset;
				
				if(startPage<1){
					startPage = 1;
					endPage = startPage+ offset*2 ;
				}
				if(endPage>=totalPageNum){
					endPage = totalPageNum;
					startPage = totalPageNum-offset*2;
				}
			}
		}
	}


	public List getRecords() {
		return records;
	}


	public void setRecords(List records) {
		this.records = records;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getCurrentPageNum() {
		return currentPageNum;
	}


	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}


	public int getTotalPageNum() {
		return totalPageNum;
	}


	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}


	public int getStartIndex() {
		return startIndex;
	}


	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}


	public int getTotalRecordsNum() {
		return totalRecordsNum;
	}


	public void setTotalRecordsNum(int totalRecordsNum) {
		this.totalRecordsNum = totalRecordsNum;
	}


	public int getProviousPageNum() {
		return currentPageNum-1 > 0 ? currentPageNum-1:1;
	}


	public void setProviousPageNum(int proviousPageNum) {
		this.proviousPageNum = proviousPageNum;
	}


	public int getNextPageNum() {
		return currentPageNum+1<=totalPageNum ? currentPageNum+1 : currentPageNum;
	}


	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
