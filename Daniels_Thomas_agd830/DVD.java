import java.util.*;
/**
 * DVD class, holds details of DVD library items.
 * 
 * @author Thomas Daniels 
 * @version 23/04/20221
 */
public class DVD extends AudioVisual
{
    // instance variables 
    private String director;

    /**
     * Constructor for objects of class DVD, defauls values set for fields
     */
    public DVD()
    {
        // initialise instance variables
        super();
        director = "";
    }
    
    /**
     * Returns director field value
     */
    public String getDirector()
    {
        return director;
    }
    
    /**
     * Sets value in director field
     */
    public void set(String director)
    {
        this.director = director;
    }

    /**
     * Reads item data in from text file, passed scanner object as parameter from readData() method in Library class
     * passes scanner to readData() method in Super class PrintedItem
     */
    public void readData(Scanner scanner)
    {
        director = scanner.next();
        super.readData(scanner);
    }
    
    /**
     * Prints DVD specific details then calls to printdetails method in super class to add those details
     */
    public void printDetails()
    {
        System.out.println("This film is directed by " + director + ".");
        super.printDetails();
    }
    
    /**
     * toString method
     */
    public String toString()
    {
        return("Director: " + director) + super.toString();
    }
}
