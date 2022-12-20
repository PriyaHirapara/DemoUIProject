package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseReader {

  public static Properties prop;

  static {
    try {
      String path = "src/configuration.properties";
      FileInputStream input = new FileInputStream(path);
      prop = new Properties();
      prop.load(input);
      input.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String get(String KeyName) {
    return prop.getProperty(KeyName);
  }
}
