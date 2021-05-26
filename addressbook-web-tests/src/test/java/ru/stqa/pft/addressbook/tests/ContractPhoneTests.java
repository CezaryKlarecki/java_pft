package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;

public class ContractPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contract().all().size() == 0) {
      app.contract().create(new ContractData().withFirstname("Cezary").withLastname("Klarecki").withHomePhone("1111"));
    }
  }


  @Test
  public void testContractPhones(){
    app.goTo().goToHomePage();
    ContractData contract = app.contract().all().iterator().next();
    ContractData contractInfoFromEditForm = app.contract().infoFromEditForm(contract);

  }

}
