package com.bridgelabz.AddressBook;
import java.util.*;
public class Person {

    private String FirstName;
    private String LastName;
    private String Gmail;
    private String Address;
    private String City;
    private String State;
    private String Zipcode;
    private String PhoneNumber;
    public Person() {

    }
    public Person(String firstName, String lastName, String gmail, String address, String city, String state, String zipcode, String phnNumber) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Gmail = gmail;
        this.Address = address;
        this.City = city;
        this.State = state;
        this.Zipcode = zipcode;
        this.PhoneNumber = phnNumber;
    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Gmail='" + Gmail + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Zipcode='" + Zipcode + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}

