import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
/**
 * MovieLibrary represents a collection of movies
 */
public class MovieLibrary
{
    // instance variables 
    private BinarySearchTree <Movie> MovieLib = new BinarySearchTree<>();
    
    /**
     * Constructor for class MovieLibrary
     */
    public MovieLibrary () {}

    ///methods/////

    /**
     * Method addMovies reads movies from a text file and adds movie objects to MovieLib
     * @param fileName the name of the file to read from
     */

    public void addMovies(String fileName)
    {
        BufferedReader reader = null;
        try{
            String line = null;
            reader = new BufferedReader(new FileReader(fileName));
            while((line = reader.readLine()) != null){  //have the buffered reader read in the lines
                String [] words = line.split(" "); //split the line into individual words and store in array
                Movie m = new Movie(words[0], words[1], Integer.parseInt(words[2]), words[3]); //the appropriate movie constructor fields are in order in each line
                this.MovieLib.insert(m); //insert the movie to the BinarySearchTree
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        
        if(!this.MovieLib.isEmpty()){
            System.out.println("Movies added!");
        }
    }

    /**
     * Method writeToFile writes movies to a file in a sorted manner
     * @param fileName the name of the file to write to
     * @throws IllegalArgumentException
     */
    public void writeToFile(String fileName)
    {
        if(this.MovieLib.isEmpty()){
            throw new NoSuchElementException("There are no movies to report");
        } else {
            this.MovieLib.writeInOrder(fileName);
            System.out.println("Sorted file written, check working directory");
        }
    }
    
    public BinarySearchTree <Movie> getMovieLib()
    {
        return this.MovieLib;
    }
}
