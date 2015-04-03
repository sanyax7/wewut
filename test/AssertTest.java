package wewut.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;

import static wewut.test.Assert.assertThrows;

public class AssertTest {
  @Test
  public void failIfNoThrow() {
    AssertionError e = null;
    try {
      assertThrows(
        IllegalArgumentException.class,
        mock(Runnable.class)
      );
    }
    catch (AssertionError ex) {
      e = ex;
    }
    assertEquals(AssertionError.class, e.getClass());
  }

  @Test
  public void failWithMessageIfNoThrow() {
    AssertionError e = null;
    try {
      assertThrows(
        IllegalArgumentException.class,
        mock(Runnable.class)
      );
    }
    catch (AssertionError ex) {
      e = ex;
    }
    assertEquals("No exception thrown", e.getMessage());
  }

  @Test
  public void failIfClassMismatch() {
    AssertionError e = null;
    try {
      assertThrows(
        IllegalArgumentException.class,
        () -> { throw new RuntimeException(""); }
      );
    }
    catch (AssertionError ex) {
      e = ex;
    }
    assertEquals(AssertionError.class, e.getClass());
  }

  @Test
  public void failWithMessageIfClassWrong() {
    AssertionError e = null;
    try {
      assertThrows(
        IllegalArgumentException.class,
        () -> { throw new RuntimeException(""); }
      );
    }
    catch (AssertionError ex) {
      e = ex;
    }
    assertEquals(
      "expected:<class java.lang.IllegalArgumentException> " +
      "but was:<class java.lang.RuntimeException>",
      e.getMessage()
    );
  }

  @Test
  public void passWithCorrectException() {
    AssertionError e = null;
    try {
      assertThrows(
        RuntimeException.class,
        () -> { throw new RuntimeException(""); }
      );
    }
    catch (AssertionError ex) {
      e = ex;
    }
    assertEquals(null, e);
  }
}
