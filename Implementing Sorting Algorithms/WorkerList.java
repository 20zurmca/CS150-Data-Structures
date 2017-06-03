
/**
 * WorkerList - extends SortedList 
 * 
 */
public class WorkerList extends SortedList<Worker>
{
    /**
     * Constructor for objects of class WorkerList
     */
    public WorkerList()
    {
        super();
    }
    
   @Override
    public void printData(){
        for(Worker w: this.data){
            System.out.println("First Name: " +w.GetFirstName() + " Last Name: " + w.GetLastName() + " ID: " +w.getID());
        }
    }
}
