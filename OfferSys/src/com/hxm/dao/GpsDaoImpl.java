package com.hxm.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;
import com.hxm.pageList.Page;
import com.hxm.util.DBCPUtil;

public class GpsDaoImpl implements GpsDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	/////////////////////GPS规格存取////////////////////////////////
	@Override
	public void savaGpsDetail(GpsDetail gpsDetail) {
		String sql = "insert into gpsdetail(imageId,productType,model,os,cpu,lcd,tp,ram,rom,dvr,camera,"
		+ "card,multimedia,tools,bluetooth,fmt,avin,tv,speaker,mic,usb,charger,battery,language,"
		+ "operatingTemperature,storageTemperature,weight,dimension)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql,gpsDetail.getImageId(),gpsDetail.getProductType(),gpsDetail.getModel(),gpsDetail.getOs(),
				gpsDetail.getCpu(),gpsDetail.getLcd(),gpsDetail.getTp(),gpsDetail.getRam(),gpsDetail.getRom(),
				gpsDetail.getDvr(),gpsDetail.getCamera(),gpsDetail.getCard(),gpsDetail.getMultimedia(),gpsDetail.getTools(),
				gpsDetail.getBluetooth(),gpsDetail.getFmt(),gpsDetail.getAvin(),gpsDetail.getTv(),gpsDetail.getSpeaker(),
				gpsDetail.getMic(),gpsDetail.getUsb(),gpsDetail.getCharger(),gpsDetail.getBattery(),gpsDetail.getLanguage(),
				gpsDetail.getOperatingTemperature(),gpsDetail.getStorageTemperature(),gpsDetail.getWeight(),gpsDetail.getDimension());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<GpsDetail> getGpsDetails() {
		List<GpsDetail> list = null;
		String sql = "select * from gpsdetail";
		try {
			list = qr.query(sql, new BeanListHandler(GpsDetail.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void modifyGpsDetail(GpsDetail gpsDetail, String id) {
		String sql = "update gpsdetail set imageId=?,productType=?,model=?,os=?,cpu=?,lcd=?,tp=?,ram=?,rom=?,dvr=?,camera=?,"
		+ "card=?,multimedia=?,tools=?,bluetooth=?,fmt=?,avin=?,tv=?,speaker=?,mic=?,usb=?,charger=?,battery=?,language=?,"
		+ "operatingTemperature=?,storageTemperature=?,weight=?,dimension=?,htmlStatic=0 where id=?";
		try {
			qr.update(sql,gpsDetail.getImageId(),gpsDetail.getProductType(),gpsDetail.getModel(),gpsDetail.getOs(),
					gpsDetail.getCpu(),gpsDetail.getLcd(),gpsDetail.getTp(),gpsDetail.getRam(),gpsDetail.getRom(),
					gpsDetail.getDvr(),gpsDetail.getCamera(),gpsDetail.getCard(),gpsDetail.getMultimedia(),gpsDetail.getTools(),
					gpsDetail.getBluetooth(),gpsDetail.getFmt(),gpsDetail.getAvin(),gpsDetail.getTv(),gpsDetail.getSpeaker(),
					gpsDetail.getMic(),gpsDetail.getUsb(),gpsDetail.getCharger(),gpsDetail.getBattery(),gpsDetail.getLanguage(),
					gpsDetail.getOperatingTemperature(),gpsDetail.getStorageTemperature(),gpsDetail.getWeight(),gpsDetail.getDimension(),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Override
	public GpsDetail getGpsDetail(String id) {
		GpsDetail detail = null;
		String sql = "select * from gpsdetail where id=?";
		try {
			detail = qr.query(sql, new BeanHandler(GpsDetail.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detail;
	}
	@Override
	public void del(String id) {
		String sql = "delete from gpsdetail where id=?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delAll(String[] idArr) {
		String sql = "delete from gpsdetail where id=?";
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
		String sql = "update gpsdetail set imageId=? where id=?";
		try {
			qr.update(sql, fileName,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int getTotalRecords() {
		int totalRecords=0;
		String sql = "select count(*) from gpsdetail";
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
		String sql = "select count(*) from gpsdetail where concat_ws('',imageId,productType,model,os,cpu,lcd,tp,ram,rom,dvr,camera,"
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
	public List<GpsDetail> getPageRecords(int startIndex, int pageSize) {
		List<GpsDetail> list = null;
		String sql = "select * from gpsdetail limit ? , ? ";
		
		try {
			list = qr.query(sql, new BeanListHandler(GpsDetail.class), startIndex,pageSize);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}
	@Override
	public List<GpsDetail> getPageRecordsByKeyWord(int startIndex,
			int pageSize, String keyWord) {
		List<GpsDetail> list = null;
		String sql = "select * from gpsdetail where concat_ws('',imageId,productType,model,os,cpu,lcd,tp,ram,rom,dvr,camera,"
		+ "card,multimedia,tools,bluetooth,fmt,avin,tv,speaker,mic,usb,charger,battery,language,"
		+ "operatingTemperature,storageTemperature,weight,dimension) like '%"+keyWord+"%' limit ? , ? ";
		
		try {
			list = qr.query(sql, new BeanListHandler(GpsDetail.class),startIndex,pageSize);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}
	@Override
	public void htmlStatic(String id) {
		String sql = "update gpsdetail set htmlStatic=1 where id =?";
		try {
			qr.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
