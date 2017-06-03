import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Class BinaryNode represents a Binary Node in a Tree
 */
public class BinaryNode <E>
{
    /////////////////fields////////////////
    private E element; //data
    private BinaryNode <E> left;  //left child
    private BinaryNode <E> right; //right child

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
    
    ////////////////Methods/////////////////////

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
     * Method printInOrder print's the tree in an inorder traversal
     */
    public void printInOrder()
    {
        if(this.left != null){            //left children, then  node, then right children
            this.left.printInOrder();
        }
        
        System.out.println(this.element + " ");

        if(this.right != null){
            this.right.printInOrder();
        }
    }
    
    /**
     * Method writeInOrder writes the nodes' string representations to a file using inorder traversal
     * @param fileName the name of the file to write to
     */
    public void writeInOrder(String fileName)
    {
        if(this.left != null){            //left children, then  node, then right children
            this.left.writeInOrder(fileName);
        }
        
        File Movies = new File(fileName); //create a new file to write to
        PrintWriter pw = null;
        try{
            if(!Movies.exists()){ //if the file does not exist, create a new one
                Movies.createNewFile();
                pw = new PrintWriter(new FileWriter(Movies));
                pw.println(this.element.toString()); //write the element as a string to the file 
                pw.flush();
                pw.close(); //close file 
            } else { //else just append to the existing file using the same prior logic 
                pw = new PrintWriter(new FileWriter(Movies, true));
                pw.println(this.element.toString()); //write an element as a string to the file
                pw.flush();
                pw.close(); //close the file
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        if(this.right != null){
            this.right.writeInOrder(fileName);
        }
    }

}
