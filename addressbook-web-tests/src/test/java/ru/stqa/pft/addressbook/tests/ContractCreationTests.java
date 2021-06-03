package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractData;
import ru.stqa.pft.addressbook.model.Contracts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContractCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContractsFromXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contracts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContractData.class);
    List<ContractData> contracts = (List<ContractData>) xstream.fromXML(xml);
    return contracts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();

  }

  @DataProvider
  public Iterator<Object[]> validContractsFromJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contracts.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<ContractData> contracts = gson.fromJson(json, new TypeToken<List<ContractData>>() {}.getType());
    return contracts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();

  }
  @Test(dataProvider = "validContractsFromJson")
  public void testContractCreation(ContractData contract) throws Exception {
    Contracts before = app.contract().all();
    File photo = new File("src/test/resources/sru.png");
    app.contract().create(contract);
    assertThat(app.contract().count(), equalTo(before.size() + 1));
    Contracts after = app.contract().all();
    assertThat(after, equalTo(
            before.withAdded(contract.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }



}
