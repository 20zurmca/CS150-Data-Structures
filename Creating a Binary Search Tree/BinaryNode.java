
/**
 * Class BinaryNode represents a Binary Node in a Tree
 */
public class BinaryNode <E>
{
    protected E element;
    protected BinaryNode <E> left;
    protected BinaryNode <E> right;

    /**
     * Constructor for class BinaryNode with no children
     * @param element of the node
     */
    public BinaryNode(E element){
        this(element, null, null);
    }

    /**
     * Constructor for class BinaryNode
     * @param element the node's element
     * @param leftChild the node's left child
     * @param rightChild the node's right child
     */
    public BinaryNode(E element, BinaryNode <E> leftChild, BinaryNode <E> rightChild){
        this.element = element;
        this.left = leftChild;
        this.right = rightChild;
    }

    /**
     * Method getElement obtains a node's element
     *
     * @return The node's element
     */
    public E getElement()
    {
        return this.element;
    }

    /**
     * Method getLeft obtain's the node's left child  
     *
     * @return the node's left child
     */
    public BinaryNode<E> getLeft()
    {
        return this.left;
    }

    /**
     * Method getRight
     * obtains a node's right child
     * @return The nodes' right child
     */
    public BinaryNode<E> getRight()
    {
        return this.right;
    }

    /**
     * Method setElement sets the element to something else
     *
     * @param element the new element
     */
    public void setElement(E element)
    {
        this.element = element;
    }

    /**
     * Method setLeft sets a node's left child
     *
     * @param newLeft the new left child
     */
    public void setLeft(BinaryNode<E> newLeft)
    {
        this.left = newLeft;
    }

    /**
     * Method setRight sets a node's right child
     *
     * @param newRight the new right child
     */
    public void setRight(BinaryNode<E> newRight)
    {
        this.right = newRight;
    }

    /**
     * Method printPreOrder prints nodes using preorder traversal
     *
     */
    public void printPreOrder() 
    {
        System.out.print(this.element + " "); //print parent node then children-left, right
        if(this.left != null){
            this.left.printPreOrder();
        }
        if(this.right != null){
            this.right.printPreOrder();
        }
    }

    /**
     * Method printPostOrder prints nodes using postorder traversal
     *
     */
    public void printPostOrder() 
    {
        if(this.left != null){    //left children, right children, then node
            this.left.printPostOrder();
        }
        if(this.right != null){
            this.right.printPostOrder();
        }
        System.out.print(this.element + " ");

    }

    /**
     * Method printInOrder prints nodes using inorder traversal
     *
     */
    public void printInOrder()
    {
        if(this.left != null){            //left children, then  node, then right children
            this.left.printInOrder();
        }
        System.out.print(this.element + " ");
        if(this.right != null){
            this.right.printInOrder();
        }
    }

}
