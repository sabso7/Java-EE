package com.campusnumerique.vehiclerental.dao;

import java.sql.SQLException;
import java.util.List;
import org.json.JSONArray;

import com.campusnumerique.vehiclerental.entity.Reservation;

public class ReservationDAO extends DAO<Reservation> {
	
	@Override
	public boolean create(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findAll() throws SQLException {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	public JSONArray findAllAsJson(){
	
		return null;
	}
}
