package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContractData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String homephone;
  private final String email;
  private String group;



  public ContractData(String firstname, String lastname, String homephone, String email, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.homephone = homephone;
    this.email = email;
    this.group = group;
  }


  public ContractData(int id, String firstname, String lastname, String homephone, String email, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.homephone = homephone;
    this.email = email;
    this.group = group;
  }

  public void setId(int id) {
    this.id = id;
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
    return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }
}
