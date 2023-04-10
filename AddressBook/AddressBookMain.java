package com.bridgelabz.AddressBook;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
    Contact contact = new Contact();
    Scanner sc = new Scanner(System.in);
    HashMap<String, AddressBook> hashMap = new HashMap<String, AddressBook>();

    public void addAddressbook() {
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the AddressBook");
        String name = sc.next();
        if (hashMap.containsKey(name)) {
            System.out.println("Enter different name for the AddressBook");
            addAddressbook();
        } else {
            addressBook.setAddressbookName(name);
            hashMap.put(addressBook.getAddressbookName(), addressBook);
            System.out.println("Address book added!!");
        }
    }

    public void addContacts() {
        Contact person = new Contact();
        if (hashMap.isEmpty()) {
            System.out.println("Your address book is empty first please add new Addressbook");
            addAddressbook();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the addressbok in which you want to add contact: ");
        String name = sc.next();
        if (hashMap.containsKey(name)) {
            AddressBook temp = hashMap.get(name);
            System.out.println("Enter FirstName: ");
            String FirstName = sc.next();
            if (FirstName.equals(person.getFirstname())) {
                System.out.println("Contact Already Exists");
            } else {
                temp.AddContact();
            }
        }
    }

    public void Display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the addressbok in which you want to display contact: ");
        String name = sc.next();
        if (hashMap.containsKey(name)) {
            AddressBook temp = hashMap.get(name);
            temp.dispalyContacts();
        }
    }

    public void Delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the addressbok in which you want to Delete contact: ");
        String name = sc.next();
        if (hashMap.containsKey(name)) {
            AddressBook temp = hashMap.get(name);
            temp.deleteContact();
        }
    }

    public void Edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the addressbok in which you want to Edit contact: ");
        String name = sc.next();
        if (hashMap.containsKey(name)) {
            AddressBook temp = hashMap.get(name);
            temp.edit();
        }
    }

    public void displayAllAddressbook() {
        System.out.println("Displaying all addressbook");
        if (hashMap.isEmpty()) {
            System.out.println("Addressbook is empty");
        } else {
            System.out.println(hashMap);
        }
    }
    public void searchByCity(){
        System.out.println("Enter the Name Of City by Which you want Search");
        String  cityName = sc.next();
        List<Contact> cityList = new ArrayList<>();
        hashMap.values().stream().forEach(addressBook -> {
            cityList.addAll(addressBook.getContactBook().stream().filter(Contact ->
                    contact.getCity().equalsIgnoreCase(cityName)).collect(Collectors.toList()));
        });
    }
    public void searchByState(){
        System.out.println("Enter the Name Of State by Which you want Search");
        String  stateName = sc.next();
        List<Contact> stateList = new ArrayList<>();
        hashMap.values().stream().forEach(addressBook -> {
            stateList.addAll(addressBook.getContactBook().stream().filter(Contact ->
                    contact.getState().equalsIgnoreCase(stateName)).collect(Collectors.toList()));
        });
    }

    public static void main(String[] args) {
        System.out.println("***** Welcome to the Address Based System *****");
        AddressBookMain addressBSMain = new AddressBookMain();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1.Add contact\n 2.Edit\n 3.Display\n 4.DeleteContact\n5.displayAllAddressbook \n 6.addAddressbook \n 7.searchCity \n 8.searchState \n 9.exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    addressBSMain.addContacts();
                    break;
                case 2:
                    addressBSMain.Edit();
                    break;
                case 3:
                    addressBSMain.Display();
                    break;
                case 4:
                    addressBSMain.Delete();
                    break;
                case 5:
                    addressBSMain.displayAllAddressbook();
                case 6:
                    addressBSMain.addAddressbook();
                case 7:
                    addressBSMain.searchByCity();
                case 8:
                    addressBSMain.searchByState();
                case 9:
                    flag = false;
                    break;
                default:
                    System.out.println(option + "Enter s valid option");
                    break;
            }
        }
        System.out.println("exit");
    }
    List<Contact> cityDelhiList = new ArrayList<>();

        addressBookMap.values().stream().forEach(addressBook ->{
        cityDelhiList.addAll(addressBook.getContactList().
                stream().filter(contact ->  contact.getCity().equalsIgnoreCase("Kolkata")).collect(Collectors.toList()));
    });
}
