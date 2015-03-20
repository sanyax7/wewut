package wewut.test.solitary;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.lang.management.RuntimeMXBean;

import wewut.test.solitary.Solitary;

import wewut.PidWriter;
import wewut.FileWriterGateway;

public class PidWriterTest extends Solitary {
  @Test
  public void writePid() throws Exception {
    RuntimeMXBean bean = mock(RuntimeMXBean.class);
    when(bean.getName()).thenReturn("12@X");
    FileWriterGateway facade = mock(FileWriterGateway.class);

    PidWriter.writePid(facade, bean);

    verify(facade).write("12");
  }
}
