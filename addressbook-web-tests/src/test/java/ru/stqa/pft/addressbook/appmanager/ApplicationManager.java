package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ApplicationManager {

  private final Properties properties;
  private WebDriver wd;
  private ContractHelper contractHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private String browser;
  private DbHelper dbHelper;



  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");

    properties.load(new FileReader(new File(String.format ("src/test/resources/%s.properties", target))));
    dbHelper = new DbHelper();
  if (browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)){
    wd = new ChromeDriver();
  }
  else if (browser.equals(BrowserType.IE)){
    wd = new InternetExplorerDriver();
  }

    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    wd.get(properties.getProperty("web.baseUrl"));
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
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

  public ContractHelper contract() {
    return contractHelper;
  }

  public DbHelper db() {
    return dbHelper;
  }

}
