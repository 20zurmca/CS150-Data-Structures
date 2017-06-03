import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
/**
 *Class that uses DirectedGraph class
 */
public class GraphExperiment
{
    
    private DirectedGraph<String> G; //Graph to test
    private String startingVertex; //starting vertex for breadthSearchClosest
    
    /**
     * Constructor for class GraphExperiment
     */
    public GraphExperiment()
    {
         G = new DirectedGraph<String>();
    }
    
    public static void main(String [] args)
    {
        GraphExperiment GE = new GraphExperiment(); 
        GE.readGraph(args[0]); //name of graph file is first argument
        GE.G.breadthFirstClosest(GE.getstartingVertex());
    }
    
    /**
     * Method getstartingVertex returns the starting vertex for the breadthFirstClosest traversal
     * @return this experiment's starting vertex
     */
    public String getstartingVertex()
    {
        return startingVertex;
    }
    
    /**
     * Method readGraph reads a file that is formatted to make a graph
     * The first line of the file contains all the vertices
     * The first vertex is considered the starting vertex for breadthFirstClosest traversal
     * From line 2 on, edges are described
     * @param fileName the name of the file
     */
     public void readGraph(String fileName){
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            String [] words = line.split(" "); //split vertice names into array
            this.startingVertex = words[0]; //initialize starting vertex of the graph
            for(int i = 0 ; i<words.length ; i++)
            {
                G.addNode(words[i]); //read other vertices and create
            }
            
            while((line = reader.readLine()) != null){ 
                String [] words2 = line.split(" "); //split the line into individual words and store in array
                G.addEdge(words2[0], words2[1], Integer.parseInt(words2[2])); //create edges
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
