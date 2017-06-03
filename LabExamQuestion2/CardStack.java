import java.util.Stack;
import java.io.*;
/**
 * Class CardStack represents a deck
 */
public class CardStack
{
    private Stack <Card> deck = new Stack<>();
    /**
     * Constructor for class CardStack
     */
    public CardStack () {} 
    
    /**
     * Method createDeck reads from a file to create cards an pushes them into a stack
     * @param fileName the file to read the cards in
     */
    public void createDeck(String fileName){
        BufferedReader reader = null;
        try{
            String line = null; 
            reader = new BufferedReader(new FileReader(fileName));
            while((line = reader.readLine()) != null){  //have the buffered reader read in the lines
                String [] words = line.split(" "); //split the line into individual words and store in array
                deck.push(new Card(words[0], Integer.parseInt(words[1]))); //create a card object and push into stack
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Method draw returns and removes a card from the deck
     * @return a card
     */
    public Card draw(){
        return deck.pop(); //pops the card 
    }
    
    /**
     * Method isEmpty returns whether the stack is empty
     * @return whether the stack is empty
     */
    public boolean isEmpty()
    {
        return deck.isEmpty();
    }
}
