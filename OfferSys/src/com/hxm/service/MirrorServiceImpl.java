package com.hxm.service;

import java.util.List;

import com.hxm.dao.MirrorDao;
import com.hxm.dao.MirrorDaoImpl;
import com.hxm.domain.MirrorDetail;
import com.hxm.pageList.Page;

public class MirrorServiceImpl implements MirrorService{
	private MirrorDao mirrorDao = new MirrorDaoImpl();
	@Override
	public void saveMirrorDetail(MirrorDetail MirrorDetail) {
		mirrorDao.savaMirrorDetail(MirrorDetail);
	}
	@Override
	public void del(String id) {
		mirrorDao.del(id);
		
	}
	@Override
	public void modifyMirrorDetail(MirrorDetail MirrorDetail, String id) {
		mirrorDao.modifyMirrorDetail(MirrorDetail, id);	
	}
	@Override
	public void delAll(String[] idArr) {
		mirrorDao.delAll(idArr);	
	}
	@Override
	public MirrorDetail getMirrorDetail(String id) {
		return mirrorDao.getMirrorDetail(id);
	}
	@Override
	public void htmlStatic(String id) {
		mirrorDao.htmlStatic(id);	
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
		int totalRecords = mirrorDao.getTotalRecords();
		System.out.println("条数="+totalRecords);
		//创建page对象
		//Page page = new Page(currentPageNums,totalRecords);
		Page page = new Page(currentPageNums,totalRecords,Page.NumCursor,5);
		//查询当前页的记录数,并封装进page
		List<MirrorDetail> list = mirrorDao.getPageRecords(page.getStartIndex(), page.getPageSize());
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
		int totalRecords = mirrorDao.getTotalRecordsByKeyWord(keyWord);
		//创建page对象
		//Page page = new Page(currentPageNums,totalRecords);
		Page page = new Page(currentPageNums,totalRecords,Page.NumCursor,5);
		//查询当前页的记录数,并封装进page
		List<MirrorDetail> list = mirrorDao.getPageRecordsByKeyWord(page.getStartIndex(), page.getPageSize(),keyWord);
		page.setRecords(list);
		return page;
	}
}
