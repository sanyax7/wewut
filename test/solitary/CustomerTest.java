package wewut.test.solitary;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import wewut.test.a;

import wewut.Rental;

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
  public void noRentalsHtmlStatement() {
    assertEquals(
      "<h1>Rental record for <em>Jim</em></h1>\n" +
      "<p>Amount owed is <em>0.0</em></p>\n" +
      "<p>You earned <em>0 frequent renter points</em></p>",
      a.customer.build().htmlStatement()
    );
  }

  @Test
  public void onRentalHtmlStatement() {
    assertEquals(
      "<h1>Rental record for <em>Jim</em></h1>\n" +
      "<p>null</p>\n" +
      "<p>Amount owed is <em>0.0</em></p>\n" +
      "<p>You earned <em>0 frequent renter points</em></p>",
      a.customer.w(
        mock(Rental.class)
      ).build().htmlStatement()
    );
  }

  @Test
  public void twoRentalsHtmlStatement() {
    assertEquals(
      "<h1>Rental record for <em>Jim</em></h1>\n" +
      "<p>null</p>\n" +
      "<p>null</p>\n" +
      "<p>Amount owed is <em>0.0</em></p>\n" +
      "<p>You earned <em>0 frequent renter points</em></p>",
      a.customer.w(
        mock(Rental.class),
        mock(Rental.class)
      ).build().htmlStatement()
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
}
