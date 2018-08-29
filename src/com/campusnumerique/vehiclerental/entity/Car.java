package com.campusnumerique.vehiclerental.entity;

import org.json.JSONObject;

public class Car {

	private int id=0;
	private String brand="";
	private String model="";
	private String plateNumber="";
	
	public Car(int id, String brand, String model, String plateNumber){
		setId(id);
		setBrand(brand);
		setModel(model);
		setPlateNumber(plateNumber);
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
		
}