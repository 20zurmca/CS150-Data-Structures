

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MovieTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MovieTest
{
   @Test
   public void testCompareTo()
   {
       //for the first comparison see if movie1's date precedes movie2's, all else equal  That is, comparison1 should be less than 0
       Movie movie1 = new Movie("Jaws","S",1973,"Thriller");
       Movie movie2 = new Movie("Jaws2","S", 1980, "Thriller");
       int comparison1 = movie1.compareTo(movie2);
       boolean lessThan2 = comparison1 < 0;
       assertEquals(true, lessThan2);
       
       //second comparison checks if movie3's title is lexographically less than movie4's, all else equal
       Movie movie3 = new Movie("Alpha","Someone",1960,"Horror");
       Movie movie4 = new Movie("Beta","Someone",1960,"Horror");
       int comparison2 = movie3.compareTo(movie4);
       boolean lessThan4 = comparison2 < 0;
       assertEquals(true, lessThan4);
       
       //third comparison checks if movie6's genre is lexographically greater than movie5's, all else equal
       Movie movie5 = new Movie("C", "D",1980,"Thriller");
       Movie movie6 = new Movie("C", "D", 1980, "Horror");
       int comparison3 = movie5.compareTo(movie6);
       boolean greaterThan6 = comparison3 > 0;
       assertEquals(true, greaterThan6);
       
       //fourth comparison checks if movie7's director is lexographically less than movie8's, all else equal
       Movie movie7 = new Movie("C", "Dan",1980,"Thriller");
       Movie movie8 = new Movie("C", "Dill", 1980, "Thriller");
       int comparison4 = movie7.compareTo(movie8);
       boolean lessThan8 = comparison4 < 0;
       assertEquals(true, lessThan8);
    }
}
