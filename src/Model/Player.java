package Model;


import java.util.ArrayList;

public class Player {
    private static ArrayList<Player> players = new ArrayList<>();
    private Account account;
    private Deck mainDeck;
    private Hand hand;
    private GraveYard graveYard = new GraveYard();
    private int manaPoint;
    private Hero hero;
    private ArrayList<Minion> minionCards = new ArrayList<>();
    private ArrayList<Spell> spellCards = new ArrayList<>();
    private ArrayList<Item> collectibleItems = new ArrayList<>();
    private int turnNumber;
    private int numberOfFlags;
    private int timeOfKeepingFlag;
    private int manaInTurn;

    public static void setPlayers(ArrayList<Player> players) {
        Player.players = players;
    }

    public void Player(Account account) {
        this.setAccount(account);
        this.setMainDeck(account.getMainDeck());
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

    public int getManaPoint() {
        return manaPoint;
    }

    public void setManaPoint(int manaPoint) {
        this.manaPoint = manaPoint;
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