
/**
 * Write a description of class Simulation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Simulation
{
    public static void main(String [] args)
    {
        SortedLinkedList<Integer> sList = new SortedLinkedList<>();
        //try to replicate the example given on the page
        sList.add(1);
        sList.add(5);
        sList.add(5);
        sList.add(5);
        sList.add(7);
        sList.add(10);
        sList.add(10);
        sList.add(10);
        sList.add(10);
        sList.add(12);
        sList.add(12);
        //print out the string
        System.out.println(sList.toString());
    }
}
