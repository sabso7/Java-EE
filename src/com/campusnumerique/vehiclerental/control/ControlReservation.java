package com.campusnumerique.vehiclerental.control;

import java.util.Date;

public class ControlReservation {

	public boolean between(Date endDate, Date startDate, Date dVerif) {
		if (dVerif.after(startDate) && dVerif.before(endDate)) {
			return true;
		} 
		return false;
	}
	
	public boolean checkValReserv(Date ReservationEndDate, Date ReservationStartDate, Date clientStartDate, Date clientEndDate) {
		if(between(ReservationEndDate, ReservationStartDate, clientStartDate)){
			return false;
		}
		if(between(ReservationEndDate, ReservationStartDate, clientEndDate)){
			return false;
		}
		if(between(clientEndDate, clientStartDate, ReservationEndDate )){
			return false;
		}
		return true;
	}
}
