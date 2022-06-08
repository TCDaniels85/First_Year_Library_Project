import java.util.*;
/**
 * PrintedItem abstract class, Super class for the periodical and book classes.
 * Extends Library item class
 * 
 * @author Thomas Daniels 
 * @version 23/04/2021
 */
public abstract class PrintedItem extends LibraryItem
{
    // instance variables 
    private String publisher;
    private int noOfPages;

    /**
     * Constructor for objects of class PrintedItem, default values set for fields
     */
    public PrintedItem()
    {
        super();
        publisher = "";
        noOfPages = 0;       
    }
    
    /**
     * Returns publisher field
     */
    public String getPublisher()
    {
        return publisher;
    }
    
    /**
     * sets publisher field value
     */
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    /**
     * Returns noOfPages field
     */
    public int getNoOfPages()
    {
        return noOfPages;
    }
    
    /**
     * sets value in noOfPages field
     */
    public void setNoOfPages(int noOfPages)
    {
        this.noOfPages = noOfPages;
    }

    /**
     * Reads data into PrindedItem class, passed the scanner object as a parameter from readData() method 
     * of either book or periodical class
     * 
     */
    public void readData(Scanner scanner)
    {
        noOfPages = scanner.nextInt();
        publisher = scanner.next();        
        super.readData(scanner);        
    }  
    
    /**
     * Prints details
     */
    public void printDetails()
    {
       System.out.println("This was published by " + publisher + " has " + noOfPages + " pages.");
       super.printDetails();
    }
    
    /**
     * ToString method to allow all details of the book items in the array to be dislpayed
     */
    public String toString()
    {        
        return("\nPublisher: " + publisher + "\nNumber of pages: " + noOfPages) + super.toString();        
    }
}
