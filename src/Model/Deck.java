package Model;

import java.util.ArrayList;

public class Deck {

    private static ArrayList<Deck> decks = new ArrayList<>();
    private String name;
    private int size = 0;
    private Hero hero ;
    private Item item;
    private ArrayList<Minion> minions = new ArrayList<>();
    private ArrayList<Spell> spells = new ArrayList<>();
    private ArrayList<Card> cardsOfDeck = new ArrayList<>(20);

    public Deck(String name) {
        this.setName(name);
        this.hero = new Hero(62, "simorq", 9000, 50, 4, "melee",
                -1, 5, 8);
    }

    public static ArrayList<Deck> getDecks() {
        return decks;
    }

    public static void setDecks(ArrayList<Deck> decks) {
        Deck.decks = decks;
    }


    public void setLevel1(Deck deck) {
        deck.addCardsOfDeck(Minion.getMinions().get(0));
        deck.addCardsOfDeck(Minion.getMinions().get(8));
        deck.addCardsOfDeck(Minion.getMinions().get(10));
        deck.addCardsOfDeck(Minion.getMinions().get(10));
        deck.addCardsOfDeck(Minion.getMinions().get(12));
        deck.addCardsOfDeck(Minion.getMinions().get(16));
        deck.addCardsOfDeck(Minion.getMinions().get(17));
        deck.addCardsOfDeck(Minion.getMinions().get(20));
        deck.addCardsOfDeck(Minion.getMinions().get(21));
        deck.addCardsOfDeck(Minion.getMinions().get(25));
        deck.addCardsOfDeck(Minion.getMinions().get(37));
        deck.addCardsOfDeck(Minion.getMinions().get(35));
        deck.addCardsOfDeck(Minion.getMinions().get(39));
        deck.addCardsOfDeck(Spell.getSpells().get(0));
        deck.addCardsOfDeck(Spell.getSpells().get(6));
        deck.addCardsOfDeck(Spell.getSpells().get(9));
        deck.addCardsOfDeck(Spell.getSpells().get(10));
        deck.addCardsOfDeck(Spell.getSpells().get(11));
        deck.addCardsOfDeck(Spell.getSpells().get(17));
        deck.addCardsOfDeck(Spell.getSpells().get(19));
        deck.setItem(Item.getItems().get(0));
    }

    public void setLevel2(Deck deck) {
        deck.addCardsOfDeck(Minion.getMinions().get(1));
        deck.addCardsOfDeck(Minion.getMinions().get(2));
        deck.addCardsOfDeck(Minion.getMinions().get(4));
        deck.addCardsOfDeck(Minion.getMinions().get(7));
        deck.addCardsOfDeck(Minion.getMinions().get(11));
        deck.addCardsOfDeck(Minion.getMinions().get(14));
        deck.addCardsOfDeck(Minion.getMinions().get(14));
        deck.addCardsOfDeck(Minion.getMinions().get(18));
        deck.addCardsOfDeck(Minion.getMinions().get(22));
        deck.addCardsOfDeck(Minion.getMinions().get(26));
        deck.addCardsOfDeck(Minion.getMinions().get(29));
        deck.addCardsOfDeck(Minion.getMinions().get(32));
        deck.addCardsOfDeck(Minion.getMinions().get(38));
        deck.addCardsOfDeck(Spell.getSpells().get(1));
        deck.addCardsOfDeck(Spell.getSpells().get(2));
        deck.addCardsOfDeck(Spell.getSpells().get(4));
        deck.addCardsOfDeck(Spell.getSpells().get(8));
        deck.addCardsOfDeck(Spell.getSpells().get(7));
        deck.addCardsOfDeck(Spell.getSpells().get(12));
        deck.addCardsOfDeck(Spell.getSpells().get(18));
        deck.setItem(Item.getItems().get(17));
    }

    public void setLevel3(Deck deck) {
        deck.addCardsOfDeck(Minion.getMinions().get(5));
        deck.addCardsOfDeck(Minion.getMinions().get(6));
        deck.addCardsOfDeck(Minion.getMinions().get(9));
        deck.addCardsOfDeck(Minion.getMinions().get(13));
        deck.addCardsOfDeck(Minion.getMinions().get(15));
        deck.addCardsOfDeck(Minion.getMinions().get(15));
        deck.addCardsOfDeck(Minion.getMinions().get(19));
        deck.addCardsOfDeck(Minion.getMinions().get(23));
        deck.addCardsOfDeck(Minion.getMinions().get(24));
        deck.addCardsOfDeck(Minion.getMinions().get(27));
        deck.addCardsOfDeck(Minion.getMinions().get(28));
        deck.addCardsOfDeck(Minion.getMinions().get(30));
        deck.addCardsOfDeck(Minion.getMinions().get(33));
        deck.addCardsOfDeck(Spell.getSpells().get(5));
        deck.addCardsOfDeck(Spell.getSpells().get(9));
        deck.addCardsOfDeck(Spell.getSpells().get(11));
        deck.addCardsOfDeck(Spell.getSpells().get(13));
        deck.addCardsOfDeck(Spell.getSpells().get(14));
        deck.addCardsOfDeck(Spell.getSpells().get(15));
        deck.addCardsOfDeck(Spell.getSpells().get(16));
        deck.setItem(Item.getItems().get(11));
    }

    public int getSize() {
        return size;
    }

    public void addCardsOfDeck(Card card) {
        cardsOfDeck.add(card);
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
        Deck deck = new Deck(name);
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
            System.out.println("it is available now !\nplease change deck's name");
            return;
        }
        deck = new Deck(deckName);
        Deck.getDecks().add(deck);
    }

    public static void deleteDeck(String deckName) {
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getName().equals(deckName)) {
                decks.remove(i);
                return;
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

    public void addCard(int id, Account account) {
        if (hero != null) {
            System.out.println("deck has hero now.");
            return;
        }
        if (cardsOfDeck.size() == 20) {
            System.out.println("deck is full!");
            return;
        }
        for (int i = 0; i < cardsOfDeck.size(); i++) {
            if (cardsOfDeck.get(i).getId() == id) {
                System.out.println("this card is in deck now");
                return;
            }
        }
        int i = 0;
        for (; i < account.getCollection().getItems().size(); i++) {
            if (account.getCollection().getItems().get(i).getId() == id) {
                break;
            }
        }
        if (i == account.getCollection().getItems().size()) {
            System.out.println("this item hasn't in collection");
            return;
        }
        i = 0;
        for (; i < account.getCollection().getSpells().size(); i++) {
            if (account.getCollection().getSpells().get(i).getId() == id) {
                break;
            }
        }
        if (i == account.getCollection().getSpells().size()) {
            System.out.println("this spell hasn't in collection");
            return;
        }
        i = 0;
        for (; i < account.getCollection().getMinions().size(); i++) {
            if (account.getCollection().getMinions().get(i).getId() == id) {
                break;
            }
        }
        if (i == account.getCollection().getMinions().size()) {
            System.out.println("this minion hasn't in collection");
            return;
        }
        Card card = new Card();
        card.setId(id);
        cardsOfDeck.add(card);
    }
}
