package com.hxm.service;

import com.hxm.domain.GpsDetail;
import com.hxm.domain.PndDetail;
import com.hxm.pageList.Page;

public interface PndService {
	public void savePndDetail(PndDetail pndDetail);
	
	public void del(String id);
	
	public void modifyPndDetail(PndDetail PndDetail, String id);
	
	public void delAll(String[] idArr);
	
	public PndDetail getPndDetail(String id);
	
	public void htmlStatic(String id);

	public Page getPageRecords(String currentPageNum);

	/**
	 *@author hxm
	 * @param currentPageNum
	 * @param keyWord
	 * @return page 
	 * 关键字搜索
	 */
	public Page getPageRecordsByKeyWord(String currentPageNum, String keyWord);
}
