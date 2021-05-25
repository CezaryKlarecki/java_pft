package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.Comparator;
import java.util.List;

public class ContractDeletionTests extends TestBase {

  @Test(enabled = false)

  public void testContractDeletion() {

    if(! app.getContractHelper().isThereAContract()) {
      app.getContractHelper().createContract(new ContractData("Cezary", "Klarecki", "696995552", "cezary.klarecki@gmail.com", "test1"));

    }
    List<ContractData> before = app.getContractHelper().getContractList();
    app.getContractHelper().selectContract(before.size() - 1);
    app.getContractHelper().initContractDeletion();
    app.getContractHelper().submitContractDeletion();
    app.getContractHelper().returnToHomePage();
    List<ContractData> after = app.getContractHelper().getContractList();
    Assert.assertEquals(after.size(), before.size() - 1);


    before.remove(before.size() - 1);
    Comparator<? super ContractData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before, after);
  }


}
