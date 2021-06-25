package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

import java.io.IOException;

public class ChangingPasswordHelper extends HelperBase{
  public ChangingPasswordHelper (ApplicationManager app) {
    super(app);
    wd = app.getDriver();
  }
  public void reset(String confirmationLink) throws IOException {
    wd.get(app.getProperty("web.baseUrl"));
    wd.get(confirmationLink);
    String user = ("user1");
    String password = "password";
    app.newSession().login(user, password);
    click(By.linkText("Menage Users"));
    click(By.name(user));
    wd.findElement(By.cssSelector("input[value='Reset Password']")).click();
  }

  public void finish(String confirmationLink) {
    wd.get(confirmationLink);
    String newPassword = "password1";
    type(By.name("password"), newPassword);
    type(By.name("password_confirm"), newPassword);
    click(By.cssSelector("input[value='Update Password']"));
  }
}
