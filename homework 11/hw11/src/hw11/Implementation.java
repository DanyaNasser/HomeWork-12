/**
 *  The program that implements Serializable and has menu system to make
 *  changes 
 * 
 * @author Danya Nasr
 * Assignment: 11
 */
package hw11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;

class Person implements Serializable{
    private String name;
    private String phoneNumber;
    private String dateOfBirth;
    private String emailAddress;
    
    public Person(String name, String phoneNumber, String dateOfBirth, String emailAddress ){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
    }
    
    public String toString(){
        return "Name:"+this.name+"    PhoneNumber:"+this.phoneNumber+"    DateOfBirth:"+this.dateOfBirth+"    EmailAddress:"+this.emailAddress;
    }
    
}

public class Implementation{
    
    public static void main(String[] args) {
        ArrayList<Object> persons = new ArrayList();
        int runLoop = -1;
        Scanner input = new Scanner(System.in);
        while (runLoop != 0){
            System.out.println("\nEnter 1 to Add information into a file.");
            System.out.println("Enter 2 to Retrieve information from a file and display them");
            System.out.println("Enter 3 to Delete information.");
            System.out.println("Enter 4 to Update information.");
            System.out.println("Enter 0 to Exit out of the program.");
            runLoop = input.nextInt();
            input.nextLine();
            switch(runLoop){
                //exit out of program
                case 0:
                    break;
                //handle adding
                case 1:
                    System.out.println("Enter the name of the person:");
                    String name = input.nextLine();
                    System.out.println("Enter the phone Number:");
                    String number = input.nextLine();
                    System.out.println("Enter the birthdate:");
                    String date = input.nextLine();
                    System.out.println("Enter the emailAddress:");
                    String email = input.nextLine();
                    Person p = new Person(name, number, date, email);
                    persons.add(p);
                    try{
                        writeToFile(persons);
                    } catch (Exception e){
                        System.out.println(e.toString());
                    }
                    break;
                    
                //handle retrieving
                case 2:
                    try{
                        readFile();
                    } catch (Exception e){
                        System.out.println(e.toString());
                    }
                    
                    break;
                    
                //handle delete
                case 3:
                    //initialize empty arraylist to overwrite
                    ArrayList<Object> empty = new ArrayList();
                    try{
                        writeToFile(empty);
                        System.out.println("All the data from file has been deleted");
                    } catch (Exception e){
                        System.out.println(e.toString());
                    }
                    
                    break;
                    
                //handle update
                case 4:
                    //get current contents of file
                    try {
                        persons = getFileContent();
                        System.out.println("\nEnter the details of person to update to file");
                        System.out.println("Enter the name of the person:");
                        String name1 = input.next();
                        System.out.println("Enter the phone Number:");
                        String number1 = input.next();
                        System.out.println("Enter the birthdate:");
                        String date1 = input.next();
                        System.out.println("Enter the emailAddress:");
                        String email1 = input.next();
                        Person p1 = new Person(name1, number1, date1, email1);
                        persons.add(p1);
                        try{
                            writeToFile(persons);
                        } catch (Exception e){
                            System.out.println(e.toString());
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                default:
                    break;
            }
        }
        input.close();
    }
    
    //method to write to file
    public static void writeToFile(ArrayList<Object> p) throws FileNotFoundException, IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("Person.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(p);
        objectOutputStream.close();
        fileOutputStream.close();
        
    }
    //method to read from file
    public static void  readFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Person.bin"));
        ArrayList persons = (ArrayList<Object>) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("\nPrinting all the available data");
        if (persons.size() == 0) {
            System.out.println("{{No data to display}}");
        } else {
            for (Object person : persons){
            System.out.println(person.toString());
            }
        }
        System.out.println();
    }
    
    //method to get the contents of file
     public static ArrayList<Object>  getFileContent() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Person.bin"));
        ArrayList persons = (ArrayList<Object>) objectInputStream.readObject();
        objectInputStream.close();
        return persons;
    }
}
