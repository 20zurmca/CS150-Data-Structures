import java.util.Random;
import java.io.*;
/**
 * Class RandomNameGenerator Generates Random first and last names
 */
public class RandomNameGenerator
{
    //***********************FIELDS***************************//
    private String [] LastNames = new String [88799]; //array for last names (will be read in from file)
    private String [] FirstNames = new String [5163]; //array for first names (will be read in from file)
    
    private int LastNamesindex = 0;
    private int FirstNamesindex = 0;
    
    /**
     * Constructor for class RandomNameGenerator
     */
    public RandomNameGenerator() 
    {
        fillLastNames();
        fillFirstNames();
    }
    
    //***************************METHODS*****************************//
    
    /**
     * Method nextFirstName generates a random first Name
     * @returns a random first name from the FirstNames array
     */
    public String nextFirstName()
    {
        Random r = new Random();
        return FirstNames[r.nextInt(FirstNames.length)];
    }
    
    /**
     * Method nextLastName generates a random last Name
     * @returns a random last name from the LastNames array
     */
    public String nextLastName()
    {
        Random r = new Random();
        return LastNames[r.nextInt(LastNames.length)];
    }
    
    /**
     * Method fillLastNames fills the LastNames array with last names from a file and then shuffles the names
     */
    private void fillLastNames(){
        BufferedReader reader = null;
        try{
            String line = null;
            reader = new BufferedReader(new FileReader("LastNames.txt"));
            while((line = reader.readLine()) != null){  //have the buffered reader read in the lines
                LastNames[LastNamesindex] = line; //enter the name from the file into the array
                LastNamesindex++;
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Method fillFirstNames fills the FirstNames array with first names from a file and then shuffles the names
     */
    private void fillFirstNames(){
        BufferedReader reader = null;
        try{
            String line = null;
            reader = new BufferedReader(new FileReader("FirstNames.txt"));
            while((line = reader.readLine()) != null){  //have the buffered reader read in the lines
                String [] words = line.split(" "); //split each line by space
                FirstNames[FirstNamesindex] = words[0]; //the first name is the first index in the words array
                FirstNamesindex++;
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
