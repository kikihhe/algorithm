package homework.homework4;


import java.util.Random;

public class Card {

    // constants for the suits
    public static final int CLUBS = 1;
    public static final int DIAMONDS = 2;
    public static final int HEARTS = 3;
    public static final int SPADES = 4;

    // constants for the face values
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    // instance variables for the face and suit of the card
    private int face;
    private int suit;

    // default constructor that randomly assigns a face and suit to the card
    public Card() {
        Random rand = new Random();
        face = rand.nextInt(13) + 1; // generate a random number from 1 to 13
        suit = rand.nextInt(4) + 1; // generate a random number from 1 to 4
    }

    // constructor that takes a face and suit value as parameters
    public Card(int f, int s) {
        face = f;
        suit = s;
    }

    // getter method for the face value
    public int getFace() {
        return face;
    }

    // getter method for the suit value
    public int getSuit() {
        return suit;
    }

    // setter method for the face value
    public void setFace(int f) {
        face = f;
    }

    // setter method for the suit value
    public void setSuit(int s) {
        suit = s;
    }

    // getter method for the textual representation of the face value
    public String getFaceText() {
        switch (face) {
            case ACE:
                return "Ace";
            case JACK:
                return "Jack";
            case QUEEN:
                return "Queen";
            case KING:
                return "King";
            default:
                return String.valueOf(face); // return the face value as a string
        }
    }

    // getter method for the textual representation of the suit value
    public String getSuitText() {
        switch (suit) {
            case CLUBS:
                return "Clubs";
            case DIAMONDS:
                return "Diamonds";
            case HEARTS:
                return "Hearts";
            case SPADES:
                return "Spades";
            default:
                return "Unknown"; // this should never happen
        }
    }

    @Override
    public String toString() {
        return getSuitText() + getFaceText() ;
    }

    public static void main(String[] args) {
                Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card(10, 3);
        Card card6 = new Card(2, 2);
        Card card7 = new Card(1, 1);
        Card card8 = new Card(12, 4);

        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
        System.out.println(card4);
        System.out.println(card5);
        System.out.println(card6);
        System.out.println(card7);
        System.out.println(card8);
    }
}
