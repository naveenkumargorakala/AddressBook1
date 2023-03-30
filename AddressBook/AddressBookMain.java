package com.bridgelabz.AddressBook;
import java.util.Scanner;
public class AddressBookMain {
    static Scanner object = new Scanner(System.in);
    Person contacts = new Person();//created object of class Contacts

    public static void main(String args[]) {
        AddresBook addresBook1=new AddresBook();
        AddressBookMain main = new AddressBookMain();
        System.out.println("1.Add contact \n 2.edit contact \n 3.show contact \n 4.exit");
        {
            System.out.println("Enter your choice:  ");
            int choice = object.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Add contact details...");
                    addresBook1.addDetails();
                break;
                case 2:
                    System.out.println("Edit contact details...");
                    addresBook1.edit();
                break;
                case 3:
                    addresBook1.displayContact();
                break;
                case 4:
                    System.out.println("delete contact in AddressBook");
                    System.out.println("enter firstName");
                    String name = object.next();
                    addresBook1.delete(name);
                break;
            }
        }
    }
}

