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

public class ContractDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contracts().size() == 0) {
      app.contract().create(new ContractData().withLastname("Cezary").
              withFirstname("Klarecki").withHomePhone("6969955522").withMobilePhone("222").
              withWorkPhone("333").withEmail("ck@fh.pl").withGroup("[none]"));
    }
  }

  @Test
  public void testContractDeletion() {
    Contracts before = app.db().contracts();
    ContractData deletedContract = before.iterator().next();
    app.contract().delete(deletedContract);
    assertEquals(app.contract().count(), before.size() - 1);
    Contracts after = app.db().contracts();
    assertThat(after, equalTo(before.without(deletedContract)));
    verifyContractListInUI();

  }
}
