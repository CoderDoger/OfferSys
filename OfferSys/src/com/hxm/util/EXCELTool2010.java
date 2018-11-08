package com.hxm.util;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class EXCELTool2010 {

	public static Font getFont(SXSSFWorkbook workbook){
	    Font font =workbook.createFont();    
	    font.setFontName("黑体");    
	    font.setFontHeightInPoints((short) 22);// 字体大小    
	    font.setBold(true);// 加粗  
	    return font;
	}
	//
	public static CellStyle getBorder(SXSSFWorkbook workbook){
		//生成一个样式
		CellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.THIN);//下边框    
		style.setBorderLeft(BorderStyle.THIN);//左边框
		style.setBorderTop(BorderStyle.THIN);//上边框    
		style.setBorderRight(BorderStyle.THIN);//右边框
		//style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
		return style;
	}
	//
	public static CellStyle getCenterStyle(SXSSFWorkbook workbook){
		//生成一个样式
		CellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.THIN);//下边框    
		style.setBorderLeft(BorderStyle.THIN);//左边框
		style.setBorderTop(BorderStyle.THIN);//上边框    
		style.setBorderRight(BorderStyle.THIN);//右边框
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
		return style;
	}
	//
	public static Cell getCell(Row row,int position,String value,CellStyle style){
		Cell cell = row.createCell(position);
		cell.setCellValue(value);
		cell.setCellStyle(style);
		return cell;	
	}
}
