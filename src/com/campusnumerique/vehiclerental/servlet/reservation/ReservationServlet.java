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
import javax.servlet.http.HttpSession;

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

		SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date newStartDateReserv;
		Date newEndDateReserv;
		Date startDateReserv;
		Date endDateReserv;
		boolean resultCheckReserv;
		List<Car> result;

		try {

			// on récupère les info du client
			String login = request.getParameter("goRent");
			int idClient = Integer.parseInt(login);
			Client clientCo = clientDAO.find(idClient);
		HttpSession session = request.getSession();
		session.setAttribute("clientCo", clientCo);
			System.out.println(clientCo);

			// on récupère les dates de réservation

			try {
				newStartDateReserv = sdp.parse(request.getParameter("startDate"));
				sdf.format(newStartDateReserv);
				session.setAttribute("startDate", newStartDateReserv);
				newEndDateReserv = sdp.parse(request.getParameter("endDate"));
				sdf.format(newEndDateReserv);
				session.setAttribute("endDate", newEndDateReserv);
				Reservation reserv;

				// on regarde si le client a déja une reservation

				reserv = reservationDAO.findClient(idClient);

				// si il a une réservation on check pour que cela ne tombe pas
				// en meme temps que la nouvelle.

				if (reserv != null) {
					startDateReserv = reserv.getStartDate();
					endDateReserv = reserv.getEndDate();
					resultCheckReserv = controlReservation.checkValReserv(newEndDateReserv, newStartDateReserv,
							startDateReserv, endDateReserv);
				}

				// si il c'est bon , on check son age et on retourne les
				// voitures correspondantes

				result = controlReservation.CheckDate(clientCo.getBirthDate());
				request.setAttribute("cars", result);
				request.getSession().setAttribute("cars", result);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("pages/reservation.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String show = request.getParameter("valid");
		String save = request.getParameter("save");
		System.out.println(show);
		System.out.println(save);

		if (save == null && show == null) {
			doGet(request, response);
			return;

		} else {

			String resultCar;
			String resultKm;
			SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			resultCar = request.getParameter("car");
			int idCar = Integer.parseInt(resultCar);
			resultKm = request.getParameter("kilometer");
			int km = Integer.parseInt(resultKm);
			Client login = (Client) session.getAttribute("clientCo");
			int idClient = login.getId();
			System.out.println("hello dopost");
			System.out.println(login);
			System.out.println(idClient);
			

			if (show != null && save == null) {

				try {
					Double finalPrice;
					Car car = carDAO.findById(idCar);
					double kms = car.getKms();
					double price = car.getPrice();
					double kilometerPrice = kms * km;
					finalPrice = kilometerPrice + price;
					request.setAttribute("finalPrice", finalPrice);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("pages/reservation.jsp").forward(request, response);
			} else if (show == null && save != null) {
				Date newStartDate;
				Date newEndDate;
				Double finalPrice = null;
				Car car;
				try {
					car = carDAO.findById(idCar);
					double kms = car.getKms();
					double price = car.getPrice();
					double kilometerPrice = kms * km;
					finalPrice = kilometerPrice + price;
					request.setAttribute("finalPrice", finalPrice);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("hello save");
				newStartDate = (Date) session.getAttribute("startdate");
				newEndDate = (Date) session.getAttribute("endDate");
				
				Reservation newReservation = new Reservation(0, idClient, idCar, newStartDate, newEndDate, finalPrice);
				boolean saveReserv = reservationDAO.saveReserv(newReservation);
				String msg = "Vous avez bien réservé !";
				request.setAttribute("msgReservation", msg);
				request.getRequestDispatcher("./clients").forward(request, response);
			}
		}
	}
}
