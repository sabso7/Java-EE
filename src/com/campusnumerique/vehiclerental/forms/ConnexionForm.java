package com.campusnumerique.vehiclerental.forms;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;

public class ConnexionForm  extends HttpServlet{
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String resultat="";
	private String connectClient;

	public void verifIdentifiants(HttpServletRequest request){
		
		String pseudo =request.getParameter("pseudo");
		request.setAttribute("pseudo", pseudo);
		String password =request.getParameter("password");
		request.setAttribute("password", password);	
	}
		
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
}
  