package com.campusnumerique.vehiclerental.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.entity.Car;

public class ControlReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDAO carDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlReservation() {
		super();
		carDAO = new CarDAO();
		// TODO Auto-generated constructor stub
	}

	public boolean between(Date endDate, Date startDate, Date dVerif) {
		if (dVerif.after(startDate) && dVerif.before(endDate)) {
			return true;
		}
		return false;
	}

	public boolean checkValReserv(Date ReservationEndDate, Date ReservationStartDate, Date clientStartDate,
			Date clientEndDate) {
		if (between(ReservationEndDate, ReservationStartDate, clientStartDate)) {
			return false;
		}
		if (between(ReservationEndDate, ReservationStartDate, clientEndDate)) {
			return false;
		}
		if (between(clientEndDate, clientStartDate, ReservationEndDate)) {
			return false;
		}
		return true;
	}

	public List<Car> CheckDate(Date birthDate) {
		Date currentDate = new Date();
		Calendar birthCalendar = Calendar.getInstance();
		birthCalendar.setTime(birthDate);

		Calendar currentCalendar = Calendar.getInstance();
		currentCalendar.setTime(currentDate);
		int years = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);

		if (years < 18) {

			String msg = "va passer ton permis !";

		}
		if (years > 18 && years < 21) {

			int cv = 7;
			List<Car> cars = new ArrayList<Car>();
			try {
				cars = carDAO.findByCv(cv);
				System.out.println(cars);
				return cars;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (years > 21 && years < 25) {

			int cv = 12;
			List<Car> cars = new ArrayList<Car>();
			try {
				cars = carDAO.findByCv(cv);
				return cars;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			List<Car> cars = new ArrayList<Car>();
			try {
				cars = carDAO.findAll();
				return cars;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

}
