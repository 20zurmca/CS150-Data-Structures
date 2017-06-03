
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for BinaryNode <E>
 */
public class TestBinaryNode
{

    @Test
    public void testGetElement()
    {
        BinaryNode<Integer> testNode = new BinaryNode<Integer>(5); //create a new binary node
        Integer result = 5; //this is the node's \\0lement
        Integer getElement = testNode.getElement(); //retrieve the element
        assertEquals(result, getElement); //assert that they equal

    }
    

    @Test
    public void testSetElement()
    {
        BinaryNode<Integer> testNode = new BinaryNode<Integer>(5); //create a new binary node
        testNode.setElement(6); //set the node's element to 6
        Integer result = 6;
        Integer getElement = testNode.getElement(); //retrieve the new element
        assertEquals(result, getElement); //assert equality
    }
    
    @Test
    public void testGetLeft()
    {
        BinaryNode<Integer> testNode = new BinaryNode<Integer>(5); 
        BinaryNode<Integer> result = null; //the node's left child should be null
        BinaryNode<Integer> getLeft = testNode.getLeft(); //retrieve the left child
        assertEquals(result, getLeft);
    }
    
    @Test
    public void testGetRight()
    {
        BinaryNode<Integer> testNode = new BinaryNode<Integer>(5);
        BinaryNode<Integer> result = null;  //the node's right child should be null
        BinaryNode<Integer> getRight = testNode.getRight(); //retrieve the right child
        assertEquals(result, getRight);
    }
    
    @Test
    public void testSetRight()
    {
        BinaryNode<Integer> testNode = new BinaryNode<Integer>(5);
        BinaryNode<Integer> NodeToSet = new BinaryNode<Integer>(6); //node to set to be right child
        testNode.setRight(NodeToSet); //set the right child
        BinaryNode<Integer> getRight = testNode.getRight(); //retrieve the right child
        assertEquals(NodeToSet, getRight);//check for equality
    }
    
    
    @Test
    public void testSetLeft(){
        //same logic for testSetRight()
        BinaryNode<Integer> testNode = new BinaryNode<Integer>(5);
        BinaryNode<Integer> NodeToSet = new BinaryNode<Integer>(6);
        testNode.setLeft(NodeToSet);
        BinaryNode<Integer> getLeft = testNode.getLeft();
        assertEquals(NodeToSet, getLeft);
        
    }
}