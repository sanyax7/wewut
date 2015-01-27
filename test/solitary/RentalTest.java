package wewut.test.solitary;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import wewut.test.a;

import wewut.Store;
import wewut.Movie;
import wewut.Rental;

public class RentalTest {
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

}
