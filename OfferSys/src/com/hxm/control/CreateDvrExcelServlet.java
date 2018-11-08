package com.hxm.control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URLEncoder;

import javax.imageio.ImageIO;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;

import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;


import com.hxm.domain.DvrDetail;
import com.hxm.service.DvrService;
import com.hxm.service.DvrServiceImpl;
import com.hxm.util.EXCELTool;


public class CreateDvrExcelServlet extends HttpServlet {
	private DvrService offerService = new DvrServiceImpl();
	private HSSFWorkbook hwb;
	private HSSFRow row;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		DvrDetail dvrDetail = offerService.getDvrDetail(id);
		
		//
		//判断Excel文件是否存，如果存在 不创建，不存在创建
		String fileName = dvrDetail.getModel()+".xls";
		String filePath = getServletContext().getRealPath("/excel/DVR/"+fileName);
		/*File file = new File(filePath);
		if(file.exists()){
			//下载
			downLoad(fileName, request, response);
			return ;
		}
*/
		
		hwb = new HSSFWorkbook();
		//create sheet
		HSSFSheet sheet = hwb.createSheet(dvrDetail.getModel());
		
		//set column width (一个字符的大小为 1/256)
		sheet.setColumnWidth(0, 22 * 256);
		sheet.setColumnWidth(1, 40 * 256);
		sheet.setColumnWidth(2, 120 * 256);
		//生成一个样式
		HSSFCellStyle border = EXCELTool.getBorder(hwb);
		HSSFCellStyle center = EXCELTool.getCenterStyle(hwb);
		center.setFont(EXCELTool.getFont(hwb));


		//style.setAlignment(HorizontalAlignment.CENTER); // 居中   
		
		//创建第1行（也可以成为表头）
		row = sheet.createRow(sheet.getLastRowNum());
		
		//设置行高
		//heightInPoints 设置的值永远是height属性值的20倍  
		row.setHeightInPoints(2*20);
		Cell cell = EXCELTool.getCell(row, 0, "DVR Product Specification", border);
		cell.setCellStyle(center);
		cell = EXCELTool.getCell(row, 1, "", border);
		cell = EXCELTool.getCell(row, 2, "", border);
		
		/* 
        * 设定合并单元格区域范围 
        *  firstRow  0-based 
        *  lastRow   0-based 
        *  firstCol  0-based 
        *  lastCol   0-based 
        */  
		 CellRangeAddress tabTitle = new CellRangeAddress(0, 0, 0, 2);
		 sheet.addMergedRegion(tabTitle);
		 
		 
		 //Product Type
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Product Type", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getProductType(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 
		 
