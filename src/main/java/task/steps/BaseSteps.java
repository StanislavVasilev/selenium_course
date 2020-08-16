package task.steps;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import task.managers.DriverManager;

public class BaseSteps {

  @Attachment(type = "image/png", value = "Screenshot")
  public static byte[] takeScreenshot() {
    return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
  }

}
