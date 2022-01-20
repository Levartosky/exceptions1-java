package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
	
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration () {
		
		long diff = checkOut.getTime() - checkIn.getTime();
		return  TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public String updateDates(Date dtI, Date dtO) {
		
		Date now = new Date();
		
		if (dtI.before(now) || dtO.before(now)) {
		return "Reservation dates for update must be future dates.";
		}
		
		else if (!dtO.after(dtI)) {			
		return "Error in reservation: Check-out date must be after check-in date.";
		}
				
		this.checkIn = dtI;
		this.checkOut = dtO;
		return null;
		
	}
	
	@Override
	public String toString() {
		
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
		
	}
		

}
