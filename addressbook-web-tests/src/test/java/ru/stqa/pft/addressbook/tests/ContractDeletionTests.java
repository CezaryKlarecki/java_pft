package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

public class ContractDeletionTests extends TestBase {

  @Test

  public void testContractDeletion() {
    int before = app.getContractHelper().getContractCount();
    if(! app.getContractHelper().isThereAContract()) {
      app.getContractHelper().createContract(new ContractData("Cezary", "Klarecki", "696995552", "cezary.klarecki@gmail.com", "test1"));

    }
    app.getContractHelper().selectContract();
    app.getContractHelper().initContractDeletion();
    app.getContractHelper().submitContractDeletion();
    app.getContractHelper().returnToHomePage();
    int after = app.getContractHelper().getContractCount();
    Assert.assertEquals(after, before - 1);
  }


}
