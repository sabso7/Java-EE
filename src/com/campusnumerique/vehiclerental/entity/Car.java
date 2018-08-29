package com.campusnumerique.vehiclerental.entity;

import org.json.JSONObject;

public class Car {

	private int id=0;
	private String brand="";
	private String model="";
	private String plateNumber="";
	private double price= 0;
	private int kms = 0;
	private int cv = 0;
	private String color="";
	
	public Car(int id, String brand, String model, String plateNumber, String color , int kms , int cv,double price ){
		setId(id);
		setBrand(brand);
		setModel(model);
		setPlateNumber(plateNumber);
		setColor(color);
		setCv(cv);
		setKms(kms);
		setPrice(price);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public JSONObject getInfos(){
		JSONObject infos= new JSONObject();
		infos.put("id", id);
		infos.put("brand", brand);
		infos.put("model", model);
		infos.put("plateNumber", plateNumber);
		return infos;
	}
	
	public String toString(){
		return getInfos().toString();
	}

	public int getKms() {
		return kms;
	}

	public void setKms(int kms) {
		this.kms = kms;
	}

	public int getCv() {
		return cv;
	}

	public void setCv(int cv) {
		this.cv = cv;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
		
}