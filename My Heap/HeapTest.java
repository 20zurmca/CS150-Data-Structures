
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
/**
 * The test class HeapTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HeapTest
{
    @Test
    public void testInsert()
    {
        Heap<Integer> minHeap = new Heap<>(); //create a new minHeap
        minHeap.insert(4); //enter intergers
        minHeap.insert(1); 
        minHeap.insert(-5);
        minHeap.insert(3);
        assertEquals(minHeap.getRoot().getElement(), (Integer)(-5)); //assert that -5 is the root (min element)
        //assert that the number of elements in the heap is 4
        assertEquals(minHeap.getNumNodes(), 4);
    }

    @Test
    public void testRemoveMin()
    {
        Heap<Integer> minHeap = new Heap<>(); //create a new minHeap
        minHeap.insert(4); //enter intergers
        minHeap.insert(1); 
        minHeap.insert(-5);
        minHeap.insert(3);
        minHeap.printInOrder(); //printout before the removal (should print 4,3, -5, 1)
        Integer min = minHeap.removeMin(); //remove the min
        minHeap.printInOrder();//printout after the removal (should print 3,1,4)
        assertEquals(min, (Integer)(-5)); //assert that -5 was removed
        assertEquals(minHeap.getNumNodes(), 3); //assert that number of nodes was decreased by 1
        assertEquals(minHeap.getRoot().getElement(), (Integer) 1); //assert that the new root in the tree is 1
        minHeap.insert(7); //insert 7 back into the tree. 
        minHeap.printInOrder(); //check if 7 was inserted (shold print 7, 3, 1, 4)
    }

    @Test
    public void testRemoveMin2()
    {
        Heap<Integer> minHeap = new Heap<>(); //create a new minHeap
        minHeap.insert(4); //enter interger 4
        minHeap.printInOrder(); //printout before the removal (should print 4)
        Integer min = minHeap.removeMin(); //remove the min
        minHeap.printInOrder();//printout after the removal (shouldn't print anything)
        assertEquals(min, (Integer)(4)); //assert that 4 was removed
        assertEquals(minHeap.getNumNodes(), 0); //assert that number of nodes was decreased by 1
        assertEquals(minHeap.getRoot(), null); //assert that the new root in the tree is null
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveMinThrowsException()
    {
        Heap<Integer> minHeap = new Heap<>(); //create a new minHeap
        Integer min = minHeap.removeMin(); //remove the min that doesn't exist, test for exception
    }
}
