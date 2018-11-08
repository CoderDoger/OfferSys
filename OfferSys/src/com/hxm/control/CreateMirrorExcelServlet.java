package com.hxm.control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

import com.hxm.domain.MirrorDetail;
import com.hxm.domain.PndDetail;
import com.hxm.service.MirrorService;
import com.hxm.service.MirrorServiceImpl;
import com.hxm.service.PndService;
import com.hxm.service.PndServiceImpl;
import com.hxm.util.EXCELTool;

public class CreateMirrorExcelServlet extends HttpServlet {
	private MirrorService offerService = new MirrorServiceImpl();
	private HSSFWorkbook hwb;
	  
	private HSSFRow row;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		MirrorDetail mirrorDetail = offerService.getMirrorDetail(id);
		
		//file path
		String fileName = mirrorDetail.getModel()+".xls";
		String filePath = getServletContext().getRealPath("/excel/Mirror/"+fileName);
		
		hwb = new HSSFWorkbook();
		//create sheet
		HSSFSheet sheet = hwb.createSheet(mirrorDetail.getModel());
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
		HSSFCell cell = EXCELTool.getCell(row, 0, "Mirror Product Specification", border);
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
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getProductType(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 
		 
		 //Model
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Model", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getModel(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 
		 //OS
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "OS", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getOs(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 
		 //CPU
		/* row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "CPU", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getCpu(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);*/
		//CPU
		 String cpu = mirrorDetail.getCpu();
		 String[] cpuArr = cpu.split(";");
		 int startCpuRow = sheet.getLastRowNum()+1;
		 for(int k=0;k<cpuArr.length;k++){
			if(k==0){
				row = sheet.createRow(startCpuRow);
				 cell =  EXCELTool.getCell(row, 0, "CPU", border);
				 cell = EXCELTool.getCell(row, 1, cpuArr[k], border);
				 cell = EXCELTool.getCell(row, 2, "", border);
				
			}else{
				row = sheet.createRow(sheet.getLastRowNum()+1);
				cell = EXCELTool.getCell(row, 0, "", border);
				cell = EXCELTool.getCell(row, 1, cpuArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);
			}	
		 }
		 
		 
		 
		 
		 //LCD
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "LCD", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getLcd(), border);
		 cell = EXCELTool.getCell(row, 2, "", border); 
		 //TP
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "TP", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getTp(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //RAM
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "RAM", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getRam(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //FLASH ROM
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "FLASH ROM", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getRom(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //DVR
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "DVR", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getDvr(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
	
		//Front Camera
		 String frontCamera = mirrorDetail.getFrontCamera();
		 String[] frontCameraArr = frontCamera.split(";");
		 int startRow = sheet.getLastRowNum()+1;
		 for(int k=0;k<frontCameraArr.length;k++){
			if(k==0){
				row = sheet.createRow(startRow);
				 cell = EXCELTool.getCell(row, 0, "Front Camera", border);
				 cell = EXCELTool.getCell(row, 1, frontCameraArr[k], border);
				 cell = EXCELTool.getCell(row, 2, "", border);
				
			}else{
				row = sheet.createRow(sheet.getLastRowNum()+1);
				cell = EXCELTool.getCell(row, 0, "", border);
				cell = EXCELTool.getCell(row, 1, frontCameraArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);
			}	
		 }
		 //合并
		 if(frontCameraArr.length>1){
			 CellRangeAddress tabFrontCamera = new CellRangeAddress(startRow, startRow+frontCameraArr.length-1, 0, 0);
			 sheet.addMergedRegion(tabFrontCamera);
		 }
		 
		//Real Camera
		 String realCamera = mirrorDetail.getRealCamera();
		 String[] realCameraArr = realCamera.split(";");
		 int startRowRcam = sheet.getLastRowNum()+1;
		 for(int k=0;k<realCameraArr.length;k++){
			if(k==0){
				row = sheet.createRow(startRowRcam);
				cell = EXCELTool.getCell(row, 0, "Real Camera", border);
				cell = EXCELTool.getCell(row, 1, realCameraArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);
				
			}else{
				row = sheet.createRow(sheet.getLastRowNum()+1);
				cell = EXCELTool.getCell(row, 0, "", border);
				cell = EXCELTool.getCell(row, 1, realCameraArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);
			}	
		 }
		 //合并
		 if(realCameraArr.length>1){
			 CellRangeAddress tabRealCamer = new CellRangeAddress(startRowRcam, startRowRcam+realCameraArr.length-1, 0, 0);
			 sheet.addMergedRegion(tabRealCamer);
		 }
		 
		 
		 //TF Card
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "TF Card", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getCard(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //Multimedia ==> Software Feature
		 String Multimedia = mirrorDetail.getMultimedia();
		 String[] multiMediaArr = Multimedia.split(";");
		 int startRowMul = sheet.getLastRowNum()+1;
		 for(int k=0;k<multiMediaArr.length;k++){
			if(k==0){
				row = sheet.createRow(startRowMul);
				cell = EXCELTool.getCell(row, 0, "Software Feature", border);
				cell = EXCELTool.getCell(row, 1, multiMediaArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);
				
			}else{
				row = sheet.createRow(sheet.getLastRowNum()+1);
				cell = EXCELTool.getCell(row, 0, "", border);
				cell = EXCELTool.getCell(row, 1, multiMediaArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);
			}	
		 }
		 //合并
		 if(multiMediaArr.length>1){
			 CellRangeAddress tabMultimedia = new CellRangeAddress(startRowMul, startRowMul+multiMediaArr.length-1, 0, 0);
			 sheet.addMergedRegion(tabMultimedia);
		 }
		 
		 //Tools ===> 屏蔽该信息显示
		 /*row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Tools", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getTools(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);*/
		 
		//GPS
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "GPS", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getGps(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //BT
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "BT", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getBluetooth(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 /*String blueTooth = mirrorDetail.getBluetooth();
		 String[] blueToothArr = blueTooth.split(";");
		 startRow = sheet.getLastRowNum()+1;
		 for(int i=0;i<blueToothArr.length;i++){
			if(i==0){
				row = sheet.createRow(startRow);
				cell = EXCELTool.getCell(row, 0, "BT", border);
				cell = EXCELTool.getCell(row, 1, blueToothArr[i], border);
				cell = EXCELTool.getCell(row, 2, "", border);
				
			}else{
				row = sheet.createRow(sheet.getLastRowNum()+1);
				cell = EXCELTool.getCell(row, 0, "", border);
				cell = EXCELTool.getCell(row, 1, blueToothArr[i], border);
				cell = EXCELTool.getCell(row, 2, "", border);
			}	
		 }
		 //合并
		 CellRangeAddress tabBlueTooth = new CellRangeAddress(startRow, startRow+blueToothArr.length-1, 0, 0);
		 sheet.addMergedRegion(tabBlueTooth);*/
		 
		//WIFI
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "WIFI", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getWifi(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//FM transmit
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "FM transmit", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getFmt(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //AV IN
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "AV IN", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getAvin(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 
		//Band
		 String band = mirrorDetail.getBand();
		 String[] bandArr = band.split(";");
		 int startBandRow = sheet.getLastRowNum()+1;
		 for(int k=0;k<bandArr.length;k++){
			if(k==0){
				row = sheet.createRow(startBandRow);
				cell = EXCELTool.getCell(row, 0, "Band", border);
				cell = EXCELTool.getCell(row, 1, bandArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);
				
			}else{
				row = sheet.createRow(sheet.getLastRowNum()+1);
				cell = EXCELTool.getCell(row, 0, "", border);
				cell = EXCELTool.getCell(row, 1, bandArr[k], border);
				cell = EXCELTool.getCell(row, 2, "", border);
			}	
		 }
		 //合并
		 if(bandArr.length>1){
			 CellRangeAddress tabBand = new CellRangeAddress(startBandRow, startBandRow+bandArr.length-1, 0, 0);
			 sheet.addMergedRegion(tabBand);
		 }
		 
		 
		 //Gsensor
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Gsensor", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getGsensor(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		 //Speaker
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Speaker", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getSpeaker(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//MIC
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "MIC", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getMic(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//USB
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "USB", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getUsb(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Charger
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Charger", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getCharger(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Battery
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Battery", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getBattery(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Language
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Language", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getLanguage(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Operating Temperature
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Operating Temperature", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getOperatingTemperature(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Storage Temperature
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Storage Temperature", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getStorageTemperature(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Weight
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Weight", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getWeight(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
		//Dimension
		 row = sheet.createRow(sheet.getLastRowNum()+1);
		 cell = EXCELTool.getCell(row, 0, "Dimension", border);
		 cell = EXCELTool.getCell(row, 1, mirrorDetail.getDimension(), border);
		 cell = EXCELTool.getCell(row, 2, "", border);
	  
		//插入ID图
		 String imgRealPath = getServletContext().getRealPath("/uploadFile/")+mirrorDetail.getImageId();
		 insertImg(hwb, sheet, imgRealPath);
		 
		 //输出Excel
		OutputStream out = new FileOutputStream(filePath);  
        hwb.write(out);  
        out.close();
        
      //提示
		String msg = "<script>alert('Excel文件已生成！');history.back();</script>";
		response.getWriter().write(msg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
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
				// 插入图片  
				Picture pict = drawing.createPicture(anchor, pictureIdx);
				//调整图片大小
				pict.resize(1.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	public void insertImg(HSSFWorkbook wb,HSSFSheet sheet,String imgRealPath ){
		 InputStream is;
		 try {
			 ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();  
			 BufferedImage bufferImg = ImageIO.read(new File(imgRealPath));  
			 ImageIO.write(bufferImg, "jpg", byteArrayOut);  
			   
			 HSSFPatriarch patriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();  
			 HSSFClientAnchor anchor = new HSSFClientAnchor(2, 2, 2, 2, (short) 2, 1, (short) 3, sheet.getLastRowNum()+1);  
			//插入图片   
			 patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));       
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
