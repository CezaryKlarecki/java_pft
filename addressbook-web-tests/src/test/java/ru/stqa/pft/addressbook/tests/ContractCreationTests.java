package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;
import ru.stqa.pft.addressbook.model.Contracts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContractCreationTests extends TestBase {

  @Test
  public void testContractCreation() throws Exception {
    Contracts before = app.contract().all();
    ContractData contract = new ContractData().withLastname("Cezary").withFirstname("Klarecki").withHomephone("6969955522").withEmail("ck@fh.pl").withGroup("[none]");
    app.contract().create(contract);
    Contracts after = app.contract().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contract.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
