package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContractAddressTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contract().all().size() == 0) {
      app.contract().create(new ContractData().withFirstname("Cezary").withLastname("Klarecki").withHomePhone("1111"));
    }
  }
  @Test
  public void testContractAddress(){
    app.goTo().goToHomePage();
    ContractData contract = app.contract().all().iterator().next();
    ContractData contractInfoFromEditForm = app.contract().infoFromEditForm(contract);
    assertThat(contract.getPrimaryAddress(), equalTo(contractInfoFromEditForm.getPrimaryAddress()));
  }

  private String mergeAdresses(ContractData contract) {
    return Arrays.asList(contract.getPrimaryAddress(),contract.getSecondaryAddress())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContractAddressTests::cleaned)
            .collect(Collectors.joining("\n"));

  }
  public static String cleaned(String address){

    return address.replaceAll("\\s", "").replaceAll("[-()]","");
  }

}
