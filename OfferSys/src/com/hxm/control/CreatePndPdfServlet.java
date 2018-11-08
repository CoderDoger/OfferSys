package com.hxm.control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

import com.hxm.domain.PndDetail;
import com.hxm.service.GpsService;
import com.hxm.service.GpsServiceImpl;
import com.hxm.service.PndService;
import com.hxm.service.PndServiceImpl;
import com.hxm.util.EXCELTool;
import com.hxm.util.PDFTool;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePndPdfServlet extends HttpServlet {
	private PndService offerService = new PndServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		PndDetail pndDetail = offerService.getPndDetail(id);
		//System.out.println(id);
		//pndDetail pndDetail = offerService.getpndDetail(id);
		//判断PDF文件是否存，如果存在 不创建，不存在创建
		String fileName = pndDetail.getModel()+".pdf";
		//File file = new File(getServletContext().getRealPath("/pdf/"+fileName));
		/*if(file.exists()){
			//下载
			downLoad(fileName, request, response);
			return ;
		}*/
		Document document = new Document();  
		//Step 2—Get a PdfWriter instance.  
		try {
			PdfWriter.getInstance(document, new FileOutputStream(getServletContext().getRealPath("/pdf/Car Gps.pdf")));
			document.open();
			//设置文件属性
			PDFTool.setFileProperties(document, "huang_xiaomeng@foxmail.com", "京华车品", pndDetail.getModel(), "PND规格书");
			//添加表格
			//创建PdfTable对象  
	        PdfPTable table=new PdfPTable(2);  
	          
	        //设置各列的列宽  
	        table.setTotalWidth(new float[]{180f,500f});  
	          
	        //创建BaseFont对象，指明字体，编码方式,是否嵌入  
	        BaseFont bf=BaseFont.createFont("C:\\Windows\\Fonts\\simkai.ttf", BaseFont.IDENTITY_H, false);  
	            //创建Font对象，将基础字体对象，字体大小，字体风格  
	        Font font=new Font(bf,10,Font.NORMAL); 
	        Font font1=new Font(bf,18,Font.BOLD);
	        // table title
	        table.addCell(PDFTool.mergeCol("PND Product Specification", font1, 2,Element.ALIGN_CENTER));
	        
	        //ID
	        table.addCell(PDFTool.getPDFCell("ID", font));
	        //添加图片
	        /* 
	        //"getServletContext().getRealPath("/uploadFile/")"
	        String ip = request.getLocalAddr();    //取得服务器IP     
	        int port = request.getLocalPort();    //取得服务器端口
	        //host
	        String host = "http://"+ ip + ":" + port;
			String imageUrl = host + "/OfferSys/uploadFile"+pndDetail.getImageId();*/
			String imagePath = getServletContext().getRealPath("/uploadFile/"+pndDetail.getImageId());
			//String imgUrl = URLEncoder.encode(imageUrl, "ISO8859-1");
			InputStream is = new FileInputStream(imagePath);
			byte[] bytes = IOUtils.toByteArray(is);
			Image image = Image.getInstance(bytes);
			image.scaleAbsolute(300,200);
			PdfPCell cell=new PdfPCell(image);
			cell.setBorderColor(new BaseColor(22, 150, 98));
			cell.setPadding(1);
			table.addCell(cell);
			//product type
			table.addCell(PDFTool.getPDFCell("product type", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getProductType(), font));
			//MODEL
			table.addCell(PDFTool.getPDFCell("MODEL", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getModel(), font));
			//OS
			table.addCell(PDFTool.getPDFCell("OS", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getOs(), font));
			//CPU
			table.addCell(PDFTool.getPDFCell("CPU", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getCpu(), font));
			//LCD
			table.addCell(PDFTool.getPDFCell("LCD", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getLcd(), font));
			//TP
			table.addCell(PDFTool.getPDFCell("TP", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getTp(), font));
			//RAM
			table.addCell(PDFTool.getPDFCell("RAM", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getRam(), font));
			//FLASH ROM
			table.addCell(PDFTool.getPDFCell("FLASH ROM", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getRom(), font));
			//DVR
			table.addCell(PDFTool.getPDFCell("DVR", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getDvr(), font));
			//Front camera
			String frontCam = pndDetail.getFrontCamera();
			String[] frontCameraArr = frontCam.split(";");
			table.addCell(PDFTool.mergeRow("Front camera", font, frontCameraArr.length));
			for(String msg:frontCameraArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			
			//Real Camera
			String realCam = pndDetail.getRealCamera();
			String[] realCamArr = realCam.split(";");
			table.addCell(PDFTool.mergeRow("Real Camerad", font, realCamArr.length));
			for(String msg:realCamArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			
			//TF Card
			table.addCell(PDFTool.getPDFCell("TF Card", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getCard(), font));
			//Multimedia
			String multiMedia = pndDetail.getMultimedia();
			String[] multiMediaArr = multiMedia.split(";");
			table.addCell(PDFTool.mergeRow("Software Feature", font, multiMediaArr.length));
			for(String msg:multiMediaArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			//Tools
			table.addCell(PDFTool.getPDFCell("Tools", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getTools(), font));
			//GPS
			table.addCell(PDFTool.getPDFCell("GPS", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getGps(), font));
			//BT
			String blueTooth = pndDetail.getBluetooth();
			String[] blueToothArr = blueTooth.split(";");
			table.addCell(PDFTool.mergeRow("BT", font, blueToothArr.length));
			for(String msg:blueToothArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			//WIFI
			table.addCell(PDFTool.getPDFCell("WIFI", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getWifi(), font));
			//FMT
			table.addCell(PDFTool.getPDFCell("FM transmit", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getFmt(), font));
			//AVIN
			table.addCell(PDFTool.getPDFCell("AV IN", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getAvin(), font));
			//Digital TV
			table.addCell(PDFTool.getPDFCell("Digital TV", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getTv(), font));
			//Band
			String band = pndDetail.getBand();
			String[] bandArr = band.split(";");
			table.addCell(PDFTool.mergeRow("Band", font, bandArr.length));
			for(String msg:bandArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			
			//Gsensor
			table.addCell(PDFTool.getPDFCell("Gsensor", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getGsensor(), font));
			//Speaker
			table.addCell(PDFTool.getPDFCell("Speaker", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getSpeaker(), font));
			//MIC
			table.addCell(PDFTool.getPDFCell("MIC", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getMic(), font));
			//USB
			table.addCell(PDFTool.getPDFCell("USB", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getUsb(), font));
			//Charger
			table.addCell(PDFTool.getPDFCell("Charger", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getCharger(), font));
			//Battery
			table.addCell(PDFTool.getPDFCell("Battery", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getBattery(), font));
			//Language
			table.addCell(PDFTool.getPDFCell("Language", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getLanguage(), font));
			//Operating temperature
			table.addCell(PDFTool.getPDFCell("Operating temperature", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getOperatingTemperature(), font));
			//Storage temperature
			table.addCell(PDFTool.getPDFCell("Storage temperature", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getStorageTemperature(), font));
			//weight
			table.addCell(PDFTool.getPDFCell("Weight", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getWeight(), font));
			//Dimension
			table.addCell(PDFTool.getPDFCell("Dimension", font));
			table.addCell(PDFTool.getPDFCell(pndDetail.getDimension(), font));
			
			document.add(table);
			document.close();
			
			//加水印
			String pdfFile = getServletContext().getRealPath("/pdf/Car Gps.pdf");
			String newPdfFile = getServletContext().getRealPath("/pdf/PND/"+fileName);
			try {
				PDFTool.waterMark(pdfFile, newPdfFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//提示
			String msg = "<script>alert('PDF文件已生成！');history.back();</script>";
			response.getWriter().write(msg);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
