package com.hxm.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;
import com.hxm.domain.Manual;
import com.hxm.pageList.Page;
import com.hxm.util.DBCPUtil;

public class ManualDaoImpl implements ManualDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	/////////////////////GPS规格存取////////////////////////////////
	@Override
	public void savaManual(Manual manual) {
		String sql = "insert into manual(objName,productName,fileName,fileSize,author)values(?,?,?,?,?)";
		try {
			qr.update(sql,manual.getObjName(),manual.getProductName(),manual.getFileName(),manual.getFileSize(),manual.getAuthor());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Manual> getManuals() {
		List<Manual> list = null;
		String sql = "select * from manual";
		try {
			list = qr.query(sql, new BeanListHandler(Manual.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void modifyManual(Manual manual, String id) {
		String sql = "update manual set objName=?,productName=?,fileName=?,fileSize=?,author=? where id=?";
		try {
			qr.update(sql,manual.getObjName(),manual.getProductName(),manual.getFileName(),manual.getFileSize(),manual.getAuthor(),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Override
	public Manual getManual(String id,String type) {
		Manual manual = null;
		String sql = "select * from manual where id=? and objName=?";
		try {
			manual = qr.query(sql, new BeanHandler<Manual>(Manual.class), id,type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manual;
	}
	@Override
	public void del(String id,String type) {
		String sql = "delete from manual where id=? and objName=?";
		try {
			qr.update(sql, id, type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delAll(String[] idArr,String categroy) {
		String sql = "delete from manual where id=? and objName='"+categroy+"'";
		Object[][] params = new Object[idArr.length][];//高维也就是行数确定执行sql语句的次数，低维也就是列数是给？赋值

		for (int i = 0; i < params.length; i++) {//循环行数,决定SQL语句执行的次数
			params[i] = new Object[]{idArr[i]};//给低维也就是列数“？”赋值，每行只给一列赋值，决定每条SQL语句的参数个数
		}
		try {
			qr.batch(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public int getTotalRecords(String type) {
		int totalRecords=0;
		String sql = "select count(*) from manual where objName=?";
		try {
			 Object obj = qr.query(sql, new ScalarHandler(1),type);
			 //System.out.println(obj.getClass().getName());
			 //重点 queryRunner 取总记录数的转换
			 totalRecords = ((Long)obj).intValue();
			 //System.out.println(totalRecords);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalRecords;
	}
	@Override
	public int getTotalRecordsByKeyWord(String keyWord,String type) {
		int totalRecords=0;
		String sql = "select count(*) from manual where concat_ws('',objName,fileName,author,productName) like '%"+keyWord+"%' and objName='"+type+"'";
		try {
			 Object obj = qr.query(sql,new ScalarHandler(1));
			 //System.out.println(obj.getClass().getName());
			 //重点 queryRunner 取总记录数的转换
			 totalRecords = ((Long)obj).intValue();
			 //System.out.println(totalRecords);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalRecords;
	}
	@Override
	public List<Manual> getPageRecords(int startIndex, int pageSize,String type) {
		List<Manual> list = null;
		String sql = "select * from manual where objName=? limit ? , ? ";
		
		try {
			list = qr.query(sql, new BeanListHandler(Manual.class), type,startIndex,pageSize);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}
	@Override
	public List<Manual> getPageRecordsByKeyWord(int startIndex,
			int pageSize, String keyWord,String type) {
		List<Manual> list = null;
		String sql = "select * from manual where concat_ws('',objName,fileName,productName,author) like '%"+keyWord+"%' and objName='"+type+"' limit ? , ? ";
		
		try {
			list = qr.query(sql, new BeanListHandler(Manual.class),startIndex,pageSize);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}
	
}
