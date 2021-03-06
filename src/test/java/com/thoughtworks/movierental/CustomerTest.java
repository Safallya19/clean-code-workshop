package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void shouldProduceAStatementForGivenRentals() {
         Customer customer=new Customer( "safal");
         customer.addRental(new Rental(new Movie ("Dunkirk", Movie.REGULAR), 7));
        customer.addRental(new Rental(new Movie ("Dumbo", Movie.CHILDRENS), 7));
        customer.addRental(new Rental(new Movie ("Jawani", Movie.NEW_RELEASE), 7));
        String statement = customer.statement();
        Assert.assertEquals("Rental Record for safal\n" +
                "\tDunkirk\t9.5\n" +
                "\tDumbo\t7.5\n" +
                "\tJawani\t21.0\n" +
                "Amount owed is 38.0\n" +
                "You earned 4 frequent renter points",statement);
    }

    @Test
    public void shouldProduceAHtmlStatement() {
         Customer customer=new Customer( "safal");
         customer.addRental(new Rental(new Movie ("Dunkirk", Movie.REGULAR), 7));
        customer.addRental(new Rental(new Movie ("Dumbo", Movie.CHILDRENS), 7));
        customer.addRental(new Rental(new Movie ("Jawani", Movie.NEW_RELEASE), 7));
        String statement = customer.htmlStatement();
        Assert.assertEquals("<h3>Rental Record for safal</h3>\n" +
                "<p>\n"+
                "\tDunkirk\t9.5\n" +
                "\tDumbo\t7.5\n" +
                "\tJawani\t21.0\n" +
                "</p>\n" +
                "<p>Amount owed is 38.0</p>\n" +
                "<p>You earned 4 frequent renter points</p>",statement);
    }

}