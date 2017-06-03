
/**
 * Tree interface 
 */
public interface Tree <E>
{
    /**
     * Method insert() inserts the given key to the tree, if it is not already present
     * Duplicates are not allowed in the tree
     * @param e the element to inser
     * @return whether the insertion was successful
     */
    boolean insert(E e);

    /**
     * Method contains() returns true if the tree contains the specified key.
     * @param e the specified key
     * @return true if the tree contains the key
     */
    boolean contains(E e);

    /**
     * Method size() returns the total number of items in the tree
     * @return number of items in the tree
     */
    int size ();

    /**
     * Method remove() removes the specified item from the tree, if it is present
     * @param e the specified item
     * @return whether the remove was successful
     */
    boolean remove (E e);

    /**
     * Method findMax() finds and returns the largest item in the tree
     * @return the largest item in the tree
     */
    E findMax();

    /**
     * Method findMin() finds and returns the smallest item in the tree
     * @return the smallest item in the tree
     */
    E findMin();

    /**
     * Method printPreOrder() prints the tree using preorder traversal
     */
    void printPreOrder();

    /**
     * Method printPostOrder() prints the tree using postorder traversal 
     */
    void printPostOrder();

    /**
     * Method printInOrder() Prints the tree using inorder traversal
     */
    void printInOrder();

    /**
     * Method empty() removes all the items from the tree
     */
    void empty();

    /**
     * Method isEmpty() returns true if there are no items in the tree, false otherwise
     * @return whether there are items in the tree
     */
    boolean isEmpty();
}
