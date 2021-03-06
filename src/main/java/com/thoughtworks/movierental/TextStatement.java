package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    protected final double totalAmount;
    protected final int totalFrequentRenterPoints;
    protected List<Rental> rentals;
    protected String customerName;

    public TextStatement(List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints, String customerName) {
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
        this.customerName = customerName;
    }

    protected String header() {
        return "Rental Record for " + customerName + "\n";
    }

    protected String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.movieTitle() + "\t" +
                    rental.calculateAmount() + "\n";
        }
        return result;
    }

    protected String footer() {
        String result = "";
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
        return result;
    }

    public String generate() {
        return header() + body() + footer();
    }
}
