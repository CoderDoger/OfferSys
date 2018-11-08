package com.hxm.service;

import java.util.List;

import com.hxm.dao.PndDao;
import com.hxm.dao.PndDaoImpl;
import com.hxm.domain.PndDetail;
import com.hxm.pageList.Page;

public class PndServiceImpl implements PndService {
	PndDao PndDao = new PndDaoImpl();
	@Override
	public void savePndDetail(PndDetail PndDetail) {
		PndDao.savaPndDetail(PndDetail);
	}
	@Override
	public void del(String id) {
		PndDao.del(id);
		
	}
	@Override
	public void modifyPndDetail(PndDetail PndDetail, String id) {
		PndDao.modifyPndDetail(PndDetail, id);	
	}
	@Override
	public void delAll(String[] idArr) {
		PndDao.delAll(idArr);	
	}
	@Override
	public PndDetail getPndDetail(String id) {
		return PndDao.getPndDetail(id);
	}
	@Override
	public void htmlStatic(String id) {
		PndDao.htmlStatic(id);	
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
		int totalRecords = PndDao.getTotalRecords();
		System.out.println("条数="+totalRecords);
		//创建page对象
		//Page page = new Page(currentPageNums,totalRecords);
		Page page = new Page(currentPageNums,totalRecords,Page.NumCursor,5);
		//查询当前页的记录数,并封装进page
		List<PndDetail> list = PndDao.getPageRecords(page.getStartIndex(), page.getPageSize());
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
		int totalRecords = PndDao.getTotalRecordsByKeyWord(keyWord);
		//创建page对象
		//Page page = new Page(currentPageNums,totalRecords);
		Page page = new Page(currentPageNums,totalRecords,Page.NumCursor,5);
		//查询当前页的记录数,并封装进page
		List<PndDetail> list = PndDao.getPageRecordsByKeyWord(page.getStartIndex(), page.getPageSize(),keyWord);
		page.setRecords(list);
		return page;
	}
	
}
