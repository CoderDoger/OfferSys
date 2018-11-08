package com.hxm.service;

import java.util.List;

import com.hxm.dao.GpsDao;
import com.hxm.dao.GpsDaoImpl;
import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;
import com.hxm.pageList.Page;

public class GpsServiceImpl implements GpsService{
	GpsDao gpsDao = new GpsDaoImpl();
	@Override
	public void saveGpsDetail(GpsDetail gpsDetail) {
		gpsDao.savaGpsDetail(gpsDetail);
	}
	@Override
	public void del(String id) {
		gpsDao.del(id);
		
	}
	@Override
	public void modifyGpsDetail(GpsDetail gpsDetail, String id) {
		gpsDao.modifyGpsDetail(gpsDetail, id);	
	}
	@Override
	public void delAll(String[] idArr) {
		gpsDao.delAll(idArr);	
	}
	@Override
	public GpsDetail getGpsDetail(String id) {
		return gpsDao.getGpsDetail(id);
	}
	@Override
	public void htmlStatic(String id) {
		gpsDao.htmlStatic(id);	
	}
	@Override
	public Page getPageRecords(String currentPageNum) {
		//初始页码为1
		int currentPageNums = 1;
		if(null!=currentPageNum &&!"".equals(currentPageNum.trim())){
			try{
				currentPageNums = Integer.parseInt(currentPageNum);
			}catch(Exception e){
				throw new RuntimeException("Sb,页码必须是整数！");
			}
		}
		//取得总的记录数
		int totalRecords = gpsDao.getTotalRecords();
		System.out.println("条数="+totalRecords);
		//创建page对象
		//Page page = new Page(currentPageNums,totalRecords);
		Page page = new Page(currentPageNums,totalRecords,Page.NumCursor,5);
		//查询当前页的记录数,并封装进page
		List<GpsDetail> list = gpsDao.getPageRecords(page.getStartIndex(), page.getPageSize());
		//System.out.println("list="+list.size());
		page.setRecords(list);
		return page;
	}
	@Override
	public Page getPageRecordsByKeyWord(String currentPageNum, String keyWord) {
		//初始页码为1
		int currentPageNums = 1;
		if(null!=currentPageNum &&!"".equals(currentPageNum.trim())){
			try{
				currentPageNums = Integer.parseInt(currentPageNum);
			}catch(Exception e){
				throw new RuntimeException("Sb,页码必须是整数！");
			}
		}
		//取得总的记录数
		int totalRecords = gpsDao.getTotalRecordsByKeyWord(keyWord);
		//创建page对象
		//Page page = new Page(currentPageNums,totalRecords);
		Page page = new Page(currentPageNums,totalRecords,Page.NumCursor,5);
		//查询当前页的记录数,并封装进page
		List<GpsDetail> list = gpsDao.getPageRecordsByKeyWord(page.getStartIndex(), page.getPageSize(),keyWord);
		page.setRecords(list);
		return page;
	}
	
	
}
