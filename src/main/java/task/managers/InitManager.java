package task.managers;

import java.util.concurrent.TimeUnit;

public class InitManager {
  private final static PropertyManager property = new PropertyManager().getInstance();

  public void init() {
    DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    DriverManager.getDriver().manage().window().maximize();
    DriverManager.getDriver().get(property.getProperty("base.url"));
  }

  public void stopFramework() {
    DriverManager.stopDriver();
  }
}
