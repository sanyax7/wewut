package wewut.test.solitary;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.management.RuntimeMXBean;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;

import wewut.test.solitary.Solitary;

import wewut.PidWriter;

public class PidWriterTest extends Solitary {
  @Test
  public void writePid() throws Exception {
    RuntimeMXBean bean = mock(RuntimeMXBean.class);
    when(bean.getName()).thenReturn("12@X");

    PidWriter.writePid("/tmp/sample.pid", bean);

    assertEquals("12", Files.readAllLines(
      Paths.get("/tmp/sample.pid"),
      Charset.defaultCharset()
    ).get(0));
  }
}
