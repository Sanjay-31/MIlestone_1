package com.MIlestoneOne.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_Name")
    private String userName;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "mobile_number")
    private int mobileNumber;

    @Column(name = "email_ID")
    private String emailID;

    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    public void setUserName(String user) {
        userName=user;
    }
    public void setFirstName(String first) {
        firstName=first;
    }
    public void setLastName(String last) {
        lastName=last;
    }
    public void setMobileNumber(int number) {
        mobileNumber=number;
    }
    public void setEmailID(String email) {
        emailID=email;
    }
    public void setAddress1(String newaddress1) {
        address1=newaddress1;
    }
    public void setAddress2(String newaddress2) {
        address2=newaddress2;
    }

//    public long getUSerID(){return  id;}
    public String getUserName()
    {
        return userName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getEmailID()
    {
        return emailID;
    }
    public int getMobileNumber()
    {
        return mobileNumber;
    }
    public String getAddress1()
    {
        return address1;
    }
    public String getAddress2()
    {
        return address2;
    }



}
