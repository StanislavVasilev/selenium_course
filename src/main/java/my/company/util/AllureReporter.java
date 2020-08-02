package my.company.util;

import io.qameta.allure.junit4.AllureJunit4;
import my.company.steps.BaseSteps;
import org.junit.runner.notification.*;

public class AllureReporter extends AllureJunit4 {

  public AllureReporter() {
    super();
  }

  @Override
  public void testFailure(Failure failure) {
    BaseSteps.takeScreenshot();
    super.testFailure(failure);
  }

}
