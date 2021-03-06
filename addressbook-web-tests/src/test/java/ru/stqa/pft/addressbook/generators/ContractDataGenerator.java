package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContractData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;



public class ContractDataGenerator {

@Parameter(names = "-c", description = "Contract count")
  public int count;
@Parameter(names = "-f", description = "Target file")
public String file;
  @Parameter(names = "-d", description = "Data format")
  public String format;


  public static void main(String[]args) throws IOException {
    ContractDataGenerator generator = new ContractDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }catch(ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();

  }

  private void run() throws IOException {
    List<ContractData> contracts = generateContracts(count);
    if (format.equals("csv")) {
      saveAsCsv(contracts, new File(file));
    }
    else if (format.equals("xml")){
      saveAsXml(contracts, new File(file));
    }
    else if (format.equals("json")){
      saveAsJson(contracts, new File(file));
    }
    else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsJson(List<ContractData> contracts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contracts);
   try(Writer writer = new FileWriter(file)){
    writer.write(json);}

  }

  private void saveAsXml(List<ContractData> contracts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContractData.class);
    String xml = xstream.toXML(contracts);
    try(Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }


  }

  private void saveAsCsv(List<ContractData> contracts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    try(Writer writer = new FileWriter(file)) {
      for (ContractData contract : contracts) {
        writer.write(String.format("%s;%s:%s;%s;%s;%s", contract.getLastname()
                , contract.getFirstname(), contract.getHomePhone(), contract.getMobilePhone()
                , contract.getWorkPhone(), contract.getEmail()));
      }
    }
  }

  private List<ContractData> generateContracts(int count) {

    List<ContractData> contracts = new ArrayList<ContractData>();
    for(int i = 0; i< count; i++){
      contracts.add(new ContractData().withLastname(String.format("lastname %s", i)).withFirstname(String.format("firstname %s", i))
              .withHomePhone(String.format("home %s", i)).withMobilePhone(String.format("mobile %s", i))
              .withWorkPhone(String.format("work %s", i)).withEmail(String.format("email %s", i)));

    }
  return contracts;
  }
}
