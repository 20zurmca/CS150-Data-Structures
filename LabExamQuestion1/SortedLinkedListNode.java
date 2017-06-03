
public class SortedLinkedListNode<E>{
    private SortedLinkedListNode<E> next; //reference to next node
    private SortedLinkedListNode<E> down; //reference to the node below it (if applicable)
    private E element; //element in the node
    /**
     * Constructor for class SortedLinkedListNode
     * @param key the node's key
     * @param element the node's element
     * @param reference the node's next pointer
     */
    public SortedLinkedListNode( E element, SortedLinkedListNode<E> reference1, SortedLinkedListNode<E> reference2){
        this.element = element;
        this.next = reference1;
        this.down = reference2; 
    }

    /**
     * Method setNext adds a node to the list by changing a node's pointer
     * @param n the node to change its pointer
     */
    public void setNext(SortedLinkedListNode<E> n){
        this.next = n;
    }

    /**
     * Method setDown adds a node to the list by changing a node's pointer
     * @param n the node to change its pointer
     */
    public void setDown(SortedLinkedListNode<E> n)
    {
        this.down = n;
    }

    /**
     * Method getNext gets a node's pointer
     * @return the node's reference
     */
    public SortedLinkedListNode<E> getNext()
    {
        return this.next;
    }
    
    /**
     * Method getDown gets a node's bottom pointer
     * @return the node's reference
     */
    public SortedLinkedListNode<E> getDown()
    {
        return this.down;
    }

    /**
     * Method getValue returns a node's element
     * @return the element of the node
     */
    public E getValue(){
        return this.element;
    }
}