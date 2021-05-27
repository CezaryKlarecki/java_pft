package ru.stqa.pft.addressbook.model;

import java.util.Objects;
import java.util.PrimitiveIterator;

public class ContractData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String home;
  private String mobile;
  private String work;
  private String email;
  private String group;
  private String allPhones;
  private String allAddresses;
  private String primaryAddress;
  private String secondaryAddress;







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

