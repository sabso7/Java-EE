package com.campusnumerique.vehiclerental.servlet.reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campusnumerique.vehiclerental.control.ControlReservation;
import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Reservation;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private CarDAO carDAO; 
	 private ReservationDAO reservationDAO;
	 private ControlReservation controlReservation ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        carDAO = new CarDAO();
        reservationDAO = new ReservationDAO();
        controlReservation = new ControlReservation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Car> cars;
		try {
			cars = carDAO.findAll();
			request.setAttribute("cars", cars);
			request.getRequestDispatcher("pages/reservation.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
<<<<<<< HEAD
	SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd");	
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
	Date startDate;
	Date endDate;
	try {
		startDate = sdp.parse(request.getParameter("startDate"));
		sdf.format(startDate);
		endDate = sdp.parse( request.getParameter("endDate"));
		sdf.format(endDate);
		String car = request.getParameter("car");
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println(car);
		
	   	
		
=======
//		Reservation reservation = new Reservation();
//		reservation.setCar(car);
//		reservation.setClient(client);
//		reservation.setStartDate(startDate);
//		reservation.setEndDate(endDate);
//		reservation.setPrice(price);

		String login = request.getParameter("login");
		
		request.setAttribute("login", login);
	String startDate = request.getParameter("startDate");
	request.setAttribute("startDate", startDate);
	request.getRequestDispatcher("pages/reservation.jsp").forward(request, response);
>>>>>>> a525089c8f9a2cf3f3bcb9245f2974214f75b2d6
	
		request.getRequestDispatcher("pages/reservation.jsp").forward(request, response);
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}
