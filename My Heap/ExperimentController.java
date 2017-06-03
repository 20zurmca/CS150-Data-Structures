import java.util.Random;
/**
 * Class ExperimentController adds 100 integers into a heap and removes them in sorted order
 */
public class ExperimentController
{
    public static void main(String [] args){
        Heap <Integer> heap = new Heap<>();
        Random random = new Random(72);

        for(int i = 0; i<100; i++){
            heap.insert(random.nextInt()); //insert 100 random intergers into the heap
        }

        while(!heap.isEmpty()){
            System.out.println(heap.removeMin()); //print them out one at a time
        }
    }
}
