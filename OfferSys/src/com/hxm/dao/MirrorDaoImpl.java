package com.hxm.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hxm.domain.MirrorDetail;
import com.hxm.util.DBCPUtil;

public class MirrorDaoImpl implements MirrorDao {
	
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Override
	public List<MirrorDetail> getMirrorDetails() {
		List<MirrorDetail> list = null;
		String sql = "select * from mirrorDetail";
		try {
			list = qr.query(sql, new BeanListHandler(MirrorDetail.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void del(String id) {
		String sql = "delete from mirrorDetail where id=?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delAll(String[] idArr) {
		String sql = "delete from mirrorDetail where id=?";
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
	public void savaMirrorDetail(MirrorDetail mirrorDetail) {
		String sql = "insert into mirrorDetail(imageId,productType,model,os,cpu,lcd,tp,ram,rom,dvr,frontCamera,"
		+ "realCamera,card,multimedia,tools,gps,bluetooth,wifi,avin,fmt,band,gsensor,speaker,mic,usb,charger,battery,language,"
		+ "operatingTemperature,storageTemperature,weight,dimension)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql,mirrorDetail.getImageId(),mirrorDetail.getProductType(),mirrorDetail.getModel(),mirrorDetail.getOs(),
				mirrorDetail.getCpu(),mirrorDetail.getLcd(),mirrorDetail.getTp(),mirrorDetail.getRam(),mirrorDetail.getRom(),
				mirrorDetail.getDvr(),mirrorDetail.getFrontCamera(),mirrorDetail.getRealCamera(),mirrorDetail.getCard(),mirrorDetail.getMultimedia(),mirrorDetail.getTools(),
				mirrorDetail.getGps(),mirrorDetail.getBluetooth(),mirrorDetail.getWifi(),mirrorDetail.getAvin(),mirrorDetail.getFmt(),
				mirrorDetail.getBand(),mirrorDetail.getGsensor(),mirrorDetail.getSpeaker(),
				mirrorDetail.getMic(),mirrorDetail.getUsb(),mirrorDetail.getCharger(),mirrorDetail.getBattery(),mirrorDetail.getLanguage(),
				mirrorDetail.getOperatingTemperature(),mirrorDetail.getStorageTemperature(),mirrorDetail.getWeight(),mirrorDetail.getDimension());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyMirrorDetail(MirrorDetail mirrorDetail, String id) {
		String sql = "update mirrorDetail set imageId=?,productType=?,model=?,os=?,cpu=?,lcd=?,tp=?,ram=?,rom=?,dvr=?,frontCamera=?,"
		+ "realCamera=?,card=?,multimedia=?,tools=?,gps=?,bluetooth=?,wifi=?,avin=?,fmt=?,band=?,gsensor=?,speaker=?,mic=?,usb=?,charger=?,battery=?,language=?,"
		+ "operatingTemperature=?,storageTemperature=?,weight=?,dimension=?, htmlStatic=0 where id=?";
		try {
			qr.update(sql,mirrorDetail.getImageId(),mirrorDetail.getProductType(),mirrorDetail.getModel(),mirrorDetail.getOs(),
					mirrorDetail.getCpu(),mirrorDetail.getLcd(),mirrorDetail.getTp(),mirrorDetail.getRam(),mirrorDetail.getRom(),
					mirrorDetail.getDvr(),mirrorDetail.getFrontCamera(),mirrorDetail.getRealCamera(),mirrorDetail.getCard(),mirrorDetail.getMultimedia(),mirrorDetail.getTools(),
					mirrorDetail.getGps(),mirrorDetail.getBluetooth(),mirrorDetail.getWifi(),mirrorDetail.getAvin(),mirrorDetail.getFmt(),
					mirrorDetail.getBand(),mirrorDetail.getGsensor(),mirrorDetail.getSpeaker(),
					mirrorDetail.getMic(),mirrorDetail.getUsb(),mirrorDetail.getCharger(),mirrorDetail.getBattery(),mirrorDetail.getLanguage(),
					mirrorDetail.getOperatingTemperature(),mirrorDetail.getStorageTemperature(),mirrorDetail.getWeight(),mirrorDetail.getDimension(),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	@Override
	public MirrorDetail getMirrorDetail(String id) {
		MirrorDetail detail = null;
		String sql = "select * from mirrorDetail where id=?";
		try {
			detail = qr.query(sql, new BeanHandler(MirrorDetail.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detail;
	}
	@Override
	public int getTotalRecords() {
		int totalRecords=0;
		String sql = "select count(*) from mirrorDetail";
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
		String sql = "select count(*) from MirrorDetail where concat_ws('',imageId,productType,model,os,cpu,lcd,tp,ram,rom,dvr,frontCamera,realCamera,"
		+ "card,multimedia,tools,bluetooth,fmt,avin,speaker,mic,usb,charger,battery,language,"
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
	public List<MirrorDetail> getPageRecords(int startIndex, int pageSize) {
		List<MirrorDetail> list = null;
		String sql = "select * from mirrorDetail limit ? , ? ";
		try {
			list = qr.query(sql, new BeanListHandler(MirrorDetail.class), startIndex,pageSize);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}
	@Override
	public List<MirrorDetail> getPageRecordsByKeyWord(int startIndex,
			int pageSize, String keyWord) {
		List<MirrorDetail> list = null;
		String sql = "select * from mirrorDetail where concat_ws('',imageId,productType,model,os,cpu,lcd,tp,ram,rom,dvr,frontCamera,realCamera,"
		+ "card,multimedia,tools,bluetooth,fmt,avin,speaker,mic,usb,charger,battery,language,"
		+ "operatingTemperature,storageTemperature,weight,dimension) like '%"+keyWord+"%' limit ? , ? ";	
		try {
			list = qr.query(sql, new BeanListHandler(MirrorDetail.class),startIndex,pageSize);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}
	@Override
	public void htmlStatic(String id) {
		String sql = "update mirrorDetail set htmlStatic=1 where id =?";
		try {
			qr.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
