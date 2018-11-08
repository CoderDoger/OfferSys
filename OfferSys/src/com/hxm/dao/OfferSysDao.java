package com.hxm.dao;

import java.util.List;

import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;
import com.hxm.domain.UserInfo;

public interface OfferSysDao {

	/**
	 *@author hxm
	 * @param dvrDetail
	 */
	public void savaDvrDetail(DvrDetail dvrDetail);
	
	public void modifyDvrDetail(DvrDetail dvrDetail,String id);
	
	public DvrDetail getDvrDetail(String id);
	
	public DvrDetail getDvrDetailByModel(String model);
	
	public List<DvrDetail> getDvrDetails();
	
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
	public List<DvrDetail> getPageRecords(int startIndex,int pageSize);
	
	public List<DvrDetail> getPageRecordsByKeyWord(int startIndex, int pageSize,String keyWord);
	
	public void htmlStatic(String id);

	public UserInfo validation(String userName, String passWord);

}
