package wewut;

import java.lang.management.RuntimeMXBean;

import java.io.IOException;
import wewut.FileWriterGateway;

public class PidWriter {
  public static void writePid(String filename, RuntimeMXBean bean) {
    try {
      FileWriterGateway writer = new FileWriterGateway(filename);
      writePid(writer, bean);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void writePid(FileWriterGateway facade, RuntimeMXBean bean) {
    try {
      writePidtoFile(facade, bean);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private
  static void writePidtoFile(FileWriterGateway facade, RuntimeMXBean bean)
  throws IOException {
    try {
      String runtimeName = bean.getName();
      facade.write(runtimeName.substring(0, runtimeName.indexOf('@')));
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
    finally {
      facade.close();
    }
  }
}
