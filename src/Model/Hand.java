package Model;

import java.util.ArrayList;
import java.util.Random;

public class Hand {
    private static final int HAND__CAPACITY = 5;
    private ArrayList<Card> cardsInThisHand = new ArrayList<>();
    private Deck deck;
    private GraveYard graveYard;

    public Hand(GraveYard graveYard) {
        this.setGraveYard(graveYard);
    }

    public static int getHand_capacity() {
        return HAND__CAPACITY;
    }

    public ArrayList<Card> getCardsInThisHand() {
        return cardsInThisHand;
    }

    public void setCardsInThisHandInFirst() {
        ArrayList<Card> cardsOfDeck = new ArrayList<>();
        for (int i = 0; i < deck.getCardsOfDeck().size(); i++) {
            cardsOfDeck.add(cardsOfDeck.get(i));
        }
        for (int i = 0; i < HAND__CAPACITY; i++) {
            Random random = new Random(cardsOfDeck.size());
            int rand = random.nextInt();
            cardsInThisHand.add(cardsOfDeck.get(rand));
            cardsOfDeck.remove(rand);
        }
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Card getNextCardInHand(int mana) {
        Card nextCardInHand = cardsInThisHand.get(0);
        if (mana > nextCardInHand.getManaPoint()) {
            graveYard.addCards(cardsInThisHand.get(0));
            cardsInThisHand.remove(0);
            return nextCardInHand;
        }
        return null;
    }

    public void addACard(int cardID) {
        if (!handIfIsFull() && deck.getCardsOfDeck().size() > 0) {
            Random random = new Random(deck.getCardsOfDeck().size());
            int rand = random.nextInt();
            cardsInThisHand.add(deck.getCardsOfDeck().get(rand));
            deck.getCardsOfDeck().remove(rand);
        }
    }

    public boolean handIfIsFull() {
        if (this.getCardsInThisHand().size() == getHand_capacity())
            return true;
        return false;
    }

    public void setGraveYard(GraveYard graveYard) {
        this.graveYard = graveYard;
    }
    //    public void deleteFromDeck(Deck deck, Card card) {
//        deck.getCardsOfDeck().remove(card);

//    }

    //    public void removeACard(int cardID) {
//        Card card = Card.searchCardByID(cardID);
//        this.getCardsInThisHand().remove(card);

//    }
}