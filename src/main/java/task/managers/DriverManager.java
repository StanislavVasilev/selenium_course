package task.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
  private static final PropertyManager property = new PropertyManager().getInstance();
  private static WebDriver driver;

  private static WebDriver initDriver() {
    switch (property.getProperty("browser")) {
      case "firefox":
        System.setProperty("webdriver.gecko.driver", property.getProperty("webdriver.gecko.driver"));
        driver = new FirefoxDriver();
        break;
      default:
        System.setProperty("webdriver.chrome.driver", property.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        break;
    }
    return driver;
  }

  public static WebDriver getDriver() {
    if (driver == null) {
      initDriver();
    }
    return driver;
  }

  public static void stopDriver() {
    driver.quit();
    driver = null;
  }
}
