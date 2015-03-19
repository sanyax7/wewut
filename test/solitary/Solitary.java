package wewut.test.solitary;

import org.junit.Before;

import wewut.FileWriterGateway;

public class Solitary {
  @Before
  public void setup() {
    FileWriterGateway.disallowAccess = true;
  }
}
