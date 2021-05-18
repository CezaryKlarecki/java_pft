package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.List;

public class ContractModificationTests extends TestBase {

  @Test
  public void testContractModification() {

    if(! app.getContractHelper().isThereAContract()) {
      app.getContractHelper().createContract(new ContractData("Cezary", "Klarecki", "696995552", "cezary.klarecki@gmail.com", "test1"));
    }
    List<ContractData> before = app.getContractHelper().getContractList();
    app.getContractHelper().selectContract(before.size() - 1);
    app.getContractHelper().initContractModification();
    app.getContractHelper().fillContractForm(new ContractData("Cezary1", "Klarecki2", "6969955523", "cezary.klarecki@gmail.com4", null), false);
    app.getContractHelper().submitContractModification();
    app.getContractHelper().returnToHomePage();
    List<ContractData> after = app.getContractHelper().getContractList();
    Assert.assertEquals(after.size(), before.size());
  }
}
