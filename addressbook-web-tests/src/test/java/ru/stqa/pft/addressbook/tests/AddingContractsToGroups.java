package ru.stqa.pft.addressbook.tests;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hibernate.Session;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;
import ru.stqa.pft.addressbook.model.Contracts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddingContractsToGroups extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().contracts().size() == 0) {
      app.contract().create(new ContractData().withLastname("Cezary").
              withFirstname("Klarecki").withHomePhone("6969955522").withMobilePhone("222").
              withWorkPhone("333").withEmail("ck@fh.pl"));
    }
  }
  @BeforeMethod
  public void ensurePreconditions2() {

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
      app.goTo().groupPageAgain();
    }
  }


  @Test

  public void testAddingContractsToGroups(ContractData contract) throws Exception{
   // Contracts before = app.db().contracts();

    app.goTo().goToHomePage();
    app.contract().selectContractById(contract.getId());
    app.contract().addToGroup();
    app.contract().goToSelectedGroupPage(contract.getId());
    //Contracts after = app.db().contracts();
   // assertThat(after, equalTo(before.withAdded(contract)));
    verifyContractListInUI();
   // System.out.println(contract.getGroups());




  }
}