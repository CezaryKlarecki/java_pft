package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.List;

public class ContractCreationTests extends TestBase {

  @Test
  public void testContractCreation() throws Exception {
    List<ContractData> before = app.getContractHelper().getContractList();
    app.getContractHelper().createContract(new ContractData("Cezary", "Klarecki", "696995552", "cezary.klarecki@gmail.com", "test1"));
    List<ContractData> after = app.getContractHelper().getContractList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