		 //第4行Model
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Model", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getModel(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //第5行CPU
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "CPU", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getCpu(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //第6行LCD
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "LCD", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getLcd(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //第7行
		 //cell = EXCELTool.getCell(row, 1, dvrDetail.getFrontCamera(), border);
		 String frontCam = dvrDetail.getFrontCamera();
		 String[] frontCameraArr = frontCam.split(";");
		 /* 
	        * 设定合并单元格区域范围 
	        *  firstRow  0-based 
	        *  lastRow   0-based 
	        *  firstCol  0-based 
	        *  lastCol   0-based 
	        */  
		// CellRangeAddress tabTitle = new CellRangeAddress(0, 0, 0, 1);
		 //sheet.addMergedRegion(tabTitle);
		 
		 int startRowFontCam = sheet.getLastRowNum()+1;
		 for(int i=0;i<frontCameraArr.length;i++){
			if(i==0){
				row =  sheet.createRow(startRowFontCam);
				cell = EXCELTool.getCell(row, 0, "Front Camera", border);
				cell = EXCELTool.getCell(row, 1, frontCameraArr[i], border);
				cell = EXCELTool.getCell(row, 2, "", border);	
			}else{
				row =  sheet.createRow(startRowFontCam+i);
				cell = EXCELTool.getCell(row, 0, "", border);
				cell = EXCELTool.getCell(row, 1, frontCameraArr[i], border);
				cell = EXCELTool.getCell(row, 2, "", border);
			}	
		 }
		 //合并
		 if(frontCameraArr.length>1){
			 CellRangeAddress tabFrontCam = new CellRangeAddress(startRowFontCam, startRowFontCam+frontCameraArr.length-1, 0, 0);
			 sheet.addMergedRegion(tabFrontCam);
		 }
		 
		 //Video Format
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Video Format", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getVideoFormat(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 
		 //Frame Rate
		 String frameRate = dvrDetail.getFrameRate();
		 String[] frameRateArr = frameRate.split(";");
		 int startRow = sheet.getLastRowNum()+1;
		 for(int k=0;k<frameRateArr.length;k++){
			if(k==0){
				row =  sheet.createRow(startRow);
				cell = EXCELTool.getCell(row, 0, "Frame Rate", border);
				cell = EXCELTool.getCell(row, 1, frameRateArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);
				
			}else{
				row =  sheet.createRow(sheet.getLastRowNum()+1);
				cell = EXCELTool.getCell(row, 0, "", border);
				cell = EXCELTool.getCell(row, 1, frameRateArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);
			}	
		 }
		//合并
		 if(frameRateArr.length>1){
			 CellRangeAddress tabframeRate = new CellRangeAddress(startRow, startRow+frameRateArr.length-1, 0, 0);
			 sheet.addMergedRegion(tabframeRate);
		 }
		 
		 //Photo Resolution
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Photo Resolution", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getPhotoResolution(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //Photo Format
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Photo Format", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getPhotoFormat(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //Storage Card
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Storage Card", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getStorageCard(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //Rear Camera
		 String realCam = dvrDetail.getRearCamera();
		 String[] realCamArr = realCam.split(";");
		 int startRealCamRow = sheet.getLastRowNum()+1;
		 for(int k=0;k<realCamArr.length;k++){
			if(k==0){
				row =  sheet.createRow(startRealCamRow);
				cell = EXCELTool.getCell(row, 0, "Rear Camera", border);
				cell = EXCELTool.getCell(row, 1, realCamArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);	
			}else{
				row =  sheet.createRow(sheet.getLastRowNum()+1);
				cell = EXCELTool.getCell(row, 0, "", border);
				cell = EXCELTool.getCell(row, 1, realCamArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);
			}	
		 }
		//合并
		 if(realCamArr.length>1){
			 CellRangeAddress tabRealCam = new CellRangeAddress(startRealCamRow, startRealCamRow+realCamArr.length-1, 0, 0);
			 sheet.addMergedRegion(tabRealCam);
		 }
		 
		 
		 //G-sensor
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "G-sensor", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getGsensor(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //GPS
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "GPS", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getGps(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //WIFI
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "WIFI", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getWifi(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //TV-OUT
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "TV-OUT", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getTvout(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //HDMI
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "HDMI", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getHdmi(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //WDR
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "WDR", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getWdr(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//ADAS
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "ADAS", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getAdas(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//USB
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "USB", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getUsb(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Power Source
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Power Source", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getPowerSource(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Battery
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Battery", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getBatter(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//MIC
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "MIC", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getMic(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Speaker
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Speaker", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getSpeaker(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Language
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Language", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getLanguage(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Operating Temperature
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Operating Temperature", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getOperatingTemperature(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Storage Temperature
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Storage Temperature", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getStorageTemperature(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Weight
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Weight", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getWeight(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Dimension
		 row =  sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Dimension", border);
		 cell = EXCELTool.getCell(row, 1, dvrDetail.getDimension(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 
		 //合并，填充ID图
		 /* 
        * 设定合并单元格区域范围 
        *  firstRow  0-based 
        *  lastRow   0-based 
        *  firstCol  0-based 
        *  lastCol   0-based 
        *  
        * CellRangeAddress tabId = new CellRangeAddress(1, sheet.getLastRowNum(), 2, 2);
		 sheet.addMergedRegion(tabId);
        */  
		//插入ID图
		String imgRealPath = getServletContext().getRealPath("/uploadFile/")+dvrDetail.getImageId();
		insertImg(hwb, sheet, imgRealPath);
		//insertImg(hwb, imgRealPath,2, 1);
		 
		 //输出Excel
		OutputStream out = new FileOutputStream(filePath);  
        hwb.write(out);  
        out.close();
        
     /* //等待3s
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //下载
		downLoad(fileName, request, response);*/
        
      //提示
		String msg = "<script>alert('Excel文件已生成！');history.back();</script>";
		response.getWriter().write(msg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	//download
	public void downLoad(String fileName,HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		/*****************************************************************************************************/
		String file= new String(fileName.getBytes("iso8859-1"),"utf-8");
		/****************************************************************************************************/
		//System.out.println(fileName);
		response.setHeader("Content-Disposition",  "attachment;fileName="+URLEncoder.encode(file,"UTF-8"));
	    response.setHeader("Content-Type",  "application/octet-Stream");
	    InputStream  is  =  getServletContext().getResourceAsStream("/excel/"+file);
	    OutputStream  os  =  response.getOutputStream();
	    int  len  =  -1;
	    byte[]  buf  =  new  byte[1024];
	    while((len=is.read(buf))!=  -1){
	       os.write(buf,  0,  len);
	    }
	    is.close();
	    os.close();
	}
	public void insertImg(HSSFWorkbook hwb,String imgRealPath,int colPosition,int rowPosition){
		 InputStream is;
		 try {
				is = new FileInputStream(imgRealPath);
				byte[] bytes = IOUtils.toByteArray(is);
				int pictureIdx = hwb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);  
				CreationHelper helper = hwb.getCreationHelper();  
				Drawing drawing = hwb.getSheetAt(0).createDrawingPatriarch();  
				ClientAnchor anchor = helper.createClientAnchor();  
				// 图片插入坐标  
				anchor.setCol1(colPosition);  
				anchor.setRow1(rowPosition);  
				anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
				// 插入图片  
				Picture pict = drawing.createPicture(anchor, pictureIdx);
				//调整图片大小
				pict.resize(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	public void insertImg(HSSFWorkbook hwb2,Sheet sheet,String imgRealPath ){
		 InputStream is;
		 try {
			 ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();  
			 BufferedImage bufferImg = ImageIO.read(new File(imgRealPath));  
			 ImageIO.write(bufferImg, "jpg", byteArrayOut);  
			   
			 HSSFPatriarch patriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();  
			 HSSFClientAnchor anchor = new HSSFClientAnchor(2, 2, 2, 2, (short) 2, 1, (short) 3, sheet.getLastRowNum()+1);  
			//插入图片   
			 patriarch.createPicture(anchor, hwb2.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));       
	        /** 
	            dx1 - the x coordinate within the first cell.//定义了图片在第一个cell内的偏移x坐标，既左上角所在cell的偏移x坐标，一般可设0 
	            dy1 - the y coordinate within the first cell.//定义了图片在第一个cell的偏移y坐标，既左上角所在cell的偏移y坐标，一般可设0 
	            dx2 - the x coordinate within the second cell.//定义了图片在第二个cell的偏移x坐标，既右下角所在cell的偏移x坐标，一般可设0 
	            dy2 - the y coordinate within the second cell.//定义了图片在第二个cell的偏移y坐标，既右下角所在cell的偏移y坐标，一般可设0 
	            col1 - the column (0 based) of the first cell.//第一个cell所在列，既图片左上角所在列 
	            row1 - the row (0 based) of the first cell.//图片左上角所在行 
	            col2 - the column (0 based) of the second cell.//图片右下角所在列 
	            row2 - the row (0 based) of the second cell.//图片右下角所在行 
	         */  
		       
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	}
}
