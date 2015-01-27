package wewut.test.sociable;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import wewut.test.a;

import wewut.Store;
import wewut.Movie;
import wewut.Rental;

public class RentalTest {
  @Test
  public void isStartedIfInStore() {
    Movie movie = a.movie.build();
    Rental rental = a.rental.w(movie).build();
    Store store = a.store.w(movie).build();

    rental.start(store);

    assertTrue(rental.isStarted());
    assertEquals(0, store.getAvailability(movie));
  }

  @Test
  public void doesNotStartIfNotAvailable() {
    Movie movie = a.movie.build();
    Rental rental = a.rental.build();
    Store store = a.store.build();

    rental.start(store);

    assertFalse(rental.isStarted());
    assertEquals(0, store.getAvailability(movie));
  }

  @Test
  public void storeAvailabilityIsModifiedOnRental() {
    Movie movie = a.movie.build();
    Rental rental = a.rental.w(movie).build();
    Store store = a.store.w(movie, movie).build();

    rental.start(store);
    a.rental.build().start(store);

    assertEquals(1, store.getAvailability(movie));
  }

}
