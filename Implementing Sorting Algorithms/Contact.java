
/**
 * A class that represents a contact
 */
public class Contact extends Person implements Comparable<Contact>
{
    // instance variables - replace the example below with your own
    private String phoneNumber;
    private String email;

    /**
     * Constructor for objects of class Contact
     */
    public Contact(String fn, String ln, String phone, String email)
    {
       super();
       this.firstName = fn;
       this.lastName = ln;
       this.phoneNumber = phone;
       this.email = email;
    }
    
 
    @Override
    public int compareTo(Contact c){
        //if last name equals other last names, check first names
         if(this.lastName.equals(c.lastName)){
             //if first names equal return 0
              if(this.firstName.equals(c.firstName)){
            return 0;
           }
            return this.firstName.compareTo(c.firstName);
          
        }
       return this.lastName.compareTo(c.lastName);
    }
    
    /**
     * Method getphoneNumber
     * @return the contact's phone number
     */
    public String getphoneNumber()
    {
        return this.phoneNumber;
    }
    
    /**
     * Method getEmail
     * @return the contact's email
     */
    
    public String getEmail(){
        return this.email;
    }
    
}

