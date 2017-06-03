

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SortedNodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SortedLinkedListTest
{
    @Test
    public void testRemove1()
    {
        SortedLinkedList<Integer> sList = new SortedLinkedList<>();
        //add integers to the list
        sList.add(1);
        sList.add(2);
        sList.add(3);
        sList.add(2);
        //remove two, return that it was successful
        boolean success = sList.remove(2);
        assertEquals(success, true);
        
        //now assert that the 2 is only counted once 
        assertEquals((Integer) sList.count(2), (Integer) 1);
    }
    
    @Test
    public void testRemove2()
    {
        //add integers to the list
        SortedLinkedList<Integer> sList = new SortedLinkedList<>();
        sList.add(1);
        sList.add(2);
        sList.add(3);
        //remove 2, return that it was successful
        boolean success = sList.remove(2);
        assertEquals(success, true);
        
        //assert that 2 shows up 0 times
        assertEquals((Integer) sList.count(2), (Integer) 0);
    }
    
    @Test
    public void testRemove3()
    {
        //add an integer to the list
        SortedLinkedList<Integer> sList = new SortedLinkedList<>();
        sList.add(1);
        //try to remove an integer that doesn't exist
        boolean fail = sList.remove(3);
        //asert that the that it failed
        assertEquals(fail, false);
    }
}

