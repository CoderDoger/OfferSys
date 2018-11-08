package com.hxm.service;

import java.util.List;

import com.hxm.dao.GpsDao;
import com.hxm.dao.GpsDaoImpl;
import com.hxm.dao.ManualDao;
import com.hxm.dao.ManualDaoImpl;
import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;
import com.hxm.domain.Manual;
import com.hxm.pageList.Page;

public class ManualServiceImpl implements ManualService{
	ManualDao manualDao = new ManualDaoImpl();

	@Override
	public void savaManual(Manual manual) {
		manualDao.savaManual(manual);
		
	}
	@Override
	public void modifyManual(Manual manual, String id) {
		manualDao.modifyManual(manual, id);
	}

	@Override
	public Manual getManual(String id,String type) {
		return manualDao.getManual(id,type);
	}
	
	
	@Override
	public void del(String id,String type) {
		
		manualDao.del(id,type);
	}
	
	@Override
	public void delAll(String[] idArr,String categroy) {
		manualDao.delAll(idArr,categroy);	
	}

	
	@Override
	public Page getPageRecords(String currentPageNum,String type) {
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
		int totalRecords = manualDao.getTotalRecords(type);
		System.out.println("条数="+totalRecords);
		//创建page对象
		//Page page = new Page(currentPageNums,totalRecords);
		Page page = new Page(currentPageNums,totalRecords,Page.NumCursor,5);
		//查询当前页的记录数,并封装进page
		List<Manual> list = manualDao.getPageRecords(page.getStartIndex(), page.getPageSize(),type);
		//System.out.println("list="+list.size());
		page.setRecords(list);
		return page;
	}
	@Override
	public Page getPageRecordsByKeyWord(String currentPageNum, String keyWord,String type) {
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
		int totalRecords = manualDao.getTotalRecordsByKeyWord(keyWord,type);
		//创建page对象
		//Page page = new Page(currentPageNums,totalRecords);
		Page page = new Page(currentPageNums,totalRecords,Page.NumCursor,5);
		//查询当前页的记录数,并封装进page
		List<Manual> list = manualDao.getPageRecordsByKeyWord(page.getStartIndex(), page.getPageSize(),keyWord,type);
		page.setRecords(list);
		return page;
	}


	
}
