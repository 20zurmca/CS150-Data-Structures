
/**
 *A class that implements MyLinkedList
 */
public class MyLinkedListIntegerContainer
{
   //fields
   private MyLinkedList <Integer> list = new MyLinkedList<Integer>();
  
    
    /**
     * Method addFront
     * adds an integer to the front of list
     * @param  num the integer to be added to the front of list
     */
    public void addFront(Integer num)
    {
        this.list.addFront(num);
    }
    
    /**
     * Method addBack
     * Adds a number to the back of list
     * @param  num the integer to be added to the back of list
     */
   public void addBack(Integer num)
    {
        this.list.addBack(num);
  }
  
  /**
     * Method linearSearch
     * Searches for an element 
     * @param e the element wanted
     * @return the position in the list
     * @return -1 if not in list
     */
    public int linearSearch(Integer e){
    int index = 0;
    //go through the list and check each node's element
    for(int i=0; i<list.getSize(); i++){
        if(this.list.getElement(i)==e){
            index = i;
            return index;
        }
    }
    return -1;
   }
   
   /**
     * Method iteratorSearch
     * Performs linear search with an iterator 
     * @param e the element wanted
     * @return the position in the list
     * @return -1 if not in list
     */
    public int iteratorSearch(Integer e){
    int index = 0;
    MyLinkedList.MyLinkedListIterator itr = this.list.iterator();
    //while the iterator can traverse, if the element it passed is equal to E, return the index it passed
    while(itr.hasNext()){
        if(itr.next() == e){
            return index;
        }
        //update the index everytime Next is called
        index++;
    }
    return -1;
  }
  
   /**
     * Method getSize
     * Returns MyLinkedListIntegerContainer's size
     */
  public int getSize(){
      return this.list.getSize();
    }
    
    /**
     * Method getList
     * Returns MyLinkedListIntegerContainer's instance variable: list
     */
  public MyLinkedList <Integer> getList(){
      return this.list;
    }
}
