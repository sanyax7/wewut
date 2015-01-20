package wewut.test.sociable;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;

import wewut.test.a;

import wewut.Store;
import wewut.Movie;
import wewut.Rental;

public class RentalTest {
  @Test
  public void isStartedIfInStoreStateBased() {
    Movie movie = a.movie.build();
    Rental rental = a.rental.w(movie).build();
    Store store = a.store.w(movie).build();

    rental.start(store);

    assertTrue(rental.isStarted());
    assertEquals(0, store.getAvailability(movie));
  }

  @Test
  public void doesNotStartIfNotAvailableStateBased() {
    Movie movie = a.movie.build();
    Rental rental = a.rental.build();
    Store store = a.store.build();

    rental.start(store);

    assertFalse(rental.isStarted());
    assertEquals(0, store.getAvailability(movie));
  }

  @Test
  public void isStartedIfInStoreInteractionBased() {
    Movie movie = a.movie.build();
    Rental rental = a.rental.w(movie).build();
    Store store = mock(Store.class);

    when(store.getAvailability(movie)).thenReturn(1);
    rental.start(store);

    assertTrue(rental.isStarted());
    verify(store).remove(movie);
  }

  @Test
  public void notStartedIfUnavailableInteractionBased() {
    Rental rental = a.rental.build();
    Store store = mock(Store.class);

    rental.start(store);

    assertFalse(rental.isStarted());
    verify(store, never()).remove(any(Movie.class));
  }
}
