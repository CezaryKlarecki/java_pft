package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContractViewPageTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contract().all().size() == 0) {
      app.contract().create(new ContractData().withFirstname("Cezary").withLastname("Klarecki")
              .withHomePhone("1111").withMobilePhone("111").withWorkPhone("444").withEmail("asds@wp.pl")
              .withEmail2("gdgd@dfs.com").withEmail3("sadsa").withPrimaryAddress("Warszawa"));
    }
  }


  @Test
  public void testContractViewPage(){
    app.goTo().goToHomePage();
    ContractData contract = app.contract().all().iterator().next();
    ContractData contractInfoFromViewPage = app.contract().infoFromViewPage(contract);
    assertThat(mergeContractInfo(contract), equalTo(contractInfoFromViewPage));
  }

  private String mergeContractInfo(ContractData contract) {
    return Arrays.asList(contract.getFirstname(), contract.getLastname(),contract.getPrimaryAddress(),contract.getHomePhone()
            ,contract.getMobilePhone(),contract.getWorkPhone(),contract.getEmail(),contract.getEmail2(),contract.getEmail3())
            .stream().filter((s) -> s != null && !s.equals(""))
            .map(ContractViewPageTests::cleaned)
            .collect(Collectors.joining("\n"));

  }
  public static String cleaned(String info){

    return info.replaceAll("\\s", "").replaceAll("[-()]","");
  }

}
