import java.util.NoSuchElementException;
/**
 * Class SortedLinkedList is a sorted linked list with down pointers for similar elements
 */
public class SortedLinkedList<E extends Comparable<? super E>> 
{
    //instance variables for class SortedLinkedList
    private SortedLinkedListNode<E> Head; // the head of the list

    /**
     * Constructor for class SortedLinkedList
     */
    public SortedLinkedList()
    {
        Head = new SortedLinkedListNode(null, null, null);
    }

    /**
     * Method add adds a node to the list based on its key.
     * @param value the value of the node to add
     */
    public void add(E value)
    {
        if(Head.getNext() == null) //simple case: if there are no elements in list just add node to head
        {
            Head.setNext(new SortedLinkedListNode(value, null, null));
            return;
        } else { //complex case
            SortedLinkedListNode<E> temp = Head.getNext(); //start temp at Head.next
            SortedLinkedListNode<E> OneBeforeTemp = Head; //have a trail marker behind temp
            while(temp != null) //while we are still traversing the list
            {
                if(value.compareTo(temp.getValue()) < 0){ //if the value at temp is less than the value passed
                    OneBeforeTemp.setNext(new SortedLinkedListNode(value, temp, null)); //insert at one before temp, reference that inserted node to temp
                    return;
                } else if(value.equals(temp.getValue())){ //if the elements equal we need to add to the down list
                    temp.setDown(new SortedLinkedListNode(value, null, temp.getDown())); //set the new down node's reference to the current down's
                    return;
                }
                temp = temp.getNext(); //update temp
                OneBeforeTemp = OneBeforeTemp.getNext(); //update trailer 
            }
            //all else fail case--we are inserting the largest key in the list. Temp will be null (will be at the reference of last node's next)
            //OneBeforeTemp will be at last non-null node.  Set it's next reference to a new node

            OneBeforeTemp.setNext(new SortedLinkedListNode(value, null, null)); 
        }
    }

    /**
     * Method count counts how many times a certain value appears in the list
     * @param value to the value to evaluate
     * @return the number of times value showed up in the list
     */
    public int count ( E value )
    {
        if(Head.getNext() == null){
            throw new NoSuchElementException("The list is empty");
        } 
        int count = 0; //initialize a counter
        SortedLinkedListNode<E> temp = Head; //set temp to head
        while((temp = temp.getNext()) != null) //while temp is the next pointer and is not null
        {
            if(temp.getValue().equals(value)){ //if we get a hit
                count++; //update the counter for the first hit
                SortedLinkedListNode<E> temp2 = temp; //now set another temp node referrenced to that temp to check for down nodes
                while((temp2 = temp2.getDown()) != null){ //while there are still elements below temp2 (bottom references are similar elements)
                    count++; //update counter
                }
            }
        }
        return count;
    }

    /**
     * Method remove removes an element from the list.  
     * If there are more than one elements equal to @param e, removes the first on the equal list.  If no such element exists, return false;
     * @param e the element to remove 
     * @return whether there is an element in the list to remove (If the remove was successful
     */
    public boolean remove(E e)
    {
        if(Head.getNext() == null){
            return false; //there are no elements in the list, return false 
        } 
        SortedLinkedListNode<E> temp = Head.getNext(); //set temp to head.next
        SortedLinkedListNode<E> OneBeforeTemp = Head; //have a following reference 

        while((temp != null)){ //while temp is not null
            if(temp.getValue().equals(e)){ //if we get a hit go to 2 cases 
                if(temp.getDown() != null){ //if temp's down reference is not null, set one before temp's reference to that down--this will take out one reference in the down list
                    OneBeforeTemp.setNext(temp.getDown());
                    //now set that down's reference to temp's next
                    temp.getDown().setNext(temp.getNext());
                    temp.setNext(null); //set temp's next to null
                    return true;
                } else { //if it is null, set OneBeforeTemp's next reference to the one after temp's
                    OneBeforeTemp.setNext(temp.getNext());
                    temp.setNext(null); //set temp's next to null
                    return true;
                }
            }
            temp = temp.getNext(); //update temp
            OneBeforeTemp = OneBeforeTemp.getNext(); //update following reference
        }
        return false; //element was not in the list
    }

    /**
     * Method toString returns a string representation of the list
     * @return the list in string form
     */
    public String toString()
    {

        //Plan: First check if Head.next is null (throw Exception). Else, Traverse each element.  Call the count method for that element.  The String will be that element + count
        if(Head.getNext() == null){
            throw new NoSuchElementException("The list is empty");
        }

        SortedLinkedListNode<E> temp = Head;
        String rt = "";
        int elementCount = 0;
        while((temp = temp.getNext()) != null) //keep updating temp to traverse the list
        {
            elementCount = count(temp.getValue());
            if(temp.getNext() != null){
                rt += temp.getValue().toString() + "-" + elementCount + ","; //iterratively compound the strings
            } else {
                rt += temp.getValue().toString() + "-" + elementCount; //don't add the comma if it's the last element in list 
            }
        }
        return rt; 
    }	
}
