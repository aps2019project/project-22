package Model;

import java.util.ArrayList;

public class Hand extends Card {
    private ArrayList<Card> cards;
    private int turn;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void chooseCards() {

    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {

    }

    public void chooseCards(ArrayList<Card> cards) {
        // Deck.getCards

    }

    public boolean checkIfTheCardsAreInDeck(ArrayList<Card> cards) {
        //    Deck.getCards
        return true; // naqeees
    }

    public void deleteFromDeck(Deck deck) {

    }

    public boolean checkIfHandHasFreeSpace() {
        boolean check = true;
        return check;
    }

    public void addToHand(ArrayList<Card> cardsOfDeck) {

    }

    public void deleteFromHand(Card card) {

    }

}
