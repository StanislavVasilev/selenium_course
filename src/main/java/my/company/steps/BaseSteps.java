package my.company.steps;

import my.company.util.TestProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {


  protected static WebDriver driver;
  protected static String baseUrl;
  public static Properties properties = TestProperties.getInstance().getProperties();

  @BeforeClass
  public static void setUp() throws Exception {
    switch (properties.getProperty("browser")) {
      case "firefox":
        System.setProperty("webdriver.gecko.driver", "/src/test/resources");
        driver = new FirefoxDriver();
        break;
      default:
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
    }
    baseUrl = properties.getProperty("app.url");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @AfterClass
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
