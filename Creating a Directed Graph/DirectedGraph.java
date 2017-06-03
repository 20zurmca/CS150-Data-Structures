import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 *A DirectedGraph class
 */
public class DirectedGraph <K>
{
    ///////////////////////////INNER CLASSES/////////////////////////////////////////////
    /**
     * Class DirectedGraphNode is an inner class that repersent the verticies in the graph
     */
    private static class DirectedGraphNode <K>
    {
        /////////////////////////////FIELDS////////////////////////////////
        K key; //the generic key
        boolean visited = false; //used in traversal
        ArrayList<DirectedGraphEdge <K> > outgoingEdges; //list of outgoing edges

        /**
         * Constructor for class DirectedGraphNode<K>
         * @param key the key for the node
         */
        public DirectedGraphNode(K key)
        {
            this.key = key;
            outgoingEdges = new ArrayList<>();
        }

        /////////////////////////////METHODS////////////////////////////////

        /**
         * Method returnClosestNeighbor returns the closest vertex to this vertex
         * Closest is in a weighted sense
         * @return the closest neighbor 
         */
        public K returnClosestNeighbor()
        {
            //if the node has no closest neighbor, return null
            if(outgoingEdges.isEmpty())
            {
                return null;
            } else { //go through the outgoingEdge list and find the one with lowest weight
                DirectedGraphEdge <K> lowestWeight = outgoingEdges.get(0);
                for(int i = 1 ; i<outgoingEdges.size() ; i++)
                {
                    if(outgoingEdges.get(i).weight < lowestWeight.weight) //if weights are equal, just use the first neighbor seen
                    {
                        lowestWeight = outgoingEdges.get(i);
                    }
                }
                return lowestWeight.endingNode.key; //returns the node the edge goes to
            }
        }
    }

    /**
     * Class DirectedGraphEdge is an inner class that represents the edges in a graph
     */
    private static class DirectedGraphEdge <K>
    {
        //////////////////////////////FIELDS/////////////////////////////////////////
        DirectedGraphNode <K> startingNode; //starting node of the edge
        DirectedGraphNode <K> endingNode; //ending node of the edge
        int weight; //the weight of the graph

        /**
         * Constructor for class DirectedGraphEdge
         * @param startingNode the starting node
         * @param endingNode the ending node
         * @param w the weight of the edge
         */
        public DirectedGraphEdge (DirectedGraphNode <K> startingNode, DirectedGraphNode <K> endingNode, int w)
        {
            this.startingNode = startingNode;
            this.endingNode = endingNode;
            weight = w;

            //add this edge to startingNode's outgoing edge list
            startingNode.outgoingEdges.add(this);
        }
    }

    ///////////////////////////////OUTTER ClASS////////////////////////////////////////////////////

    ///////////////////////////////////FIELDS//////////////////////////////////////////////////////

    private ArrayList<DirectedGraphNode <K>> allNodes; //keeps track of all nodes in the graph

    /**
     * Constructor for class DirectedGraph
     */
    public DirectedGraph()
    {
        allNodes = new ArrayList<>();
    }

    ///////////////////////////////METHODS//////////////////////////////////////////////////////////////

    /**
     * Method addNode adds a node to the graph with key k
     * Key should be unique or node should not be added and method should return false
     * @param k the key of the added node
     * @return whether insertion was successful
     */
    public boolean addNode(K k)
    {
        //create a new Node
        DirectedGraphNode<K> newNode = new DirectedGraphNode<>(k); 

        //check if node exists
        for(DirectedGraphNode <K> node : allNodes)
        {
            if(node.key.equals(newNode.key))
            {
                return false;
            }
        }

        //safe to add
        allNodes.add(newNode);
        return true;
    }

    /**
     * Method addEdge adds an edge from the node with key k1 to the node with key k2 and weight w.
     * Edge should not be added if either nodes do not exist.
     * If edge already exists, simply change its weight
     * @param k1 the key of the starting node
     * @param k2 the key of the second node
     * @param w the weight of the edge
     * @returns true if the edge is successfully added. 
     */
    public boolean addEdge(K k1, K k2, int w )
    {
        //check if both vertices are in the node's list
        DirectedGraphNode <K> startingNode = getVertex(k1);
        DirectedGraphNode <K> endingNode = getVertex(k2);
        
        if(startingNode == null || endingNode == null )
        {
            return false;
        }
        
        //check if there is an existent edge between the vertices.  If there is, change the weight
        DirectedGraphEdge <K> potentialEdge = getEdge(k1, k2);
        if(potentialEdge != null)
        {
            potentialEdge.weight = w; //change the weight
            return true; 
        }
        
        //last case: no edge between the vertices, create new edge
        DirectedGraphEdge <K> newEdge = new DirectedGraphEdge(startingNode, endingNode, w);
        return true;
    }
    
