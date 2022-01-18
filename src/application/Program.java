package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	
	public static void main (String[]args) throws ParseException{
	
	Scanner sc = new Scanner(System.in);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	System.out.println("Room number: ");
	int number = sc.nextInt();
	
	System.out.println("Check-in Date: ");
	Date dtI = sdf.parse(sc.next());
	
	System.out.println("Check-out Date: ");
	Date dtO = sdf.parse(sc.next());
	
	
	if (!dtO.after(dtI)) {
		System.out.println("Error in reservation: Check-out date must be after check-in date. ");
	}
	
	else {
		
		Reservation res = new Reservation(number, dtI, dtO);
		System.out.println("Reservation: " +res);
 		
		System.out.println("");
		System.out.println("Enter data to update the reservation: ");
		System.out.println("Check-in Date: ");
		dtI = sdf.parse(sc.next());		
		
		System.out.println("Check-out Date: ");
		dtO = sdf.parse(sc.next());
		
		Date now = new Date();
		if (dtI.before(now) || dtO.before(now)) {
		System.out.println("Reservation dates for update must be future dates.");
		}
		else if (!dtO.after(dtI)) {
			
			System.out.println("Error in reservation: Check-out date must be after check-in date. ");
		}
		
		else {
			
			
			res.updateDates(dtI, dtO);
			System.out.println("Reservation: "+ res);
		}
		
		sc.close();
	
	}
	
	// Add comments to compare branches att...
	
	}

}
