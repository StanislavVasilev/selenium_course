package managers;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {
  public final Properties properties = new Properties();

  private PropertyManager INSTANCE = null;


  public PropertyManager getProperty() {
    try {
      properties.load(new FileInputStream("src/main/resources" +
              System.getProperty("env", "application") + ".environment"));
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

  public String getProperty(String key, String value){
    return properties.getProperty(key, value);
  }

  public String getProperty(String key){
    return properties.getProperty(key);
  }
}
