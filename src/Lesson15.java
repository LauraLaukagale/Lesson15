import java.sql.SQLOutput;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Lesson15 {
    enum suits {
        Hearts,
        Spades,
        Clubs,
        Diamonds
    }

    enum cardValues {
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King,
        Ace
    }

    public static void main(String[] args) {


//        Tasks 1
//      Write a program where actions with constant values of String (Enums) will be provided.
//      Please take a look here: https://www.geeksforgeeks.org/enum-in-java/
//      Create a new Enum where all card suits will be stored - Spades, Clubs, Hearts and Diamonds.
//      Create a new Enum where all card values will be stored - Two, Three, …, King and Ace.
//      Using two for loops, create a card pack as the String array with all possible cards, for example, Spades Two, Spades Three, Spades Four, etc. You can use Enum function values() if You want.
//      Create a shuffle algorithm and shuffle the card pack.
//      Select the first card and print it out in the console.
//      Select another six cards and print all six cards in the console. It is not possible to select the same card from the pack because each card is unique. Please “remove” the card after selection.

        String[] cardDeck = new String [52];
        int counter = 0;

//      transform enum to array
        for (int i = 0; i <suits.values().length; i++) {
            for (int j = 0; j <cardValues.values().length; j++) {

                cardDeck[counter] = String.format("%s %s", suits.values()[i], cardValues.values()[j]);
                System.out.println(cardDeck[counter]);
                counter++;
            }
        }

//        Shuffle the deck simple
//        Select one random card
//        It will return a value between 0-1, here we are multiplying by 51 as we have in total 52 indexes
//        Math.random()*51;
//        Get 1st random card
        String randomCard = cardDeck[(int)(Math.random()*51d)];
        System.out.println("We got a RANDOM FIRST CARD: " + randomCard );

//        Get 1st six cards, but unfortunately they might be repeated */
        for (int i = 0; i < 6; i++) {
            String randomCard6 = cardDeck[(int)(Math.random()*51d)];
            System.out.println("We got one of 6 RANDOM cards: " + randomCard6 );
            
        }

//        Now lets shuffle cards properly
        Random rnd = ThreadLocalRandom.current();
        for (int i = cardDeck.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = cardDeck[index];
            cardDeck[index] = cardDeck[i];
            cardDeck [i] = a;
        }
//        PRINT 1ST 6 ELEMENTS, NOT THEY WILL NEVER REPEAT (WITH SHUFFLE ABOVE)
        for (int i = 0; i < 6; i++) {
            System.out.println("We got one out of 6 REALLY SUFFLED CARDS: " + cardDeck[i]);
            
        }
    }
}
