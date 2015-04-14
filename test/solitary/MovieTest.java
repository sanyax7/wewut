package wewut.test.solitary;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import static wewut.test.Assert.assertThrows;
import static wewut.test.Assert.assertMoney;

import wewut.test.a;

import wewut.Movie;

public class MovieTest {
  @Test
  public void getChargeForChildrens1Day() {
    assertMoney(
      1.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(1)
    );
  }

  @Test
  public void getChargeForChildrens2Day() {
    assertMoney(
      1.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(2)
    );
  }

  @Test
  public void getChargeForChildrens3Day() {
    assertMoney(
      1.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(3)
    );
  }

  @Test
  public void getChargeForChildrens4Day() {
    assertMoney(
      3.,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(4)
    );
  }

  @Test
  public void getChargeForChildrens5Day() {
    assertMoney(
      4.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(5)
    );
  }

  @Test
  public void getChargeForNewRelease1Day() {
    assertMoney(
      3.,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getCharge(1)
    );
  }

  @Test
  public void getChargeForNewRelease2Day() {
    assertMoney(
      6.,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getCharge(2)
    );
  }

  @Test
  public void getChargeForNewRelease3Day() {
    assertMoney(
      9.,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getCharge(3)
    );
  }

  @Test
  public void getChargeForRegular1Day() {
    assertMoney(
      2.,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(1)
    );
  }

  @Test
  public void getChargeForRegular2Day() {
    assertMoney(
      2.,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(2)
    );
  }

  @Test
  public void getChargeForRegular3Day() {
    assertMoney(
      3.5,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(3)
    );
  }

  @Test
  public void getChargeForRegular4Day() {
    assertMoney(
      5.,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(4)
    );
  }

  @Test
  public void getPointsForChildrens1Day() {
    assertEquals(
      1,
      a.movie.w(Movie.Type.CHILDREN).build().getPoints(1)
    );
  }

  @Test
  public void getPointsForChildrens2Day() {
    assertEquals(
      1,
      a.movie.w(Movie.Type.CHILDREN).build().getPoints(2)
    );
  }

  @Test
  public void getPointsForNewRelease1Day() {
    assertEquals(
      1,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getPoints(1)
    );
  }

  @Test
  public void getPointsForNewRelease2Day() {
    assertEquals(
      2,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getPoints(2)
    );
  }

  @Test
  public void getPointsForNewRelease3Day() {
    assertEquals(
      2,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getPoints(3)
    );
  }

  @Test
  public void getPointsForRegular1Day() {
    assertEquals(
      1,
      a.movie.w(Movie.Type.REGULAR).build().getPoints(1)
    );
  }

  @Test
  public void getPointsForRegular2Day() {
    assertEquals(
      1,
      a.movie.w(Movie.Type.REGULAR).build().getPoints(2)
    );
  }

  @Test
  public void invalidTitleCustomAssertion() {
    assertThrows(
      IllegalArgumentException.class,
      () -> a.movie.w(Movie.Type.UNKNOWN).build()
    );
  }
}
