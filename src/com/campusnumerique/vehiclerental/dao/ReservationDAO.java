package com.campusnumerique.vehiclerental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

import com.campusnumerique.vehiclerental.entity.Car;
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
	
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation find(int id) {
		
		return null;
	}

	@Override
	public List<Reservation> findAll() throws SQLException {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		ResultSet result = this.connection.createStatement().executeQuery("SELECT * FROM reservation");
		while(result.next()){
			Reservation reservation = new Reservation(result.getInt("id"),result.getInt("clientReserv"),result.getInt("carReserv"), 
					result.getDate("startDate"),result.getDate("endDate"),result.getDouble("price"));
			reservations.add(reservation);
		}
		return reservations;	
	}
	
	public JSONArray findAllAsJson(){
	
		return null;
	}
	
	public Reservation findClient(int idClient) throws SQLException{
		
		ResultSet result = this.connection.createStatement().executeQuery("SELECT * FROM reservation WHERE clientReserv = " + idClient);
		Reservation	reserv = null;
		if(result.first())
			
		reserv = new Reservation(result.getInt("id"),result.getInt("clientReserv"),result.getInt("carReserv"), 
					result.getDate("startDate"),result.getDate("endDate"),result.getDouble("price"));
		return reserv;	
	}
	
	public boolean saveReserv(Reservation newReservation){
		String msg ="bien enregistré";
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO reservation(clientReserv,carReserv,startDate,endDate,price) VALUES (?,?,?,?,?) ");
			java.sql.Date sqlStartDate = new java.sql.Date(newReservation.getStartDate().getTime());
			System.out.println("date test");
			System.out.println(sqlStartDate);
			java.sql.Date sqlEndDate = new java.sql.Date(newReservation.getEndDate().getTime());
			
			preparedStatement.setInt(1, newReservation.getClient());
			preparedStatement.setInt(2, newReservation.getCar());
			preparedStatement.setDate(3, sqlStartDate);
			preparedStatement.setDate(4, sqlEndDate);
			preparedStatement.setDouble(5, newReservation.getPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public List<Reservation> findReservByClient(int idClient) throws SQLException {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		ResultSet result = this.connection.createStatement().executeQuery("SELECT * FROM reservation WHERE client =" + idClient);
		while(result.next()){
			Reservation reservation = new Reservation(result.getInt("id"),result.getInt("clientReserv"),result.getInt("carReserv"), 
					result.getDate("startDate"),result.getDate("endDate"),result.getDouble("price"));
			reservations.add(reservation);
		}
		return reservations;		
	}
	
	public boolean deleteReserv(int idReserv) throws SQLException {
		ResultSet result;
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE FROM reservation WHERE id = ?");
			preparedStatement.setInt(1, idReserv);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;	
	}
	
	
	
	
	
	
	
	
	
}
