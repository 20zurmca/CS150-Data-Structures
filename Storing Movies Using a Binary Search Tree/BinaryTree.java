import java.util.NoSuchElementException;
/**
 *A recursive implementation of a Binary Search Tree
 *Some implmentation seen in Weiss, Mark A. "Data Structures & Problem Solving Using Java". 4th ed. Pearson Education, Inc, 2010. pp. 691-697
 */
public abstract class BinaryTree <E> implements Tree <E>
{

    //instance variable of class BinaryTree--the root
    protected BinaryNode <E> root;

    /**
     *Constructor for class BinaryTree
     */
    public BinaryTree()
    {
        this.root = null;
    }

    //*******************METHODS************************//

    //abstract methods to be overriden in concrete class

    public abstract boolean remove(E e);

    public abstract boolean insert(E e);

    public abstract boolean contains(E e);

    public abstract int size();

    //implemented methods from interface
    @Override
    public void empty ()
    {
        this.root = null;
    }

    @Override
    public boolean isEmpty()
    {	
        return this.root == null;
    }

    @Override
    public E findMax()
    {
        return getElement(findMax(root));
    }

    @Override
    public E findMin()
    {
        return getElement(findMin(root));
    }

    @Override
    public void printPreOrder() 
    {
        this.root.printPreOrder();
        System.out.println("\n");

    }

    @Override
    public void printPostOrder() 
    {
        this.root.printPostOrder();
        System.out.println("\n");

    }
    
    @Override
    public void printInOrder()
    {
        this.root.printInOrder();
    }
    
    /**
     * Method writeInOrder writes the tree's nodes to a file in an inorder traversal manner
     */
    public void writeInOrder(String fileName)
    {
        this.root.writeInOrder(fileName);
    }

    /**
     * Internal method to get element field.
     * @param node the node to get an element from.
     * @return the element field or null if param is null.
     */
    protected E getElement(BinaryNode<E> node)
    {
        return node == null ? null : node.getElement();
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param node the node that roots the tree.
     * @return node containing the smallest item.
     */
    protected BinaryNode<E> findMin(BinaryNode<E> node)
    {
        if(node!= null){
            while(node.getLeft() != null){
                node = node.getLeft();
            }
        }
        return node;
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param node the node that roots the tree.
     * @return node containing the largest item.
     */
    protected BinaryNode<E> findMax(BinaryNode<E> node)
    {
        if(node != null){
            while(node.getRight() != null){
                node = node.getRight();
            }
        }
        return node;
    }

    /**
     * Method getRoot returns the root of this tree
     * @return the tree's root
     */
    protected BinaryNode<E> getRoot()
    {
        return this.root;
    }
}

