package com.cleancode.martinfowler.videostore;

public class Rental
{
	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}
	
	public int getDaysRented () {
		return daysRented;
	}
	
	public Movie getMovie () {
		return movie;
	}

	public double calculateRentalAmount() {
		return getMovie().getPrice().calculateAmount(getDaysRented());
	}

	private Movie movie;
	private int daysRented;
}