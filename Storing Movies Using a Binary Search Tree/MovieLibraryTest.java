
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;

/**
 * The test class MovieLibraryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MovieLibraryTest
{
    @Test
    public void testaddMovies()
    {
        MovieLibrary lib = new MovieLibrary();
        lib.addMovies("TestData.txt");
        assertEquals(lib.getMovieLib().isEmpty(), false); //assert that there are movies in lib's binary search tree
    }

    @Test
    public void testwriteInOrder()
    {
        MovieLibrary lib = new MovieLibrary();
        lib.addMovies("TestData.txt");
        lib.writeToFile("TestSortedData.txt"); //look in the working directory and check if the movies were sorted correctly 
    }
    
    @Test (expected = NoSuchElementException.class)
    public void testWriteToFileThrowsException()
    {
        MovieLibrary lib = new MovieLibrary();
        lib.writeToFile("TestSortedData.txt"); //exception should be thrown if the tree is empty
    }
    
    @Test (expected = NoSuchElementException.class)
    public void testWriteToFileThrowsException2()
    {
        MovieLibrary lib = new MovieLibrary();
        lib.addMovies("Blank.txt"); //reading in a blank file 
        lib.writeToFile("Blank2.txt"); //should throw an exception
        
    }
}
