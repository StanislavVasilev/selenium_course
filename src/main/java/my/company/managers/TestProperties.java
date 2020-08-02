package my.company.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
  private final Properties properties = new Properties();
  private static TestProperties INSTANCE = null;

  private TestProperties() {
    try {
      properties.load(new FileInputStream(new File("src/main/resources/" +
              System.getProperty("env", "environment") + ".properties")));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static TestProperties getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new TestProperties();
    }
    return INSTANCE;
  }

  public String getProperty(String param, String value) {
    return properties.getProperty(param, value);
  }

  public String getProperty(String param) {
    return properties.getProperty(param);
  }
}
