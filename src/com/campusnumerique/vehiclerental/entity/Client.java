package com.campusnumerique.vehiclerental.entity;

import java.util.Date;

import org.json.JSONObject;

public class Client {

	private int id=0;
	private String login="";
	private String firstName="";
	private String lastName="";
	private String mail="";
	private String password="";
	private Date birthDate;
	private String numPermis="";
	private Date datePermis;
	
	private boolean isGuest=false;
	
	public Client(){
		setLogin("guest");
		setGuest(true);
	}
	
	public Client(int id, String login, String firstName, String lastName, String mail, String password, Date birthDate, String numPermis, Date datePermis){
		setId(id);
		setLogin(login);  
		setFirstName(firstName);
		setLastName(lastName);
		setMail(mail);
		setPassword(password);
		setBirthDate(birthDate);
		setNumPermis(numPermis);
		setDatePermis(datePermis);
		setGuest(false);
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		if(login!=null && !login.equals(""))
			this.login = login;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getNumPermis() {
		return numPermis;
	}

	public void setNumPermis(String numPermis) {
		this.numPermis = numPermis;
	}

	public Date getDatePermis() {
		return datePermis;
	}

	public void setDatePermis(Date datePermis) {
		this.datePermis = datePermis;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isGuest() {
		return isGuest;
	}

	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public JSONObject getInfos(){
		JSONObject infos= new JSONObject();
		infos.put("login", login);
		infos.put("id", id);
		infos.put("firstName", firstName);
		infos.put("lastName", lastName);
		infos.put("mail", mail);
		infos.put("isGuest", isGuest);
		infos.put("password", password);
		infos.put("birthDate", birthDate);
		infos.put("numPermis", numPermis);
		infos.put("datePermis", datePermis);
		
		
		return infos;
	}
	
	public String toString(){
		return getInfos().toString();
	}
}