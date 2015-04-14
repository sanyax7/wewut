package wewut.test.solitary;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import static wewut.test.Assert.assertMoney;

import org.joda.time.DateTimeUtils;
import org.joda.time.DateTime;

import wewut.test.a;

import wewut.Store;
import wewut.Movie;
import wewut.Rental;

public class RentalTest extends Solitary {
  @Test
  public void creationDateTimeNow() {
    Rental rental = a.rental.build();
    assertEquals(1000, rental.getCreationDateTime().getMillis());
  }

  @Test
  public void creationDateTimeSet() {
    Rental rental = a.rental.w(new DateTime(199)).build();
    assertEquals(199, rental.getCreationDateTime().getMillis());
  }

  @Test
  public void rentalIsStartedIfInStore() {
    Rental rental = a.rental.build();
    Store store = mock(Store.class);

    when(store.getAvailability(any(Movie.class)))
      .thenReturn(1);

    rental.start(store);

    assertTrue(rental.isStarted());
  }

  @Test
  public void notStartedIfUnavailable() {
    Rental rental = a.rental.build();
    Store store = mock(Store.class);

    rental.start(store);

    assertFalse(rental.isStarted());
  }

  @Test
  public void getChargeFromMovie() {
    Movie movie = mock(Movie.class);

    when(movie.getCharge(any(Integer.class))).thenReturn(
      a.money.w(1.5).build()
    );

    assertMoney(1.5, a.rental.w(movie).build().getCharge());
  }

}
