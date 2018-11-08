package com.hxm.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.jboss.weld.bean.NewBean;

import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;
import com.hxm.domain.UserInfo;
import com.hxm.util.DBCPUtil;

public class OfferSysDaoImpl implements OfferSysDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Override
	public void savaDvrDetail(DvrDetail dvrDetail) {
		String sql = "insert into dvrdetail(imageId,productType,model,cpu,lcd,frontCamera,videoFormat,frameRate,photoResolution,"
				+ "photoFormat,storageCard,cardCapacity,rearCamera,gsensor,gps,wifi,tvout,hdmi,wdr,adas,usb,powerSource,"
				+ "batter,mic,speaker,language,operatingTemperature,storageTemperature,weight,dimension)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql,dvrDetail.getImageId(),dvrDetail.getProductType(),dvrDetail.getModel(),dvrDetail.getCpu(),
					dvrDetail.getLcd(),dvrDetail.getFrontCamera(),dvrDetail.getVideoFormat(),dvrDetail.getFrameRate(),
					dvrDetail.getPhotoResolution(),dvrDetail.getPhotoFormat(),dvrDetail.getStorageCard(),dvrDetail.getCardCapacity(),
					dvrDetail.getRearCamera(),dvrDetail.getGsensor(),dvrDetail.getGps(),dvrDetail.getWifi(),dvrDetail.getTvout(),
					dvrDetail.getHdmi(),dvrDetail.getWdr(),dvrDetail.getAdas(),dvrDetail.getUsb(),
					dvrDetail.getPowerSource(),dvrDetail.getBatter(),dvrDetail.getMic(),dvrDetail.getSpeaker(),
					dvrDetail.getLanguage(),dvrDetail.getOperatingTemperature(),dvrDetail.getStorageTemperature(),dvrDetail.getWeight(),
					dvrDetail.getDimension());
		
			//System.out.println("sql execute");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void modifyDvrDetail(DvrDetail dvrDetail, String id) {
		String sql = "update dvrdetail set imageId=?,productType=?,model=?,cpu=?,lcd=?,frontCamera=?,videoFormat=?,frameRate=?,photoResolution=?,"
				+ "photoFormat=?,storageCard=?,cardCapacity=?,rearCamera=?,gsensor=?,gps=?,wifi=?,tvout=?,hdmi=?,wdr=?,adas=?,usb=?,powerSource=?,"
				+ "batter=?,mic=?,speaker=?,language=?,operatingTemperature=?,storageTemperature=?,weight=?,dimension=?,htmlStatic=0 where id=?";
	
		try {
			qr.update(sql,dvrDetail.getImageId(),dvrDetail.getProductType(),dvrDetail.getModel(),dvrDetail.getCpu(),
					dvrDetail.getLcd(),dvrDetail.getFrontCamera(),dvrDetail.getVideoFormat(),dvrDetail.getFrameRate(),
					dvrDetail.getPhotoResolution(),dvrDetail.getPhotoFormat(),dvrDetail.getStorageCard(),dvrDetail.getCardCapacity(),
					dvrDetail.getRearCamera(),dvrDetail.getGsensor(),dvrDetail.getGps(),dvrDetail.getWifi(),dvrDetail.getTvout(),
					dvrDetail.getHdmi(),dvrDetail.getWdr(),dvrDetail.getAdas(),dvrDetail.getUsb(),
					dvrDetail.getPowerSource(),dvrDetail.getBatter(),dvrDetail.getMic(),dvrDetail.getSpeaker(),
					dvrDetail.getLanguage(),dvrDetail.getOperatingTemperature(),dvrDetail.getStorageTemperature(),dvrDetail.getWeight(),
					dvrDetail.getDimension(),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
	}
	@Override
	public DvrDetail getDvrDetail(String id) {
		DvrDetail detail = null;
		String sql = "select * from dvrdetail where id = ?";
		try {
			detail = qr.query(sql, new BeanHandler(DvrDetail.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detail;
	}

	@Override
	public List<DvrDetail> getDvrDetails() {
		List<DvrDetail> list = null;
		String sql = "select * from dvrdetail";
		try {
			list = qr.query(sql, new BeanListHandler(DvrDetail.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void del(String id) {
		String sql = "delete from dvrdetail where id=?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateImg(String fileName,String id) {
		String sql = "update dvrdetail set imageId=? where id=?";
		try {
			qr.update(sql, fileName,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getTotalRecords() {
			int totalRecords=0;
			String sql = "select count(*) from dvrdetail";
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
		String sql = "select count(*) from dvrdetail where concat_ws('',imageId,productType,model,cpu,lcd,frontCamera,videoFormat,frameRate,photoResolution,"
				+ "photoFormat,storageCard,cardCapacity,rearCamera,gsensor,gps,wifi,tvout,hdmi,wdr,adas,usb,powerSource,"
				+ "batter,mic,speaker,language,operatingTemperature,storageTemperature,weight,dimension) like '%"+keyWord+"%'";
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
	public List<DvrDetail> getPageRecords(int startIndex, int pageSize) {
			List<DvrDetail> list = null;
			String sql = "select * from dvrdetail order by model limit ? , ? ";
			
			try {
				list = qr.query(sql, new BeanListHandler(DvrDetail.class), startIndex,pageSize);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;	
	}
	
	@Override
	public List<DvrDetail> getPageRecordsByKeyWord(int startIndex, int pageSize,String keyWord) {
		List<DvrDetail> list = null;
		String sql = "select * from dvrdetail where concat_ws('',imageId,productType,model,cpu,lcd,frontCamera,videoFormat,frameRate,photoResolution,"
				+ "photoFormat,storageCard,cardCapacity,rearCamera,gsensor,gps,wifi,tvout,hdmi,wdr,adas,usb,powerSource,"
				+ "batter,mic,speaker,language,operatingTemperature,storageTemperature,weight,dimension) like '%"+keyWord+"%' order by model limit ? , ? ";
		
		try {
			list = qr.query(sql, new BeanListHandler(DvrDetail.class),startIndex,pageSize);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}

	@Override
	public void htmlStatic(String id) {
		String sql = "update dvrdetail set htmlStatic=1 where id =?";
	
		try {
			qr.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delAll(String[] idArr) {
		String sql = "delete from dvrdetail where id=?";
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
	public UserInfo validation(String userName, String passWord) {
		//System.out.println("dao=="+userName+"==="+passWord);
		UserInfo user = null;
		String sql = "select * from user where userName = ? and passWord = ?";
		//String sql = "select * from user";
		try {
			user = qr.query(sql, new BeanHandler<UserInfo>(UserInfo.class),userName,passWord);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public DvrDetail getDvrDetailByModel(String model) {
		DvrDetail detail = null;
		System.out.println("dao.model="+model);
		String sql = "select * from dvrdetail where model = ? limit 0,1";
		try {
			detail = qr.query(sql, new BeanHandler(DvrDetail.class), model);
			System.out.println(detail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detail;
	}
}
