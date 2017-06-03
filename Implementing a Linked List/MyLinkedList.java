import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
/**
 * A singly linked, non-circular list
 */
public class MyLinkedList <E> implements Iterable  
{

  /**
  * Class: Node
  * A class that represents a node in MyLinkedList
  */
    private static class Node <E>{
     //fields
     public E Element;
     //Next is the next node
     public Node <E> Next;
     //constructor
     public Node (E element, Node <E> reference ){
        Element = element;
        Next = reference;
     }
     
  }
 
    //instance variables for MyLinkedList class

    //the size of the list
    private int size; 
    //the head of the Linked List
    private Node Head;
    //tail of the linked list
    private Node Tail;
	//Counter for the iterator to prevent concurrent modifications
	private int modCount = 0;

   
    //outer class constructor
  public MyLinkedList()
  {
       size = 0;
       //The head and tail will function as placeholders (dummy nodes) to make the iterator easier to implement.  They will have no data; the tail will reference null; the head will reference the tail.
       Tail = new Node <E> (null,null);
       Head = new Node <E> (null, Tail);
	   modCount++;
        
  }
    
  
  //Methods
  /**
   * Method iterator
   * Creates an instance of MyLinkedListIterator
   * @return an iterator
  */
  
   @Override
   public MyLinkedListIterator iterator(){
    return new MyLinkedListIterator();
    }
    
  /**
  * Method addFront
  * adds a node to the front of MyLinkedList
  * @param Element the element to add
  */
   public void addFront (E Element)
  {
           // The node's reference will be the head's original reference
			Node <E> newNode = new Node(Element, Head.Next);
		   //update the head's reference to be the new node
			Head.Next = newNode;
            size++;
			modCount++;
   }
   
  /**
  * Method addFront
  * adds a node to the back of MyLinkedList
  * @param Element the element to add
  */
   public void addBack (E Element)
   {
     if(Tail.Next == null && Head.Next == Tail){
           //Same situation as addFront
           addFront(Element);
           modCount++;
     } else {
            //Else add a new node to the end of the list, having it reference the Tail
            Node newTail = new Node(null, null);
            this.Tail.Element = Element;
            this.Tail.Next = newTail;
             //update size
            size++;
            this.Tail = newTail;
            modCount++;
     }
   }

   /**
   *Method getNode
   *Returns the node at a given index
   *@param index the index
   *@return a Node
   */
    private Node <E> getNode(int index) 
   {
     if(index >= size || index<0){
		throw new IndexOutOfBoundsException();
     }
     if(this.size==0){
         throw new NullPointerException();
        }
      //first node is the one that the head references (node 0)
		Node <E> Current = Head.Next;
       //traverse the list until index is reached
		for(int i = 0; i<index; i++){
		Current = Current.Next;
     }
     //return current
     return Current;
    }
    
	 /**
   *Method getElement
   *Returns a node's element at a given index.  Uses getNode.
   *@param index the index
   *@return E an element
   */
	public E getElement(int index){
    return this.getNode(index).Element;
   }
   
   /**
   *Method getSize
   *@return MyLinkedList's size
   */
    public int getSize(){
        return this.size;
    }
    
    /**
   *Method toArray
   *@return all the elements in MyLinkedList to an Array
   */
   public E [] toArray(E [] array){
       if(array.length<1 || this.size>array.length){
           System.out.println("Error: Array dimensions do not match with the list size");
           return null;
        }
        for(int i = 0; i<this.size; i++){
            array[i] = this.getElement(i);
       }
       return array;
    }
  
  /**
  * Class MyLinkedListIterator
  * A class that implements java's Iterator interface for MyLinkedList
  */
   public class MyLinkedListIterator implements Iterator <E> 
   {
    //Instance variables
	private Node <E> Current;
	private int expectedModCount = modCount;
    
   //Constructor 
   public MyLinkedListIterator()
   {
     //start the iterator at the first element (just past the head)
     Current = Head.Next;
   }
   
   @Override
   public boolean hasNext()
	{
     if(expectedModCount!=modCount){
		 throw new ConcurrentModificationException();
	   }
     //as long as current is not on the tail, list has potential to have a next node
	  return Current != Tail;
    }
	
	@Override
   public E next() {
	  if(!hasNext()){
		throw new NoSuchElementException();
	  }
      //the item will be the current element the iterator is on
	  E Element = Current.Element;
      //the iterator will move one spot when next is called
      Current = Current.Next;
	  //return the item from the node we left behind
	  return Element;
    }
  }
}
