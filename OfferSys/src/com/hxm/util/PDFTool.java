package com.hxm.util;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PDFTool {
	
	//设置属性
	public static void setFileProperties(Document document,String author,String creator,String title,String subject) {
		//设置作者
		document.addAuthor(author);
		//设置日期
	    document.addCreationDate();
	    //设置创建者
	    document.addCreator(creator);
	    //设置标题
	    document.addTitle(title);
	    //设置主题
	    document.addSubject(subject);
	}
	
	//合并行的静态函数  
    public static PdfPCell mergeRow(String str,Font font,int i) {  
          
        //创建单元格对象，将内容及字体传入  
        PdfPCell cell=new PdfPCell(new Paragraph(str,font));  
        //设置单元格内容居中  
        //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT); 
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        cell.setBorderColor(new BaseColor(22, 150, 98));
        //将该单元格所在列包括该单元格在内的i行单元格合并为一个单元格  
        cell.setRowspan(i);  
          
        return cell;  
    }  
  
    //合并列的静态函数  
    public static PdfPCell mergeCol(String str,Font font,int i) {  
          
        PdfPCell cell=new PdfPCell(new Paragraph(str,font));  
        cell.setMinimumHeight(20);  
        //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT); 
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        cell.setBorderColor(new BaseColor(22, 150, 98));
        //将该单元格所在行包括该单元格在内的i列单元格合并为一个单元格  
        cell.setColspan(i);  
          
        return cell;  
    }  
    
    //合并列的静态函数  
    public static PdfPCell mergeCol(String str,Font font,int i,int horizontalAlignment) {  
          
        PdfPCell cell=new PdfPCell(new Paragraph(str,font));  
        cell.setMinimumHeight(25);  
        cell.setHorizontalAlignment(horizontalAlignment);
        //cell.setHorizontalAlignment(Element.ALIGN_LEFT); 
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  
        cell.setBorderColor(new BaseColor(22, 150, 98));
        //将该单元格所在行包括该单元格在内的i列单元格合并为一个单元格  
        cell.setColspan(i);     
        return cell;  
    } 
  
    //获取指定内容与字体的单元格  
    public static PdfPCell getPDFCell(String string, Font font)   
    {  
        //创建单元格对象，将内容与字体放入段落中作为单元格内容  
        PdfPCell cell=new PdfPCell(new Paragraph(string,font));  
          
        //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT); 
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  
        cell.setBorderColor(new BaseColor(22, 150, 98));  
        //设置最小单元格高度  
        cell.setMinimumHeight(16);  
        return cell;  
    }  
    public static void waterMark(String pdfFile,String newPdfFile) throws Exception{
    	// 待加水印的文件  
        PdfReader reader = new PdfReader(pdfFile);  
        // 加完水印的文件  
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(newPdfFile));  
        //pdf totalPageNum  
        int total = reader.getNumberOfPages() + 1;  
  
        PdfContentByte content;  
        // 设置字体  
        //BaseFont base = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);  
        BaseFont base = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
        // 水印文字  
        String waterText = "www.jwdigital.com";  
        int textLen = waterText.length(); // 文字长度  
//        char c = 0;  
//        int high = 50;// 高度  
        // 循环对每页插入水印  
        for (int i = 1; i < total; i++) {  
            // 水印的起始  
//            high = 100; 
            //得到对应页的pdf层
            content = stamper.getUnderContent(i);  
            // 开始  
            content.beginText();  
            // 设置颜色  
            content.setColorFill(new BaseColor(196, 196, 196));  
            // 设置字体及字号  
            content.setFontAndSize(base, 50);  
            // 设置起始位置  
            //content.setTextMatrix(10, 10);
            //content.setTextMatrix(AffineTransform.getRotateInstance(10));
           
            /*// 开始写入水印  （支持中文）
            for (int k = 0; k < textLen; k++) {  
                content.setTextRise(14);  
                c = waterText.charAt(k);  
                // 将char转成字符串  
                content.showText(c + "");  
                //high -= 5;  
            } */
            //content.setTextMatrix(30, 30); 
            //写水印，只支持英文
            content.showTextAligned(Element.ALIGN_LEFT, waterText, 120, 250, 30); 
            content.endText();  
        }  
        	stamper.close();
        	reader.close();
    }  
}
