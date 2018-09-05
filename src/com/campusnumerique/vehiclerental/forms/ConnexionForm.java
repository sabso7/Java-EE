package com.campusnumerique.vehiclerental.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnexionForm {
	private String resultat="";

	public void verifIdentifiants(HttpServletRequest request){
		
		String login =request.getParameter("login");
		request.setAttribute("login", login);
		

		String pass =request.getParameter("pass");
		request.setAttribute("pass", pass);
		
		
		if(pass.equals  ("abc")){
			
			resultat ="Vous êtes bien connecté !";
		}else{
			
		resultat ="Identifiants incorrectes";
		}
	}
		
	
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
}
