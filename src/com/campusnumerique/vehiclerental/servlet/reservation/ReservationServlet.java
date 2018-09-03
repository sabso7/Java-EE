package com.campusnumerique.vehiclerental.servlet.reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 private CarDAO carDAO = null; 
	 private ReservationDAO reservationDAO = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        carDAO = new CarDAO();
        reservationDAO = new ReservationDAO();
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
	
	}

}
