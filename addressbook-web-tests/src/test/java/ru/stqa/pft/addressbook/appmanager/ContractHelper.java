package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContractData;
import org.testng.*;
import ru.stqa.pft.addressbook.model.Contracts;

import java.util.List;

public class ContractHelper extends HelperBase {

  public ContractHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContractCreation() {
    click(By.name("submit"));
  }

  public void fillContractForm(ContractData contractData, boolean creation) {

    type(By.name("firstname"), contractData.getFirstname());
    type(By.name("lastname"), contractData.getLastname());
    type(By.name("home"), contractData.getHomePhone());
    type(By.name("mobile"), contractData.getMobilePhone());
    type(By.name("work"), contractData.getWorkPhone());
    type(By.name("email"), contractData.getEmail());
    attach(By.name("photo"), contractData.getPhoto());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contractData.getGroup());
    }
    else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }


  }

  public void initCreateContract() {
    click(By.linkText("add new"));
  }

  public void selectContract(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void selectContractById(int id) {

    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

  }

  public void initContractModification(int index) {
    click(By.xpath("//table[@id='maintable']/tbody/tr[" + index + "]/td[8]/a/img"));
  }

  public void initContractModificationById(int id) {
    //  wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

  }
  public void initViewPageById(int id) {
   // WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
   // WebElement row = checkbox.findElement(By.xpath("./../.."));
   // List<WebElement> cells = row.findElements(By.tagName("td"));
   // cells.get(6).findElement(By.tagName("a")).click();
    wd.findElement(By.cssSelector("a[href='view.php?id=" + id + "']")).click();

  }
  public void submitContractModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void initContractDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void submitContractDeletion() {
    wd.switchTo().alert().accept();
  }

  public boolean isThereAContract() {
    return isElementPresent(By.name("selected[]"));
  }

  public ContractData infoFromEditForm(ContractData contract) {
    initContractModificationById(contract.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    //String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    wd.navigate().back();
    return new ContractData().withId(
            contract.getId()).withLastname(lastname).withFirstname(firstname).withPrimaryAddress(address)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3);
  }

  public void create(ContractData contract) {
    initCreateContract();
    fillContractForm(contract, true);
    submitContractCreation();
    returnToHomePage();
    contractCache = null;

  }

  public void modify(ContractData contract) {
    selectContractById(contract.getId());
    initContractModificationById(contract.getId());
    fillContractForm(contract, false);
    submitContractModification();
    returnToHomePage();
    contractCache = null;

  }

  public void delete(int index) {
    selectContract(index);
    initContractDeletion();
    submitContractDeletion();
    returnToHomePage();


  }

  public void delete(ContractData contract) {
    selectContractById(contract.getId());
    initContractDeletion();
    submitContractDeletion();
    returnToHomePage();
    contractCache = null;

  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contracts contractCache = null;

  public Contracts all() {
    if (contractCache != null) {
      return new Contracts(contractCache);
    }
    contractCache = new Contracts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement element : rows) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String allPhones = cells.get(5).getText();
      String address = cells.get(3).getText();
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String allEmails = cells.get(4).getText();
      contractCache.add(new ContractData().withId(id)
              .withFirstname(firstname).withLastname(lastname).withPrimaryAddress(address).withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return new Contracts(contractCache);
  }


  public ContractData infoFromViewPage(ContractData contract) {
    initViewPageById(contract.getId());
    String contractInfoFromViewPage = wd.findElement(By.xpath("//div[@id='content']")).getText();
    return new ContractData().withAllViewPageInfo(contractInfoFromViewPage);

}}
