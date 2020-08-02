package managers;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {
  public static Properties properties = new Properties();

  private PropertyManager INSTANCE = null;

  public PropertyManager getProperty() {
    try {
      properties.load(new FileInputStream("src/main/resources",
              properties.getProperty(("key", "value"), "environment"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public PropertyManager getINSTANCE() {
    if (INSTANCE == null) {
      INSTANCE = new PropertyManager();
    }
    return INSTANCE;
  }

}
