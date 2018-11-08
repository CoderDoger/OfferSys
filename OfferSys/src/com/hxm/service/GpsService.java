package com.hxm.service;

import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;
import com.hxm.pageList.Page;

public interface GpsService {
	
	public void saveGpsDetail(GpsDetail gpsDetail);
	
	public void del(String id);
	
	public void modifyGpsDetail(GpsDetail gpsDetail, String id);
	
	public void delAll(String[] idArr);
	
	public GpsDetail getGpsDetail(String id);
	
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
