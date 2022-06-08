import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.*;
/**
 * Library class to create Library objects
 * Contains StoreItem(), storeUser(), checkUserIDIsUnique(), printSingleRecord(), printAllItems(), readData(), writeUserData(), addUserIDCheck(),
 * StoreItemReservation(), generateReservationNo(), getReservationNo(), makeItemReservation(), printItemReservations(), writeItemReservations()
 * readItemReservation(), printDiaryEntries(), checkItemReservation() and deletsItemReservation() methods.
 * 
 * @author Thomas Daniels
 * @version 23/04/21
 */
public class Library 
{
    // instance variablesblow
    //private ArrayList<LibraryItem> itemList;
    //private ArrayList<LibraryUser> userList;
    //private List<LibraryItem> itemList;
    //private List<LibraryUser> userList;
    private Map<String, LibraryItem> itemMap;
    private Map<String, LibraryUser> userMap;
    private HashSet<String> userIDCheck;
    private Map<String, ItemReservation> itemReservationMap;
    private Diary diary;
    private HashSet<String> itemReservationClash;
    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        //itemList = new ArrayList<LibraryItem>();
        //userList = new ArrayList<LibraryUser>();  
        //itemList = new List<LibraryItem>();
        //userList = new List<LibraryUser>();
        itemMap = new HashMap<>();
        userMap = new HashMap<>();
        userIDCheck = new HashSet<>();
        itemReservationMap = new HashMap<>();
        diary = new Diary();
        itemReservationClash = new HashSet<>();
        
    }

    /**
     * Adds LibraryItem  object to the appropriate HashMap
     */
    public void storeItem(LibraryItem libraryItem)
    {
        //itemList.add(libraryItem);
        //itemMap.add(libraryItem);
        String itemCode = libraryItem.getItemCode();
        itemMap.put(itemCode, libraryItem);
    }
    
    /**
     * Adds a LibraryUser object to the Arraylist, makes a call to the setUserID() method to give the user an ID if the user does not have one.
     * Uses a while loop to check that the userID is unique before adding to the userMap
     */
    public void storeUser(LibraryUser libraryUser)
    {
        String userID = libraryUser.getUserID();
        if (userID.equals("unknown"))
        {
            boolean checkUnique = false;
            int initialSize = userIDCheck.size();
            while (checkUnique == false)
            {               
                libraryUser.setUserID();  // sets user ID by calling generateUserID method within the LibraryUserClass 
                userIDCheck.add(libraryUser.getUserID());
                checkUnique = checkUserIDIsUnique(initialSize);  // if the userID is unique, it is set here
                
            }           
           String newID = libraryUser.getUserID();
           userMap.put(newID, libraryUser);          
        }
        else
        {
            //userList.add(libraryUser); 
            userMap.put(userID, libraryUser);
        }
    }
    
    /**
     * Checks whether a generated ID is unique. Compares the size of the HashSet before and after the userID has been added to it.
     * As a HashSet does not allow duplicate values, if the size before and after are the same, then the generated ID already exists.
     *
     * Takes an int initialSize as a parameter from the store method, this is the size of the HashSet before the userID is added.
     * Returns a boolean
     */
    private boolean checkUserIDIsUnique(int initialSize)
    {
        int checkSize = userIDCheck.size(); //Size of hashset after userID is added.
        
        if (initialSize == checkSize)
        {            
            return false;
        }
        else 
        {
            return true;
        }
    }    

    /**
     * Prints details for a single item in array list, user enters record number required and the type of record
     * Type "user" to read from user database, type "library" to read from library database
     * NEEDS CHANGING FOR HASHMAP
     */
    public void printSingleRecord(String keyValue ,String recordType)
    {
        if (recordType.equalsIgnoreCase("library"))
        {            
            LibraryItem libraryItem = itemMap.get(keyValue);
            libraryItem.printDetails();            
        }
        else if (recordType.equalsIgnoreCase("user"))
        {            
            LibraryUser libraryUser = userMap.get(keyValue);
            libraryUser.printDetails();            
        }
    }
    
    /**
     * Prints all library items and library users in stored in the hashMaps.
     */
    public void displayDetails()
    {
        int listPosition = 1;
        //for (LibraryItem libraryItem : itemList)
        for (LibraryItem libraryItem : itemMap.values())
        {
            System.out.println("\nItem numnber: " + listPosition);
            System.out.println(libraryItem.toString());
            listPosition ++;
        }
        listPosition = 1; //resets List postion for users
        //for (LibraryUser libraryUser : userList)
        for (LibraryUser libraryUser : userMap.values())
        {
            System.out.println("\nLibrary User: " + listPosition);
            System.out.println(libraryUser.toString());
            listPosition ++;
        }
        
    }
    
    /**
     * Reads item selected from file dialogue, Sets directory for dialogue box to parent directory of project.
     * Recognises flags in [] so data can be added to the correct list.
     */
    public void readData() 
    {
        Frame myFrame = null;        
        Scanner scanner;
        String typeOfData = "";
        
        
        FileDialog dialogueBox = new FileDialog(myFrame, "Open", FileDialog.LOAD);
        
        //Sets directory to parent directory, 
        dialogueBox.setDirectory("..\\Data files\\");
        dialogueBox.setVisible(true);
        //creates path for fileName
        String fileName = dialogueBox.getDirectory() + dialogueBox.getFile();
        //System.out.println(fileName);
        System.out.println("Reading data from: " + dialogueBox.getFile());         
        
        File dataFile = new File(fileName);
        
       try
        {           
           
            scanner = new Scanner(dataFile);
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("\n ***Error:- FileNotFoundException***");
            System.err.println("The data file, " + fileName + " does not appear to exist or you have not selected a file, please try again");
            return;  // Returns null so user can choose a file again without having to exit system
        }
                    
            while (scanner.hasNextLine())
            {                
                String lineOfText = scanner.nextLine().trim();
                //if (lineOfText.startsWith("//") == false & lineOfText.isEmpty() == false)
                if (lineOfText.startsWith("//") == true) 
                {                    
                }
                else if (lineOfText.isEmpty() == true)
                {                    
                }
                else if (lineOfText.startsWith("[") == true)
                {
                   //Scanner reads line of text, sets delimiter to look for flags between []
                   Scanner thirdScanner = new Scanner(lineOfText);
                   thirdScanner.useDelimiter("[\\[\\]]");   
                   typeOfData = thirdScanner.next(); // sets typeOfData field to flag value
                   thirdScanner.close();
                                                        
                }
                else if (typeOfData.equals("data error"))
                {
                    //tells the scanner to do nothting for each line of data after an unexpected flag or if no flag is found
                }
               else
                {      
                    //Second scanner to read lineOfText as input String                    
                    Scanner secondScanner = new Scanner(lineOfText);
                    secondScanner.useDelimiter("\\s*,\\s*");  
                    if (typeOfData.equalsIgnoreCase("book data"))
                    {                        
                        Book book = new Book(); 
                        book.readData(secondScanner);
                        storeItem(book);                        
                    }
                    else if (typeOfData.equalsIgnoreCase("periodical data"))
                    {
                        Periodical periodical = new Periodical();
                        periodical.readData(secondScanner);
                        storeItem(periodical);                        
                    }
                    else if (typeOfData.equalsIgnoreCase("CD data"))
                    {
                        CD cd = new CD();
                        cd.readData(secondScanner);
                        storeItem(cd);
                    }
                    else if (typeOfData.equalsIgnoreCase("DVD data"))
                    {
                        DVD dvd = new DVD();
                        dvd.readData(secondScanner);
                        storeItem(dvd);
                    }
                    else if (typeOfData.equalsIgnoreCase("Library User Data"))
                    {
                        LibraryUser libraryUser = new LibraryUser();
                        libraryUser.readData(secondScanner);                        
                        storeUser(libraryUser);
                    }
                    else if (typeOfData.equals(""))
                    {
                        //Informs user that there is no flag defining data type, sets typeOfData to data error
                        System.out.println("Error, some data contained in this file has no flag to define data type, some information may not have been added to array. Please check the file");
                        typeOfData = "data error";
                    }
                    else 
                    {
                       //Informs user that an unexpected flag has been encounted, sets typeOfData to data error so following lines of data in file can be skipped
                       System.out.println("Error, an unexpected flag has been encounted.");
                       System.out.println("An unknown data type is contained in this file, the flag: [" + typeOfData + "] is not reconised by our system, data with this flag has been ignored.");
                       typeOfData = "data error";
                    }
                    secondScanner.close();
                }                
            }            
            scanner.close();       
    }
    
    /**
     * Writes user data to a text file as comma seperated data, with a flag set between [ ] to indicate data type.
     */
    public void writeUserData()
    {
        Frame myFrame = null;
        PrintWriter pWriter;
        
        FileDialog dialogueBox = new FileDialog(myFrame, "Save", FileDialog.SAVE);
        dialogueBox.setDirectory("..\\Data files\\");
        dialogueBox.setFile(".txt");
        dialogueBox.setVisible(true);
        String fileName = dialogueBox.getDirectory() + dialogueBox.getFile();// + ".txt."; //adds the .txt extension on for the user
        //PrintWriter pWriter = new PrintWriter(fileName);
        try
        {           
           pWriter = new PrintWriter(fileName);
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("\n ***Error:- FileNotFoundException***");
            System.err.println("The data file, " + fileName + " does not appear to exist or you have not selected a file, please try again");
            return;  // Returns null so user can choose a file again without having to exit system
        }
        pWriter.println("// data is userID, surname, firstName, otherInitials, title\n\n[Library User Data] \n");
        //for(LibraryUser libraryUser : userList)
        for(LibraryUser libraryUser : userMap.values())
        {
            libraryUser.writeData(pWriter);
        }
        pWriter.close();
    }
    
    /**
     * Method to add userID to a HashSet
     * 
     */
    public void addUserIDCheck(String userID)
    {
        userIDCheck.add(userID);
    }
    
     /**
     * Adds itemReservation object to the hashMap
     */
    public void storeItemReservation(ItemReservation itemReservation)
    {
        String reservationNo = itemReservation.getReservationNo();
        itemReservationMap.put(reservationNo, itemReservation);
        diary.addReservation(itemReservation);
    }
    
    /**
    * Generates a reservation number sequentially, determines the size of the map to get the current number of reservations, adds one to this number for the next 
    * reservation number and pads the rest out with zeros to return a 6 digit number as a string.
    */
    private String generateReservationNo() 
    {
        String zeros = "";       //initialised empty
        int noOfReservations = getNoOfReservations();
        noOfReservations += 1;      //adds one for new item reservation number
        String number = String.valueOf(noOfReservations);        // converts noOfReservations to a String
        int numberLength = number.length();         //determines the length of the string
        for (int i=0; i < (6 - numberLength); i++)      // loop creates a string of zeros to pad number out into to a six digit string below
        {
            zeros = zeros + "0";
        }        
        return zeros + number;        
    }
    
    /**
     * Returns the number of records in itemReservationMap
     */
    public int getNoOfReservations()
    {
        return itemReservationMap.size();
    }
    
    /**
     * Returns an item reservation object from hashmap using the key
     */
    public ItemReservation getItemReservation(String reservationNo)
    {
        return itemReservationMap.get(reservationNo);
    }
    
    /**
     * Creates an item reservation and adds it to the list of reservations
     * Checks each of the fields to ensure all data entered is valid. 
     * If any fields are not valid, a message is output to display which fields are not valid and informs the user a reservation has not been created.
     */
    public boolean makeItemReservation(String itemCode, String userID, String startDate, int noOfDays)
    {
        boolean validUser = false;
        boolean validItemCode = false;
        boolean validDays = true;
        boolean validDate = DateUtil.isValidDateString(startDate);          //method returns true or false depending on date being valid or not 
        
        for(String user : userMap.keySet())
        {
            if (user.equals(userID))
            {
                validUser = true;              
            }            
        }        
        
        for(String item : itemMap.keySet())
        {
            if(item.equals(itemCode))
            {
                validItemCode = true;                
            }            
        }        
        //if statements to display to user what fields were invalid
        if (noOfDays <= 0 || noOfDays >= 100)
        {
            System.out.println("Sorry please enter a valid number of days, minimum 1, maximum 100");
            validDays = false;
        }        
        if(validUser == false) 
        {System.out.println("Sorry the user ID: " + userID + " does not exist."); }
        if(validItemCode == false) 
        {System.out.println("Sorry the item code: " + itemCode + " does not exist."); }        
        if (validDate == false)
        {System.out.println("Please use the correct date format DD/MM/YYYY");}
        
        // checks for any invalid fields, if any are invalid false is returned
        if (validUser == false || validItemCode == false || validDays == false || validDate == false)
        {
            System.out.println("A reservation has not been made because of the above errors.");
            return false;
        }
        else 
        {   
            boolean checkitemReservation = checkItemReservation(itemCode, startDate, noOfDays);  // makes a call to check reservation method, sets check reservation as true or false
            if (checkitemReservation == true)
            {
                String reservationNo = generateReservationNo();        
                ItemReservation itemReservation = new ItemReservation(reservationNo, itemCode, userID, startDate, noOfDays);
                storeItemReservation(itemReservation);
                System.out.println("Your reservation has been made, your reservation number is:" + reservationNo);
                return true;
            }        
            else
            {
                //if there are existing reservations that clash, their details are printed out to the terminal so the user can adjust the reservation being made
                Iterator<String> iterator = itemReservationClash.iterator();
                System.out.println("Sorry your reservation has clashed with the following existing reservations, please check these details and amend your reservation appropriately");
                while(iterator.hasNext())
                {
                    System.out.println("\n" + getItemReservation(iterator.next()));
                }
                return false;
            }
        }
    } 
    
    /**
     * Prints out a list of the current reservations to the terminal.
     */
    public void printItemReservations()
    {               
        for (ItemReservation itemReservation : itemReservationMap.values())
        {            
            System.out.println("\n"+itemReservation.toString());            
        }
    }
    
    /**
     * Writes the item reservation data to a text file as comma seperated data, with a flag set between [ ] to indicate data type.
     */
    public void writeItemReservationData()
    {
        Frame myFrame = null;
        PrintWriter pWriter;
        
        FileDialog dialogueBox = new FileDialog(myFrame, "Save", FileDialog.SAVE);
        dialogueBox.setDirectory("..\\Data files\\");
        dialogueBox.setFile(".txt");        //adds .txt file type in dialogue box
        dialogueBox.setVisible(true);
        String fileName = dialogueBox.getDirectory() + dialogueBox.getFile();   // + ".txt."; //adds the .txt extension on for the user
        
        try
       {
           
           pWriter = new PrintWriter(fileName);
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("\n ***Error:- FileNotFoundException***");
            System.err.println("The data file, " + fileName + " does not appear to exist or you have not selected a file, please try again");
            return;  // Returns null so user can choose a file again without having to exit system
        }
        pWriter.println("// data is reservationNo, itemCode, userID, startDate, noOfDays\n\n[Item Reservation Data] \n");        //adds comments and flag to the file
        for(ItemReservation itemReservation : itemReservationMap.values())
        {
            itemReservation.writeData(pWriter);
        }
        pWriter.close();
    }
    
    /**
     * Reads item reservations from a text file, validate the data is of the correct type using a flag
     */
    public void readItemReservationData()
    {
        Frame myFrame = null;
        Scanner scanner;
        String typeOfData = "";      
        FileDialog dialogueBox = new FileDialog(myFrame, "Open", FileDialog.LOAD);
        
        //Sets directory to parent directory, 
        dialogueBox.setDirectory("..\\Data files\\");
        dialogueBox.setVisible(true);
        //creates path for fileName
        String fileName = dialogueBox.getDirectory() + dialogueBox.getFile();        
        System.out.println("Reading data from: " + dialogueBox.getFile());         
        
        File dataFile = new File(fileName);         
       try
        {           
           scanner = new Scanner(dataFile);
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("\n ***Error:- FileNotFoundException***");
            System.err.println("The data file, " + fileName + " does not appear to exist or you have not selected a file, please try again");
            return;  // Returns null so user can choose a file again without having to exit system
        }
                    
            while (scanner.hasNextLine())
            {               
                String lineOfText = scanner.nextLine().trim();                
                if (lineOfText.startsWith("//") == true)
                {                    
                }
                else if (lineOfText.isEmpty() == true)
                {                    
                }
                else if (lineOfText.startsWith("[") == true)
                {
                   //Scanner reads line of text, sets delimiter to look for flags between []
                   Scanner thirdScanner = new Scanner(lineOfText);
                   thirdScanner.useDelimiter("[\\[\\]]");   
                   typeOfData = thirdScanner.next(); // sets typeOfData field to flag value
                   thirdScanner.close();                                                        
                }
                else if (typeOfData.equals("data error"))
                {
                    //tells the scanner to do nothting for each line of data after an unexpected flag or if no flag is found
                }
               else
                {   
                    //Second scanner to read lineOfText as input String                    
                    Scanner secondScanner = new Scanner(lineOfText);
                    secondScanner.useDelimiter("\\s*,\\s*");  
                    if (typeOfData.equalsIgnoreCase("Item Reservation Data"))
                    {                        
                        ItemReservation itemReservation = new ItemReservation();
                        itemReservation.readData(secondScanner);
                        storeItemReservation(itemReservation);                                               
                    }                    
                    else if (typeOfData.equals(""))
                    {
                        //Informs user that there is no flag defining data type, sets typeOfData to data error
                        System.out.println("Error, some data contained in this file has no flag to define data type, some information may not have been added to array. Please check the file");
                        typeOfData = "data error";
                    }
                    else 
                    {
                       //Informs user that an unexpected flag has been encounted, sets typeOfData to data error so following lines of data in file can be skipped
                       System.out.println("Error, an unexpected flag has been encounted.");
                       System.out.println("An unknown data type is contained in this file, the flag: [" + typeOfData + "] is not reconised by our system, data with this flag has been ignored.");
                       typeOfData = "data error";
                    }
                    secondScanner.close();
                }                
            }            
            scanner.close(); 
    }
    
    /**
     * Prints out a list of reservations for each day between two dates supplied by the user as parameters.
     */
    public void printDiaryEntries(String startDateString, String endDateString)
    {
        Date startDate = DateUtil.convertStringToDate(startDateString);
        Date endDate = DateUtil.convertStringToDate(endDateString);
        diary.printEntries(startDate, endDate);
    }
    
    /**
     * This method takes itemCode, startDate and noOfDays as parameters, passed from the make item reservation method.
     * Sends the date to the diary's getReservations() method, each reservation on that date (if there are any) has it's itemCode field compared to the reservation being made itemCode
     * If that item is reserverved on that day, the reservationNo of that object is saved in a hashSet(so it does not get duplicated for each day, important 
     * for when they are printed in the makeReservation() method).
     * 
     * returns true if the hashSet is empty meaning the item has not been reserved at any other time.
     */
    private boolean checkItemReservation(String itemCode, String startDate, int noOfDays)
    {
        Date checkDate = DateUtil.convertStringToDate(startDate); 
        int daysLeftToCheck = noOfDays;
        ItemReservation[] itemReservations = new ItemReservation[0]; //ititialise ItemReservation array
        while(daysLeftToCheck > 0)
        {
            itemReservations = diary.getReservations(checkDate);
            if (itemReservations != null)
            {
                for (ItemReservation itemReservation : itemReservations)
                {                    
                    if(itemCode == itemReservation.getItemCode())
                    {
                        String keyValue = itemReservation.getReservationNo();
                        itemReservationClash.add(keyValue);                   // Adds reservation number to hashSet, so can be used as key value to get reservation details later
                    }
                }
                checkDate = DateUtil.nextDate(checkDate);
                daysLeftToCheck -= 1;
            }
            else
            {            
                checkDate = DateUtil.nextDate(checkDate);
                daysLeftToCheck -= 1;
            }
        }
        
        if(itemReservationClash.isEmpty())
        {
            return true;
        }
        else
        {
            return false;            
        }
    }
    
    /**
     * Deletes the reservation, takes a reservationNo parameter.
     * Checks if the reservation number is the correct 6 digit length and informs the user if the reservation number doesn't exist.
     */
    public void deleteItemReservation(String reservationNo)
    {
        if(reservationNo.length() == 6)
        {
            //itemReservationMap.remove(reservationNo);
            if (itemReservationMap.remove(reservationNo) == null)
            {
                System.out.println("sorry that reservation does not exist");
            }
            else
            {
                System.out.println("Reservation " + reservationNo + " has been deleted");
            }
        }
        else
        {
            System.out.println("Incorrect reservation number entered, please enter a 6 digit number");
        }        
    }    
}
