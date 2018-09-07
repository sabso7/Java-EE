package com.campusnumerique.vehiclerental.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.Reservation;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO = null;
	private ReservationDAO reservationDAO = null;

	/**
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientServlet() throws ClassNotFoundException {
		super();
		clientDAO = new ClientDAO();
		reservationDAO = new ReservationDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.removeAttribute("msgReservation");
		List<Client> clients;
		List<Reservation> reservations;
		try {
			clients = clientDAO.findAll();
			reservations = reservationDAO.findAll();
			request.setAttribute("reservations", reservations);
			request.setAttribute("clients", clients);
			request.getRequestDispatcher("pages/clients.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// METHODE doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String delete = request.getParameter("delete");
		String goRent = request.getParameter("goRent");
		

		if (request.getParameter("goRent") != null) {
			
			request.setAttribute("login", goRent );
			request.getRequestDispatcher("./reservation").forward(request, response);
			return;
		} 
		if(delete != null){
			try {
				String reservToDelete = request.getParameter("delete");
				int idReserv = Integer.parseInt(reservToDelete);
				boolean functionDel = reservationDAO.deleteReserv(idReserv);
				doGet(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		else {
			
			doGet(request, response);
		}
	}

}
