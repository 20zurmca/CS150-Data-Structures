

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestMyLinkedList.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyLinkedListTest
{
    /**
     * Default constructor for test class TestMyLinkedList
     */
    public MyLinkedListTest()
    {
    }
   

   //test addToFront
    @Test
    public void testaddFront() {
        
        MyLinkedListIntegerContainer LLic = new MyLinkedListIntegerContainer();
        Integer [] Theoretical = {10,9,8,7,6,5,4,3,2,1,0};
        // fill integer container with integers
        for(Integer i=0; i<11; i++){
            LLic.addFront(i);
        }
        Integer [] Actual = LLic.getList().toArray(new Integer [LLic.getSize()]);
        assertArrayEquals(Actual,Theoretical);
     }
    
    
    //test addToBack
    @Test
    public void testAddToBack() {
         MyLinkedListIntegerContainer LLic = new MyLinkedListIntegerContainer();
        Integer [] Theoretical = {0,1,2,3,4,5,6,7,8,9,10};
        // fill integer container with integers
        for(Integer i=0; i<11; i++){
            LLic.addBack(i);
        }
        Integer [] Actual = LLic.getList().toArray(new Integer [LLic.getSize()]);
        assertArrayEquals(Actual,Theoretical);
   }
   
   //test linearSearch with element in a list
    @Test
    public void testlinearSearch1() {
        MyLinkedListIntegerContainer LLic = new MyLinkedListIntegerContainer();
        Integer [] Theoretical = {0,1,2,3,4,5,6,7,8,9,10};
        // fill integer container with integers
        for(Integer i=0; i<11; i++){
            LLic.addBack(i);
        }
        int position = LLic.linearSearch(2);
        assertEquals(2,position);
   }
   
   //test linearSearch with element not in the list
     @Test
    public void testlinearSearch2() {
        MyLinkedListIntegerContainer LLic = new MyLinkedListIntegerContainer();
        Integer [] Theoretical = {0,1,2,3,4,5,6,7,8,9,10};
        // fill integer container with integers
        for(Integer i=0; i<11; i++){
            LLic.addBack(i);
        }
        int position = LLic.linearSearch(20);
        assertEquals(-1,position);
   }
   
   //test iteratorSearch with element in a list
    @Test
    public void testiteratorSearch() {
         MyLinkedListIntegerContainer LLic = new MyLinkedListIntegerContainer();
        Integer [] Theoretical = {0,1,2,3,4,5,6,7,8,9,10};
        // fill integer container with integers
        for(Integer i=0; i<11; i++){
            LLic.addBack(i);
        }
        //use iterator to search for 2
        int position = LLic.iteratorSearch(2);
       
        assertEquals(2, position);
   }
   
   //test iteratorSearch with element not in the list
     @Test
    public void testiteratorSearch2() {
         MyLinkedListIntegerContainer LLic = new MyLinkedListIntegerContainer();
        Integer [] Theoretical = {0,1,2,3,4,5,6,7,8,9,10};
        // fill integer container with integers
        for(Integer i=0; i<11; i++){
            LLic.addBack(i);
        }
        //use iterator to search for 2
        int position = LLic.iteratorSearch(20);
       
        assertEquals(-1, position);
   }
}
