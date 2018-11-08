package com.hxm.domain;

import java.io.Serializable;
import java.util.Arrays;

public class GpsDetail implements Serializable  {
	/*
		imageId
		productType
		model
		os
		cpu
		lcd
		tp
		ram
		rom
		dvr
		camera
		card
		multimedia
		tools
		bluetooth
		fmt
		avin
		tv
		speaker
		mic
		usb
		charger
		battery
		language
		operatingTemperature
		storageTemperature
		weight
		dimension
	 */
	private int id;
	private String imageId;
	private String productType;
	private String model;
	private String os;
	private String cpu;
	private String lcd;
	private String tp;
	private String ram;
	private String rom;
	private String dvr;
	private String camera;
	private String card;
	private String multimedia;
	private String tools;
	private String bluetooth;
	private String fmt;
	private String avin;
	private String tv;
	private String speaker;
	private String mic;
	private String usb;
	private String charger;
	private String battery;
	private String language;
	private String operatingTemperature;
	private String storageTemperature;
	private String weight;
	private String dimension;
	private int htmlStatic;
	public GpsDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GpsDetail(int id, String imageId, String productType, String model,
			String os, String cpu, String lcd, String tp, String ram,
			String rom, String dvr, String camera, String card,
			String multimedia, String tools, String bluetooth, String fmt,
			String avin, String tv, String speaker, String mic, String usb,
			String charger, String battery, String language,
			String operatingTemperature, String storageTemperature,
			String weight, String dimension, int htmlStatic) {
		super();
		this.id = id;
		this.imageId = imageId;
		this.productType = productType;
		this.model = model;
		this.os = os;
		this.cpu = cpu;
		this.lcd = lcd;
		this.tp = tp;
		this.ram = ram;
		this.rom = rom;
		this.dvr = dvr;
		this.camera = camera;
		this.card = card;
		this.multimedia = multimedia;
		this.tools = tools;
		this.bluetooth = bluetooth;
		this.fmt = fmt;
		this.avin = avin;
		this.tv = tv;
		this.speaker = speaker;
		this.mic = mic;
		this.usb = usb;
		this.charger = charger;
		this.battery = battery;
		this.language = language;
		this.operatingTemperature = operatingTemperature;
		this.storageTemperature = storageTemperature;
		this.weight = weight;
		this.dimension = dimension;
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
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
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
	public String getTp() {
		return tp;
	}
	public void setTp(String tp) {
		this.tp = tp;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getRom() {
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	public String getDvr() {
		return dvr;
	}
	public void setDvr(String dvr) {
		this.dvr = dvr;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(String multimedia) {
		this.multimedia = multimedia;
	}
	public String getTools() {
		return tools;
	}
	public void setTools(String tools) {
		this.tools = tools;
	}
	public String getBluetooth() {
		return bluetooth;
	}
	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}
	public String getFmt() {
		return fmt;
	}
	public void setFmt(String fmt) {
		this.fmt = fmt;
	}
	public String getAvin() {
		return avin;
	}
	public void setAvin(String avin) {
		this.avin = avin;
	}
	public String getTv() {
		return tv;
	}
	public void setTv(String tv) {
		this.tv = tv;
	}
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public String getMic() {
		return mic;
	}
	public void setMic(String mic) {
		this.mic = mic;
	}
	public String getUsb() {
		return usb;
	}
	public void setUsb(String usb) {
		this.usb = usb;
	}
	public String getCharger() {
		return charger;
	}
	public void setCharger(String charger) {
		this.charger = charger;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
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
	public int getHtmlStatic() {
		return htmlStatic;
	}
	public void setHtmlStatic(int htmlStatic) {
		this.htmlStatic = htmlStatic;
	}
	@Override
	public String toString() {
		return "GpsDetail [id=" + id + ", imageId=" + imageId
				+ ", productType=" + productType + ", model=" + model + ", os="
				+ os + ", cpu=" + cpu + ", lcd=" + lcd + ", tp=" + tp
				+ ", ram=" + ram + ", rom=" + rom + ", dvr=" + dvr
				+ ", camera=" + camera + ", card=" + card + ", multimedia="
				+ multimedia + ", tools=" + tools + ", bluetooth=" + bluetooth
				+ ", fmt=" + fmt + ", avin=" + avin + ", tv=" + tv
				+ ", speaker=" + speaker + ", mic=" + mic + ", usb=" + usb
				+ ", charger=" + charger + ", battery=" + battery
				+ ", language=" + language + ", operatingTemperature="
				+ operatingTemperature + ", storageTemperature="
				+ storageTemperature + ", weight=" + weight + ", dimension="
				+ dimension + ", htmlStatic=" + htmlStatic + "]";
	}
	
}
