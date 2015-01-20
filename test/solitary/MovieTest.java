package wewut.test.solitary;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import wewut.test.a;

import wewut.Movie;

public class MovieTest {
  @Test
  public void getChargeForChildrens() {
    assertEquals(
      1.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(1),
      0
    );
    assertEquals(
      1.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(2),
      0
    );
    assertEquals(
      1.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(3),
      0
    );
    assertEquals(
      3.,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(4),
      0
    );
    assertEquals(
      4.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(5),
      0
    );
  }

  @Test
  public void getChargeForNewRelease() {
    assertEquals(
      3.,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getCharge(1),
      0
    );
    assertEquals(
      6.,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getCharge(2),
      0
    );
    assertEquals(
      9.,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getCharge(3),
      0
    );
  }

  @Test
  public void getChargeForRegular() {
    assertEquals(
      2.,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(1),
      0
    );
    assertEquals(
      2.,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(2),
      0
    );
    assertEquals(
      3.5,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(3),
      0
    );
    assertEquals(
      5.,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(4),
      0
    );
  }

  @Test
  public void getPointsForChildrens() {
    assertEquals(
      1,
      a.movie.w(Movie.Type.CHILDREN).build().getPoints(1)
    );
    assertEquals(
      1,
      a.movie.w(Movie.Type.CHILDREN).build().getPoints(2)
    );
  }

  @Test
  public void getPointsForNewRelease() {
    assertEquals(
      1,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getPoints(1)
    );
    assertEquals(
      2,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getPoints(2)
    );
    assertEquals(
      2,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getPoints(3)
    );
  }

  @Test
  public void getPointsForRegular() {
    assertEquals(
      1,
      a.movie.w(Movie.Type.REGULAR).build().getPoints(1)
    );
    assertEquals(
      1,
      a.movie.w(Movie.Type.REGULAR).build().getPoints(2)
    );
  }

  @Test
  (expected=IllegalArgumentException.class)
  public void invalidTitle() {
    a.movie.w(Movie.Type.UNKNOWN).build();
  }

}
