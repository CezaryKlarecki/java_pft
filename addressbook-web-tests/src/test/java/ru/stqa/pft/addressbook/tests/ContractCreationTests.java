package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContractCreationTests extends TestBase {

  @Test(enabled = false)
  public void testContractCreation() throws Exception {
    List<ContractData> before = app.getContractHelper().getContractList();
    ContractData contract = new ContractData("Cezary", "Klarecki", "696995552", "cezary.klarecki@gmail.com", "test1");
    app.getContractHelper().createContract(contract);
    List<ContractData> after = app.getContractHelper().getContractList();
    Assert.assertEquals(after.size(), before.size() + 1);



    //contract.setId(after.stream().max((Comparator<ContractData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contract);
    Comparator<? super ContractData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before.size(), after.size());




  }

}
