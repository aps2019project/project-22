package Model;


import java.util.ArrayList;

public class Player {
    private Account account;
    private static ArrayList<Player> players = new ArrayList<>();
    private Deck mainDeck;
    private Hand hand;
    private GraveYard graveYard = new GraveYard();
    private int mana;
    private ArrayList<Card> usedCards = new ArrayList<>();
    private ArrayList<Item> collectibleItems = new ArrayList<>();
    private int turnNumber;

    public static void setPlayers(ArrayList<Player> players) {
        Player.players = players;
    }

    public void Player(Account account )
    {
        this.setAccount(account);
        this.setMainDeck(account.getMainDeck());
    }
    public Card findInGraveYard(int cardID)
    {
        for (Card card : getGraveYard().getCards())
        {
            if (card.getCardId() == cardID)
            {
                return card;
            }
        }
        return null;
    }

    public Account getAccount(){
        return account;
    }
    public void setAccount(Account account){
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

    public ArrayList<Card> getUsedCards() {
        return usedCards;
    }

    public void setUsedCards(ArrayList<Card> usedCards) {
        this.usedCards = usedCards;
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

    public static void addPlayer(Player player){
        Player.getPlayers().add(player);

    }

    public static void deletePlayer(Player player){
        Player.getPlayers().remove(player);
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public void setMana(int mana1){
        this.mana = mana1;
    }
     public int getMana() {
        return mana;
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
}