package com.hxm.domain;

import java.io.Serializable;
import java.util.Arrays;

public class DvrDetail implements Serializable  {
	/*
	 * imageId;
	 productType;
	model;
	cpu;
	 lcd;
	 frontCamera;
	 videoFormat;
	 frameRate;
	  photoResolution;
	  photoFormat;
	  storageCard;
	  cardCapacity;
	  rearCamera;
	  gsensor;
	  gps;
	  wifi;
	  tvout;
	  hdmi;
	  wdr;
	  adas;
	  usb;
	  powerSource;
	  batter;
	  mic;
	  speaker;
	  language;
	  operatingTemperature;
	  storageTemperature;
	  weight;
	   dimension;
	   htmlStatic
	 */
	private int id;
	private String imageId;
	private String productType;
	private String model;
	private String cpu;
	private String lcd;
	private String frontCamera;
	private String videoFormat;
	private String frameRate;
	private String photoResolution;
	private String photoFormat;
	private String storageCard;
	private String cardCapacity;
	private String rearCamera;
	private String gsensor;
	private String gps;
	private String wifi;
	private String tvout;
	private String hdmi;
	private String wdr;
	private String adas;
	private String usb;
	private String powerSource;
	private String batter;
	private String mic;
	private String speaker;
	private String language;
	private String operatingTemperature;
	private String storageTemperature;
	private String weight;
	private String dimension;
	private int htmlStatic;
	
	public DvrDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DvrDetail(int id, String imageId, String productType, String model,
			String cpu, String lcd, String frontCamera, String videoFormat,
			String frameRate, String photoResolution, String photoFormat,
			String storageCard, String cardCapacity, String rearCamera,
			String gsensor, String gps, String wifi, String tvout, String hdmi,
			String wdr, String adas, String usb, String powerSource,
			String batter, String mic, String speaker, String language,
			String operatingTemperature, String storageTemperature,
			String weight, String dimension, int htmlStatic) {
		super();
		this.id = id;
		this.imageId = imageId;
		this.productType = productType;
		this.model = model;
		this.cpu = cpu;
		this.lcd = lcd;
		this.frontCamera = frontCamera;
		this.videoFormat = videoFormat;
		this.frameRate = frameRate;
		this.photoResolution = photoResolution;
		this.photoFormat = photoFormat;
		this.storageCard = storageCard;
		this.cardCapacity = cardCapacity;
		this.rearCamera = rearCamera;
		this.gsensor = gsensor;
		this.gps = gps;
		this.wifi = wifi;
		this.tvout = tvout;
		this.hdmi = hdmi;
		this.wdr = wdr;
		this.adas = adas;
		this.usb = usb;
		this.powerSource = powerSource;
		this.batter = batter;
		this.mic = mic;
		this.speaker = speaker;
		this.language = language;
		this.operatingTemperature = operatingTemperature;
		this.storageTemperature = storageTemperature;
		this.weight = weight;
		this.dimension = dimension;
		this.htmlStatic = htmlStatic;
	}
	
