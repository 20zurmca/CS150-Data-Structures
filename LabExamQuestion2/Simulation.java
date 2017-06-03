
/**
 * A class that represents a simulation of a card game
 */
public class Simulation
{
    public static void main(String [] args)
    {
        //simulate the game--two players
        int player1 = 0;
        int player2 = 0;
        CardStack deck = new CardStack();
        deck.createDeck("Cards.txt"); //create the deck
        while(!deck.isEmpty()){
            Card one = deck.draw(); //have them draw until it's empty
            Card two = deck.draw();
            if(one.compareTo(two) > 0){ //compare each draw--update the player score as appropriate
                player1++;
            } else{
                player2++;
            }
        }

        //give end result printouts
        System.out.println("The final score was Player 1: " + player1 + " Player 2: " + player2);
        if(player1>player2)
        {
            System.out.println("Player1 wins!");
        } else {
            System.out.println("Player2 wins!");
        }
    }
}
