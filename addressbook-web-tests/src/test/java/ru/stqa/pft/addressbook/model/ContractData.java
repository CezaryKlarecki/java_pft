package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContractData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String homephone;
  private String email;
  private String group;


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

  public ContractData withHomephone(String homephone) {
    this.homephone = homephone;
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

  public String getHomephone() {
    return homephone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
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
