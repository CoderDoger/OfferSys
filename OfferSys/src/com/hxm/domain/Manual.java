package com.hxm.domain;

import java.io.Serializable;

public class Manual implements Serializable{
	private int id;
	private String objName;
	private String productName;
	private String fileName;
	private Long fileSize;
	/**
	 * @return the fileSize
	 */
	
	private String author;
	public Manual() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Manual(int id, String objName, String productName, String fileName,
			Long fileSize, String author) {
		super();
		this.id = id;
		this.objName = objName;
		this.productName = productName;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.author = author;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	public Long getFileSize() {
		return fileSize;
	}
	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	/**
	 * @return the objName
	 */
	public String getObjName() {
		return objName;
	}
	/**
	 * @param objName the objName to set
	 */
	public void setObjName(String objName) {
		this.objName = objName;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Manual [id=" + id + ", objName=" + objName + ", productName="
				+ productName + ", fileName=" + fileName + ", fileSize="
				+ fileSize + ", author=" + author + "]";
	}
	
	
	
}
