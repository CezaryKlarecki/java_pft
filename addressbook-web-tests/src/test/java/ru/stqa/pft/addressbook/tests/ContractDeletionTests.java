package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
public class ContractDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contract().list().size() == 0) {
      app.contract().create(new ContractData().withFirstname("Cezary").withLastname("Klarecki"));
    }
  }

  @Test
  public void testContractDeletion() {
    Set<ContractData> before = app.contract().all();
    ContractData deletedContract = before.iterator().next();
    app.contract().delete(deletedContract);
    Set<ContractData> after = app.contract().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContract);
    Assert.assertEquals(before, after);
  }
}
