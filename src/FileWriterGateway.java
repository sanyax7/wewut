package wewut;

import java.io.IOException;
import java.io.FileWriter;

public class FileWriterGateway extends FileWriter {
  public static boolean disallowAccess = false;

  public FileWriterGateway(String filename) throws IOException {
    super(filename);
    if (disallowAccess) {
      throw new RuntimeException("access disallowed");
    }
  }
}
