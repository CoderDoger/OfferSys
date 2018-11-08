package com.hxm.dao;

import java.util.List;

import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;

public interface GpsDao {
	public void savaGpsDetail(GpsDetail dvrDetail);
	
	public void modifyGpsDetail(GpsDetail gpsDetail,String id);
	
	public GpsDetail getGpsDetail(String id);
	
	public List<GpsDetail> getGpsDetails();
	
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
	public List<GpsDetail> getPageRecords(int startIndex,int pageSize);
	
	public List<GpsDetail> getPageRecordsByKeyWord(int startIndex, int pageSize,String keyWord);
	
	public void htmlStatic(String id);
}
