package com.bridgelabz.AddressBook;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class AddressBookMain {
    ContactBook contactBook = new ContactBook();

    public void AddressBook() {
        Scanner object = new Scanner(System.in);
        System.out.println("1.Add contact \n 2.edit contact \n 3.show contact \n 4.delete contact \n 5.add multiple contacts \n 6.exit"  );
        {
            System.out.println("Enter your choice:  ");
            int choice = object.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add contact details...");

                    contactBook.addDetails();
//                    Map<String, person> addressBookMap = new HashMap<>();
                    AddressBook();
                    break;
                case 2:
                    System.out.println("Edit contact details...");
                    contactBook.edit();
                    AddressBook();
                    break;
                case 3:
                    contactBook.displayContact();
                    AddressBook();
                    break;
                case 4:
                    System.out.println("delete contact in AddressBook");
                    System.out.println("enter firstName");
                    String name = object.next();
                    contactBook.delete(name);
                    AddressBook();
                    break;
                case 5:
                    contactBook.addMultipleContacts();
                    AddressBook();
                    break;
                case 6:
                    System.out.println("exit addressbook");
                    break;
            }
        }
    }
    public static void main(String args[]) {
        Map<String,ContactBook> AddressBookMap = new HashMap<>();
        System.out.println("###  Welcome to Addressbook System  ###");
        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.AddressBook();
        ContactBook friendsBook=new ContactBook();
        AddressBookMap.put("friendsBook",friendsBook);
        ContactBook familyBook = new ContactBook();
        AddressBookMap.put("familyBook",familyBook);
           }
}

