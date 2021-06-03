package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;
import java.util.PrimitiveIterator;
@XStreamAlias("contracts")
public class ContractData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstname;
  @Expose
  private String lastname;
  @Expose
  private String home;
  @Expose
  private String mobile;
  @Expose
  private String work;
  private String group;
  private String allPhones;
  private String allAddresses;
  private String primaryAddress;
  private String secondaryAddress;
  @Expose
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  private String allViewPageInfo;

  public File getPhoto() {
    return photo;
  }

  public ContractData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  private File photo;


  public ContractData withAllViewPageInfo(String allViewPageInfo) {
    this.allViewPageInfo = allViewPageInfo;
    return this;
  }

  public ContractData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContractData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContractData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContractData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContractData withAllAddresses(String allAddresses) {
    this.allAddresses = allAddresses;
    return this;
  }

  public ContractData withPrimaryAddress(String primaryAddress) {
    this.primaryAddress = primaryAddress;
    return this;
  }

  public ContractData withSecondaryAddress(String secondaryAddress) {
    this.secondaryAddress = secondaryAddress;
    return this;
  }

  public ContractData withId(int id) {
    this.id = id;
    return this;
  }

  public ContractData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContractData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContractData withHomePhone(String home) {
    this.home = home;
    return this;
  }

  public ContractData withMobilePhone(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContractData withWorkPhone(String work) {
    this.work = work;
    return this;
  }

  public ContractData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContractData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getAllViewPageInfo() {
    return allViewPageInfo;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getHomePhone() {
    return home;
  }

  public String getMobilePhone() {
    return mobile;
  }

  public String getWorkPhone() {
    return work;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAllAddresses() {
    return allAddresses;
  }

  public String getPrimaryAddress() {
    return primaryAddress;
  }

  public String getSecondaryAddress() {
    return secondaryAddress;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  @Override
  public String toString() {
    return "ContractData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContractData that = (ContractData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }


}

