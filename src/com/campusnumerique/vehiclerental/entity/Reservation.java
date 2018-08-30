package com.campusnumerique.vehiclerental.entity;

import java.util.Date;

public class Reservation {

	private int id;
	private String client;
	private String car;
	private Date startDate;
	private Date endDate;
	private double price;
	
	public Reservation (int id , String client , String car , Date startDate , Date endDate , double price){
		
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
