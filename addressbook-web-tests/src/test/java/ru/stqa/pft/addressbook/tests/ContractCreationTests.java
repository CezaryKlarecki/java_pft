package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
public class ContractCreationTests extends TestBase {

  @Test
  public void testContractCreation() throws Exception {
    Set<ContractData> before = app.contract().all();
    ContractData contract = new ContractData().withLastname("Cezary").withFirstname("Klarecki").withHomephone("6969955522").withEmail("ck@fh.pl").withGroup("[none]");
    app.contract().create(contract);
    Set<ContractData> after = app.contract().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contract.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contract);
    Assert.assertEquals(before, after);


  }

}
