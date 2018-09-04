package com.campusnumerique.vehiclerental.control;

import java.util.Calendar;
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
	
	
	public boolean CheckDate(Date birthDate, Date dValid) {
		Date currentDate = new Date();
		Calendar birthCalendar = Calendar.getInstance();
		birthCalendar.setTime(birthDate);
	    
	    Calendar currentCalendar = Calendar.getInstance();
	    currentCalendar.setTime(currentDate);
		int years = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
		
		if(years <18 ){
			
			return false;
						
		}
		if(years >18 && years <21 ){
			
			return false; 
			
		}
		if(years >21 && years <25 ){
			
			return false;
					
		}else{
			
			return true;
		}
				
	}
		
}

