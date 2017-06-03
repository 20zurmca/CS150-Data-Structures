
/**
 * A class that represents a card
 */
public class Card implements Comparable<Card>
{
    private String suit; //the suit of the card
    private int rank; //the rank of the card
    
    /**
     * Constructor for class Card
     * @param suit the suit of the card
     * @param rank the rank of the card
     */
    public Card(String suit, int rank)
    {
        this.suit = suit;
        this.rank = rank;
    }
    
    @Override
    public int compareTo(Card c)
    {
        //checking case if this object or c is 1 of clubs--this card beats all others
        if(this.rank == 1 && this.suit.equals("C"))
        {
            return 1;
        } else if(c.getRank() == 1 && c.getSuit().equals("C")){
            return -1;
        }else if(this.rank < c.getRank()){ //other cases--first compare rank
            return -1;
        }else if(this.rank > c.getRank())
        {
            return 1;
        } else {
            return this.suit.compareTo(c.getSuit()); //then suit
        }
    }
    
    public String getSuit()
    {
        return this.suit;
    }
    
    public int getRank()
    {
        return this.rank;
    }
   
}
