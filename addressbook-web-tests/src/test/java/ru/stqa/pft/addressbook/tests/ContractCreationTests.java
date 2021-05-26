package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;
import ru.stqa.pft.addressbook.model.Contracts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContractCreationTests extends TestBase {

  @Test
  public void testContractCreation() throws Exception {
    Contracts before = app.contract().all();
    ContractData contract = new ContractData().
            withLastname("Cezary").withFirstname("Klarecki").withHomePhone("6969955522").
            withMobilePhone("222").withWorkPhone("333").withEmail("ck@fh.pl").withGroup("[none]");
    app.contract().create(contract);
    assertThat(app.contract().count(), equalTo(before.size() + 1));
    Contracts after = app.contract().all();
    assertThat(after, equalTo(
            before.withAdded(contract.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
