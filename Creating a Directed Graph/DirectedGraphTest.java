

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DirectedGraphTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DirectedGraphTest
{
    @Test
    public void testGraph()
    {
        //create a directed graph
        DirectedGraph<Integer> G = new DirectedGraph<Integer>();
        //add a vertex
        assertEquals(G.addNode(5), true);
        //try to add it again, should be false
        assertEquals(G.addNode(5), false);
        //add two more vertices
        assertEquals(G.addNode(7), true);
        assertEquals(G.addNode(6), true);
        //add an edge between 5 and 6
        assertEquals(G.addEdge(5,6,10), true);
        //try to add an edge between two vertices, one of which does not exist
        assertEquals(G.addEdge(11,6,4), false);
        //change the edge weight and assert that it changed
        assertEquals(G.addEdge(5,6,11), true);
        assertEquals(G.getEdgeWeight(G.getEdge(5,6)), 11); 
        
        //Next, add another edge from 5 to 7
        assertEquals(G.addEdge(5,7,8), true);
        //the size of the Neighborhood set of 5 should be 2.  The size of the Neighborhood set of 6 and 7 should be 0
        assertEquals(G.getNeighbors(5).size(), 2);
        assertEquals(G.getNeighbors(7).size(), 0);
        assertEquals(G.getNeighbors(6).size(), 0);
        
        //Find 5's closest Neighbor: should be 7, not 6.
        assertEquals(G.returnClosestNeighbor(5), (Integer) 7);
        
        //make sure that 6 and 7 closest neighbors are null
        assertEquals(G.returnClosestNeighbor(6), null);
        assertEquals(G.returnClosestNeighbor(7), null);
        
        
        
        
        
    }
    
    @Test
    public void testBreadthSearch()
    {
        //copy the above method and do a breadth search, starting at 5.  Output should be 5 7, 6 null, 7 null
        
        
        
        //create a directed graph
        DirectedGraph<Integer> G = new DirectedGraph<Integer>();
        //add a vertex
        assertEquals(G.addNode(5), true);
        //try to add it again, should be false
        assertEquals(G.addNode(5), false);
        //add two more vertices
        assertEquals(G.addNode(7), true);
        assertEquals(G.addNode(6), true);
        //add an edge between 5 and 6
        assertEquals(G.addEdge(5,6,10), true);
        //try to add an edge between two vertices, one of which does not exist
        assertEquals(G.addEdge(11,6,4), false);
        //change the edge weight and assert that it changed
        assertEquals(G.addEdge(5,6,11), true);
        assertEquals(G.getEdgeWeight(G.getEdge(5,6)), 11); 
        
        //Next, add another edge from 5 to 7
        assertEquals(G.addEdge(5,7,8), true);
        //the size of the Neighborhood set of 5 should be 2.  The size of the Neighborhood set of 6 and 7 should be 0
        assertEquals(G.getNeighbors(5).size(), 2);
        assertEquals(G.getNeighbors(7).size(), 0);
        assertEquals(G.getNeighbors(6).size(), 0);
        
        //Find 5's closest Neighbor: should be 7, not 6.
        assertEquals(G.returnClosestNeighbor(5), (Integer) 7);
        
        //make sure that 6 and 7 closest neighbors are null
        assertEquals(G.returnClosestNeighbor(6), null);
        assertEquals(G.returnClosestNeighbor(7), null);
        
        G.breadthFirstClosest(5);
    }
    
    @Test
    public void testBreadthSearch2()
    {
        //copy the above method and do a breadth search, starting at 5.  All closest neighbors for 5 will have the same weight.  Output should be 5 6, 6 null, 7 null
        
        
        
        //create a directed graph
        DirectedGraph<Integer> G = new DirectedGraph<Integer>();
        //add a vertex
        assertEquals(G.addNode(5), true);
        //try to add it again, should be false
        assertEquals(G.addNode(5), false);
        //add two more vertices
        assertEquals(G.addNode(7), true);
        assertEquals(G.addNode(6), true);
        //add an edge between 5 and 6
        assertEquals(G.addEdge(5,6,10), true);
        //try to add an edge between two vertices, one of which does not exist
        assertEquals(G.addEdge(11,6,4), false);
        //change the edge weight and assert that it changed
        assertEquals(G.addEdge(5,6,4), true);
        assertEquals(G.getEdgeWeight(G.getEdge(5,6)), 4); 
        
        //Next, add another edge from 5 to 7
        assertEquals(G.addEdge(5,7,4), true);
        //the size of the Neighborhood set of 5 should be 2.  The size of the Neighborhood set of 6 and 7 should be 0
        assertEquals(G.getNeighbors(5).size(), 2);
        assertEquals(G.getNeighbors(7).size(), 0);
        assertEquals(G.getNeighbors(6).size(), 0);
        
        //Find 5's closest Neighbor: should be 7, not 6.
        assertEquals(G.returnClosestNeighbor(5), (Integer) 6);
        
        //make sure that 6 and 7 closest neighbors are null
        assertEquals(G.returnClosestNeighbor(6), null);
        assertEquals(G.returnClosestNeighbor(7), null);
        
        G.breadthFirstClosest(5);
    }
}
