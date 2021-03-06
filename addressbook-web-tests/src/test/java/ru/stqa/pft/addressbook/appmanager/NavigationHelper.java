package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {

    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }

    click(By.linkText("groups"));

  }
  public void groupPageAgain() {

    if (isElementPresent(By.name("MainForm"))){
      return;
    }
    click(By.xpath("//div[@id='content']/div"));
    click(By.linkText("group page"));
}
  public void goToHomePage() {

    if (isElementPresent(By.name("MainForm"))){
      return;
    }
    click(By.linkText("home"));
  }
}

