package com.bridgelabz.AddressBook;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class AddresBook {
    public int contactId;
    List<Person> list1 = new ArrayList<>();
    Person person = new Person();
    public void addDetails() {
        String FirstName, LastName, Gmail, Address, City, State, Zipcode, PhoneNumber;
        Random generatingId = new Random();//Using random function to generate contact id
        Scanner in = new Scanner(System.in);
        System.out.println("FirstName: ");
        person.setFirstName(in.next());
        System.out.println("LastName: ");
        LastName = in.next();
        person.setLastName(LastName);
        System.out.println("Gmail: ");
        Gmail = in.next();
        person.setGmail(Gmail);
        System.out.println("Address: ");
        Address = in.next();
        person.setAddress(Address);
        System.out.println("City: ");
        City = in.next();
        person.setCity(City);
        System.out.println("State: ");
        State = in.next();
        person.setState(State);
        System.out.println("Zipcode: ");
        Zipcode = in.next();
        person.setZipcode(Zipcode);
        System.out.println("Phone: ");
        PhoneNumber = in.next();
        person.setPhoneNumber(PhoneNumber);
        System.out.println("Added Successfully contact");

        list1.add(person);
    }
        private int getContactIndex(String name) {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).getFirstName().equals(name)) {
                    return i;
                }
            }
            return -1;
        }

    public void displayContact(){
        System.out.println("FirstName: "+person.getFirstName() +"\n LastName: "+person.getLastName() +"\n Gmail: "+person.getGmail()+"\n Address: "+person.getAddress() +"\n City: "+person.getCity() +"\n State: "+person.getState()+"\n ZipCode: "+person.getZipcode()+"\n PhoneNumber: "+person.getPhoneNumber());
    }
    public void edit() {
        String FirstName, LastName, Gmail, Address, City, State, Zipcode, PhoneNumber;
        Person person =new Person();
        System.out.println("Enter What you Want to edit:");
        System.out.println("1:FirstName,2:LastName,3:Gmail,4:Address,5:City,6:State,7:Zipcode,8:Phonenumber");
        Scanner in = new Scanner(System.in);
        String label = in.next();
        switch (label) {
            case "1":
                System.out.println("changed first name: ");
                FirstName = in.next();
                person.setFirstName(FirstName);
                System.out.println("FirstName updated");
                break;
            case "2":
                System.out.println("lastname to change: ");
                LastName = in.next();
                person.setLastName(LastName);
                System.out.println("LastName updated");
                break;
            case "3":
                System.out.println("gmail to change: ");
                Gmail = in.next();
                person.setGmail(Gmail);
                System.out.println("Gmail updated");
                break;
            case "4":
                System.out.println("Address to change: ");
                Address = in.next();
                person.setAddress(Address);
                System.out.println("Address updated");
                break;
            case "5":
                System.out.println("City to change: ");
                City = in.next();
                person.setCity(City);
                System.out.println("City updated");
                break;
            case "6":
                System.out.println("State to change: ");
                State = in.next();
                person.setState(State);
                System.out.println("State updated");
                break;
            case "7":
                System.out.println("Zipcode to change: ");
                Zipcode = in.next();
                person.setZipcode(Zipcode);
                System.out.println("Zipcode updated");
                break;
            case "8":
                System.out.println("Phone number to change: ");
                PhoneNumber = in.next();
                person.setPhoneNumber(PhoneNumber);
                System.out.println("PhoneNUmber updated");
                break;
            default:
                list1.add(person);
                System.out.println("Enter only 1 to 8 numbers");
        }
    }

}