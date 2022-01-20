package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	
	public static void main (String[]args) {
	
	Scanner sc = new Scanner(System.in);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	try {
		

		System.out.println("Room number: "); 
		int number = sc.nextInt();
		
		System.out.println("Check-in Date: ");
		Date dtI = sdf.parse(sc.next());
		
		System.out.println("Check-out Date: ");
		Date dtO = sdf.parse(sc.next());
		
		
		Reservation res = new Reservation(number, dtI, dtO);
		System.out.println("Reservation: " +res);
		
		System.out.println("");
		System.out.println("Enter data to update the reservation: ");
		System.out.println("Check-in Date: ");
		dtI = sdf.parse(sc.next());		
		
		System.out.println("Check-out Date: ");
		dtO = sdf.parse(sc.next());
		
		res.updateDates(dtI, dtO);
		System.out.println("Reservation: "+ res);
	
	}
	
	catch (ParseException e){
		
		System.out.println("Invalid date format.");
		
	}
	
	catch (DomainException e) {
		
		System.out.println("Error in reservation: " + e.getMessage());
		
	}
	
	catch (RuntimeException e) {
	
		System.out.println("Unexpected error.");
	}	
	sc.close();
	}
	
}

