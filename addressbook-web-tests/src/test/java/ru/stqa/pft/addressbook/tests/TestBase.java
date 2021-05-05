package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;


public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }


}
