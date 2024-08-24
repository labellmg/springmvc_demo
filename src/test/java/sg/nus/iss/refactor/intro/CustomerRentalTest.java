package sg.nus.iss.refactor.intro;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerRentalTest {
  private final String CUSTOMER_NAME = "Alex Tan";
  private final String REGULAR_MOVIE_NAME = "It's A Wonderful Life";
  private final String CHILDREN_MOVIE_NAME = "Peter Pan";
  private final String NEW_RELEASE_MOVIE_NAME = "The New Batman Movie";
  
  public Rental createRental(int days, int categoryCode) {
    return new Rental(new Movie(getMovieName(categoryCode), categoryCode), days);
  }
  
  @Test
  public void renting_2_days_regular_statement() {
    CustomerRental cr = new CustomerRental(CUSTOMER_NAME);
    cr.addRental(createRental(2, Movie.REGULAR));
    
    String expexted = "Rental Record for " + CUSTOMER_NAME + "\n" +
                      REGULAR_MOVIE_NAME + "\t" + 2.0 + "\n" +
                      "Amount owed is " + 2.0 + "\n" +
                      "You earned " + 1 + " frequent renter points";
    assertEquals(expexted, cr.statement());
  }
  
  @Test
  public void renting_3_days_regular_statement() {
    CustomerRental cr = new CustomerRental(CUSTOMER_NAME);
    cr.addRental(createRental(3, Movie.REGULAR));
    
    String expexted = "Rental Record for " + CUSTOMER_NAME + "\n" +
                      REGULAR_MOVIE_NAME + "\t" + 3.5 + "\n" +
                      "Amount owed is " + 3.5 + "\n" +
                      "You earned " + 1 + " frequent renter points";
    assertEquals(expexted, cr.statement());
  }
  
  
  @Test
  public void renting_3_days_children_statement() {
    CustomerRental cr = new CustomerRental(CUSTOMER_NAME);
    cr.addRental(createRental(3, Movie.CHILDRENS));
    
    String expexted = "Rental Record for " + CUSTOMER_NAME + "\n" +
                      CHILDREN_MOVIE_NAME + "\t" + 1.5 + "\n" +
                      "Amount owed is " + 1.5 + "\n" +
                      "You earned " + 1 + " frequent renter points";
    assertEquals(expexted, cr.statement());
  } 
  // Many more test cases
  
  @Test
  public void renting_4_days_children_statement() {
    CustomerRental cr = new CustomerRental(CUSTOMER_NAME);
    cr.addRental(createRental(4, Movie.CHILDRENS));
    
    String expexted = "Rental Record for " + CUSTOMER_NAME + "\n" +
                      CHILDREN_MOVIE_NAME + "\t" + 3.0 + "\n" +
                      "Amount owed is " + 3.0 + "\n" +
                      "You earned " + 1 + " frequent renter points";
    assertEquals(expexted, cr.statement());
  }
  
  @Test
  public void renting_2_days_new_release_statement() {
    CustomerRental cr = new CustomerRental(CUSTOMER_NAME);
    cr.addRental(createRental(2, Movie.NEW_RELEASE));
    
    String expexted = "Rental Record for " + CUSTOMER_NAME + "\n" +
                      NEW_RELEASE_MOVIE_NAME + "\t" + 6.0 + "\n" +
                      "Amount owed is " + 6.0 + "\n" +
                      "You earned " + 2 + " frequent renter points";
    assertEquals(expexted, cr.statement());
  }
  
  @Test
  public void renting_1_day_regular_5_days_chidren_3_days_new_release_statement() {
    CustomerRental cr = new CustomerRental(CUSTOMER_NAME);
    cr.addRental(createRental(1, Movie.REGULAR));
    cr.addRental(createRental(5, Movie.CHILDRENS));
    cr.addRental(createRental(3, Movie.NEW_RELEASE));
    
    String expected = "Rental Record for " + CUSTOMER_NAME + "\n" +
                      REGULAR_MOVIE_NAME + "\t" + 2.0 + "\n" +
                      CHILDREN_MOVIE_NAME + "\t" + 4.5 + "\n" +
                      NEW_RELEASE_MOVIE_NAME + "\t" + 9.0 + "\n" +
                      "Amount owed is " + 15.5 + "\n" +
                      "You earned " + 4 + " frequent renter points";
    
    System.out.print(expected);
    
    assertEquals(expected, cr.statement());
  }
  
  
  private String getMovieName(int categoryCode) {
    switch (categoryCode) {
      case Movie.REGULAR:
        return REGULAR_MOVIE_NAME;
      
      case Movie.CHILDRENS:
        return CHILDREN_MOVIE_NAME;
       
      case Movie.NEW_RELEASE:
        return NEW_RELEASE_MOVIE_NAME;
    }
    
    throw new IllegalArgumentException("Category type is not correct");
  }
}
