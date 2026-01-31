package com.cleancode.martinfowler.videostore;

public abstract class Price {
    public abstract int getPriceCode();
    public abstract double calculateAmount(int daysRented);
}
