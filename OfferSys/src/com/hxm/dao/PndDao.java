package com.hxm.dao;

import java.util.List;

import com.hxm.domain.GpsDetail;
import com.hxm.domain.PndDetail;

public interface PndDao {
	public void savaPndDetail(PndDetail pndDetail);
	
	public void modifyPndDetail(PndDetail pndDetail,String id);
	
	public PndDetail getPndDetail(String id);
	
	public List<PndDetail> getPndDetails();
	
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
	public List<PndDetail> getPageRecords(int startIndex,int pageSize);
	
	public List<PndDetail> getPageRecordsByKeyWord(int startIndex, int pageSize,String keyWord);
	
	public void htmlStatic(String id);
}
