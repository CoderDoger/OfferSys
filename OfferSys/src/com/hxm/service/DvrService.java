package com.hxm.service;

import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;
import com.hxm.domain.UserInfo;
import com.hxm.pageList.Page;

public interface DvrService {
	
	public void modifyDvrDetail(DvrDetail dvrDetail, String id);
	
	public void del(String id);
	
	public void delAll(String[] idArr);
	
	public DvrDetail getDvrDetail(String id);
	
	public void savaDvrDetail(DvrDetail dvrDetail);
	
	public void htmlStatic(String id);
	
	public Page getPageRecords(String currentPageNum);

	public Page getPageRecordsByKeyWord(String currentPageNum, String keyWord);

	public UserInfo validation(String userName, String passWord);

}
