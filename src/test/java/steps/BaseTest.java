package steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import task.managers.InitManager;
import task.steps.BaseSteps;

public class BaseTest {

  @Before
  public void getStart() {
    InitManager.init();
  }

  @After
  public void after(Scenario scenario) {
    if (scenario.isFailed()) {
      BaseSteps.takeScreenshot();
    }
    InitManager.stopFramework();
  }


}
