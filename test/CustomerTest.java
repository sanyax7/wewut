import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerTest {

  @Test
  public void getName() {
    assertEquals(
      "John",
      a.customer.w("John").build().getName()
    );
  }

  @Test
  public void noRentalsStatement() {
    assertEquals(
      "Rental record for David\nAmount " +
      "owed is 0.0\n" +
      "You earned 0 frequent renter points",
      a.customer.w("David").build().statement()
    );
  }

  @Test
  public void oneNewReleaseStatement() {
    assertEquals(
      "Rental record for John\n\t" +
      "Godfather 4 9.0\n" +
      "Amount owed is 9.0\n" +
      "You earned 2 frequent renter points",
      a.customer.w("John").w(
        a.rental.w(a.movie.w(Movie.Type.NEW_RELEASE))
      ).build().statement()
    );
  }

  @Test
  public void allRentalTypesStatement() {
    assertEquals(
      "Rental record for Pat\n\t" +
      "Godfather 4 9.0\n" +
      "\tScarface 3.5\n" +
      "\tLion King 1.5\n" +
      "Amount owed is 14.0\n" +
      "You earned 4 frequent renter points",
      a.customer.w("Pat").w(
        a.rental.w(a.movie.w(Movie.Type.NEW_RELEASE)),
        a.rental.w(a.movie.w("Scarface").w(Movie.Type.REGULAR)),
        a.rental.w(a.movie.w("Lion King").w(Movie.Type.CHILDREN))
      ).build().statement()
    );
  }

  @Test
  public void newReleaseAndRegularStatement() {
    assertEquals(
      "Rental record for Steve\n\t" +
      "Godfather 4 9.0\n" +
      "\tScarface 3.5\n" +
      "Amount owed is 12.5\n" +
      "You earned 3 frequent renter points",
      a.customer.w("Steve").w(
        a.rental.w(a.movie.w(Movie.Type.NEW_RELEASE)),
        a.rental.w(a.movie.w("Scarface").w(Movie.Type.REGULAR))
      ).build().statement()
    );
  }

  @Test
  public void noRentalsHtmlStatement() {
    assertEquals(
      "<h1>Rental record for <em>David" +
      "</em></h1>\n<p>Amount owed is <em>" +
      "0.0</em></p>\n<p>You earned <em>0 " +
      "frequent renter points</em></p>",
      a.customer.w("David").build().htmlStatement()
    );
  }

  @Test
  public void oneNewReleaseHtmlStatement() {
    assertEquals(
      "<h1>Rental record for <em>John</em>" +
      "</h1>\n<p>Godfather 4 9.0</p>\n" +
      "<p>Amount owed is <em>9.0</em></p>" +
      "\n<p>You earned <em>2 frequent " +
      "renter points</em></p>",
      a.customer.w("John").w(
        a.rental.w(a.movie.w(Movie.Type.NEW_RELEASE))
      ).build().htmlStatement()
    );
  }

  @Test
  public void allRentalTypesHtmlStatement() {
    assertEquals(
      "<h1>Rental record for <em>Pat</em>" +
      "</h1>\n<p>Godfather 4 9.0</p>\n" +
      "<p>Scarface 3.5</p>\n<p>Lion King" +
      " 1.5</p>\n<p>Amount owed is <em>14.0</em></p>" +
      "\n<p>You earned <em>4 frequent " +
      "renter points</em></p>",
      a.customer.w("Pat").w(
        a.rental.w(a.movie.w(Movie.Type.NEW_RELEASE)),
        a.rental.w(a.movie.w("Scarface").w(Movie.Type.REGULAR)),
        a.rental.w(a.movie.w("Lion King").w(Movie.Type.CHILDREN))
      ).build().htmlStatement()
    );
  }

  @Test
  public void newReleaseAndRegularHtmlStatement() {
    assertEquals(
      "<h1>Rental record for <em>Steve</em>" +
      "</h1>\n<p>Godfather 4 9.0</p>\n" +
      "<p>Scarface 3.5</p>\n" +
      "<p>Amount owed is <em>12.5</em></p>" +
      "\n<p>You earned <em>3 frequent " +
      "renter points</em></p>",
      a.customer.w("Steve").w(
        a.rental.w(a.movie.w(Movie.Type.NEW_RELEASE)),
        a.rental.w(a.movie.w("Scarface").w(Movie.Type.REGULAR))
      ).build().htmlStatement()
    );
  }

  @Test
  (expected=IllegalArgumentException.class)
  public void invalidTitle() {
    a.customer.w(
      a.rental.w(a.movie.w(Movie.Type.UNKNOWN))
    ).build();
  }

}
