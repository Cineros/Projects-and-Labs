// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;

public class DeckOfCards {
    // random number generator
    private static final SecureRandom rand = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

    private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
    public int currentCard = 0; // index of next Card to be dealt (0-51)

    // constructor fills deck of Cards
    public DeckOfCards() {
        int[] values = {12, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        // populate deck with Card objects
        for (int count = 0; count < deck.length; count++) {
            deck[count] = new Card(values[count %13], faces[count % 13], suits[count / 13]);
        }
    }
    public void shuffle(){
        currentCard = 0;
        for(int i = 0; i < 1000; i++){
            int randNum = rand.nextInt()%52;
            if(randNum < 0){
                randNum = 0 - randNum;
            }
            Card temp;
            temp = deck[i%52];
            deck[i%52] = deck[randNum];
            deck[randNum] = temp;
        }
    }
    public void dealCard(int i, Card[] a){
        a[i] = deck[currentCard];
        currentCard++;
    }
}