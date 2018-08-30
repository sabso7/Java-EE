package com.campusnumerique.vehiclerental.entity;

public class Reservation {

	private int id;
	private String client;
	private String car;
	private String startDate;
	private String endDate;
	private double price;
	
	public Reservation (int id , String client , String car , String startDate , String endDate , double price){
		
		setId(id);
		setClient(client);
		setCar(car);
		setStartDate(startDate);
		setStartDate(endDate);
		setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
