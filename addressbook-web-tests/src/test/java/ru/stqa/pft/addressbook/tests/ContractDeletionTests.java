package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

public class ContractDeletionTests extends TestBase {

  @Test

  public void testContractDeletion() {

    if(! app.getContractHelper().isThereAContract()) {
      app.getContractHelper().createContract(new ContractData("Cezary", "Klarecki", "696995552", "cezary.klarecki@gmail.com", "test1"));

    }
    app.getContractHelper().selectContract();
    app.getContractHelper().initContractDeletion();
    app.getContractHelper().submitContractDeletion();


  }


}
