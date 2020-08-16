package my.company.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
  private static WebDriver driver;
  private static final TestProperties properties = TestProperties.getInstance();

  public DriverManager() {
  }

  public static WebDriver initDriver() {
    switch (properties.getProperty("browser")) {
      case "firefox":
        System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
        driver = new FirefoxDriver();
        break;
      case "chrome":
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
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
