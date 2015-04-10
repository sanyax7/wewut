package wewut.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Date;

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

  public static void assertDateWithFormat(String expected, String format, Date dt) {
    assertEquals(expected, new SimpleDateFormat(format).format(dt));
  }
}
