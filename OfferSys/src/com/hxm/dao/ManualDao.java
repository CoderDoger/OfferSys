package com.hxm.dao;

import java.util.List;

import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;
import com.hxm.domain.Manual;

public interface ManualDao {
	
	public void savaManual(Manual manual);
	
	public void modifyManual(Manual manual,String id);
	
	public Manual getManual(String id,String type);
	
	public List<Manual> getManuals();
	
	public void del(String id,String type);
	
	public void delAll(String[] idArr,String categroy);
	
	
	//public void updateImg(String fileName,String id);
	
	/**
	 * @return int
	 * 返回dvrdetail 表中总的记录条数
	 */
	public int getTotalRecords(String type);
	
	public int getTotalRecordsByKeyWord(String keyWord,String type);
	
	/**
	 * @param startIndex 起始位置
	 * @param pageSize 偏移条数
	 * @return List<Customer>
	 */
	public List<Manual> getPageRecords(int startIndex,int pageSize,String type);
	
	public List<Manual> getPageRecordsByKeyWord(int startIndex, int pageSize,String keyWord,String type);

}
