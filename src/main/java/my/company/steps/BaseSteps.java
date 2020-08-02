package my.company.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Attachment;
import my.company.util.TestProperties;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

  protected static WebDriver driver;
  protected static String baseUrl;
  public static Properties properties = TestProperties.getInstance().getProperties();

  public static WebDriver getDriver() {
    if (driver == null) {
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
    }
    return driver;
  }

  /**
   * doc
   */
  @Before
  public static void setUp() {
    baseUrl = properties.getProperty("app.url");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(baseUrl);
  }

  @After
  public static void afterMethod() {
    driver.quit();
  }

  @Attachment(type = "image/png", value = "Screenshot")
  public static byte[] takeScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Attachment(type = "text/plain", value = "{0}")
  public static String saveTextLog(String attacheName, String message) {
    return message;
  }
}