	public int getHtmlStatic() {
		return htmlStatic;
	}
	public void setHtmlStatic(int htmlStatic) {
		this.htmlStatic = htmlStatic;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getLcd() {
		return lcd;
	}
	public void setLcd(String lcd) {
		this.lcd = lcd;
	}
	public String getFrontCamera() {
		return frontCamera;
	}
	public void setFrontCamera(String frontCamera) {
		this.frontCamera = frontCamera;
	}
	public String getVideoFormat() {
		return videoFormat;
	}
	public void setVideoFormat(String videoFormat) {
		this.videoFormat = videoFormat;
	}
	public String getFrameRate() {
		return frameRate;
	}
	public void setFrameRate(String frameRate) {
		this.frameRate = frameRate;
	}
	public String getPhotoResolution() {
		return photoResolution;
	}
	public void setPhotoResolution(String photoResolution) {
		this.photoResolution = photoResolution;
	}
	public String getPhotoFormat() {
		return photoFormat;
	}
	public void setPhotoFormat(String photoFormat) {
		this.photoFormat = photoFormat;
	}
	public String getStorageCard() {
		return storageCard;
	}
	public void setStorageCard(String storageCard) {
		this.storageCard = storageCard;
	}
	public String getCardCapacity() {
		return cardCapacity;
	}
	public void setCardCapacity(String cardCapacity) {
		this.cardCapacity = cardCapacity;
	}
	public String getRearCamera() {
		return rearCamera;
	}
	public void setRearCamera(String rearCamera) {
		this.rearCamera = rearCamera;
	}
	public String getGsensor() {
		return gsensor;
	}
	public void setGsensor(String gsensor) {
		this.gsensor = gsensor;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getTvout() {
		return tvout;
	}
	public void setTvout(String tvout) {
		this.tvout = tvout;
	}
	public String getHdmi() {
		return hdmi;
	}
	public void setHdmi(String hdmi) {
		this.hdmi = hdmi;
	}
	public String getWdr() {
		return wdr;
	}
	public void setWdr(String wdr) {
		this.wdr = wdr;
	}
	public String getAdas() {
		return adas;
	}
	public void setAdas(String adas) {
		this.adas = adas;
	}
	public String getUsb() {
		return usb;
	}
	public void setUsb(String usb) {
		this.usb = usb;
	}
	public String getPowerSource() {
		return powerSource;
	}
	public void setPowerSource(String powerSource) {
		this.powerSource = powerSource;
	}
	public String getBatter() {
		return batter;
	}
	public void setBatter(String batter) {
		this.batter = batter;
	}
	public String getMic() {
		return mic;
	}
	public void setMic(String mic) {
		this.mic = mic;
	}
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getOperatingTemperature() {
		return operatingTemperature;
	}
	public void setOperatingTemperature(String operatingTemperature) {
		this.operatingTemperature = operatingTemperature;
	}
	public String getStorageTemperature() {
		return storageTemperature;
	}
	public void setStorageTemperature(String storageTemperature) {
		this.storageTemperature = storageTemperature;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	@Override
	public String toString() {
		return "DvrDetail [id=" + id + ", imageId=" + imageId
				+ ", productType=" + productType + ", model=" + model
				+ ", cpu=" + cpu + ", lcd=" + lcd + ", frontCamera="
				+ frontCamera + ", videoFormat=" + videoFormat + ", frameRate="
				+ frameRate + ", photoResolution=" + photoResolution
				+ ", photoFormat=" + photoFormat + ", storageCard="
				+ storageCard + ", cardCapacity=" + cardCapacity
				+ ", rearCamera=" + rearCamera + ", gsensor=" + gsensor
				+ ", gps=" + gps + ", wifi=" + wifi + ", tvout=" + tvout
				+ ", hdmi=" + hdmi + ", wdr=" + wdr + ", adas=" + adas
				+ ", usb=" + usb + ", powerSource=" + powerSource + ", batter="
				+ batter + ", mic=" + mic + ", speaker=" + speaker
				+ ", language=" + language + ", operatingTemperature="
				+ operatingTemperature + ", storageTemperature="
				+ storageTemperature + ", weight=" + weight + ", dimension="
				+ dimension + ", htmlStatic=" + htmlStatic
				+ ", getHtmlStatic()=" + getHtmlStatic() + ", getId()="
				+ getId() + ", getImageId()=" + getImageId()
				+ ", getProductType()=" + getProductType() + ", getModel()="
				+ getModel() + ", getCpu()=" + getCpu() + ", getLcd()="
				+ getLcd() + ", getFrontCamera()=" + getFrontCamera()
				+ ", getVideoFormat()=" + getVideoFormat()
				+ ", getFrameRate()=" + getFrameRate()
				+ ", getPhotoResolution()=" + getPhotoResolution()
				+ ", getPhotoFormat()=" + getPhotoFormat()
				+ ", getStorageCard()=" + getStorageCard()
				+ ", getCardCapacity()=" + getCardCapacity()
				+ ", getRearCamera()=" + getRearCamera() + ", getGsensor()="
				+ getGsensor() + ", getGps()=" + getGps() + ", getWifi()="
				+ getWifi() + ", getTvout()=" + getTvout() + ", getHdmi()="
				+ getHdmi() + ", getWdr()=" + getWdr() + ", getAdas()="
				+ getAdas() + ", getUsb()=" + getUsb() + ", getPowerSource()="
				+ getPowerSource() + ", getBatter()=" + getBatter()
				+ ", getMic()=" + getMic() + ", getSpeaker()=" + getSpeaker()
				+ ", getLanguage()=" + getLanguage()
				+ ", getOperatingTemperature()=" + getOperatingTemperature()
				+ ", getStorageTemperature()=" + getStorageTemperature()
				+ ", getWeight()=" + getWeight() + ", getDimension()="
				+ getDimension() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
