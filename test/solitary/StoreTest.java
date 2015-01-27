package wewut.test.solitary;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

import wewut.test.a;

import wewut.Store;
import wewut.Movie;

public class StoreTest {
  @Test
  public void storeWithNoAvailability() {
    Store store = a.store.build();
    assertEquals(
      0,
      store.getAvailability(mock(Movie.class))
    );
  }

  @Test
  public void storeWithAvailability() {
    Movie movie = mock(Movie.class);
    Store store = a.store.w(movie, movie).build();
    assertEquals(2, store.getAvailability(movie));
  }

  @Test
  public void storeWithRemovedAvailability() {
    Movie movie = mock(Movie.class);
    Store store = a.store.w(movie, movie).build();

    store.remove(movie);

    assertEquals(1, store.getAvailability(movie));
  }

}
