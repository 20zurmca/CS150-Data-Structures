import java.util.NoSuchElementException;
/**
 * Binary Search Tree
 */
public class BinarySearchTree <E extends Comparable<? super E>> extends BinaryTree <E> 
{

    /**
     * Constructor for class BinarySearchTree
     */
    public BinarySearchTree()
    {
        super();
    }
    
    //////////////Methods//////////////////

    @Override
    public int size(){
        return size(root);
    }

    @Override
    public boolean remove(E e) 
    {
        int size1 = this.size(); //obtain tree size
        this.root = remove(e, root);//remove a node
        int size2 = this.size(); //obtain new tree size
        return size2 == size1-1;//new size should be size1-1
    }

    @Override
    public boolean insert(E e)
    {
        int size1 = this.size(); //obtain tree size
        this.root = insert(e, root); //insert a node
        int size2 = this.size(); //obtain new tree size
        return size2 == size1+1; //new size should be size1 + 1
    }

    @Override
    public boolean contains(E e) {
        return contains(e, root);
    }

    /**
     * Internal method to insert into a subtree
     * @param element the item to insert
     * @param node the node that roots the tree
     * @return the new root
     * @throws IllegalArgumentException if element is already present
     */
    private BinaryNode<E> insert(E element, BinaryNode<E> node)
    {
        
        if(node == null){ //if the passed parameter is null, create a new binary node containing the element passed
            node = new BinaryNode<E> (element);
        } else if(element.compareTo(node.getElement())< 0){  //if the element is less than the passed node's element, recursively call insert on the left child
            node.setLeft(insert(element, node.getLeft())); //need to call setleft to insert into the tree
        } else if(element.compareTo(node.getElement())> 0){ //else do the same logic with the right child
            node.setRight(insert(element, node.getRight()));
        } else { throw new IllegalArgumentException(element.toString());} //if the elements equal, thats an exception
        return node; //new root
    }

    /**
     * Internal method to remove minimum item from a subtree.
     * @param node the node that roots the tree.
     * @return the new root.
     * @throws NoSuchElementException if t is empty
     */
    private BinaryNode <E> removeMin(BinaryNode <E> node)
    {
        if(node == null){ //if we reach the end of the tree and havent found the element, throw and exception
            throw new NoSuchElementException("The item does not exist");
        } else if(node.getLeft() != null){ //as long as there are left children
            node.setLeft(removeMin(node.getLeft())); //recursively call the funcion on the left child--use setLeft() to refrain from loosing an extra node
            return node; //return the node
        } else {
            return node.getRight(); //if there are no left children, the smallest element of a subtree is the first right child
        }
    }

        /**
         * Internal method to remove from a subtree.
         * @param element the item to remove.
         * @param node the node that roots the tree
         * @return the new root.
         * @throws NoSuchElementException if element is not found
         */

        private BinaryNode <E> remove (E element, BinaryNode <E> node )
        { 
            if(node == null){ //if the node is null the element does not exist 
            throw new NoSuchElementException(element.toString() + "The item does not exist");
        }

        if(element.compareTo(node.getElement()) < 0){ //if the element is less than this node's element
            node.setLeft(remove(element, node.getLeft())); //call function recursively on left child--use setLeft so we don't loose a node
        } else if(element.compareTo(node.getElement()) > 0){ //else call it recursively on right child
            node.setRight(remove(element, node.getRight()));
        } else if(node.getLeft() != null && node.getRight() != null){  //if there are two children
            node.setElement(findMin(node.getRight()).getElement()); //find the minimum of the right subtree--that is the node's new element
            node.setRight(removeMin(node.getRight()));  //set the node's right child to be the minimum node of right subtree
        } else {
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight(); //if there are less than two children, if the left child is not null, set node = to it
        }
        return node; //return new root
    }

    /**
     * Internal method to check if an element is in the tree
     * @param element to seek
     * @param node the node that roots the tree
     * @return whether the element was found in the tree
     */
    private boolean contains(E element, BinaryNode<E> node)
    {
        if(node == null){  //keep checking left and/or right subtrees via recursion until compareTo returns 0, or node=null
            return false;
        } else if(element.compareTo(node.getElement()) < 0){
            return contains(element, node.getLeft());
        } else if(element.compareTo(node.getElement())> 0){
            return contains(element, node.getRight());
        } else { return true; }
    }

    /**
     * Internal method to check the size of a tree
     * @param node the root
     * @return the size of the tree
     */
    private int size(BinaryNode<E> node)
    {
        if(node == null){
            return 0;
        }
        return 1 + size(node.getRight()) + size(node.getLeft()); //recursive call on left and right children
    }
}
