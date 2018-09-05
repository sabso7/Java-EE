package com.campusnumerique.vehiclerental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.campusnumerique.vehiclerental.entity.Car;


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
			Car car = new Car(result.getInt("id"),result.getString("brand"), result.getString("model"), result.getString("plateNumber"), result.getString("color"), result.getInt("cv"),result.getInt("kms"),result.getDouble("price"));
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
				
				Car car = new Car(result.getInt("id"),result.getString("brand"), result.getString("model"), 
						result.getString("plateNumber"), result.getString("color"), result.getInt("cv"),
						result.getDouble("kms"),result.getDouble("price"));
				
				cars.put(car.getInfos());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;
	}
	
	public List<Car> findByCv(int cv ) throws SQLException{
		ArrayList<Car> cars = new ArrayList<Car>();
		ResultSet result = this.connection.createStatement().executeQuery("SELECT * FROM car WHERE cv <" + cv);
		while(result.next()){
			Car car = new Car(result.getInt("id"),result.getString("brand"), result.getString("model"), result.getString("plateNumber"), result.getString("color"), result.getInt("cv"),result.getInt("kms"),result.getDouble("price"));
			cars.add(car);
		}
		return cars;
	}
	
	public Car findById(int idCar ) throws SQLException{
	Car car = null;
		ResultSet result = this.connection.createStatement().executeQuery("SELECT * FROM car WHERE id = " + idCar);
	if(result.first())	{
		car = new Car(result.getInt("id"),result.getString("brand"), result.getString("model"), result.getString("plateNumber"), 
				result.getString("color"), result.getInt("cv"),result.getDouble("kms"),result.getDouble("price"));
	}
		return car;
	}
}
