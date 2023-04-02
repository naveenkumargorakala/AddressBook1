package com.bridgelabz.AddressBook;
import java.util.Scanner;
public class AddressBookMain {
    AddressBook addresBook1 = new AddressBook();

    public void processOfContact() {
        Scanner object = new Scanner(System.in);
        System.out.println("1.Add contact \n 2.edit contact \n 3.show contact \n 4.delete contact \n 5.exit");
        {
            System.out.println("Enter your choice:  ");
            int choice = object.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add contact details...");
                    addresBook1.addDetails();
                    processOfContact();
                    break;
                case 2:
                    System.out.println("Edit contact details...");
                    addresBook1.edit();
                    processOfContact();
                    break;
                case 3:
                    addresBook1.displayContact();
                    processOfContact();
                    break;
                case 4:
                    System.out.println("delete contact in AddressBook");
                    System.out.println("enter firstName");
                    String name = object.next();
                    addresBook1.delete(name);
                    break;
                case 5:
                    addresBook1.addMultipleContacts();
                    break;
                case 6:
                    System.out.println("exit addressbook");
                    break;
            }
        }
    }
    public static void main(String args[]) {
        System.out.println("###  Welcome to Addressbook System  ###");
        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.processOfContact();
    }
}

