package wewut.test.solitary;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import wewut.test.a;

import wewut.Movie;

public class MovieTest {
  @Test
  public void getChargeForChildrens1Day() {
    assertEquals(
      1.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(1),
      0
    );
  }

  @Test
  public void getChargeForChildrens2Day() {
    assertEquals(
      1.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(2),
      0
    );
  }

  @Test
  public void getChargeForChildrens3Day() {
    assertEquals(
      1.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(3),
      0
    );
  }

  @Test
  public void getChargeForChildrens4Day() {
    assertEquals(
      3.,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(4),
      0
    );
  }

  @Test
  public void getChargeForChildrens5Day() {
    assertEquals(
      4.5,
      a.movie.w(Movie.Type.CHILDREN).build().getCharge(5),
      0
    );
  }

  @Test
  public void getChargeForNewRelease1Day() {
    assertEquals(
      3.,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getCharge(1),
      0
    );
  }

  @Test
  public void getChargeForNewRelease2Day() {
    assertEquals(
      6.,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getCharge(2),
      0
    );
  }

  @Test
  public void getChargeForNewRelease3Day() {
    assertEquals(
      9.,
      a.movie.w(Movie.Type.NEW_RELEASE).build().getCharge(3),
      0
    );
  }

  @Test
  public void getChargeForRegular1Day() {
    assertEquals(
      2.,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(1),
      0
    );
  }

  @Test
  public void getChargeForRegular2Day() {
    assertEquals(
      2.,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(2),
      0
    );
  }

  @Test
  public void getChargeForRegular3Day() {
    assertEquals(
      3.5,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(3),
      0
    );
  }

  @Test
  public void getChargeForRegular4Day() {
    assertEquals(
      5.,
      a.movie.w(Movie.Type.REGULAR).build().getCharge(4),
      0
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
  public void invalidTitle() {
    Runnable runnable = new Runnable() {
      public void run() {
        a.movie.w(Movie.Type.UNKNOWN).build();
      }
    };

    assertThrows(
      IllegalArgumentException.class,
      runnable
    );
  }

  public void assertThrows(Class ex, Runnable runnable) {
    Exception exThrown = null;
    try {
      runnable.run();
    }
    catch (Exception exThrownActual) {
      exThrown = exThrownActual;
    }

    if (null == exThrown) {
      fail("No exception thrown");
    }
    else {
      assertEquals(ex, exThrown.getClass());
    }
  }

}
