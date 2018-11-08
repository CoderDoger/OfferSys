package com.hxm.service;


import com.hxm.domain.Manual;
import com.hxm.pageList.Page;

public interface ManualService {
	
	public void modifyManual(Manual manual, String id);
	
	public void del(String id,String categroy);
	
	public void delAll(String[] idArr,String categroy);
	
	public Manual getManual(String id,String type);
	
	public void savaManual(Manual manual);
	
	public Page getPageRecords(String currentPageNum,String type);

	public Page getPageRecordsByKeyWord(String currentPageNum, String keyWord,String type);

}
