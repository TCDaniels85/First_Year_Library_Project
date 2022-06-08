import java.util.*;

/**
 * Book class, holds details of book library items.
 * 
 * @author Thomas Daniels 
 * @version 23/04/2021
 */
public class Book extends PrintedItem
{
    // instance variables 
    String author;
    String isbn;

    /**
     * Constructor for objects of class Book, default values set for fields.
     */
    public Book()    
    {
        super();
        author = "";
        isbn = "";
    }
    
    /**
     * Returns author field
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * Changes data in author field
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    /**
     * Returns data in isbn field
     */
    public String getIsbn()
    {
        return isbn;
    }
    
    /**
     * Sets data in isbn field
     */
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
    
    /**
     * Reads item data in from text file, passed scanner object as parameter from readData() method in Library class
     * passes scanner to Super class PrintedItem
     */
    public void readData(Scanner scanner)
    {
        author = scanner.next();
        isbn = scanner.next();
        super.readData(scanner);
    }
    
    /**
     * Prints Book specific details then calls to printdetails method in super class to add those details
     */
    public void printDetails()
    {
       System.out.println("The author of this book is " + author + " and the isbn number is " + isbn + ".");
       super.printDetails();
    }
    /**
     * ToString method to allow all details of the book items in the array to be dislpayed
     */
    public String toString()
    {
        
        return("Author: " + author + "\nISBN Number: " + isbn) + super.toString();
        
    }

}
