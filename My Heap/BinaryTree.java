import java.util.NoSuchElementException;
/**
 *A recursive implementation of a Binary Search Tree
 *Some implmentation seen in Weiss, Mark A. "Data Structures & Problem Solving Using Java". 4th ed. Pearson Education, Inc, 2010. pp. 691-697
 */
public abstract class BinaryTree <E> 
{

    //instance variables
    protected BinaryNode <E> root; //root of the tree
    protected int numNodes; //the number of nodes in the tree

    /**
     *Constructor for class BinaryTree
     */
    public BinaryTree()
    {
        this.root = null;
    }

    //*******************METHODS************************//

    //abstract methods to be overriden in concrete class

    public abstract void insert(E data);

    public abstract E removeMin();

    //implemented methods
    /**
     * Method empty empty's the tree
     */
    protected void empty ()
    {
        this.root = null;
    }
    
    /**
     * Method isEmpty asks if the tree is empty
     * @return whether the root is null
     */
    protected boolean isEmpty()
    {	
        return this.root == null;
    }

    protected void printPreOrder() 
    {
        if(!this.isEmpty()){
            this.root.printPreOrder();
            System.out.println("\n");
        }
    }

    protected void printPostOrder() 
    {
        if(!this.isEmpty()){
            this.root.printPostOrder();
            System.out.println("\n");
        }
    }

    protected void printInOrder()
    {
        if(!this.isEmpty()){
            this.root.printInOrder();
            System.out.println("\n");
        }
    }
    
    /**
     * Method getRoot returns the root 
     * @return this.root
     */
    protected BinaryNode<E> getRoot()
    {
        return this.root;
    
    }
    /**
     * Method getNumNodes returns the number of nodes in the tree
     * @return the number of nodes in the tree
     */
    
    protected int getNumNodes()
    {
        return this.numNodes;
    }
}

