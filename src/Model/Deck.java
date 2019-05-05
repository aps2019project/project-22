package Model;

import java.util.ArrayList;

public class Deck {

    private static ArrayList<Deck> decks = new ArrayList<>();
    private String name;
    private int size = 0;
    private Hero hero;
    private Item item;
    private ArrayList<Minion> minions = new ArrayList<>();
    private ArrayList<Spell> spells = new ArrayList<>();
    private ArrayList<Card> cardsOfDeck = new ArrayList<>(20);

    public static ArrayList<Deck> getDecks() {
        return decks;
    }

    public static void setDecks(ArrayList<Deck> decks) {
        Deck.decks = decks;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void increaseSize() {
        this.setSize(this.getSize() + 1);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        if (this.getHero() == null)
            this.hero = hero;
    }

    public ArrayList<Card> getCardsOfDeck() {
        return cardsOfDeck;
    }

    public void setCardsOfDeck(ArrayList<Card> cardsOfDeck) {
        this.cardsOfDeck = cardsOfDeck;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        if (this.item == null)
            this.item = item;
    }

    public void Deck(String name, Hero hero, Item item, ArrayList<Card> cardsOfDeck) {
        Deck deck = new Deck();
        deck.setName(name);
        deck.setHero(hero);
        deck.setItem(item);
        deck.setCardsOfDeck(cardsOfDeck);
    }

    public static Deck searchDeckByName(String deckName) {
        for (Deck deck : Deck.getDecks()) {
            if (deck.getName().equals(deckName))
                return deck;
        }
        return null;
    }

    public static void createDeck(String deckName) {
        Deck deck = searchDeckByName(deckName);
        if (deck != null) {
            System.out.println("please change deck's name");
            return;
        }
        deck = new Deck();
        deck.setName(deckName);
        Deck.getDecks().add(deck);
    }

    public static void removeDeck(String deckName) {
        for (Deck deck : Deck.getDecks()) {
            if (deck.getName().equals(deckName)) {
                getDecks().remove(deck);
                break;
            }
        }
    }

    public static void addCardToDeck(String deckName, int cardID) {
        Deck deck = searchDeckByName(deckName);
        Card card = Card.searchCardByID(cardID);
        deck.getCardsOfDeck().add(card);
    }

    public static void removeCardFromDeck(String deckName, int cardID) {
        Deck deck = searchDeckByName(deckName);
        Card card = Card.searchCardByID(cardID);
        deck.getCardsOfDeck().remove(card);
    }

    public boolean checkIfItIsFilled() {
        if (this.getCardsOfDeck().size() == 20 && this.getHero() != null)
            return true;
        return false;
    }

    public void deleteItem(Item item) {
        this.setItem(null);
    }

    public void deleteHero() {
        this.setHero(null);
    }

    public void seeTheNextCardAddedToHand() {
        //badan minvism...
    }

    public void chooseRandomCardsForDeck() {
        //badan minvism...
    }

    public Card nextCard() {
        return this.getCardsOfDeck().get(getSize());

    }

    public boolean boolCheckIfItHasThisCard(int cardID) {
        for (Card card : this.getCardsOfDeck()) {
            if (card.getCardId() == cardID)
                return true;
        }
        return false;
    }

    public Card checkIfItHasThisCard(int cardID) {
        for (Card card : this.getCardsOfDeck()) {
            if (card.getCardId() == cardID)
                return card;
        }
        return null;
    }

    public ArrayList<Minion> getMinions() {
        return minions;
    }

    public void setMinions(ArrayList<Minion> minions) {
        this.minions = minions;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }
}
