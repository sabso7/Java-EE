package com.campusnumerique.vehiclerental.entity;

import java.util.Date;

public class Reservation {

	private int id;
	private int client;
	private int car;
	private Date startDate;
	private Date endDate;
	private double price;
	
	public Reservation (int id , int i , int j , Date startDate , Date endDate , double price){
		
		setId(id);
		setClient(i);
		setCar(j);
		setStartDate(startDate);
		setEndDate(endDate);
		setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getCar() {
		return car;
	}

	public void setCar(int car) {
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
