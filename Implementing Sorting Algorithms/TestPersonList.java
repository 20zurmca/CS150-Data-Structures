

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *Testing WorkerList and ContactList classes
 */
public class TestPersonList
{
    /**
     * Default constructor for test class TestWorkerList
     */
    public TestPersonList()
    {
    }
    
    public static void main(String [] args){
    }
    
     @Test
    public void testWorkerCompareTo()
    {
        WorkerList wl = new WorkerList();
        Worker w1 = new Worker(34252, "Cameron", "Zurmuhl");
        Worker w2 = new Worker(19020, "Chloe" , "Hysore");
        Worker w3 = new Worker(18974, "Laurence", "Zurmuhl");
        Worker w4 = new Worker(19023, "Kyle", "Zurmuhl");
        Worker w5 = new Worker(80000, "Sarah", "Zurmuhl");
        
        //result should be a 1
        int result = w1.compareTo(w2);
        //should be negative -1
        int anotherResult = w4.compareTo(w5);
       
       assertEquals(result, 1);
       assertEquals(anotherResult, -1);
        
    }
   
     @Test
    public void testContactCompareTo()
    {
        ContactList cl = new ContactList();
        Contact c1 = new Contact( "Cameron", "Zurmuhl", "2679456473","zurmuhlc@lafayette.edu");
        Contact c2 = new Contact( "Chloe" , "Hysore", "2156740337", "ceh1011000@gmail.com");
        Contact c3 = new Contact( "Laurence", "Zurmuhl", "2156740336","larry.zurmuhl@verizon.net");
        Contact c4 = new Contact( "Kyle", "Zurmuhl", "2156740337", "kyzur@gmail.com");
        Contact c5 = new Contact( "Sarah", "Zurmuhl", "2156740337", "srz@verizon.net");
        
       //result should be positive (Zurmuhl is lower than Hysore)
       int result = c1.compareTo(c2);
       //anotherResult should be negative (Kyle is higher than Sarah)
       int anotherResult = c4.compareTo(c5);
       
       boolean lexographicallyLess = result>0;
       boolean lexographicallyHigher = anotherResult<0;
       
       assertEquals(lexographicallyLess, true);
       assertEquals(lexographicallyHigher, true);
    }
    
    @Test
    public void testaddElement(){
        WorkerList wl = new WorkerList();
        Worker w1 = new Worker(34252, "Cameron", "Zurmuhl");
        wl.addElement(w1);
        Worker [] Theoretical = {w1};
        //use ToArray
        Worker [] Actual = wl.getList().toArray(new Worker [wl.getList().size()]);
        
        assertArrayEquals(Actual,Theoretical);
        
    }
    
    @Test
    public void testWorkerMergeSort()
    {
        WorkerList wl = new WorkerList();
        Worker w1 = new Worker(34252, "Cameron", "Zurmuhl");
        Worker w2 = new Worker(19020, "Chloe" , "Hysore");
        Worker w3 = new Worker(18974, "Laurence", "Zurmuhl");
        Worker w4 = new Worker(19023, "Kyle", "Zurmuhl");
        Worker w5 = new Worker(80000, "Sarah", "Zurmuhl");
        
        //this should be the correct order
        Worker [] Theoretical = { w3, w2, w4, w1, w5};
      
        //add to the list
        wl.addElement(w1);
        wl.addElement(w2);
        wl.addElement(w3);
        wl.addElement(w4);
        wl.addElement(w5);
        
        //sort
        wl.mergeSort(0,wl.getList().size()-1);
        
        //toArray

        Worker [] Actual = wl.getList().toArray(new Worker [wl.getList().size()]);
        
        assertArrayEquals(Actual, Theoretical);
        
    }
    
    @Test
    public void testContactMergeSort()
    {
        ContactList cl = new ContactList();
        Contact c1 = new Contact( "Cameron", "Zurmuhl", "2679456473","zurmuhlc@lafayette.edu");
        Contact c2 = new Contact( "Chloe" , "Hysore", "2156740337", "ceh1011000@gmail.com");
        Contact c3 = new Contact( "Laurence", "Zurmuhl", "2156740336","larry.zurmuhl@verizon.net");
        Contact c4 = new Contact( "Kyle", "Zurmuhl", "2156740337", "kyzur@gmail.com");
        Contact c5 = new Contact( "Sarah", "Zurmuhl", "2156740337", "srz@verizon.net");
        
        //this should be the right order
        Contact [] Theoretical = {c2, c1, c4, c3, c5};
        
        //add to list
        cl.addElement(c1);
        cl.addElement(c2);
        cl.addElement(c3);
        cl.addElement(c4);
        cl.addElement(c5);
        
        //sort
        cl.mergeSort(0,cl.getList().size()-1);
        
        //toArray
        Contact [] Actual = cl.getList().toArray(new Contact [cl.getList().size()]);
        
        assertArrayEquals(Actual,Theoretical);
       
    }
    
     @Test
    public void testWorkerQuickSort()
    {
        //repeat process from merge sort for quick sort
        WorkerList wl = new WorkerList();
        Worker w1 = new Worker(34252, "Cameron", "Zurmuhl");
        Worker w2 = new Worker(19020, "Chloe" , "Hysore");
        Worker w3 = new Worker(18974, "Laurence", "Zurmuhl");
        Worker w4 = new Worker(19023, "Kyle", "Zurmuhl");
        Worker w5 = new Worker(80000, "Sarah", "Zurmuhl");
        
        Worker [] Theoretical = { w3, w2, w4, w1, w5};
      
        wl.addElement(w2);
        wl.addElement(w5);
        wl.addElement(w3);
        wl.addElement(w4);
        wl.addElement(w1);
        
        wl.quickSort(0,wl.getList().size()-1);

        Worker [] Actual = wl.getList().toArray(new Worker [wl.getList().size()]);
        
        assertArrayEquals(Actual, Theoretical);
        
    }
   
     @Test
    public void testContactQuickSort()
    {
        //repeat process from merge sort for quick sort
        ContactList cl = new ContactList();
        Contact c1 = new Contact( "Cameron", "Zurmuhl", "2679456473","zurmuhlc@lafayette.edu");
        Contact c2 = new Contact( "Chloe" , "Hysore", "2156740337", "ceh1011000@gmail.com");
        Contact c3 = new Contact( "Laurence", "Zurmuhl", "2156740336","larry.zurmuhl@verizon.net");
        Contact c4 = new Contact( "Kyle", "Zurmuhl", "2156740337", "kyzur@gmail.com");
        Contact c5 = new Contact( "Sarah", "Zurmuhl", "2156740337", "srz@verizon.net");
        Contact [] Theoretical = {c2, c1, c4, c3, c5};
      
        cl.addElement(c1);
        cl.addElement(c2);
        cl.addElement(c3);
        cl.addElement(c4);
        cl.addElement(c5);
        
        cl.quickSort(0, cl.getList().size()-1);
        Contact [] Actual = cl.getList().toArray(new Contact [cl.getList().size()]);
        
        assertArrayEquals(Actual,Theoretical);
    }
}
