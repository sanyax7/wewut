import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
      "Rental record for Jim\n" +
      "Amount owed is 0.0\n" +
      "You earned 0 frequent renter points",
      a.customer.build().statement()
    );
  }

  @Test
  public void oneRentalStatement() {
    assertEquals(
      "Rental record for Jim\n" +
      "\tnull\n" +
      "Amount owed is 0.0\n" +
      "You earned 0 frequent renter points",
      // Overload w to accept Rental class
      a.customer.w(
        mock(Rental.class)
      ).build().statement()
    );
  }

  @Test
  public void twoRentalsStatement() {
    assertEquals(
      "Rental record for Jim\n" +
      "\tnull\n" +
      "\tnull\n" +
      "Amount owed is 0.0\n" +
      "You earned 0 frequent renter points",
      a.customer.w(
        mock(Rental.class),
        mock(Rental.class)
      ).build().statement()
    );
  }

  @Test
  public void noRentalsCharge() {
    assertEquals(
      .0,
      a.customer.build().getTotalCharge(),
      0
    );
  }

  @Test
  public void twoRentalsCharge() {
    Rental rental = mock(Rental.class);

    when(rental.getCharge()).thenReturn(2.);

    assertEquals(
      4.,
      a.customer.w(
        rental,
        rental
      ).build().getTotalCharge(),
      0
    );
  }

  @Test
  public void threeRentalsCharge() {
    Rental rental = mock(Rental.class);

    when(rental.getCharge()).thenReturn(2.);

    assertEquals(
      6.,
      a.customer.w(
        rental,
        rental,
        rental
      ).build().getTotalCharge(),
      0
    );
  }

  @Test
  public void noRentalsPoints() {
    assertEquals(
      0,
      a.customer.build().getTotalPoints()
    );
  }

  @Test
  public void twoRentalsPoints() {
    Rental rental = mock(Rental.class);

    when(rental.getPoints()).thenReturn(2);

    assertEquals(
      4,
      a.customer.w(
        rental,
        rental
      ).build().getTotalPoints()
    );
  }

  @Test
  public void threeRentalsPoints() {
    Rental rental = mock(Rental.class);

    when(rental.getPoints()).thenReturn(2);

    assertEquals(
      6,
      a.customer.w(
        rental,
        rental,
        rental
      ).build().getTotalPoints()
    );
  }

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
