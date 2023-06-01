/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author kirtan patel
 */

import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        for (int i = 0; i < magicHand.length; i++) {
            Card c = getRandomCard();
            magicHand[i] = c;
        }

        Card luckyCard = getUserCard();

        boolean foundMatch = false;
        for (Card card : magicHand) {
            if (card.getSuit().equals(luckyCard.getSuit()) && card.getValue() == luckyCard.getValue()) {
                foundMatch = true;
                break;
            }
        }

        if (foundMatch) {
            System.out.println("Congratulations! Your  lucky card is in the magic hand.");
        } else {
            System.out.println("Sorry, your lucky card is not in the magic hand.");
        }
    }

    public static Card getRandomCard() {
        int randomSuitIndex = (int) (Math.random() * 4);
        int randomValue = (int) (Math.random() * 13) + 1;
        String suit = Card.SUITS[randomSuitIndex];
        return new Card(suit, randomValue);
    }

    public static Card getUserCard() {
        Scanner scanner = new Scanner(System.in);

       
            System.out.println("Enter the value of your card (1-13):");
            int value = scanner.nextInt();

            System.out.println("Enter the suit of your card (Clubs, Hearts, Spades, Diamonds):");
            String suit = scanner.next();

            return new Card(suit, value);
        
        
    }

}
