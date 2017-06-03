
/**
 * ContactList - extends SortedList
 */
public class ContactList extends SortedList<Contact>
{
    

    /**
     * Constructor for objects of class ContactList
     */
    public ContactList()
    {
       super();
    }
    
    @Override
    public void printData()
    {
        for(Contact c: this.data){
            System.out.println("Name: " +c.GetLastName() + ", " + c.GetFirstName() + " Email: " + c.getEmail() + " Phone: " + c.getphoneNumber());
    }
   } 
   
}
