package com.campusnumerique.vehiclerental.servlet.reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
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
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.Reservation;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDAO carDAO;
	private ReservationDAO reservationDAO;
	private ControlReservation controlReservation;
	private ClientDAO clientDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationServlet() {
		super();
		carDAO = new CarDAO();
		clientDAO = new ClientDAO();
		reservationDAO = new ReservationDAO();
		controlReservation = new ControlReservation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Car> cars;
		try {
			cars = carDAO.findAll();
			request.setAttribute("cars", cars);
			String login = request.getParameter("login");
			int idClient = Integer.parseInt(login);
			System.out.println(idClient);
			Client clientCo = clientDAO.find(idClient);
			System.out.println(clientCo);
			request.setAttribute("client", clientCo);
			request.getSession().setAttribute("login", login);
			request.getRequestDispatcher("pages/reservation.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date newStartDateReserv;
		Date newEndDateReserv;
		Date startDateReserv;
		Date endDateReserv;
		boolean result;
		int idClient;

		try {
			newStartDateReserv = sdp.parse(request.getParameter("startDate"));
			sdf.format(newStartDateReserv);
			newEndDateReserv = sdp.parse(request.getParameter("endDate"));
			sdf.format(newEndDateReserv);
			String car = request.getParameter("car");
			String login = request.getParameter("login");
			idClient = Integer.parseInt(login);
			System.out.println(idClient);
			Reservation reserv;
			try {
				reserv = reservationDAO.findClient(idClient);
				startDateReserv = reserv.getStartDate();
				endDateReserv = reserv.getEndDate();
				System.out.println(startDateReserv);
				System.out.println(endDateReserv);
				
				result = controlReservation.checkValReserv(newEndDateReserv, newStartDateReserv,
						startDateReserv, endDateReserv);
				System.out.println(result);
				request.setAttribute("login", login);
				String startDate1 = request.getParameter("startDate");
				request.setAttribute("startDate", startDate1);
				request.getRequestDispatcher("pages/reservation.jsp").forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
