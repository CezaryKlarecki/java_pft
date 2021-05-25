package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.time.Duration;

public class ApplicationManager {

  private WebDriver wd;
  private ContractHelper contractHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private String browser;
  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
  if (browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)){
    wd = new ChromeDriver();
  }
  else if (browser.equals(BrowserType.IE)){
    wd = new InternetExplorerDriver();
  }

    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    wd.get("http://localhost:8080/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
    contractHelper = new ContractHelper(wd);
  }


  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void stop() {
    logout();
    wd.quit();
  }


  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public ContractHelper getContractHelper() {
    return contractHelper;
  }
}
