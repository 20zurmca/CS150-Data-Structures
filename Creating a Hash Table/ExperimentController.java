import java.util.ArrayList;
import java.util.concurrent.*;
import java.io.*;
/**
 * Write a description of class ExperimentController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ExperimentController
{

    /**
     * Constructor for class ExperimentController
     */
    public ExperimentController()
    {
    }

    public static void main(String [] args)
    {
        ExperimentController EC = new ExperimentController();
        for(int i = 1000; i <= 10000 ; i+= 1000 ){
            System.out.println("--------------------------------------------------");
            System.out.println();
            EC.timeInsert(i, 10);
            EC.timeFind(i, 10);
            EC.timeFindNegatives(i, 10);
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println();
        }
    }

    /**
     * Method timeInsert reports an averaged time to insert a given amount of elements to a hashTable
     * @param numberOfTimes the number of items to insert
     * @param hashTableSize the size of the hashTable
     */
    public void timeInsert(int numberOfItems, int hashTableSize)
    {
        long totalTime = 0;
        MyHashTable t = t = new MyHashTable(hashTableSize);
        RandomNameGenerator r = new RandomNameGenerator();
        int cycle = 0;

        //fill hashtable and record times
        while(cycle < 5){ //5 run average

            for(int i = 0; i<numberOfItems; i++){

                String firstName = r.nextFirstName(); //first name of student
                String lastName = r.nextLastName(); //last name of student
                long randomID = ThreadLocalRandom.current().nextLong(11111111, 99999999); //random ID for student

                long startTime = System.currentTimeMillis();
                t.insert(new Student(firstName, lastName, randomID)); //insert student
                long stopTime = System.currentTimeMillis();
                totalTime += stopTime - startTime;
            }
            cycle++; //next run
        }
        //summary statistics
        float averagedTime = (float)totalTime/5;
        System.out.println("Time to insert " + numberOfItems+ " students in a hash table of size " + hashTableSize + ": " + averagedTime+ " ms");
    }

    /**
     * Method timeFind returns the averaged time to find every ID in an ID array in a HashTable
     * @param numberOfTimes the number of items to insert
     * @param hashTableSize the size of the hashTable
     */
    public void timeFind(int numberOfItems, int hashTableSize )
    {
        int cycle = 0; //will complete 5 cycles for averaging
        long totalTime = 0; //total time for searching
        ArrayList<Long> IDs = new ArrayList<Long>(); //holds the student IDs to search for 

        //fill the HashTable
        MyHashTable t = new MyHashTable(hashTableSize);
        RandomNameGenerator r = new RandomNameGenerator();

        for(int i = 0; i<numberOfItems; i++){
            String firstName = r.nextFirstName();
            String lastName = r.nextLastName();
            long randomID = ThreadLocalRandom.current().nextLong(11111111, 99999999);
            IDs.add(randomID); //add to array list
            t.insert(new Student(firstName, lastName, randomID));
        }

        //search

        while(cycle < 5 ) //five run average
        {
            //find all keys
            long startTime = System.currentTimeMillis();
            for(int i = 0; i<IDs.size(); i++){
                t.getStudent(IDs.get(i));
            }
            long stopTime = System.currentTimeMillis();
            totalTime += (stopTime - startTime);
            cycle++; //update run
        }

        //summary statistics
        float averagedTime = (float)totalTime/5;
        System.out.println("Time to Find " + IDs.size() + " Students in a hash table of size " + hashTableSize + ": " + averagedTime + " ms");
    }

    /**
     * Method timeFindNegatives returns the averaged time to find IDs that are not in the hashtabl
     * @param numberOfTimes the number of items to insert
     * @param hashTableSize the size of the hashTable 
     */
    public void timeFindNegatives(int numberOfItems, int hashTableSize )
    {
        int cycle = 0; //will complete 5 cycles for averaging
        long totalTime = 0; //total time for searching

        //fill the HashTable
        MyHashTable t = new MyHashTable(hashTableSize);
        RandomNameGenerator r = new RandomNameGenerator();

        for(int i = 0; i<numberOfItems; i++){
            String firstName = r.nextFirstName();
            String lastName = r.nextLastName();
            long randomID = ThreadLocalRandom.current().nextLong(11111111, 99999999);
            t.insert(new Student(firstName, lastName, randomID));
        }

        //search

        while(cycle < 5 ) //5 run average 
        {
            //find all keys
            long startTime = System.currentTimeMillis();
            for(int i = 0; i<numberOfItems; i++){
                t.getStudent(ThreadLocalRandom.current().nextLong(-1234322112, -4543422));
            }
            long stopTime = System.currentTimeMillis();
            totalTime += (stopTime - startTime);
            cycle++;
        }

        //summary statistics 
        float averagedTime = (float)totalTime/5;
        System.out.println("Time to Find " + numberOfItems + " Students that don't exist in a hash table of size " + hashTableSize + ": " + averagedTime + " ms");
    }
}

