import java.util.*;
/**
 * Audio Visual class, holds details of audio visual items, super class of the CD and DVD classes.
 * extends LibraryItem class
 * 
 * @author Thomas Daniels) 
 * @version 23/04/2021
 */
public abstract class AudioVisual extends LibraryItem
{
    // Instance variables
    private int playingTime;
    

    /**
     * Constructor for objects of class AudioVisual, default values used for fields.
     */
    public AudioVisual()
    {
        super();
        playingTime = 0;        
    }
    
    /**
     * Returns value in playingTime field
     */
    public int getPlayingTime()
    {
        return playingTime;
    }
    
    /**
     * Sets value in playingTime field
     */
    public void set(int playingTime)
    {
        this.playingTime = playingTime;
    }

    /**
     * Reads data into AudioVisual class, passed the scanner object as a parameter from readData() method 
     * of either CD or DVD class
     */
    public void readData(Scanner scanner)
    {
        playingTime = scanner.nextInt();
        super.readData(scanner);
    }
    
    /**
     * Prints details of selected item
     */
    public void printDetails()
    {
        System.out.println("This item has a playing time of " + playingTime + " minutes.");
        super.printDetails();
    }
    
    /**
     * ToString method
     */
    public String toString()
    {
        return("\nPlaying time: " + playingTime) + super.toString();
    }
    
}
