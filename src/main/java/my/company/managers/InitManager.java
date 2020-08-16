package my.company.managers;

import java.util.concurrent.TimeUnit;

public class InitManager {
  public static TestProperties properties = TestProperties.getInstance();

  public static void setUp() {
    DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    DriverManager.getDriver().manage().window().maximize();
    DriverManager.getDriver().get(properties.getProperty("app.url"));
  }

  public static void quitFramework() {
    DriverManager.stopDriver();
  }
}
