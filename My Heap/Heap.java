import java.util.Stack;
import java.util.NoSuchElementException;
/**
 * A BinaryHeap class
 */
public class Heap <E extends Comparable<? super E>> extends BinaryTree <E>
{
    /**
     * Constructor for objects of class Heap
     */
    public Heap()
    {
        super();
    }

    /////////methods////////////
    /**
     * Method getDirections instructs where to insert a new node
     * @param n the number of nodes in the tree
     * @return a boolean stack--true means go left, false means go right
     */
    private Stack<Boolean> getDirections(int n)

    {
        Stack<Boolean> goLeft = new Stack<Boolean>();
        while(n>=2)

        {
            if(n%2==0){
                goLeft.push(true);
            }else{
                goLeft.push(false);
            }
            n=n/2;   
        }
        return goLeft;
    }

    /**
     * Internal method to access a node given directions
     * @param location the location of the node (1,2,3....)
     * @return the node at that location
     */
    private BinaryNode<E> accessNode(int location)
    {
        Stack <Boolean> Directions = getDirections(location); //get directions to the node at location
        BinaryNode<E> node = root; //store the root in a temp variable
        while(!Directions.isEmpty()){ //while there are still directions
            if(Directions.pop()){ //pop the direction and reset temp accordingly
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return node; 
    }

    /**
     * Method insert inserts an element into the heap
     * @param data the element to insert as a node
     */
    @Override
    public void insert(E data)
    { 
        //update number of nodes
        numNodes++;
        //get directions
        Stack <Boolean> Directions = getDirections(numNodes);
        this.root = insert(data, root, Directions);
    }

    /**
     * removes the minimum item in the heap
     * @return the min item (root's element)
     * @throws NoSuchElementException if heap is empty
     */
    @Override
    public E removeMin()
    {
        if(this.root == null){ //if there are no nodes, throw exception
            throw new NoSuchElementException(); //exception if root is null
        } else if(numNodes == 1){ //if there is only one node
            E minElement = this.root.getElement(); //obtain the root's element
            numNodes--; //decrease number of nodes 
            this.root = null; //set root to null
            return minElement;
        }
        ///////Other Cases/////////////
        E minElement = root.getElement();//get the root's element
        this.root.setElement(accessNode(numNodes).getElement()); //set the root's elements to the last leaf's
        setLeafNull(accessNode(numNodes/2)); //set the last leaf node to null by accesing parent and call setLeafNull
        numNodes--;   //decrease the number of nodes in the tree by 1
        percolateDown(1); //percolate the root down
        return minElement; //return root's element
    }

    /**
     * Method setLeafNull sets last leaf's parent's left or right child null, depending on which one is the last leaf
     * @param node the parent of the last leaf
     */
    private void setLeafNull(BinaryNode <E> node){
        //the last leaf will either be a left or right child of the parent
        if(node.getRight() != null)
        {
            node.setRight(null); 
        } else {
            node.setLeft(null);
        }
    }

    /**
     * Internal method percolateDown sinks the root to its proper place (from textbook)
     * @param hole the node that roots the tree
     **/

    private void percolateDown(int hole)
    {
        int child;
        E tempE = accessNode(hole).getElement(); //obtain the element at the hole 
        for( ; 2*hole <= numNodes; hole = child) //loop through the binary tree until there is no left child.  //At end of loop move hoel to chidl
        {
            child = 2*hole; //get the left child node 
            //test for two children first.  Then test if right child is smaller than left. If both true, Update child
            if(child!=numNodes && (accessNode(child + 1).getElement().compareTo(accessNode(child).getElement()) < 0)){ 
                child++; 
            }

            if(accessNode(child).getElement().compareTo(tempE) < 0){ //if the child node is larger than parent, set the node's element at hole to the child's
                accessNode(hole).setElement(accessNode(child).getElement()); 
            } else {
                break; //else break 
            }
        }
        accessNode(hole).setElement(tempE); //set the node's element at the hole to temp
    }

    /**
     * Internal method to insert into a subtree
     * @param element the item to insert
     * @param node the node that roots the tree
     * @param Directions the boolean stack of directions
     * @return the new root
     */
    private BinaryNode<E> insert(E element, BinaryNode<E> node, Stack <Boolean> Directions)
    {
        if(node == null){ //if the passed parameter is null (case 1), create a new binary node containing the element passed
            node = new BinaryNode<E> (element);
        } else if(Directions.pop()){  //Case 2: else, get a direction--if true, it is to go left
            node.setLeft(insert(element, node.getLeft(), Directions)); //set the left node 
            if(node.getElement().compareTo(node.getLeft().getElement()) > 0) //do a swap, if necessary, to percolate up 
            {
                swap(node, node.getLeft());
            }
        } else{ //case 3: direction is false--set the right child of the node 
            node.setRight(insert(element, node.getRight(), Directions));
            if(node.getElement().compareTo(node.getRight().getElement()) > 0) //do a swap, if necessary, to percolate up
            {
                swap(node, node.getRight());
            }
        }
        return node;
    }

    /**
     * Internal method that swaps two node's elements
     * @param node1 the first node to swap
     * @param node2 the second node to swap
     */
    private void swap(BinaryNode <E> node1 , BinaryNode <E> node2)
    {
        E tmp = node2.getElement();
        node2.setElement(node1.getElement());
        node1.setElement(tmp);
    }
}

