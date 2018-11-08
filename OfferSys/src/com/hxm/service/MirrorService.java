package com.hxm.service;

import com.hxm.domain.MirrorDetail;
import com.hxm.pageList.Page;

public interface MirrorService {
	public void saveMirrorDetail(MirrorDetail mirrorDetail);
	
	public void del(String id);
	
	public void modifyMirrorDetail(MirrorDetail mirrorDetail, String id);
	
	public void delAll(String[] idArr);
	
	public MirrorDetail getMirrorDetail(String id);
	
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
