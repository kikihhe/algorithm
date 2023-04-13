package homework.homework5;

import homework.homework4.Card;

public class DeckOfCardsTest {

    public static void main(String[] args) {

        DeckOfCards deck = new DeckOfCards(); // create a new deck of cards object

        System.out.println("The populated deck:");
        System.out.println(deck); // print the populated deck

        System.out.println("Shuffling the deck...");
        deck.shuffle(); // shuffle the deck

        System.out.println("The shuffled deck:");
        System.out.println(deck); // print the shuffled deck

        System.out.println("Dealing each card from a shuffled deck:");
        while (deck.cardsLeft() > 0) { // loop until there are no more cards left in the deck
            Card card = deck.dealCard(); // deal a card from the deck and store it in a variable
            System.out.println(card.getFaceText() + " of " + card.getSuitText()); // print
            System.out.println("Cards left in the deck: " + deck.cardsLeft()); // print the number of cards left in the deck
        }
    }
}