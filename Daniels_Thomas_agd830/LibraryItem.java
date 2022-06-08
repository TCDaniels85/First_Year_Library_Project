import java.util.*;

/**
 * LibraryItem class for details of items held within the library, Book, Periodical, CD, DVD.
 * Holds fields common to all these classes. Super class of PrintedItem and AudioVisual
 * 
 * @author Thomas Daniels 
 * @version 23/04/2021
 */
public abstract class LibraryItem
{
    // Field Variables, please note cost is in pence
    private String title, itemCode;
    private int cost, timesBorrowed;
    private boolean onLoan;

//     /**
//      * Constructor for library item.
//      * Commented out as this constructor is no longer required.
//      */
//     public LibraryItem(String title, String itemCode, int cost, int timesBorrowed, boolean onLoan)
//     {
//         this.publisher = publisher;
//         this.noOfPages = noOfPages;
//         this.title = title;
//         this.itemCode = itemCode;
//         this.cost = cost;
//         this.timesBorrowed = timesBorrowed;
//         this.onLoan = onLoan;
//     }
    
    /**
     * No parameter constructor, default values set for fields
     */
    public LibraryItem()
    {
        title = "";
        itemCode = "";
        cost = 0;
        timesBorrowed = 0;
        onLoan = false;
    }

    /**
     * Returns book title
     */
    public String getTitle()
    {
       return title;
    }
    
    /**
     * Change book title if required
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * Returns the item code
     */
    public String getItemCode()
    {
       return itemCode;
    }
    
     /**
     * Change item code if required
     */
    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }
    
    /**
     * Returns item cost in pence
     */
    public int getCost()
    {
       return cost;
    }
    
     /**
     * Change cost if required, in pence
     */
    public void setCost(int cost)
    {
        this.cost = cost;
    }
    
    /**
     * Returns the number of times the item is borrowed
     */
    public int getTimesBorrowed()
    {
       return timesBorrowed;
    }
    
     /**
     * Change the number of times the book has been borrowed if required
     */
    public void setTimesBorrowed(int timesBorrowed)
    {
        this.timesBorrowed = timesBorrowed;
    }
    
    /**
     * Returns whether or not the book is on loan
     */
    public boolean getOnLoan()
    {
       return onLoan;
    }
    
     /**
     * Change whether or not book is out on loan if required
     */
    public void setOnLoan(boolean onLoan)
    {
        this.onLoan = onLoan;
    }
        
    /**
     * Prints details of LibraryItem to screen
     */
    public void printDetails()
    {
        if (onLoan == false)
        {
            System.out.println(title + " has item code " + itemCode + " and has been borrowed " + timesBorrowed + " times. \nThis item currently available and when new, costs " + cost + " pence.");
        } else 
        {
            System.out.println(title + " has item code " + itemCode + "and has been borrowed " + timesBorrowed + " times. \nThis item currently on loan and when new, costs " + cost + " pence.");
        } 
    }
    
    /**
     * toString method, allows details to be printed out in Library class
     */
    public String toString()
    {
        return "\nTitle: " + title + "\nItem code: " + itemCode + "\nCost when new: " + cost + " pence\nNumber of times borrowed: " + timesBorrowed + "\nItem out on loan: " + onLoan;
    }
    
    /**
     * Reads data into LibraryItem class, passed the scanner object as a parameter from readData() method 
     * of either PrintedItem or AudioVisual class depending on item type.
     */
    public void readData(Scanner scanner)
    {
        //noOfPages = scanner.nextInt();
        //publisher = scanner.next();
        title = scanner.next();
        itemCode = scanner.next();
        cost = scanner.nextInt();
        timesBorrowed = scanner.nextInt();
        onLoan = scanner.nextBoolean();                    
    }
}
