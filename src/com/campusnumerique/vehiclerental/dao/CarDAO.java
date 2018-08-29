package com.campusnumerique.vehiclerental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;

public class CarDAO extends DAO<Car>{

	@Override
	public boolean create(Car obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Car obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Car obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Car find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAll() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Car> cars = new ArrayList<Car>();
		ResultSet result = this.connection.createStatement().executeQuery("SELECT * FROM car");
		while(result.next()){
			Car car = new Car(result.getInt("id"),result.getString("brand"),result.getString("model"),result.getString("plateNumber"));
			cars.add(car);
		}
		return cars;
	}
	
	public JSONArray findAllAsJson(){
		JSONArray cars = new JSONArray();
		ResultSet result;
		try {
			result = this.connection.createStatement().executeQuery("SELECT * FROM car");
			while(result.next()){
	
				Car car = new Car(result.getInt("id"),result.getString("brand"),result.getString("model"),result.getString("plateNumber"));    
				cars.put(car.getInfos());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;
	}

}
