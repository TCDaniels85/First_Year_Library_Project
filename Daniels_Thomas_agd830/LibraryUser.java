import java.util.*;
//import java.awt.*;
import java.io.*;
/**
 * Library User class to create objects that old library user details.
 * Contains accessor and mutator methods for every field
 * writeData(), readData(), printDetails(), toString, and generateUserID() methods
 * 
 * @author Thomas Daniels
 * @version 23/04/21
 */
public class LibraryUser 
{
    // instance variables
    private String userID, surname, firstName, otherInitials, title;    

//     /**
//      * Constructor for objects of class LibraryUser, requires surname, firstName, otherInitials and title.
//      * The userID is set with the userID() mutator method as this requires generating from the generateUserID() method.
//      * 
//      */
//     public LibraryUser(String surname, String firstName, String otherInitials, String title)
//     {
//         // initialise instance variables
//         userID = "unknown";
//         this.surname = surname;
//         this.firstName = firstName; 
//         this.otherInitials = otherInitials;
//         this.title = title;
//     }
    
    /**
     * No parameter constructor, no parameters required for this class as data will always be read in from a file. Default values set for fields
     */
    public LibraryUser()
    {
       userID = "unknown";
       surname = "";
       firstName = "";
       otherInitials = "";
       title = "";
    }

    /**
     * Accessor method for userID field
     */
    public String getUserID()
    {
        return userID;
    }
    
    /**
     * Mutator method to set userID
     */
    public void setUserID()
    {
        String userID = generateUserID("AB-", 6);        
        this.userID = userID;         
    }
    
    /**
     * Accessor method for surname field
     */
    public String getSurname()
    {
        return surname;
    }
    
    /**
     * Mutator method to set surname field
     */
    public void setSurname(String surname)
    {
        this.surname = surname; 
    }
    
    /**
     * Accessor method for firstName field
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Mutator method to set firstName field
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    /**
     * Accessor method for otherInitials field
     */
    public String getOtherInitials()
    {
        return otherInitials;
    }    
    
    /**
     * Mutator method to set otherI:nitials field
     */
    public void setOtherInitials(String otherInitials)
    {
        this.otherInitials = otherInitials;
    }
    
    /**
     * Accessor method for title field
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Mutator method to set title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * Prints out user details
     */
    public void printDetails()
    {
        System.out.println("UserID: " + userID);
        System.out.println("Name : " + title + " " + firstName + " " + otherInitials + " " + surname);
    }
    
    /**
     * Reads data into LibraryUser fields, passed scanner object as parameter from readData method in Library class
     */
    public void readData(Scanner scanner)
    {
        userID = scanner.next();
        surname = scanner.next();
        firstName = scanner.next(); 
        otherInitials = scanner.next();
        title = scanner.next();
    }
    
    /**
     * toString method for LibraryUser
     */
    public String toString()
    {
        return("User ID: " + userID + "\nFull Name: " + title + " " + firstName + " " + otherInitials + " " + surname);
    }
    
    /**
     * Write Data to a file, passed pWriter object from writeUserData() method in Library class
     */
    public void writeData(PrintWriter pWriter)
    {        
        pWriter.println(userID + ", " + surname + ", " + firstName + ", " + otherInitials + ", " + title);
    }
    /**
     * Generates a user ID using a random number generator, using prefix provided as a parameter.
     * Length parameter is used to set length of the ID number, created and returned as a string using a for loop.
     */
    private String generateUserID(String prefix, int length)
    {
        Random randomGenerator = new Random();        
        String idNumber = ""; //Initialised so string is empty
        for(int i=0; i< length; i++)    //for loop generates a random int and adds it to the end of the idNumber string, so user can set the length
        {
            int result = randomGenerator.nextInt(10);
            idNumber = idNumber + result;
        }
        //System.out.println(prefix + idNumber); //used for testing
        return prefix + idNumber;
    }
}
