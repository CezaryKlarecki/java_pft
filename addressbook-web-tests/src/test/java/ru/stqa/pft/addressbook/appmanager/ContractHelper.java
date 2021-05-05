package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContractData;

public class ContractHelper extends HelperBase {

  public ContractHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.xpath("//table[@id='maintable']/tbody/tr/th[3]"));
  }

  public void submitContractCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillFirstnameField(ContractData contractData) {

    type(By.name("firstname"), contractData.getFirstname());
    type(By.name("lastname"), contractData.getLastname());
    type(By.name("home"), contractData.getHomephone());
    type(By.name("email"), contractData.getEmail());
  }

  public void initCreateContract() {
    click(By.linkText("add new"));
  }

  public void selectContract() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }

  public void initContractModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
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

}
