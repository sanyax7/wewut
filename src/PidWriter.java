package wewut;

import java.lang.management.RuntimeMXBean;

import java.io.IOException;
import wewut.FileWriterGateway;

public class PidWriter {
  public static void writePid(String filename, RuntimeMXBean bean) {
    try {
      writePidtoFile(filename, bean);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private
  static void writePidtoFile(String filename, RuntimeMXBean bean)
  throws IOException {
    FileWriterGateway writer = new FileWriterGateway(filename);
    try {
      String runtimeName = bean.getName();
      writer.write(runtimeName.substring(0, runtimeName.indexOf('@')));
    }
    finally {
      writer.close();
    }
  }
}
