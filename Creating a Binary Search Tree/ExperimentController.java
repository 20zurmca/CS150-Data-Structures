import java.util.Scanner;
/**
 * Class ExperimentController displays capabilities of the BinarySearchTree
 */
public class ExperimentController
{
    ////fields/////////

    BinarySearchTree <Integer> IntegerTree = new BinarySearchTree<>();

    /**
     * Constructor for class Experiment Controller
     */
    public ExperimentController (){}

    //////methods/////////
    public static void main(String [] args)
    {
        ExperimentController EC = new ExperimentController();
        EC.demonstrate();
    }

    /**
     * Method to demonstrate capabilities of BinarySearchTree
     */
    public void demonstrate()
    {
        System.out.println("Now adding 20, 15, 21, 8, 17, 11, and 45 to tree \n");
        try{
            IntegerTree.insert(20);
            IntegerTree.insert(15);
            IntegerTree.insert(21);
            IntegerTree.insert(8);
            IntegerTree.insert(17);
            IntegerTree.insert(11);
            IntegerTree.insert(45);
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Now obtaining the root's element: " + IntegerTree.getElement(IntegerTree.getRoot()) + "\n");
        System.out.println("Now printing the size of the tree: " + IntegerTree.size() + "\n");

        System.out.println("Finding the min and max element of the tree.  Max: " + IntegerTree.findMax() + " Min: " + IntegerTree.findMin() + "\n");

        System.out.println("Now printing PostOrder iteration \n");
        IntegerTree.printPostOrder();

        System.out.println("Now printing InOrder iteration \n");
        IntegerTree.printInOrder();

        System.out.println("Now printing PreOrder iteration. All further tree prints will use this printing method \n");
        IntegerTree.printPreOrder();

        System.out.println("Printing the root's left and right child elements.  Left: " + IntegerTree.getElement(IntegerTree.getRoot().getLeft()) + " Right: " + IntegerTree.getElement(IntegerTree.getRoot().getRight()) + "\n");

        System.out.println("Removing 8 from the tree: \n");
        try{
            IntegerTree.remove(8);
        } catch(Exception e){
            e.printStackTrace();
        }
        IntegerTree.printPreOrder();

        System.out.println("Finding the min and max element of the new tree.  Max: " + IntegerTree.findMax() + " Min: " + IntegerTree.findMin() + "\n");

        //have the user input an integer to the terminal.  Call IntegerTree's contains method with that integer and give a message whether the integer is in the tree
        boolean contains = false;
        Integer input = 0;
        Scanner sc = null;
        try{
            sc = new Scanner(System.in);
            System.out.print("Now test if an element is in the tree. \nInput an integer and an appropriate message will appear whether the integer is in the tree: ");
            input = sc.nextInt();
        } catch(Exception e ){
            e.printStackTrace();
        } finally {
            sc.close();
        }

        contains = IntegerTree.contains(input);
        if(contains){
            System.out.println("This integer is in the tree! \n");
        } else {
            System.out.println("This integer is not in the tree \n");
        }

        System.out.println("Now removing the root of the tree \n");
        try{
            IntegerTree.remove(IntegerTree.getElement(IntegerTree.getRoot()));
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("The new root is: " + IntegerTree.getElement(IntegerTree.getRoot()) + "\n");
        System.out.println("PreOrder print: ");
        IntegerTree.printPreOrder();

        System.out.println("Now I will empty the tree \n");
        IntegerTree.empty();

        System.out.println("Printing size of empty tree: " + IntegerTree.size() + "\n");

        //test if the tree is empty using isEmpty() method
        if(IntegerTree.isEmpty()){
            System.out.println("The tree has been proven empty");
        } else {
            System.out.println("The tree is not empty!");
        }
    }
}
