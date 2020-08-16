package my.company.steps;

import io.qameta.allure.Attachment;
import my.company.managers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseSteps {

  @Attachment(type = "image/png", value = "Screenshot")
  public static byte[] takeScreenshot() {
    return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
  }

  @Attachment(type = "text/plain", value = "{0}")
  public static String saveTextLog(String attacheName, String message) {
    return message;
  }
}
