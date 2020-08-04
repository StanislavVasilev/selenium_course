package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import task.managers.InitManager;

public class BaseTest {

  @Before
  public void getStart() {
    InitManager.init();
  }

  @After
  public void after() {
    InitManager.stopFramework();
  }


}
