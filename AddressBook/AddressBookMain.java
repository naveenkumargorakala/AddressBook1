package com.bridgelabz.AddressBook;
import java.io.*;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
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

    public void searchByCity() {
        System.out.println("Enter the Name Of City by Which you want Search");
        String cityName = sc.next();
        List<Contact> cityList = new ArrayList<>();
        hashMap.values().stream().forEach(addressBook -> {
            cityList.addAll(addressBook.getContactBook().stream().filter(Contact ->
                    contact.getCity().equalsIgnoreCase(cityName)).collect(Collectors.toList()));
        });
    }

    public void searchByState() {
        System.out.println("Enter the Name Of State by Which you want Search");
        String stateName = sc.next();
        List<Contact> stateList = new ArrayList<>();
        hashMap.values().stream().forEach(addressBook -> {
            stateList.addAll(addressBook.getContactBook().stream().filter(Contact ->
                    contact.getState().equalsIgnoreCase(stateName)).collect(Collectors.toList()));
        });
    }
    private void writeToFile() {
        String path = "E:\\RFP262Batch\\src\\com\\bridgelabz\\address_book.txt";
        StringBuffer addressBookBuffer = new StringBuffer();
        hashMap.values().stream().forEach(contact -> {
            String personDataString = contact.toString().concat("\n");
            addressBookBuffer.append(personDataString);
        });

        try {
            Files.write(Paths.get(path), addressBookBuffer.toString().getBytes());
        }
        catch (IOException e) {
            System.out.println("Catch block");
        }
    }

    private void readFromFile() {
        String path = "E:\\RFP262Batch\\src\\com\\bridgelabz\\address_book.txt";
        System.out.println("Reading from : " + path + "\n");
        try {
            Files.lines(new File(path).toPath()).forEach(employeeDetails -> System.out.println(employeeDetails));
        }
        catch(IOException e){
            System.out.println("Catch block");
        }
    }


    private void writetocsv() {
        String csvPath = "E:\\RFP262Batch\\src\\com\\bridgelabz\\AddressBook\\contact.csv";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(csvPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String[]> csvLines = new ArrayList<String[]>();
        CSVWriter writer = new CSVWriter(fileWriter);
        String[] header = {"FirstName","LastName","Address","City","State","zip code","phone number","Email"};
        writer.writeNext(header);
        hashMap.keySet().stream().forEach(bookName -> hashMap.get(bookName).getContactBook()
                .stream().forEach(person -> csvLines.add(person.getContactStrings())));
        writer.writeAll(csvLines);
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readfromcsv(){
        // Reading CSV
        String csvPath ="E:\\RFP262Batch\\src\\com\\bridgelabz\\AddressBook\\contact.csv";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(csvPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CSVReader reader = new CSVReaderBuilder(fileReader).build();
        List<String[]> linesOfData = null;
        try {
            linesOfData = reader.readAll();
        } catch (IOException | CsvException e) {

            e.printStackTrace();
        }
        System.out.println("\nReading data from csv file:");
        linesOfData.stream().forEach(csvs -> {
            for (String value : csvs)
                System.out.print(value + "\t");
            System.out.println();
        });
        try {
            reader.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public <JSONParser> void writefromJson(){
        JSONArray jsonPersons = new JSONArray();
        hashMap.keySet().stream().forEach(bookname -> hashMap.get(bookname).getContactBook()
                .stream().forEach(prsn -> jsonPersons.put((prsn.getContactJSON()))));

        Path jsonPath = Paths.get("D:\\Prathamesh Java\\Day28_AddressBook\\src\\com\\bridgelabz\\addressbook\\AddressBook.jason");
        try {
            Files.deleteIfExists(jsonPath);
            Files.writeString(jsonPath, jsonPersons.toString(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONParser jsonParser = new JSONParser();
        System.out.println("\nReading data from JSON file:");
        try {
            Object object = jsonParser.parse(Files.newBufferedReader(jsonPath));
            JSONArray personsList = (JSONArray) object;
            System.out.println(personsList);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
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
                case 10:
                    addressBSMain.readFromFile();
                case 11:
                    System.out.println("Exit");
                    break;
                case 12:
                    addressBSMain.readFromFile();
                case 13:
                    addressBSMain.readfromcsv();
                case 14:
                    addressBSMain.writefromJson();

                default:
                    System.out.println(option + "Enter s valid option");
                break;
            }
        }
        System.out.println("exit");
    }
}



