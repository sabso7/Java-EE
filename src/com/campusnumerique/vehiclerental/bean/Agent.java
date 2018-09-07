package com.campusnumerique.vehiclerental.bean;

public class Agent {
	
	private String agentName;
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentFirstname() {
		return agentFirstname;
	}
	public void setAgentFirstname(String agentFirstname) {
		this.agentFirstname = agentFirstname;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	private String agentFirstname;
	private boolean actif;

}
