package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

public class ContractCreationTests extends TestBase {

  @Test
  public void testContractCreation() throws Exception {

    app.getContractHelper().createContract (new ContractData("Cezary", "Klarecki", "696995552", "cezary.klarecki@gmail.com", "test1"));


  }

}
