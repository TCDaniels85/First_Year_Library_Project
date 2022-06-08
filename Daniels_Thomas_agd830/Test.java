import java.util.Date;
/**
 * Test Class, written in the constructor so the test executes automatically. Each test is seperated by 
 * whitespace and is numbered for readability. Some tests or parts of tests have been commented out as they are not longer 
 * relevent in the final version of the project.
 * 
 * @author Thomas Daniels 
 * @version 23/04/21
 */
public class Test
{
    //no instance variables    

    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
       //Test the LibraryItem object is created properly
       //LibraryItem libraryItem1 = new LibraryItem("The Great Beyond", "GB23984", 700, 32, true);
       
       //Tests each Library Item is created
       Book book1 = new Book();
       CD cd1 = new CD();
       Periodical periodical1 = new Periodical();
       DVD dvd1 = new DVD();
       System.out.println("\nTest 1 Each type of LibraryItem object created correctly?");
       System.out.println("\nBook:");
       book1.printDetails();
       System.out.println("\nCD:");
       cd1.printDetails();
       System.out.println("\nPeriodical:");
       periodical1.printDetails();
       System.out.println("\nDVD:");
       dvd1.printDetails();
       
       // adds secod item to check the ArrayList in the Library class 
       //LibraryItem libraryItem2 = new LibraryItem("Everybody Loves Java", "EL23984", 850, 26, false);
       //Book book2 = new Book();
       Library library = new Library();
       //library.storeItem(libraryItem1);
       //library.storeItem(libraryItem2);       
       //library.storeItem(book1);
       //library.storeItem(book2);
       //System.out.println(" \nTest 2 ArrayList creation?");
       //library.printAllItems();
       
       //Test LibraryUser is created correctly
       System.out.println("\nTest 3 LibraryUser Creation");
       //LibraryUser libraryUser1 = new LibraryUser("Jones", "John", "I", "Mr");
       LibraryUser libraryUser1 = new LibraryUser();
       libraryUser1.printDetails();
       
       
       //Test that file dialogue is operating correctly and selecting a file.
       System.out.println(" \nTest 4 Test that read item data is working \nIf your selected file name appears below, this is working.");
       library.readData();
       
       System.out.println("\nTest 5 Test that print all items is working correctly");
       //library.printAllItems();
       library.displayDetails();
       
//        System.out.println("\nTest 6 Individual record details printed from arrays");
//        library.printSingleRecord(0,"library");
//        library.printSingleRecord(6,"library");
//        library.printSingleRecord(18,"library");
//        library.printSingleRecord(23,"library");
//        library.printSingleRecord(1,"user");
//        
       //Test that user data can be written to a file
       System.out.println("\nTest 7 userData can be written to a file");
       library.writeUserData();
       
       //Test that user ID is generated correctly
       System.out.println("\nTest 8 user ID generation");
       //LibraryUser user1 = new LibraryUser();
       //user1.generateUserID("ABD-", 6);       //testing when method was public
       libraryUser1.setUserID();
       libraryUser1.printDetails();
       
       
       
       //Test DateUtil class
       System.out.println("\nTest 9 DateUtil class, check method daysBetween");
       DateUtil date = new DateUtil();
       Date startDate = date.convertStringToDate("25-09-2020");
       Date endDate = date.convertStringToDate("12-04-2021");
       int result = date.daysBetween(startDate, endDate);
       System.out.println(result + " days.");
       
       //Test item reservation object creation
       System.out.println("\nTest 10 Item reservation creation");
       ItemReservation test10 = new ItemReservation("0", "ABD23242", "AB-009323", "12-04-21", 12);
       test10.printDetails();
      
       //test item reservation number generator
       //String result10 = library.generateReservationNo(98); // method public and takes user input for now
       //System.out.println(result10);
       //library.makeItemReservation("ABD23242", "AB-009323", "12-04-21", 12);
       //itemReservation.printDetails();
       
       //Test item reservation map, userDataTest.txt needs reading into the Library so users have a predefined userID
       System.out.println("\nTest 11 Item reservation map, (LOAD userDataTest.txt so users have valid ID's ");
       library.readData();  // so users with the userID's below can be loaded into system
       library.makeItemReservation("LM003698", "AB-093569", "02-01-2021", 6);
       library.makeItemReservation("LM004720", "AB-183785", "24-02-2021", 16);
       library.makeItemReservation("LM003873", "AB-779796", "19-01-2021", 39);
       library.makeItemReservation("LM005002", "AB-767886", "14-01-2021", 45);
       library.printItemReservations();
       
       //Test item reservation write and read methods      
       System.out.println("\nTest 12 item reservation write and read");
       library.writeItemReservationData();
       library.readItemReservationData();
       System.out.println("\nShould be 8 reservations here");
       library.printItemReservations();
       
       //Test reservation validation
       System.out.println("\nTest 13 item reservation validation");
       library.makeItemReservation("LM003698", "AB-767886", "14-01-2021", 45); // another reservation created for LM003698 added to test clashing with two reservations
       library.makeItemReservation("LM003698", "AB-767886", "01-01-2021", 30); //clashes with two reservations
       
       //Tests an item has be deleted
       System.out.println("\nTest 13 item reservation delete method");
       library.printItemReservations();
       System.out.println("\nReservation 000001 should be deleted from list below");
       library.deleteItemReservation("000001");
       library.printItemReservations();      
    }  
}
