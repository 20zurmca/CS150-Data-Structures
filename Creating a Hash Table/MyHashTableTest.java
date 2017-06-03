
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.*;

/**
 * The test class MyHashTableTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyHashTableTest
{
    @Test
    public void testInsert()
    {
        MyHashTable t = new MyHashTable(10);
        boolean a = t.insert(new Student("Cameron", "Zurmuhl", 34252L));
        boolean b = t.insert(new Student("Jackie", "Robinson", 34252L));
        assertEquals(a, true);
        assertEquals(b, false);
    }

    @Test
    public void testGetStudent()
    {
        MyHashTable t = new MyHashTable(10);
        RandomNameGenerator random = new RandomNameGenerator();
        Student Cameron = new Student("Cameron", "Zurmuhl", 34252L);
        t.insert(Cameron); //insert students
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 42523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43524L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43573L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43543L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43583L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43323L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43123L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 53123L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 63123L));

        Student s = t.getStudent(34252L); //obtain that student from the list
        assertEquals(s, Cameron);
    }

    @Test
    public void testPopStudent()
    {
        MyHashTable t = new MyHashTable(10);
        RandomNameGenerator random = new RandomNameGenerator();
        Student Cameron = new Student("Cameron", "Zurmuhl", 34252L);
        t.insert(Cameron); //insert students
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 42523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43524L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43573L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43543L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43583L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43323L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43123L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 53123L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 63123L));

        Student s = t.popStudent(34252L); //obtain a student from the list
        assertEquals(s, Cameron);

        //assert that if you try to get the student again, the result is null
        assertEquals(t.getStudent(34252L), null);
    }

    @Test
    public void testLoadFactor()
    {
        MyHashTable t = new MyHashTable(10);
        Student Cameron = new Student("Cameron", "Zurmuhl", 34252L);
        t.insert(Cameron); //insert a student
        assertEquals(t.calcLoadFactor(), .10f, 0.00f); //should be 1/10 spots filled, or .10
    }
    
    @Test
    public void testLoadFactor2()
    {
        MyHashTable t = new MyHashTable(10);
        RandomNameGenerator r = new RandomNameGenerator();
        //insert 30 students
        for(int i = 0 ; i<30; i++)
        {
            t.insert(new Student(r.nextFirstName(), r.nextLastName(), ThreadLocalRandom.current().nextLong(10000,20000)));
        }
        
        assertEquals(t.calcLoadFactor(), 3.0f, 0.0f); //should be 300% full
    }
    
    @Test
    public void testInsert2()
    {
        MyHashTable t = new MyHashTable(10);
        RandomNameGenerator r = new RandomNameGenerator();
        //insert 30 similar students
        for(int i = 0 ; i<30; i++)
        {
            t.insert(new Student(r.nextFirstName(), r.nextLastName(), 1000L));
        }
        assertEquals(t.calcLoadFactor(), 0.1f, 0.0f); //should be 1/10 full because duplicates are not allowed
    }

    @Test
    public void testBoundaryCase()
    {
        MyHashTable t = new MyHashTable(0); //I made it the case that the hash table will be size 10 if input for n is 0 or below
        assertEquals(t.calcLoadFactor(), 0.0f, 0.0f); //should be all empty therefore no load factor
        t.insert(new Student("Cameron", "Zurmuhl", 34252L)); 
        //load factor should now be 1/10
        assertEquals(t.calcLoadFactor(), 0.1f, 0.0f);
    }

    @Test
    public void testInsert3()
    {
        //insert a lot of elements, some which will be duplicates and won't enter, then test loadfactor

        MyHashTable t = new MyHashTable(10);
        RandomNameGenerator random = new RandomNameGenerator();
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L));  //duplicate 
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 42523L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43524L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43573L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L)); //duplicate
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43523L)); //duplciate 
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43543L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43583L));
        t.insert(new Student(random.nextFirstName(), random.nextLastName(), 43323L));

        //load factor should be .70

        assertEquals(t.calcLoadFactor(), .7f, 0.0f);
    }
}
