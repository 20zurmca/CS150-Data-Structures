import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
/**
 * class that tests the runTime of iteratorSearch and linearSearch for MyLinkedList
 */
public class ExperimentController
{
    //create a File object containing the Census data
    private File CenusNames= new File("Names.txt");
    //LastNames will be a quarter of Census data
    private String [] LastNames = new String [88799];
    //Will read the file into an array
    private String [] CensusData = new String [4*88799];
    //random letters used for building first names
    private String [] randomLetters = {"a", "e", "v", "b"};
    private int CensusDataindex = 0;
    private int LastNameindex = 0;
    
    /**
     * Constructor for objects of class ExperimentController
     */
  public ExperimentController() {}
 
    
    public void fillNames(){
    //initialize a scanner object 
    Scanner reader = null;
    try {
     reader = new Scanner(CenusNames);
     while(reader.hasNext()){
        //load all the census data in to the array--contains last name and three statistics with the name
        this.CensusData[CensusDataindex] = reader.next();
        this.CensusDataindex++;
     }

     for(int i =0; i<CensusData.length; i=i+4){ //Last names occur every four strings in Census data
        this.LastNames[LastNameindex] = this.CensusData[i];
        this.LastNameindex++;
     }
     //shuffle the names to get a mix
     shuffle(LastNames);
  } catch(Exception e){
    e.printStackTrace();
   }
 }

  
   
   public static void main(String [] args)
   {
        ExperimentController EC = new ExperimentController();
        //load the names
        EC.fillNames();
        int numTrials = 0;
        //ask the user how many trials he/she wants for averaging
        Scanner in = new Scanner(System.in);
          try{
            System.out.print("Enter the amount of trials to sort 88799 elements.  These trials will be used to average the run times: ");
            numTrials = in.nextInt();
          } catch (Exception e){
            e.printStackTrace();
        
       }
      //call all the sorts
        EC.timeofquickSort1(EC.LastNames.length, 100, numTrials);
        EC.timeofquickSort2(EC.LastNames.length, numTrials);
        EC.timeofmergeSort1(EC.LastNames.length, 100, numTrials);
        EC.timeofmergeSort2(EC.LastNames.length, numTrials);
    
  }
    
 
     /**
     * Method timeofquickSort1
     *A method that times quicksort on a WorkerList
     *@param numberOfItems the number of Workers to be added
     *@param seed the random seed used
     *@param numOfRuns number of trials per experiment
     *@return the run time in ms
     */
    public float timeofquickSort1(int numberOfItems, int seed, int numOfRuns){
      long totalTime = 0;
      float avgTime = 0;
      int cycle = 0;
      while(cycle<numOfRuns){
      Random random = new Random(seed);
      WorkerList wl= new WorkerList();
      //add random workers to the list
      for(int i=0; i<numberOfItems; i++){
          if(random.nextInt()>0){
          Worker w = new Worker(random.nextInt(), "FirstName", "LastName");
          wl.addElement(w);
        }
    }
      //time the amount of time it takes to search the list for a worker
      //give print outs for each trial
      System.out.println("Working on trial " + cycle +"...");
      long startTime = System.currentTimeMillis();
      //sort the list
      wl.quickSort(0, wl.getList().size()-1);
      long stopTime = System.currentTimeMillis();
      //compound the totalTime per cycle
      totalTime += (stopTime - startTime);
    
     //update cycle and seed for next run
      cycle++;
      seed++;
   }
   //take an average
    avgTime = (float)totalTime/numOfRuns;
   //print results
    System.out.println("----------------------WorkerList QuickSort Results-------------------------------");
    System.out.println("The WorkerList was sorted in " + avgTime +"ms, on a " + numOfRuns + " run average.");
    System.out.println();
    return avgTime;
 }
 
 /**
     * Method timeofquickSort2 times quicksort on a ContactList
     *@param numberOfItems the number of Contacts to be added
     *@param numOfRuns number of trials per experiment
     *@return the run time in ms
     */
    public float timeofquickSort2(int numberOfItems, int numOfRuns){
      long totalTime = 0;
      float avgTime = 0;
      int cycle = 0;
      while(cycle<numOfRuns){
      ContactList cl= new ContactList();
      Random random = new Random(100);
      //add random contacts to the list
      for(int i=0; i<numberOfItems; i++){
          Contact c = new Contact(randomLetters[random.nextInt(4)] + randomLetters[random.nextInt(4)] + randomLetters[random.nextInt(4)] + randomLetters[random.nextInt(4)], LastNames[i], "Phone", "Email");
          cl.addElement(c);
        }
      //time the amount of time it takes to search the list for a contact
      //give print outs for each trial
      System.out.println("Working on trial " + cycle +"...");
      long startTime = System.currentTimeMillis();
     //sort the list
      cl.quickSort(0, cl.getList().size()-1);
      long stopTime = System.currentTimeMillis();
      totalTime += (stopTime - startTime);
    
     //update cycle and seed for next run
    cycle++;
   }
   //take an average
     avgTime = (float)totalTime/numOfRuns;
   //print results
     System.out.println("----------------------ContactList QuickSort Results-------------------------------");
     System.out.println("The ContactList was sorted in " + avgTime +"ms, on a " + numOfRuns + " run average.");
     System.out.println();
     return avgTime;
 }
 
