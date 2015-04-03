package wewut.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Assert {
  public static void assertThrows(Class ex, Runnable runnable) {
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
