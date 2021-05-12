package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

public class ContractModificationTests extends TestBase {

  @Test
  public void testContractModification() {
    app.getContractHelper().selectContract();
    app.getContractHelper().initContractModification();
    app.getContractHelper().fillContractForm(new ContractData("Cezary1", "Klarecki2", "6969955523", "cezary.klarecki@gmail.com4", null), false);
    app.getContractHelper().submitContractModification();
    app.getContractHelper().returnToHomePage();

  }
}
