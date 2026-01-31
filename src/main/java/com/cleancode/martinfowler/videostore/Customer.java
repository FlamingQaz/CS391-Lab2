package com.cleancode.martinfowler.videostore;

import java.util.ArrayList;
import java.util.List;

public class Customer 
{
	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.add (rental);
	}
	
	public String getName () {
		return name;
	}
	
	public String statement () {
		String 				result 					= "Rental Record for " + getName () + "\n";

		for (Rental rental :rentals) {
			double thisAmount = rental.calculateRentalAmount();
			result += formatRentalLine(rental, thisAmount);
		}

		result += "You owed " + String.valueOf (getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf (getFrequentRenterPoints()) + " frequent renter points\n";


		return result;
	}

	private double getTotalAmount() {
		double totalAmount = 0;
		for (Rental rental : rentals) {
			totalAmount += rental.calculateRentalAmount();
		}
		return totalAmount;
	}

	private int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental rental : rentals) {
			frequentRenterPoints = addFrequentRenterPoints(rental, frequentRenterPoints);
		}
		return frequentRenterPoints;
	}

	private int addFrequentRenterPoints(Rental rental, int frequentRenterPoints) {
		frequentRenterPoints++;

		if (rental.getMovie ().getPriceCode () == Movie.NEW_RELEASE
				&& rental.getDaysRented () > 1)
			frequentRenterPoints++;

		return frequentRenterPoints;
	}

	private String formatRentalLine(Rental rental, double thisAmount) {
		return "\t" + rental.getMovie ().getTitle () + "\t"
							+ String.valueOf (thisAmount) + "\n";
	}
	

	private String name;
	private List<Rental> rentals = new ArrayList<> ();
}