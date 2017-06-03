import java.util.ArrayList;
import java.util.Random;
/**
 * Abstract class SortedList - contains an ArrayList that will have defined methods to be extended
 * Contains one abstract method to be inherited and defined
 */

public abstract class SortedList <T extends Comparable<? super T>> 
{
    // instance variables - replace the example below with your own
    protected ArrayList <T> data = new ArrayList<T>();
    
  /**
  * Constructor for SortedList
  */
 
  public SortedList () {}
  
  //Methods

  /**
   * Method addElement adds an element to the data
   * @param element an element to be added to the data
   */
  public void addElement (T element)
  {
      this.data.add(element);
  }
  
   /**
   * Method quickSort 
   * @param low the first index in data
   * @param high the last index in data
   * Sorts 
   */
   public void quickSort (int low, int high)
  {
      
      int middle = (low + high)/2;
      T Mid = this.data.get(middle);
      T Low = this.data.get(low);
      T High = this.data.get(high);
      
      //if there are no element in the list, return
      if(high-low<=0){
          return;
        }
      //if there are two elements in the list, just sort those two
      if(high-low==1){
          if(Low.compareTo(High)>0){
              swap(low,high);
              return;
            
        } 
      }
      //Begin median of three pivot selection
      if(Mid.compareTo(Low)<0){
          swap(low,middle);
        }
        
      if(High.compareTo(Low)<0){
          swap(low,high);
        }
        
      if(High.compareTo(Mid)<0){
          swap(middle,high);
       }
       
      //place pivot at position high-1
      swap(middle, high-1);
      T Pivot = this.data.get(high-1);
      
      //Begin partitioning. If there are more than three elements the list is already sorted--no need to continue
      if(high-low > 2){
      int i;
      int j;
      for(i=low, j=high-1; ; ){
          //Enter ArrayList from the left and compare to pivot--find values that are less than pivot 
          while(this.data.get(++i).compareTo(Pivot)<0){
          ;
        }
        //Enter ArrayList from the right and compare to pivot--find values that are greater than pivot
          while(Pivot.compareTo(this.data.get(--j))<0){
           ;
        }
        //if the two markers cross eachother, stop
        if(i>=j){
            break;
            }
          //swap
        swap(i, j);
        }
        //restore pivot and sort
        swap(i, high-1);
        quickSort(low, i-1);
        quickSort(i+1, high);
    
    }
  }
 
  /**
  * Method swap exchanges reference positions in data
  * @param i one reference
  * @param j the other reference
  */
   public void swap(int i, int j)
    {
     //standard swap algorithm
      if(i >=0 && j>=0){
        T temp =this.data.get(i);
        this.data.set(i, this.data.get(j));
        this.data.set(j, temp);
      }
    }
    
   /**
    * Method mergeSort sorts the data
    * @param left the left-most index of the subarray
    * @param right the right-most index of the subarray
    */
  public void mergeSort( int left, int right)
  {
      if(left<right){
          int center = (left + right)/2;
          //sort left half 
          mergeSort(left, center);
          //sort right half
          mergeSort(center+1, right);
          //merge the arrays
          merge(left, center+1, right);
    }
  }
  
  /**
   * Method merge merges two sorted sublists together
   * @param leftPosition the left-most index of the subarry
   * @param rightPosition the index of the start of the second half.
   * @param rightEnd the right-most index of the subarray
   */
  public void merge( int leftPosition, int rightPosition, int rightEnd)
   {
       //initialize a temp array
       T [] tempArray = (T []) new Comparable[this.data.size()];
       
       int leftEnd = rightPosition - 1;
       int tempPosition = leftPosition;
       int numElements = rightEnd - leftPosition + 1;
       
       //main loop
       while(leftPosition <= leftEnd && rightPosition <= rightEnd){
           if(this.data.get(leftPosition).compareTo(this.data.get(rightPosition)) <= 0){
               tempArray[tempPosition++] = this.data.get(leftPosition++);
            } else {
                tempArray[tempPosition++] = this.data.get(rightPosition++);
            }
        }
        
       while(leftPosition <= leftEnd){ //copy rest of first half
            tempArray[tempPosition++] = this.data.get(leftPosition++);
        }
        
       while(rightPosition <= rightEnd){ //Copy rest of right half
            tempArray[tempPosition++] = this.data.get(rightPosition++);
        }
       
        //copy temp array back
       for(int i = 0; i< numElements; i++, rightEnd--)
        {
           this.data.set(rightEnd,tempArray[rightEnd]); 
        }
   
  }
  
  public void insertionSort(){
      for(int i = 1; i<this.data.size(); i++){
          T toInsert = this.data.get(i);
          int j;
          for(j = i-1; i>=0; j--){
              if(toInsert.compareTo(this.data.get(j))<0){
                  this.data.set(j+1,this.data.get(j));
                } else {
                    break;
                }
    }
     this.data.set(j+1, toInsert); 
  }
}


  /**
   * Method printData to be inherited and defined in concrete class
   */
  public abstract void printData();
  
  /**
   * Method getList returns the ArrayList
   * @return the data
   */
  public ArrayList<T> getList(){
      return this.data;
    }
  
    
}
