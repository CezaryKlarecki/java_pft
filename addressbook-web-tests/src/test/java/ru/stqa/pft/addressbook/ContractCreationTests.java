package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
//import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContractCreationTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/addressbook/index.php");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContractCreation() throws Exception {

    initCreateContract();
    fillFirstnameField(new ContractData("Cezary", "Klarecki", "696995552", "cezary.klarecki@gmail.com"));
    // wd.findElement(By.name("theform")).click();
    submitContractCreation();
    returnToHomePage();
      }

  private void returnToHomePage() {
    wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr/th[3]")).click();
  }

  private void submitContractCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void fillFirstnameField(ContractData contractData) {

    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contractData.getFirstname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contractData.getLastname());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(contractData.getHomephone());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contractData.getEmail());
  }

  private void initCreateContract() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    logout();
    wd.quit();
    }

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
 }
