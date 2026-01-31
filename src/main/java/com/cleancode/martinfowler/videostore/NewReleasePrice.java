package com.cleancode.martinfowler.videostore;

public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 3;
    }
}
