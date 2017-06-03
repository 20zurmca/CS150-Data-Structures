
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RandomNameGeneratorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RandomNameGeneratorTest
{
    @Test
    public void testRandomNameGenerator()
    {
        RandomNameGenerator random = new RandomNameGenerator();
        //make a random name and print to consol, see if it makes sense
        System.out.println(random.nextFirstName() + " " + random.nextLastName());
    }
    
    @Test
    public void testRandomStudentGenerator()
    {
        RandomNameGenerator random = new RandomNameGenerator(); //create a random name generator
        MyHashTable table = new MyHashTable(3); //create a new hashtable
        
        Student s = new Student(random.nextFirstName(), random.nextLastName(), 34252L);
        table.insert(s); //insert randomly generated student to hash table
        Student t = table.popStudent(34252L); //achieve that student 
        
        assertEquals(t, s); //assert equality
        
        System.out.println(t.getfirstName() + " " + t.getlastName()); //check if name makes sense
    }
}
