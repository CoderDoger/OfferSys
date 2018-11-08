package com.hxm.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import com.hxm.domain.GpsDetail;
import com.hxm.domain.PndDetail;
import com.hxm.util.DBCPUtil;

public class PndDaoImpl implements PndDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Override
	public List<PndDetail> getPndDetails() {
		List<PndDetail> list = null;
		String sql = "select * from pndDetail";
		try {
			list = qr.query(sql, new BeanListHandler(PndDetail.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void del(String id) {
		String sql = "delete from pndDetail where id=?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delAll(String[] idArr) {
		String sql = "delete from pndDetail where id=?";
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
	public void updateImg(String fileName, String id) {
		// TODO Auto-generated method stub

	}
	@Override
	public void savaPndDetail(PndDetail pndDetail) {
		String sql = "insert into pndDetail(imageId,productType,model,os,cpu,lcd,tp,ram,rom,dvr,frontCamera,"
		+ "realCamera,card,multimedia,tools,gps,bluetooth,wifi,avin,fmt,tv,band,gsensor,speaker,mic,usb,charger,battery,language,"
		+ "operatingTemperature,storageTemperature,weight,dimension)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql,pndDetail.getImageId(),pndDetail.getProductType(),pndDetail.getModel(),pndDetail.getOs(),
				pndDetail.getCpu(),pndDetail.getLcd(),pndDetail.getTp(),pndDetail.getRam(),pndDetail.getRom(),
				pndDetail.getDvr(),pndDetail.getFrontCamera(),pndDetail.getRealCamera(),pndDetail.getCard(),pndDetail.getMultimedia(),pndDetail.getTools(),
				pndDetail.getGps(),pndDetail.getBluetooth(),pndDetail.getWifi(),pndDetail.getAvin(),pndDetail.getFmt(),pndDetail.getTv(),
				pndDetail.getBand(),pndDetail.getGsensor(),pndDetail.getSpeaker(),
				pndDetail.getMic(),pndDetail.getUsb(),pndDetail.getCharger(),pndDetail.getBattery(),pndDetail.getLanguage(),
				pndDetail.getOperatingTemperature(),pndDetail.getStorageTemperature(),pndDetail.getWeight(),pndDetail.getDimension());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyPndDetail(PndDetail pndDetail, String id) {
		String sql = "update pndDetail set imageId=?,productType=?,model=?,os=?,cpu=?,lcd=?,tp=?,ram=?,rom=?,dvr=?,frontCamera=?,"
		+ "realCamera=?,card=?,multimedia=?,tools=?,gps=?,bluetooth=?,wifi=?,avin=?,fmt=?,tv=?,band=?,gsensor=?,speaker=?,mic=?,usb=?,charger=?,battery=?,language=?,"
		+ "operatingTemperature=?,storageTemperature=?,weight=?,dimension=?, htmlStatic=0 where id=?";
		try {
			qr.update(sql,pndDetail.getImageId(),pndDetail.getProductType(),pndDetail.getModel(),pndDetail.getOs(),
					pndDetail.getCpu(),pndDetail.getLcd(),pndDetail.getTp(),pndDetail.getRam(),pndDetail.getRom(),
					pndDetail.getDvr(),pndDetail.getFrontCamera(),pndDetail.getRealCamera(),pndDetail.getCard(),pndDetail.getMultimedia(),pndDetail.getTools(),
					pndDetail.getGps(),pndDetail.getBluetooth(),pndDetail.getWifi(),pndDetail.getAvin(),pndDetail.getFmt(),pndDetail.getTv(),
					pndDetail.getBand(),pndDetail.getGsensor(),pndDetail.getSpeaker(),
					pndDetail.getMic(),pndDetail.getUsb(),pndDetail.getCharger(),pndDetail.getBattery(),pndDetail.getLanguage(),
					pndDetail.getOperatingTemperature(),pndDetail.getStorageTemperature(),pndDetail.getWeight(),pndDetail.getDimension(),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	@Override
	public PndDetail getPndDetail(String id) {
		PndDetail detail = null;
		String sql = "select * from pndDetail where id=?";
		try {
			detail = qr.query(sql, new BeanHandler(PndDetail.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detail;
	}
	@Override
	public int getTotalRecords() {
		int totalRecords=0;
		String sql = "select count(*) from pndDetail";
		try {
			 Object obj = qr.query(sql, new ScalarHandler(1));
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
	public int getTotalRecordsByKeyWord(String keyWord) {
		int totalRecords=0;
		String sql = "select count(*) from PndDetail where concat_ws('',imageId,productType,model,os,cpu,lcd,tp,ram,rom,dvr,frontCamera,realCamera,"
		+ "card,multimedia,tools,bluetooth,fmt,avin,tv,speaker,mic,usb,charger,battery,language,"
		+ "operatingTemperature,storageTemperature,weight,dimension) like '%"+keyWord+"%'";
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
	public List<PndDetail> getPageRecords(int startIndex, int pageSize) {
		List<PndDetail> list = null;
		String sql = "select * from pndDetail limit ? , ? ";
		try {
			list = qr.query(sql, new BeanListHandler(PndDetail.class), startIndex,pageSize);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}
	@Override
	public List<PndDetail> getPageRecordsByKeyWord(int startIndex,
			int pageSize, String keyWord) {
		List<PndDetail> list = null;
		String sql = "select * from pndDetail where concat_ws('',imageId,productType,model,os,cpu,lcd,tp,ram,rom,dvr,frontCamera,realCamera,"
		+ "card,multimedia,tools,bluetooth,fmt,avin,tv,speaker,mic,usb,charger,battery,language,"
		+ "operatingTemperature,storageTemperature,weight,dimension) like '%"+keyWord+"%' limit ? , ? ";	
		try {
			list = qr.query(sql, new BeanListHandler(PndDetail.class),startIndex,pageSize);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}
	@Override
	public void htmlStatic(String id) {
		String sql = "update pndDetail set htmlStatic=1 where id =?";
		try {
			qr.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
