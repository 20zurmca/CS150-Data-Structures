
/**
 * Worker class extends Person
 */
public class Worker extends Person implements Comparable<Worker>
{
    // instance variables - replace the example below with your own
    private long ID;
  
    /**
     * Constructor for objects of class Worker
     */
    public Worker(long id, String fn, String ln)
    {
        super();
        this.ID = id;
        this.firstName = fn;
        this.lastName = ln;
    }
    
    
    //Methods
    @Override
    public int compareTo(Worker w){
        
        if(this.ID == w.getID()){
            return 0;
        } else if(this.ID > w.getID()){
            return 1;
        } else {
            return -1;
        }
        
   }
   
   /**
    * Method getID
    * @return the worker's ID
    */
   
   public long getID(){
       return this.ID;
    }
}
