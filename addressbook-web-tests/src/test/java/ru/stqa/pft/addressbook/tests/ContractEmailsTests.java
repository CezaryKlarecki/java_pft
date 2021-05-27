package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContractEmailsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contract().all().size() == 0) {
      app.contract().create(new ContractData().withFirstname("Cezary").withLastname("Klarecki").withHomePhone("1111").withEmail("sd@dsf.pl").withEmail2("dfs@gds.pl").withEmail3("asdas@hfd.com"));
    }
  }

  @Test
  public void testContractEmails() {
    app.goTo().goToHomePage();
    ContractData contract = app.contract().all().iterator().next();
    ContractData contractInfoFromEditForm = app.contract().infoFromEditForm(contract);
    assertThat(contract.getAllEmails(), equalTo(mergeEmails(contractInfoFromEditForm)));
  }

  private String mergeEmails(ContractData contract) {
    return Arrays.asList(contract.getEmail(), contract.getEmail2(), contract.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContractEmailsTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email) {
    return email.replaceAll("\\s", "").replaceAll("[-()]", "");
  }


}
