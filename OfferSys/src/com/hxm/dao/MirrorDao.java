package com.hxm.dao;

import java.util.List;

import com.hxm.domain.MirrorDetail;

public interface MirrorDao {
	
	public void savaMirrorDetail(MirrorDetail mirrorDetail);
	
	public void modifyMirrorDetail(MirrorDetail mirrorDetail,String id);
	
	public MirrorDetail getMirrorDetail(String id);
	
	public List<MirrorDetail> getMirrorDetails();
	
	public void del(String id);
	
	public void delAll(String[] idArr);
	
	
	public void updateImg(String fileName,String id);
	
	/**
	 * @return int
	 * 返回dvrdetail 表中总的记录条数
	 */
	public int getTotalRecords();
	
	public int getTotalRecordsByKeyWord(String keyWord);
	
	/**
	 * @param startIndex 起始位置
	 * @param pageSize 偏移条数
	 * @return List<Customer>
	 */
	public List<MirrorDetail> getPageRecords(int startIndex,int pageSize);
	
	public List<MirrorDetail> getPageRecordsByKeyWord(int startIndex, int pageSize,String keyWord);
	
	public void htmlStatic(String id);
}
