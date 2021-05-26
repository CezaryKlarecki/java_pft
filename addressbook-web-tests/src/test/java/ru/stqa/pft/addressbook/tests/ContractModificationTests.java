package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;
import ru.stqa.pft.addressbook.model.Contracts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContractModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contract().all().size() == 0) {
      app.contract().create(new ContractData().withLastname("Cezary").
              withFirstname("Klarecki").withHomePhone("6969955522").withMobilePhone("222").
              withWorkPhone("333").withEmail("ck@fh.pl").withGroup("[none]"));
    }
  }

  @Test
  public void testContractModification() {
    Contracts before = app.contract().all();
    ContractData modifiedContract = before.iterator().next();
    ContractData contract = new ContractData()
            .withId(modifiedContract.getId()).withLastname("Klareckii").withFirstname("Cezary 5")
            .withHomePhone("6969955522").withMobilePhone("333").withWorkPhone("555").withEmail("ck@fh.pl").withGroup("[none]");
    app.contract().modify(contract);
    assertEquals(app.contract().count(), before.size());
    Contracts after = app.contract().all();
    assertThat(after, equalTo(before.without(modifiedContract).withAdded(contract)));
  }


}
