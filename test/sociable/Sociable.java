package wewut.test.sociable;

import org.junit.Before;

public class Sociable {
  @Before
  public void setup() throws Exception {
    Process p;
    p = Runtime.getRuntime().exec("rm -rf /tmp/wewut");
    p.waitFor();
    p = Runtime.getRuntime().exec("mkdir -p /tmp/wewut");
    p.waitFor();
  }
}
