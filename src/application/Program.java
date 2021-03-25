package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next()); // esta convertendo a data em String para um Date.
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation:" + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); // esta convertendo a data em String para um Date.
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDate(checkIn, checkOut);
			System.out.println("Reservation:" + reservation);
		}
		catch (ParseException e) { // erro na conversão parse.
			System.out.println("Invalid Date Format!");
		}
		catch (DomainException e) { //caso um IllegalArgumentException seja chamado no bloco try, pela chamada 
			                                 // "reservation.updateDate(checkIn, checkOut);"
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) { // exceção generica.
			System.out.println("Unexpected error");
		}

		sc.close();
	}
}
