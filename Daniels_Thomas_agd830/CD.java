import java.util.*;
/**
 * CD class, holds details of CD library items.
 * 
 * @author Thomas Daniels 
 * @version 23/04/2021
 */
public class CD extends AudioVisual
{
    // instance variables
    private String artist;
    private int noOfTracks;

    /**
     * Constructor for objects of class CD, default values set for fields
     */
    public CD()
    {
        super();
        artist = "";
        noOfTracks = 0;
    }
    
    /**
     * Returns artist field
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Sets value in artist field
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
    
    /**
     * Returns noOfTracks field
     */
    public int getNoOfTracks()
    {
        return noOfTracks;
    }
    
    /**
     * sets value in noOfTracks field
     */
    public void setNoOfTracks(int noOfTracks)
    {
        this.noOfTracks = noOfTracks;
    }

    /**
     * Reads item data in from text file, passed scanner object as parameter from readData() method in Library class
     * passes scanner to Super class AudioVisual
     */
    public void readData(Scanner scanner)
    {
        artist = scanner.next();
        noOfTracks = scanner.nextInt();
        super.readData(scanner);
    }
    /**
     * Prints CD specific details then calls to printdetails method in super class to add those details
     */
    public void printDetails()
    {
        System.out.println("The artist who performs the music on this CD is " + artist + " and contains " + noOfTracks + "tracks.");
        super.printDetails();
    }
    /**
     * toString method
     */
    public String toString()
    {
        return("Artist: " + artist + "\nNumber of tracks: " + noOfTracks) + super.toString();
    }
}
