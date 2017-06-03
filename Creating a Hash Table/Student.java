
/**
 * A class that represents a student
 */
public class Student
{
    //**********************FILEDS***********************//

    private String firstName; //first name
    private String lastName; //last name
    private long studentID; //student ID

    /**
     * Constructor for class Student
     * @param fN this object's first name
     * @param lN this object's last name
     * @param ID this object's student ID
     */
    public Student(String fN, String lN, long ID)
    {
        firstName = fN;
        lastName = lN;
        studentID = ID;
    }

    //********************METHODS*****************////

    /**
     * Method getfirstName returns this object's first name
     * @return this object's first name
     */
    public String getfirstName()
    {
        return firstName;
    }

    /**
     * Method getlastName returns this object's lastName
     * @return this object's last name
     */
    public String getlastName()
    {
        return lastName;
    }

    /**
     * Method getID returns this object's student ID
     * @returns this object's student ID
     */
    public long getID()
    {
        return studentID;
    }
    
    public String toString()
    {
        return firstName + " " + lastName + " " + studentID;
    }
}
