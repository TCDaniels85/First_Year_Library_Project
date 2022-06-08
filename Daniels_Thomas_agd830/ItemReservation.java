import java.util.Date;
import java.util.*;
import java.io.*;
/**
 * Creates an item reservation object to hold reservation details of library items.
 * Item reservation class, contains accessor and mutator methods for the Item reservation objects
 * write and read methods, and toString() and printDetails() methods.
 * 
 * @author Thomas Daniels
 * 
 * @version 23/04/2021
 */
public class ItemReservation
{
    // Variable declarations
    String reservationNo, itemCode, userID;
    Date startDate;
    int noOfDays;    

    /**
     * Constructor for objects of class ItemReservation
     * Start date needs to be entered as a string in DD-MM-YYYY format, eg 04-05-2021
     */
    public ItemReservation(String reservationNo, String itemCode, String userID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.itemCode = itemCode;
        this.userID = userID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
        
    }
    
    /**
     * Default constructor no parameters required, default values given to fields
     */
    public ItemReservation()
    {
        reservationNo = "";
        itemCode = "";
        userID = "";
        startDate = null;
        noOfDays = 0;
    }
    
    /**
     * Returns reservation number
     */
    public String getReservationNo()
    {
        return reservationNo;
    }
    
    /**
     * Set reservation number
     */
    public void setReservationNo(String reservationNo)
    {
        this.reservationNo = reservationNo;
    }
    /**
     * Returns item code
     */
    public String getItemCode()
    {
        return itemCode;
    }
    
    /**
     * Set item code
     */
    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }
    
    /**
     * Returns userID
     */
    public String getUserID()
    {
        return userID;
    }
    
    /**
     * Sets the user ID
     */
    public void setUserID(String userID)
    {
        this.userID = userID;
    }
    
    /**
     * Returns the start date field
     */
    public Date getStartDate()
    {
        return startDate;
    }
    
    /**
     * Sets start date field
     */
    public void setStartDate(String startDate)
    {        
        this.startDate = DateUtil.convertStringToDate(startDate);
    }
    
    /**
     * Returns number of days to be reserved field
     */
    public int getNoOfDays()
    {
        return noOfDays;
    }
    
    /**
     * Set number of days item to be reserved for
     */
    public void setNoOfDays(int noOfDays)
    {
        this.noOfDays = noOfDays;
    }   

        
    /**
     * toString method for item reservation
     */
    public String toString()
    {
        return ("\nItem reservation number: " + reservationNo + "\nItem Code: " + itemCode + "\nUser ID: " + userID + "\nStart date of reservation: " + startDate + "\nNumber of days reserved: " + noOfDays);
    }
    
    /**
     * Prints all details of the reservation.
     */
    public void printDetails()
    {
        System.out.println("Reservation number is " + reservationNo + " for item code " + itemCode + " checked out by user " + userID + " on " + startDate + " for " + noOfDays + " days.");
    }
    
    /**
     * Writes data to file, receives pWriter object from writeItemReservation in Library class, 
     */
    public void writeData(PrintWriter pWriter)
    {
        String startDate = DateUtil.convertDateToShortString(this.startDate);
        pWriter.println(reservationNo + ", " + itemCode + ", " + userID + ", " + startDate + ", " + noOfDays);
    }
    
    /**
     * Reads data from user selected file into the fields of the ItemReservation object
     */
    public void readData (Scanner scanner)
    {        
        reservationNo = scanner.next();
        itemCode = scanner.next();
        userID = scanner.next();
        startDate = DateUtil.convertStringToDate(scanner.next());
        noOfDays = scanner.nextInt();
    }
    
}
