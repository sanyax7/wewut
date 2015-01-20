package wewut.test.sociable;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import wewut.test.a;

import wewut.Movie;

public class CustomerTest {
  @Test
  public void allRentalTypesStatement() {
    assertEquals(
      "Rental record for Pat\n" +
      "\tGodfather 4 9.0\n" +
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
  public void allRentalTypesHtmlStatement() {
    assertEquals(
      "<h1>Rental record for <em>Pat</em></h1>\n" +
      "<p>Godfather 4 9.0</p>\n" +
      "<p>Scarface 3.5</p>\n" +
      "<p>Lion King 1.5</p>\n" +
      "<p>Amount owed is <em>14.0</em></p>\n" +
      "<p>You earned <em>4 frequent renter points</em></p>",
      a.customer.w("Pat").w(
        a.rental.w(a.movie.w(Movie.Type.NEW_RELEASE)),
        a.rental.w(a.movie.w("Scarface").w(Movie.Type.REGULAR)),
        a.rental.w(a.movie.w("Lion King").w(Movie.Type.CHILDREN))
      ).build().htmlStatement()
    );
  }

}
