package Model;

import java.util.ArrayList;

public class Hand {
    private static final int HAND__CAPACITY = 5;
    private ArrayList<Card> cardsInThisHand = new ArrayList<>();
    private Card nextCardInHand;

    public static int getHand_capacity() {
        return HAND__CAPACITY;
    }

    public ArrayList<Card> getCardsInThisHand() {
        return cardsInThisHand;
    }

    public void setCardsInThisHand(ArrayList<Card> cardsInThisHand) {
        this.cardsInThisHand = cardsInThisHand;
    }

    public Card getNextCardInHand() {
        return nextCardInHand;
    }

    public void setNextCardInHand(Card nextCardInHand) {
        this.nextCardInHand = nextCardInHand;
    }

    public void removeACard(int cardID) {
        Card card = Card.searchCardByID(cardID);
        this.getCardsInThisHand().remove(card);
    }

    public void addACard(int cardID) {
        Card card = Card.searchCardByID(cardID);
        if (!checkIfIsFull()) {
            this.getCardsInThisHand().add(card);
        deleteFromDeck(,card);
        }
    }

    public boolean checkIfIsFull() {
        if (this.getCardsInThisHand().size() == getHand_capacity())
            return true;
        return false;
    }

    public void deleteFromDeck(Deck deck, Card card) {
        deck.getCardsOfDeck().remove(card);
    }

}