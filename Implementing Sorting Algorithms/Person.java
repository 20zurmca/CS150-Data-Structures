
/**
 * Abstract class that represents a person
 * 
 */
public abstract class Person
{
    // instance variables 
   protected String firstName;
   protected String lastName;
   
   //constructor
   public Person(){}
   /**
    * Method GetFirstName
    * @return the first name of the person
    */
   protected String GetFirstName(){
       return this.firstName;
    }
    /**
    * Method GetLastName
    * @return the last name of the person
    */
   protected String GetLastName(){
       return this.lastName;
    }
}