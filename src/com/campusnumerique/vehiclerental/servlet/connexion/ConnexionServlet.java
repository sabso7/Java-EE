package com.campusnumerique.vehiclerental.servlet.connexion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.dao.ConnexionDAO;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.forms.ConnexionForm;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientDAO clientDAO;
	private ConnexionDAO connexionDAO; 
	private ConnexionForm connexionForm; 	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
    	clientDAO = new ClientDAO();
    	connexionDAO = new ConnexionDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("pages/connexion.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pseudo =request.getParameter("pseudo");
		request.setAttribute("pseudo", pseudo);
		String password = request.getParameter("password");
		request.setAttribute("password", password);
		try {
			Client clientConnect = connexionDAO.checkUserAuth(password, pseudo);
			System.out.println(clientConnect);
			if(clientConnect.getLogin().equals("guest")){
				doGet(request , response);
			}
			else{
				System.out.println("hello sandrine");
				request.getRequestDispatcher("./cars").forward(request, response);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