  /**
     *Method timeofmergeSort1 times a merge sort on a WorkerList
     *@param numberOfItems the number of Workers to be added
     *@param seed the random seed used
     *@param numOfRuns number of trials per experiment
     *@return the run time in ms
     */
    public float timeofmergeSort1(int numberOfItems, int seed, int numOfRuns){
      long totalTime = 0;
      float avgTime = 0;
      int cycle = 0;
      while(cycle<numOfRuns){
        Random random = new Random(seed);
        WorkerList wl= new WorkerList();
      //add random workers to the list
        for(int i=0; i<numberOfItems; i++){
             if(random.nextInt()>0){
              Worker w = new Worker(random.nextInt(), "FirstName", "LastName");
              wl.addElement(w);
          }
        }
      //time the amount of time it takes to search the list for a worker
      //give print outs for each trial
        System.out.println("Working on trial " + cycle + "...");
        long startTime = System.currentTimeMillis();
     //search the list
        wl.mergeSort(0,wl.getList().size()-1);
        long stopTime = System.currentTimeMillis();
        totalTime += (stopTime - startTime);
    
     //update cycle and seed for next run
        cycle++;
        seed++;
   }
   //take an average
     avgTime = (float)totalTime/numOfRuns;
   //print results
     System.out.println("----------------------WorkerList MergeSort Results-------------------------------");
     System.out.println("The WorkerList was sorted in " + avgTime +"ms, on a " + numOfRuns + " run average.");
     System.out.println();
     return avgTime;
 }
 
 
   /**
     * Method timeofmergeSort2
     *Method timeofmergeSort2 times a merge sort for ContactList
     *@param numberOfItems the number of contacts to be added
     *@param numOfRuns number of trials per experiment
     *@return the run time in ms
     */
    public float timeofmergeSort2(int numberOfItems, int numOfRuns){
      long totalTime = 0;
      float avgTime = 0;
      int cycle = 0;
      while(cycle<numOfRuns){
        Random random = new Random(100);
        ContactList cl= new ContactList();
      //add contacts to the list
        for(int i=0; i<numberOfItems; i++){
            //Create the first name randomly...last name comes from arr
            Contact c = new Contact(randomLetters[random.nextInt(4)] + randomLetters[random.nextInt(4)] + randomLetters[random.nextInt(4)] + randomLetters[random.nextInt(4)], LastNames[i], "Phone", "Email");
            cl.addElement(c);
          }
      //time the amount of time it takes to search the list for a contact
      //give print outs for each trial
        System.out.println("Working on trial " + cycle +"...");
        long startTime = System.currentTimeMillis();
     //search the list
        cl.mergeSort(0, cl.getList().size()-1);
        long stopTime = System.currentTimeMillis();
        totalTime += (stopTime - startTime);
    
     //update cycle and seed for next run
        cycle++;
   }
   //take an average
     avgTime = (float)totalTime/numOfRuns;
   //print results
     System.out.println("----------------------ContactList MergeSort Results-------------------------------");
     System.out.println("The ContactList was sorted in " + avgTime +"ms, on a " + numOfRuns + " run average.");
     System.out.println();
     return avgTime;
 }

    /**
     * Method shuffle shuffles the data
     * @param a the array to shuffle
     */
    public void shuffle(String [] a){
        Random random = new Random();
        //swap the last index with a random index in the array
        for(int i = 0; i<a.length;i++){
           int randomIndex = random.nextInt(a.length-1);
           swap(a,i,randomIndex);
    }
  }
  
  /**
  * Method swap exchanges reference positions in data
  * @param a the array in which the swaps take place
  * @param i one reference
  * @param j the other reference
  */
   public void swap(String [] a,int i, int j)
    {
     //standard swap algorithm
      if(i >=0 && j>=0){
          String temp =a[i];
          a[i] = a[j];
          a[j] = temp;
      }
    }
}
