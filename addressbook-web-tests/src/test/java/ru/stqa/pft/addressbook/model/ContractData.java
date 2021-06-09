package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;
import java.util.PrimitiveIterator;
@XStreamAlias("contracts")
@Entity
@Table(name ="addressbook")
public class ContractData {
  @XStreamOmitField
  @Id
  @Column(name="id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name="firstname")
  @Type(type ="text")
  private String firstname;
  @Expose
  @Column(name="lastname")
  @Type(type ="text")
  private String lastname;
  @Expose
  @Column(name="home")
  @Type(type ="text")
  private String home;
  @Expose
  @Column(name="mobile")
  @Type(type ="text")
  private String mobile;
  @Expose
  @Column(name="work")
  @Type(type ="text")
  private String work;
  @Transient
  private String group;
  @Transient
  private String allPhones;
  @Transient
  private String allAddresses;
  @Column(name="address")
  @Type(type ="text")
  private String primaryAddress;
  @Transient
  private String secondaryAddress;
  @Expose
  @Column(name="email")
  @Type(type ="text")
  private String email;
  @Column(name="email2")
  @Type(type ="text")
  private String email2;
  @Column(name="email3")
  @Type(type ="text")
  private String email3;
  @Transient
  private String allEmails;
  @Transient
  private String allViewPageInfo;
  @Column(name="photo")
  @Type(type ="mediumtext")
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }

  public ContractData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }



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

