import java.util.*;
/**
 * Periodical class, holds details of periodical library items.
 * 
 * @author Thomas Daniels
 * @version 23/04/2021
 */
public class Periodical extends PrintedItem
{
    // instance variables 
    String publicationDate;

    /**
     * Constructor for objects of class Periodical, default values set for fields
     */
    public Periodical()
    {
        super();
        publicationDate = "";
    }
    
    /**
     * Returns publication date
     */
    public String getPublicationDate()
    {
        return publicationDate;
    }
    
    /**
     * Sets publicationDate field value
     */
    public void setPublicationDate(String publicationDate)
    {
        this.publicationDate = publicationDate;
    }
   
     /**
     * Reads item data in from text file, passed scanner object as parameter from readData() method in Library class
     * passes scanner to Super class printed item
     */
    public void readData(Scanner scanner)
    {
        publicationDate = scanner.next();
        super.readData(scanner);
    }
    
    /**
     * Prints periodical object specific details then calls to printDetails() method in super class to add those details
     */
    public void printDetails()
    {
       System.out.println("The publication date of this periodical is " + publicationDate + ".");
       super.printDetails();
    }
    
    /**
     * ToString method to allow all details of the Periodical items in the array to be dislpayed
     */
    public String toString()
    {        
        return("Publication date: " + publicationDate) + super.toString();        
    }
}
