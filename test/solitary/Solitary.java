package wewut.test.solitary;

import org.junit.Before;

import org.joda.time.DateTimeUtils;

import wewut.FileWriterGateway;

public class Solitary {
  @Before
  public void setup() {
    FileWriterGateway.disallowAccess = true;
    DateTimeUtils.setCurrentMillisFixed(1000);
  }
}
