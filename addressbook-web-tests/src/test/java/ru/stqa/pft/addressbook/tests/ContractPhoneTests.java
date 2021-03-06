package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContractPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contract().all().size() == 0) {
      app.contract().create(new ContractData().withFirstname("Cezary")
              .withLastname("Klarecki").withHomePhone("1111").withMobilePhone("222").withWorkPhone("3333"));
    }
  }


  @Test
  public void testContractPhones(){
    app.goTo().goToHomePage();
    ContractData contract = app.contract().all().iterator().next();
    ContractData contractInfoFromEditForm = app.contract().infoFromEditForm(contract);
    assertThat(contract.getAllPhones(), equalTo(mergePhones(contractInfoFromEditForm)));

  }

  private String mergePhones(ContractData contract) {
    return Arrays.asList(contract.getHomePhone(),contract.getMobilePhone(),contract.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContractPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));

    }


  public static String cleaned(String phone){

    return phone.replaceAll("\\s", "").replaceAll("[-()]","");
  }

}
