package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class ContractDeletionTests extends TestBase {

  @Test

  public void testContractDeletion() {
    app.getContractHelper().selectContract();
    app.getContractHelper().initContractDeletion();
    app.getContractHelper().submitContractDeletion();


  }


}
