package com.hxm.service;

import java.util.List;

import com.hxm.dao.OfferSysDao;
import com.hxm.dao.OfferSysDaoImpl;
import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;
import com.hxm.domain.UserInfo;
import com.hxm.pageList.Page;

public class DvrServiceImpl implements DvrService {
	
	private OfferSysDao offerDao = new OfferSysDaoImpl();
	
	
	@Override
	public void modifyDvrDetail(DvrDetail dvrDetail, String id) {
		offerDao.modifyDvrDetail(dvrDetail, id);
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
		int totalRecords = offerDao.getTotalRecords();
		//创建page对象
		//Page page = new Page(currentPageNums,totalRecords);
		Page page = new Page(currentPageNums,totalRecords,Page.NumCursor,5);
		//查询当前页的记录数,并封装进page
		List<DvrDetail> list = offerDao.getPageRecords(page.getStartIndex(), page.getPageSize());
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
		int totalRecords = offerDao.getTotalRecordsByKeyWord(keyWord);
		//创建page对象
		//Page page = new Page(currentPageNums,totalRecords);
		Page page = new Page(currentPageNums,totalRecords,Page.NumCursor,5);
		//查询当前页的记录数,并封装进page
		List<DvrDetail> list = offerDao.getPageRecordsByKeyWord(page.getStartIndex(), page.getPageSize(),keyWord);
		page.setRecords(list);
		return page;
	}

	@Override
	public void del(String id) {	
		offerDao.del(id);
	}

	@Override
	public DvrDetail getDvrDetail(String id) {
		return offerDao.getDvrDetail(id);
	}

	@Override
	public void savaDvrDetail(DvrDetail dvrDetail) {
		offerDao.savaDvrDetail(dvrDetail);
		
	}

	@Override
	public void htmlStatic(String id) {
		offerDao.htmlStatic(id);
	}

	@Override
	public void delAll(String[] idArr) {
		offerDao.delAll(idArr);
	}

	@Override
	public UserInfo validation(String userName, String passWord) {
		//System.out.println("servic="+userName+"==="+passWord);
		return offerDao.validation(userName, passWord);	
	}
}
