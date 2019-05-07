package refactorProgramm;

import java.lang.*;
import java.util.*;

public class Customer {
    private String name;
    public Vector rentals = new Vector(); 
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public Vector getRentals() {
    	return this.rentals;
    }
    public String getName (){
        return name;
    };
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            // add frequent renter points
            frequentRenterPoints = getFrequentRenterPoints(frequentRenterPoints, each);
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
	public int getFrequentRenterPoints(int frequentRenterPoints, Rental each) {
		frequentRenterPoints ++;
		// add bonus for a two day new release rental
		if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) 
		    frequentRenterPoints ++;
		return frequentRenterPoints;
	}

}
    