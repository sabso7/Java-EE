package com.campusnumerique.vehiclerental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.json.JSONArray;

import com.campusnumerique.vehiclerental.entity.Reservation;

public class ReservationDAO extends DAO<Reservation> {
	
	@Override
	public boolean create(Reservation obj) {

//		ResultSet result = this.connection.createStatement().executeQuery("INSERT INTO reservation() ")
//		Reservation reservation = new Reservation();
		

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
	
	public Reservation findClient(int idClient) throws SQLException{
		ResultSet result = this.connection.createStatement().executeQuery("SELECT * FROM reservation WHERE clientReserv = " + idClient);
		Reservation	reserv = new Reservation(result.getInt("id"),result.getInt("clientReserv"),result.getInt("carReserv"), 
					result.getDate("startDate"),result.getDate("endDate"),result.getDouble("price"));
		return reserv;	
	}
}
