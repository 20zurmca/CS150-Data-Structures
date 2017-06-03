

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest
{
    private Student a = new Student("Cameron","Zurmuhl", 34252L);
    @Test
    public void testgetfirstName()
    {
        assertEquals("Cameron", a.getfirstName());
    }
    
    @Test
    public void testgetlastName()
    {
        assertEquals("Zurmuhl", a.getlastName());
    }
    
    @Test
    public void testgetID()
    {
        assertEquals(34252, a.getID());
    }
    
}
