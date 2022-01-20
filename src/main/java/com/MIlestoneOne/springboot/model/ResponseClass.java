package com.MIlestoneOne.springboot.model;


// response class for returning only returning some attributes.
public class ResponseClass {
    private String First;
    private String Last;
    private String email;
    private int MobileNo;


    public ResponseClass(User u)
    {
     First=u.getFirstName();
     Last=u.getLastName();
     MobileNo=u.getMobileNumber();
     email=u.getEmailID();
    }

    public String getEmail() {
        return email;
    }

    public int getMobileNo() {
        return MobileNo;
    }

    public String getFirst() {
        return First;
    }

    public String getLast() {
        return Last;
    }

    public void setFirst(String first) {
        First = first;
    }

    public void setLast(String last) {
        Last = last;
    }

    public void setMobileNo(int mobileNo) {
        MobileNo = mobileNo;
    }
}
