package wewut;

import java.util.Map;

public class Store {
  private Map<Movie, Integer> movies;

  public Store(Map<Movie, Integer> movies) {
    this.movies = movies;
  }

  public int getAvailability(Movie movie) {
    if (null == movies.get(movie))
      return 0;
    return movies.get(movie);
  }

  public boolean getAvailability(Movie movie, int quantity) {
    if (null == movies.get(movie))
      return false;
    return movies.get(movie) >= quantity;
  }

  public void remove(Movie movie) {
    if (null == movies.get(movie))
      return;
    Integer count = movies.get(movie);
    movies.put(movie, --count);
  }
}
