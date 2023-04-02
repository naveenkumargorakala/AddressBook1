package com.bridgelabz.AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AddressBook {
    List<Person> contactList = new ArrayList<>();
    Person person = new Person();
    Scanner input = new Scanner(System.in);
    public void addDetails() {
//        String FirstName, LastName, Gmail, Address, City, State, Zipcode, PhoneNumber;

        System.out.println("FirstName: ");
        person.setFirstName(input.next());
        System.out.println("LastName: ");
        person.setLastName(input.next());
        System.out.println("Gmail: ");
        person.setGmail(input.next());
        System.out.println("Address: ");
        person.setAddress(input.next());
        System.out.println("City: ");
        person.setCity(input.next());
        System.out.println("State: ");
        person.setState(input.next());
        System.out.println("Zipcode: ");
        person.setZipcode(input.next());
        System.out.println("Phone: ");
        person.setPhoneNumber(input.next());
        System.out.println("Added Successfully contact");

        contactList.add(person);
    }

    public void displayContact() {
        System.out.println("contacts: "+contactList);
//        System.out.println("Enter firstName of Contact to display: ");
//        String FirstName = in.next();
//        boolean isPresent = false;
//        for(Person person:contactList){
//            if(person.getFirstName().equals(FirstName)){
//                isPresent = true;
//                System.out.println(person.toString());
//            }
//        }
//        if(isPresent){
//            System.out.println("No contact found!!!");
//        }
        // System.out.println("FirstName: "+person.getFirstName() +"\n LastName: "+person.getLastName() +"\n Gmail: "+person.getGmail()+"\n Address: "+person.getAddress() +"\n City: "+person.getCity() +"\n State: "+person.getState()+"\n ZipCode: "+person.getZipcode()+"\n PhoneNumber: "+person.getPhoneNumber());
    }

    public void edit() {
//        String FirstName, LastName, Gmail, Address, City, State, Zipcode, PhoneNumber;
        System.out.println("Enter the First Name to Edit : ");
        String FirstName = (input.next());
        boolean IsAvaible = false;

        for (int i = 0; i < contactList.size(); i++) {
            if (person.getFirstName().equals(FirstName)) {
                IsAvaible = true;
                System.out.println("Enter What you Want to edit:");
                System.out.println("1:FirstName,2:LastName,3:Gmail,4:Address,5:City,6:State,7:Zipcode,8:Phonenumber");

                String label = input.next();
                switch (label) {
                    case "1":
                        System.out.println("changed first name: ");
                        person.setFirstName(input.next());
                        System.out.println("FirstName updated");
                        break;
                    case "2":
                        System.out.println("lastname to change: ");
                        person.setLastName(input.next());
                        System.out.println("LastName updated");
                        break;
                    case "3":
                        System.out.println("gmail to change: ");
                        person.setGmail(input.next());
                        System.out.println("Gmail updated");
                        break;
                    case "4":
                        System.out.println("Address to change: ");
                        person.setAddress(input.next());
                        System.out.println("Address updated");
                        break;
                    case "5":
                        System.out.println("City to change: ");
                        person.setCity(input.next());
                        System.out.println("City updated");
                        break;
                    case "6":
                        System.out.println("State to change: ");
                        person.setState(input.next());
                        System.out.println("State updated");
                        break;
                    case "7":
                        System.out.println("Zipcode to change: ");
                        person.setZipcode(input.next());
                        System.out.println("Zipcode updated");
                        break;
                    case "8":
                        System.out.println("Phone number to change: ");
                        person.setPhoneNumber(input.next());
                        System.out.println("PhoneNUmber updated");
                        break;
                    default:
                        contactList.add(person);
                        System.out.println("Enter only 1 to 8 numbers");
                        break;
                }
            }
        }
        if (IsAvaible) {
            System.out.println("Contact Doesn't exist.");
        }
    }

    public void delete(String name) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the First Name to Delete Contact: ");
        String FirstName = (in.next());
        boolean IsAvaible = false;
        if (person.getFirstName().equals(FirstName)) {
            IsAvaible = true;
            contactList.remove(person);
        }
    }
    void addMultipleContacts(){
        System.out.println("Enter the number of person whose details you want" +
                "to add to address book");
        int no_of_person = input.nextInt();
        for(int i=1; i<=no_of_person; i++){
//            call addition method for so many times
            addDetails();
        }
    }

}

