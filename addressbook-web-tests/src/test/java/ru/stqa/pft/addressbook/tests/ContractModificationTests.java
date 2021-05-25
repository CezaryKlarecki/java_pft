package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContractModificationTests extends TestBase {

  @Test(enabled = false)
  public void testContractModification() {

    if(! app.getContractHelper().isThereAContract()) {
      app.getContractHelper().createContract(new ContractData("Cezary", "Klarecki", "696995552", "cezary.klarecki@gmail.com", "test1"));
    }
    List<ContractData> before = app.getContractHelper().getContractList();
    int index = before.size() - 1;
    app.getContractHelper().selectContract(index);
    app.getContractHelper().initContractModification(index);
    ContractData contract = new ContractData(before.get(index).getId(), "Cezary7", "Klarecki7", "696995554", "cezarys.klarecki@gmail.com", "tests");
    app.getContractHelper().fillContractForm(contract, false);
    app.getContractHelper().submitContractModification();
    app.getContractHelper().returnToHomePage();
    List<ContractData> after = app.getContractHelper().getContractList();
    Assert.assertEquals(after.size(), before.size());


    before.remove(index);
    before.add(contract);
    Comparator<? super ContractData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before,after);}
    }
