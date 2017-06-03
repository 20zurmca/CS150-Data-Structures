
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
/**
 * Test class for BinarySearchTree
 */
public class TestBinarySearchTree
{
    @Test
    public void testGetRoot()
    {
        BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>(); //create a BinarySearchTree
        BinaryNode<Integer> root = null; // this is what tree's root references
        assertEquals(root, tree.getRoot());
        
        //add some integers in and see if the right root element returns
        tree.insert(7);
        tree.insert(9);
        tree.insert(6);
        
        Integer e = tree.getRoot().getElement();
        assertEquals((Integer)7,e);
        
        
    }

    @Test
    public void testSize()
    {
        BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>(); //create a BinarySearchTree
        int size = 0; //this is the size of the empty tree
        int realSize = tree.size(); //obtain the real size from the root
        assertEquals(size, realSize); //assert equality
        //insert an element, check if size is 1
        tree.insert(9);
        size = 1;
        realSize = tree.size();
        assertEquals(size, realSize);
    }

    @Test
    public void testEmpty()
    {
        BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>(); //create a BinarySearchTree
        tree.insert(6); //insert an integer
        tree.empty(); //make empty
        assertEquals(tree.getRoot(), null); //assert equality (root should be null)
        assertEquals(tree.isEmpty(), true); //make sure that isEmpty will return true
    }

    @Test
    public void testInsert()
    {
        BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>(); //create a BinarySearchTree
        boolean success = tree.insert(6); //insert 6 to the tree
        assertEquals(true, success); //check if the the insertion was successful
        //check if the root's children are null
        assertEquals(tree.getRoot().getLeft(), null);
        assertEquals(tree.getRoot().getRight(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertThrowsException()
    {
        BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>(); //create a BinarySearchTree
        boolean success = tree.insert(6); //insert 6 to the tree
        //try to insert the same element again and see if exception occurs
        tree.insert(6);
    }

    @Test
    public void testRemove()
    {
        BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(6); //insert 6 into the tree
        boolean success = tree.remove(6); //remove 6 from the tree
        assertEquals(true, success); //check if size depeleted by 1
    }

    @Test
    public void testRemove2() 
    {
        BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>();
        //insert multiple elements 
        tree.insert(7);
        tree.insert(3);
        tree.insert(8);
        tree.insert(9);
        tree.insert(2);
        tree.insert(6);
        boolean success = tree.remove(7); //remove 7 and 2 from the tree
        boolean success2 = tree.remove(2);
        assertEquals(true, success); //check if size depeleted by 2
        assertEquals(true, success2);
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testRemoveThrowsException()
    {
        BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>();
        //insert multiple elements 
        tree.insert(7);
        tree.insert(3);
        tree.insert(8);
        tree.insert(9);
        tree.insert(2);
        tree.insert(6);
        //try to remove an element that doesn't exist in the tree, should throw exception
        tree.remove(20);
        
    }

    @Test
    public void testContains() 
    {
        BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>();
        //insert multiple elements 
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(9);
        tree.insert(2);
        tree.insert(6);
        boolean success = tree.contains(5); //remove 5 from the tree
        assertEquals(true, success); //check if size depeleted by 1
        
        //call contains with an integer not in the tree
        boolean fail = tree.contains(20);
        assertEquals(false, fail);
    }

    @Test
    public void testFindMin()
    {
        BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>();
        //insert multiple elements 
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(9);
        tree.insert(2);
        tree.insert(6);
        Integer min = tree.findMin(); //obtain the min element
        assertEquals(min, (Integer)2); //check if 2 was returned
    }

    @Test
    public void testFindMax()
    {
        BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>();
        //insert multiple elements 
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(9);
        tree.insert(2);
        tree.insert(6);
        Integer max = tree.findMax(); //obtain the max element
        assertEquals(max, (Integer)9); //check if 9 was returned
    }

}
