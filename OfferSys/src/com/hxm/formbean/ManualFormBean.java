package com.hxm.formbean;

public class ManualFormBean {
	private String objName;
	private String productName;
	private String fileName;
	private String author;
	public ManualFormBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManualFormBean(String objName, String productName, String fileName,
			String author) {
		super();
		this.objName = objName;
		this.productName = productName;
		this.fileName = fileName;
		this.author = author;
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
	@Override
	public String toString() {
		return "ManualFormBean [objName=" + objName + ", productName="
				+ productName + ", fileName=" + fileName + ", author=" + author
				+ "]";
	}
	
	
}
