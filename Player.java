package Model;


import java.util.ArrayList;
import java.util.Random;

public class Player {
    private static ArrayList<Player> players = new ArrayList<>();
    private Account account;
    private Deck mainDeck;
    private Hand hand;
    private GraveYard graveYard = new GraveYard();
    private int mana;
    private boolean item8 = false;
    private Hero hero;
    private ArrayList<Minion> minionCards = new ArrayList<>();
    private ArrayList<Spell> spellCards = new ArrayList<>();
    private ArrayList<Item> collectibleItems = new ArrayList<>();
    private int turnNumber;
    private ArrayList<Card> cardsInTheFiled = new ArrayList<>();
    private int numberOfFlags;
    private int timeOfKeepingFlag;
    private int howLongFlagsHasBeenKept = 0;
    private int howManyFlag = 0;
    private int manaInTurn;
    private boolean flag = false;

    public boolean getItem8(){
        return item8;
    }
    public int getHowLongFlagsHasBeenKept() {
        return howLongFlagsHasBeenKept;
    }

    public void setHowLongFlagsHasBeenKept(int howLongFlagsHasBeenKept) {
        this.howLongFlagsHasBeenKept = howLongFlagsHasBeenKept;
    }

    public int getHowManyFlag() {
        return howManyFlag;
    }

    public void setHowManyFlag(int howManyFlag) {
        this.howManyFlag = howManyFlag;
    }

    public void setFlagTrue(){
        flag = true;
    }
    public void setFlagFalse(){
        flag = false;
    }
    public boolean getFlag(){
        return flag;
    }
    public void setItem8True(){
        item8 = true;
    }
    public void setItem8False(){
        item8 = false;
    }
    public static void setPlayers(ArrayList<Player> players) {
        Player.players = players;
    }
    public void addCardsInTheFile (Card cardsInTheFiled) {
        this.cardsInTheFiled.add(cardsInTheFiled);
    }
    public ArrayList<Card> getCardsInTheFiled() {
        return getCardsInTheFiled();
    }
    public void Player(Account account) {
        this.setAccount(account);
        this.setMainDeck(account.getMainDeck());
    }
    public void setDeck(Deck deck){
        Random rand = new Random();
        for (int i = 0; i < 13; i++){
            int n = rand.nextInt(40);
            deck.addCardsOfDeck(Minion.getMinions().get(n));
        }
        for (int i = 0; i < 7; i++){
            int n = rand.nextInt(20);
            deck.addCardsOfDeck(Spell.getSpells().get(n));
        }
        int n = rand.nextInt(20);
        deck.setItem(Item.getItems().get(n));
        mainDeck = deck;
    }
    public void setHand(){
        Random rand = new Random();
        int n = rand.nextInt(20);
        for (int i = 0; i < 5; i++){
            hand.addCard(mainDeck.getCardsOfDeck().get(n));
        }
    }
    public void setCard(){
        this.minionCards = Minion.getMinions();
        this.spellCards = Spell.getSpells();
    }
    public Card findInGraveYard(int cardID) {
        for (Card card : getGraveYard().getCards()) {
            if (card.getCardId() == cardID) {
                return card;
            }
        }
        return null;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public GraveYard getGraveyard() {
        return this.getGraveYard();
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public ArrayList<Item> getCollectibleItems() {
        return collectibleItems;
    }

    public void setCollectibleItems(ArrayList<Item> collectibleItems) {
        this.collectibleItems = collectibleItems;
    }

    public void setGraveyard(GraveYard graveyard) {
        this.setGraveYard(graveyard);
    }

    public static void addPlayer(Player player) {
        Player.getPlayers().add(player);

    }

    public static void deletePlayer(Player player) {
        Player.getPlayers().remove(player);
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public void increaseTurnNumber() {
        setTurnNumber(getTurnNumber() + 1);
    }

    public void addToGraveYard(Card card) {
        this.getGraveyard().getCards().add(card);
    }

    public Deck getMainDeck() {
        return mainDeck;
    }

    public void setMainDeck(Deck mainDeck) {
        this.mainDeck = mainDeck;
    }

    public GraveYard getGraveYard() {
        return graveYard;
    }

    public void setGraveYard(GraveYard graveYard) {
        this.graveYard = graveYard;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public ArrayList<Minion> getMinionCards() {
        return minionCards;
    }

    public void setMinionCards(ArrayList<Minion> minionCards) {
        this.minionCards = minionCards;
    }

    public ArrayList<Spell> getSpellCards() {
        return spellCards;
    }

    public void setSpellCards(ArrayList<Spell> spellCards) {
        this.spellCards = spellCards;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getNumberOfFlags() {
        return numberOfFlags;
    }

    public void setNumberOfFlags(int numberOfFlags) {
        this.numberOfFlags = numberOfFlags;
    }

    public int getTimeOfKeepingFlag() {
        return timeOfKeepingFlag;
    }

    public void setTimeOfKeepingFlag(int timeOfKeepingFlag) {
        this.timeOfKeepingFlag = timeOfKeepingFlag;
    }
    public void insertCard(int x,int y){
        Card card=hand.getNextCardInHand(manaInTurn);
        if(card==null){
            return;
        }
        card.setX(x);
        card.setY(y);
        Cell.insertCard(card,x,y);
    }

    public int getManaInTurn() {
        return manaInTurn;
    }

    public void setManaInTurn() {
        int manaInTurn=2;
        if (turnNumber == 1) {
            manaInTurn = 2;
        } else if (turnNumber == 2 || turnNumber == 3) {
            manaInTurn = 3;
        } else if (turnNumber == 4 || turnNumber == 5) {
            manaInTurn = 4;
        } else if (turnNumber == 6 || turnNumber == 7) {
            manaInTurn = 5;
        } else if (turnNumber == 8 || turnNumber == 9) {
            manaInTurn = 6;
        } else if (turnNumber == 10 || turnNumber == 11) {
            manaInTurn = 7;
        } else if (turnNumber == 12 || turnNumber == 13) {
            manaInTurn = 8;
        } else {
            manaInTurn = 9;
        }
        this.manaInTurn = manaInTurn;
    }

}