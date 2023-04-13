package 作业.作业五;

import 作业.作业四.Card;

import java.util.Random;

public class DeckOfCards {

    // constant for the number of cards in the deck
    public static final int NUM_CARDS = 52;

    // instance variables for the array of cards and the current card index
    private Card[] cards;
    private int currentCard;

    // constructor that creates a full deck of cards
    public DeckOfCards() {
        cards = new Card[NUM_CARDS]; // create an array of 52 cards
        currentCard = 0; // set the current card index to 0
        // loop through the suits and face values to create each card
        for (int suit = Card.CLUBS; suit <= Card.SPADES; suit++) {
            for (int face = Card.ACE; face <= Card.KING; face++) {
                cards[currentCard] = new Card(face, suit); // create a new card with the given face and suit
                currentCard++; // increment the current card index
            }
        }
        currentCard = 0; // reset the current card index to 0
    }

    // method that shuffles the deck by randomly swapping pairs of cards
    public void shuffle() {
        Random rand = new Random();
        // loop through the deck and swap each card with another random card
        for (int i = 0; i < NUM_CARDS; i++) {
            int j = rand.nextInt(NUM_CARDS); // generate a random index from 0 to 51
            Card temp = cards[i]; // store the current card in a temporary variable
            cards[i] = cards[j]; // assign the random card to the current position
            cards[j] = temp; // assign the temporary card to the random position
        }
        currentCard = 0; // reset the current card index to 0
    }

    // method that deals a card from the deck and returns it
    public Card dealCard() {
        if (currentCard < NUM_CARDS) { // check if there are still cards left in the deck
            return cards[currentCard++]; // return the current card and increment the index
        } else {
            return null; // return null if the deck is empty
        }
    }

    // method that returns the number of cards left in the deck
    public int cardsLeft() {
        return NUM_CARDS - currentCard; // subtract the current card index from the total number of cards
    }

    // method that returns a string representation of the deck contents
    public String toString() {
        String result = ""; // initialize an empty string to store the result
        // loop through the deck and append each card to the result string
        for (int i = 0; i < NUM_CARDS; i++) {
            result += cards[i].getFaceText() + " of " + cards[i].getSuitText() + "\n"; // add the textual representation of each card followed by a newline character
        }
        return result; // return the result string
    }
}