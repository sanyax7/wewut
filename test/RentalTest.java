import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
// . . .

public class RentalTest {

/**
 * Store object is not available in src.
 */

  // State verification - classicist
/*  @Test
  public void rentalIsStartedIfInStore() {
    Movie movie = a.movie.build();
    Rental rental = a.rental.w(movie).build();
    Store store = a.store.w(movie).build();

    rental.start(store);

    assertTrue(rental.isStarted());
    assertEquals(0, store.getAvailability(movie));
  }

  @Test
  public void rentalDoesNotStartIfNotAvailable() {
    Movie movie = a.movie.build();
    Rental rental = a.rental.build();
    Store store = a.store.build();

    rental.start(store);

    assertFalse(rental.isStarted());
    assertEquals(0, store.getAvailability(movie));
  }*/

  // Behavior Verification - mockist
/*  @Test
  public void rentalIsStartedIfInStore() {
    Movie movie = a.movie.build();
    Rental rental = a.rental.w(movie).build();
    Store store = mock(Store.class);

    when(store.getAvailability(movie)).thenReturn(1);

    rental.start(store);

    assertTrue(rental.isStarted());
    verify(store).remove(movie);
  }

  @Test
  public void rentalDoesNotStartIfNotAvailable() {
    Rental rental = a.rental.build();
    Store store = mock(Store.class);

    rental.start(store);

    assertFalse(rental.isStarted());

    verify(store, never()).remove(any(Movie.class));
  }*/
}
