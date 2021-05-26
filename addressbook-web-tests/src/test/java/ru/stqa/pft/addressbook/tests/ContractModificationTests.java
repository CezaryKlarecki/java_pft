package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContractModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contract().list().size() == 0) {
      app.contract().create(new ContractData().withLastname("Cezary").withFirstname("Klarecki").withHomephone("6969955522").withEmail("ck@fh.pl").withGroup("[none]"));
    }
  }

  @Test
  public void testContractModification() {
    Set<ContractData> before = app.contract().all();
    ContractData modifiedContract = before.iterator().next();
    ContractData contract = new ContractData()
            .withId(modifiedContract.getId()).withLastname("Klareckii").withFirstname("Cezary 5")
            .withHomephone("6969955522").withEmail("ck@fh.pl").withGroup("[none]");
    app.contract().modify(contract);
    Set<ContractData> after = app.contract().all();
    Assert.assertEquals(after.size(), before.size());



    before.remove(modifiedContract);
    before.add(contract);
    Assert.assertEquals(before, after);
  }


}
