package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContractData;
import org.testng.*;

public class ContractHelper extends HelperBase {

  public ContractHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContractCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContractForm(ContractData contractData, boolean creation) {

    type(By.name("firstname"), contractData.getFirstname());
    type(By.name("lastname"), contractData.getLastname());
    type(By.name("home"), contractData.getHomephone());
    type(By.name("email"), contractData.getEmail());
    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contractData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }


  }
  public void initCreateContract() {
    click(By.linkText("add new"));
  }

  public void selectContract() {
    click(By.name("selected[]"));
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

  public boolean isThereAContract() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }

  public void createContract(ContractData contract) {
   initCreateContract();
    fillContractForm(contract, true);
   submitContractCreation();
    returnToHomePage();
  }

  public int getContractCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
