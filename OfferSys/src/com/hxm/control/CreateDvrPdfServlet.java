package com.hxm.control;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;

import com.hxm.domain.DvrDetail;
import com.hxm.service.DvrService;
import com.hxm.service.DvrServiceImpl;
import com.hxm.util.PDFTool;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateDvrPdfServlet extends HttpServlet {
	private DvrService offerService = new DvrServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		DvrDetail dvrDetail = offerService.getDvrDetail(id);
		System.out.println(id);
		//DvrDetail dvrDetail = offerService.getDvrDetail(id);
		//判断PDF文件是否存，如果存在 不创建，不存在创建
		String fileName = dvrDetail.getModel()+".pdf";
		/*File file = new File(getServletContext().getRealPath("/pdf/"+fileName));
		if(file.exists()){
			//下载
			downLoad(fileName, request, response);
			return ;
		}*/
		Document document = new Document();  
		//Step 2—Get a PdfWriter instance.  
		try {
			PdfWriter.getInstance(document, new FileOutputStream(getServletContext().getRealPath("/pdf/Car Dvr.pdf")));
			document.open();
			//设置文件属性
			PDFTool.setFileProperties(document, "huang_xiaomeng@foxmail.com", "京华车品", dvrDetail.getModel(), "DVR规格书");
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
	        table.addCell(PDFTool.mergeCol("DVR Product Specification", font1, 2,Element.ALIGN_CENTER));
	        
	        //ID
	        table.addCell(PDFTool.getPDFCell("ID", font));
	        //添加图片
	        /* 
	        //"getServletContext().getRealPath("/uploadFile/")"
	        String ip = request.getLocalAddr();    //取得服务器IP     
	        int port = request.getLocalPort();    //取得服务器端口
	        //host
	        String host = "http://"+ ip + ":" + port;
			String imageUrl = host + "/OfferSys/uploadFile"+dvrDetail.getImageId();*/
			String imagePath = getServletContext().getRealPath("/uploadFile/"+dvrDetail.getImageId());
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
			table.addCell(PDFTool.getPDFCell(dvrDetail.getProductType(), font));
			//MODEL
			table.addCell(PDFTool.getPDFCell("MODEL", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getModel(), font));
			//CPU
			table.addCell(PDFTool.getPDFCell("CPU", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getCpu(), font));
			//LCD
			table.addCell(PDFTool.getPDFCell("LCD", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getLcd(), font));
			//Front camera
			String frontCam = dvrDetail.getFrontCamera();
			String[] frontCameraArr = frontCam.split(";");
   			
			table.addCell(PDFTool.mergeRow("Front camera", font, frontCameraArr.length));
			for(String msg:frontCameraArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			
			//Video Format
			table.addCell(PDFTool.getPDFCell("Video Format", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getVideoFormat(), font));
			
			//Frame Rate
			String frameRate = dvrDetail.getFrameRate();
			String[] frameRateArr = frameRate.split(";");
			table.addCell(PDFTool.mergeRow("Frame Rate", font, frameRateArr.length));
			for(String msg:frameRateArr){
				//System.out.println(msg);
				table.addCell(PDFTool.getPDFCell(msg, font));
			}
			
			//Photo Resolution
			table.addCell(PDFTool.getPDFCell("Photo Resolution", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getPhotoResolution(), font));
			//Photo Format
			table.addCell(PDFTool.getPDFCell("Photo Format", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getPhotoFormat(), font));
			//Storage Card
			table.addCell(PDFTool.getPDFCell("Storage Card", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getStorageCard(), font));
			//Card Capacity
			table.addCell(PDFTool.getPDFCell("Card Capacity", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getCardCapacity(), font));
			//Rear Camera	YES(Option)
			table.addCell(PDFTool.getPDFCell("Rear Camera", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getRearCamera(), font));
			//G-sensor
			table.addCell(PDFTool.getPDFCell("G-sensor", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getGsensor(), font));
			//GPS
			table.addCell(PDFTool.getPDFCell("GPS", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getGps(), font));
			//WIFI
			table.addCell(PDFTool.getPDFCell("WIFI", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getWifi(), font));
			//TV-OUT
			table.addCell(PDFTool.getPDFCell("TV-OUT", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getTvout(), font));
			//HDMI
			table.addCell(PDFTool.getPDFCell("HDMI", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getHdmi(), font));
			//WDR
			table.addCell(PDFTool.getPDFCell("WDR", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getWdr(), font));
			//ADAS
			table.addCell(PDFTool.getPDFCell("ADAS", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getAdas(), font));
			//USB
			table.addCell(PDFTool.getPDFCell("USB", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getUsb(), font));
			//Power Source
			table.addCell(PDFTool.getPDFCell("Power Source", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getPowerSource(), font));
			//Battery
			table.addCell(PDFTool.getPDFCell("Battery", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getBatter(), font));
			//MIC
			table.addCell(PDFTool.getPDFCell("MIC", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getMic(), font));
			//Speaker
			table.addCell(PDFTool.getPDFCell("Speaker", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getSpeaker(), font));
			//Language
			table.addCell(PDFTool.getPDFCell("Language", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getLanguage(), font));
			//Operating temperature
			table.addCell(PDFTool.getPDFCell("Operating temperature", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getOperatingTemperature(), font));
			//Storage temperature
			table.addCell(PDFTool.getPDFCell("Storage temperature", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getStorageTemperature(), font));
			//weight
			table.addCell(PDFTool.getPDFCell("Weight", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getWeight(), font));
			//Dimension
			table.addCell(PDFTool.getPDFCell("Dimension", font));
			table.addCell(PDFTool.getPDFCell(dvrDetail.getDimension(), font));
			
			document.add(table);
			document.close();
			
			//加水印
			String pdfFile = getServletContext().getRealPath("/pdf/Car Dvr.pdf");
			String newPdfFile = getServletContext().getRealPath("/pdf/DVR/"+fileName);
			try {
				PDFTool.waterMark(pdfFile, newPdfFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//等待3s
			
			//下载
			//downLoad(fileName, request, response);
			
			//提示
			String msg = "<script>alert('PDF文件已生成！');history.back();</script>";
			response.getWriter().write(msg);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
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
	    InputStream  is  =  getServletContext().getResourceAsStream("/pdf/"+file);
	    OutputStream  os  =  response.getOutputStream();
	    int  len  =  -1;
	    byte[]  buf  =  new  byte[1024];
	    while((len=is.read(buf))!=  -1){
	       os.write(buf,  0,  len);
	    }
	    is.close();
	    os.close();
	}
}
