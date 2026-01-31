package com.cleancode.martinfowler.videostore;

public class Movie
{
	public static final int CHILDRENS	= 2;
	public static final int REGULAR 	= 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private Price price;

	public Movie (String title, int priceCode) {
		this.title 		= title;
		setPriceCode(priceCode);
	}

	public int getPriceCode () {
		return price.getPriceCode();
	}

	public void setPriceCode (int code) {
		switch (code) {
			case REGULAR:
				price = new RegularPrice();
				break;
			case NEW_RELEASE:
				price = new NewReleasePrice();
				break;
			case CHILDRENS:
				price = new ChildrensPrice();
				break;
		}
	}

	public String getTitle () {
		return title;
	}

	public Price getPrice() {
		return price;
	}

}