    /**
     * Method getNeighbors returns an ArrayList containing all the neighbors k can reach in one hop
     * @return the list of neighbors 
     */
    public ArrayList <K> getNeighbors(K k)
    {
        ArrayList <K> neighbors = new ArrayList<>(); //initialize the array list to hold the keys 
        DirectedGraphNode <K> startingNode = getVertex(k); //get the starting vertex 
        for(DirectedGraphEdge <K> edge : startingNode.outgoingEdges)
        {
            neighbors.add(edge.endingNode.key); //obtain the keys in the starting vertex's neighborhood.  Add to the list
        }
        return neighbors; //return the list
    }
    
    /**
     * Method breadthFirstClosest
     * prints out the closest neighbor each node in the graph can reach in one hop, using breadth first order
     * @param k1 the key of the vertex to start at
     */
    public void breadthFirstClosest(K k1)
    {
        //set all node instance variables to false so I can call method multiple times
        for(DirectedGraphNode <K> node : allNodes)
        {
            if(node.visited)
            {
                node.visited = false;
            }
        }
        
        //obtain the vertex, if applicable
        DirectedGraphNode <K> startingVertex = getVertex(k1);
        if(startingVertex == null ) {return;} //can't traverse 
        
        //initialize queue
        Queue <DirectedGraphNode <K>> q = new LinkedList<>();
        q.add(startingVertex);
        startingVertex.visited = true;
        
        //start enqueue/dequeue process
        while(!q.isEmpty())
        {
            DirectedGraphNode <K> u = q.poll();
            System.out.println(u.key + " " + u.returnClosestNeighbor()); //print closest neighbor 
            //enqueue all neighbors, if not already enqueued 
            for(DirectedGraphEdge <K> edge: u.outgoingEdges) //for every outgoing edge
            {
                if(!edge.endingNode.visited) //if the ending node is not already visited
                {
                    edge.endingNode.visited = true;
                    q.add(edge.endingNode); //enqueue 
                }
            }
        }
    }

    /**
     * Method getVertex searches the allNodes ArrayList for the node with a given key
     * @param key the key of the node to search for
     * @return the node with that key (null if non existent)
     */
    private DirectedGraphNode <K> getVertex(K key)
    {
        for(DirectedGraphNode<K> node : allNodes)
        {
            if(node.key.equals(key)){ //search by key
                return node;
            }
        }
        return null; //non existant node 
    }
    
    /**
     * Method getEdge returns the edge that connects two vertices, or null if there is none
     * @param k1 the key of the starting node
     * @param k2 the key of the second node
     * @return the edge connecting them
     */
    public DirectedGraphEdge <K> getEdge(K k1, K k2 )
    {
        //check if both vertices exit
        DirectedGraphNode <K> startingVertex = getVertex(k1);
        DirectedGraphNode <K> endingVertex = getVertex(k2);
        if(startingVertex == null || endingVertex == null )
        {
            return null; //one or more vertex does not exist -- cannot have an edge
        }
        
        //Case 2: Find the edge that connects the starting vertex to the ending vertex 
        for(DirectedGraphEdge <K> edge : startingVertex.outgoingEdges )
        {
            if(edge.endingNode.equals(endingVertex))
            {
                return edge;
            }
        }
        return null; //no edge connects them 
    }
    
    /**
     * Method getEdgeWeight returns and edge's weight
     * @param edge the edge to examine
     * @return its weight
     */
    public int getEdgeWeight(DirectedGraphEdge <K> edge)
    {
        return edge.weight;
    }
    
    /**
         * Method returnClosestNeighbor returns the closest vertex to the passed paramater
         * Closest is in a weighted sense
         * @param key the key of the vertex to examine
         * @return the closest neighbor to key
         */
        public K returnClosestNeighbor(K key)
        {
           DirectedGraphNode <K> node = getVertex(key); //get the node that goes with the key
           return node.outgoingEdges.size() == 0 ? null: node.returnClosestNeighbor(); //return null, if applicable, or that node's closes neighbor's key
        }
}
