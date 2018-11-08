package com.hxm.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;

import com.hxm.domain.MirrorDetail;
import com.hxm.domain.PndDetail;
import com.hxm.service.MirrorService;
import com.hxm.service.MirrorServiceImpl;
import com.hxm.service.PndService;
import com.hxm.service.PndServiceImpl;
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

public class CreateMirrorPdfServlet extends HttpServlet {

private MirrorService offerService = new MirrorServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		MirrorDetail mirrorDetail = offerService.getMirrorDetail(id);
		//System.out.println(id);
		//mirrorDetail mirrorDetail = offerService.getmirrorDetail(id);
		//判断PDF文件是否存，如果存在 不创建，不存在创建
		String fileName = mirrorDetail.getModel()+".pdf";
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
			PDFTool.setFileProperties(document, "huang_xiaomeng@foxmail.com", "京华车品", mirrorDetail.getModel(), "Mirror规格书");
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
			String imageUrl = host + "/OfferSys/uploadFile"+mirrorDetail.getImageId();*/
			String imagePath = getServletContext().getRealPath("/uploadFile/"+mirrorDetail.getImageId());
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
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getProductType(), font));
			//MODEL
			table.addCell(PDFTool.getPDFCell("MODEL", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getModel(), font));
			//OS
			table.addCell(PDFTool.getPDFCell("OS", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getOs(), font));
			//CPU
			table.addCell(PDFTool.getPDFCell("CPU", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getCpu(), font));
			//LCD
			table.addCell(PDFTool.getPDFCell("LCD", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getLcd(), font));
			//TP
			table.addCell(PDFTool.getPDFCell("TP", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getTp(), font));
			//RAM
			table.addCell(PDFTool.getPDFCell("RAM", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getRam(), font));
			//FLASH ROM
			table.addCell(PDFTool.getPDFCell("FLASH ROM", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getRom(), font));
			//DVR
			table.addCell(PDFTool.getPDFCell("DVR", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getDvr(), font));
			//Front camera
			String frontCam = mirrorDetail.getFrontCamera();
			String[] frontCameraArr = frontCam.split(";");
			table.addCell(PDFTool.mergeRow("Front camera", font, frontCameraArr.length));
			for(String msg:frontCameraArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			
			//Real Camera
			String realCam = mirrorDetail.getRealCamera();
			String[] realCamArr = realCam.split(";");
			table.addCell(PDFTool.mergeRow("Real Camerad", font, realCamArr.length));
			for(String msg:realCamArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			
			//TF Card
			table.addCell(PDFTool.getPDFCell("TF Card", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getCard(), font));
			//Multimedia ==>Software Support
			String multiMedia = mirrorDetail.getMultimedia();
			String[] multiMediaArr = multiMedia.split(";");
			table.addCell(PDFTool.mergeRow("Software Feature", font, multiMediaArr.length));
			for(String msg:multiMediaArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			//Tools ==>屏蔽该信息显示
			/*table.addCell(PDFTool.getPDFCell("Tools", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getTools(), font));*/
			
			//GPS
			table.addCell(PDFTool.getPDFCell("GPS", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getGps(), font));
			//BT
			String blueTooth = mirrorDetail.getBluetooth();
			String[] blueToothArr = blueTooth.split(";");
			table.addCell(PDFTool.mergeRow("BT", font, blueToothArr.length));
			for(String msg:blueToothArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			//WIFI
			table.addCell(PDFTool.getPDFCell("WIFI", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getWifi(), font));
			//FMT
			table.addCell(PDFTool.getPDFCell("FM transmit", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getFmt(), font));
			//AVIN
			table.addCell(PDFTool.getPDFCell("AV IN", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getAvin(), font));
			
			//Band
			String band = mirrorDetail.getBand();
			String[] bandArr = band.split(";");
			table.addCell(PDFTool.mergeRow("Band", font, bandArr.length));
			for(String msg:bandArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			
			//Gsensor
			table.addCell(PDFTool.getPDFCell("Gsensor", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getGsensor(), font));
			//Speaker
			table.addCell(PDFTool.getPDFCell("Speaker", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getSpeaker(), font));
			//MIC
			table.addCell(PDFTool.getPDFCell("MIC", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getMic(), font));
			//USB
			table.addCell(PDFTool.getPDFCell("USB", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getUsb(), font));
			//Charger
			table.addCell(PDFTool.getPDFCell("Charger", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getCharger(), font));
			//Battery
			table.addCell(PDFTool.getPDFCell("Battery", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getBattery(), font));
			//Language
			table.addCell(PDFTool.getPDFCell("Language", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getLanguage(), font));
			//Operating temperature
			table.addCell(PDFTool.getPDFCell("Operating temperature", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getOperatingTemperature(), font));
			//Storage temperature
			table.addCell(PDFTool.getPDFCell("Storage temperature", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getStorageTemperature(), font));
			//weight
			table.addCell(PDFTool.getPDFCell("Weight", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getWeight(), font));
			//Dimension
			table.addCell(PDFTool.getPDFCell("Dimension", font));
			table.addCell(PDFTool.getPDFCell(mirrorDetail.getDimension(), font));
			
			document.add(table);
			document.close();
			
			//加水印
			String pdfFile = getServletContext().getRealPath("/pdf/Car Gps.pdf");
			String newPdfFile = getServletContext().getRealPath("/pdf/Mirror/"+fileName);
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
