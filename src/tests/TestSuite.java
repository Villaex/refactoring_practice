package tests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

import refactorProgramm.*;

public class TestSuite {
	
	 @Test
	 public void CustomerNameSetAfterInitiliazing() {
		 Customer testCustomer = new Customer("TestCandidate");
		 
		 assertEquals("TestCandidate", testCustomer.getName(), "Customer Name should be equal to TestCandidate");
	 }
	 
	 @Test
	 public void addRentalTest() {
		 Customer testCustomer = new Customer("TestCandidate");
		 Vector<Rental> testVector = new Vector<>(); 
		 assertEquals(testVector,testCustomer.getRentals(), "At this point rentals should still be empty");
		 testCustomer.addRental(new Rental(new Movie("ABC", 2), 10));
		 String testString = "ABC";
		 assertEquals(testString, ((Rental)testCustomer.rentals.elementAt(0)).getMovie().getTitle(), "At this point rentals should contain the movie ABC");
	 }
	 
	 @Test
	 public void statementTest() {
		Movie m1 = new Movie("ABC", 1);
        Movie m2 = new Movie("XYZ", 2);
        Rental r1 = new Rental(m1, 4);
        Rental r2 = new Rental(m2, 3);
        Customer c1 = new Customer("TestCandidate");
        c1.addRental(r1);   c1.addRental(r2);
        String testStatement = "Rental Record for " + c1.getName() + "\n";
        testStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        testStatement += "\t" + r1.getMovie().getTitle()+ "\t" + "\t" + r1.getDaysRented() + "\t" + String.valueOf(12.0) + "\n";
        testStatement += "\t" + r2.getMovie().getTitle()+ "\t" + "\t" + r2.getDaysRented() + "\t" + String.valueOf(1.5) + "\n";
        testStatement += "Amount owed is " + String.valueOf(13.5) + "\n";
        testStatement += "You earned " + String.valueOf(3) + " frequent renter points";;
        		
        assertEquals(testStatement, c1.statement().toString(), "Customer statement should be correct.");
	 }

}
