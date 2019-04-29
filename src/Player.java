package Model;


import java.util.ArrayList;

public class Player extends Account {

    private static ArrayList<Player> players;
    private String name;
    private ArrayList<Hand> hands;
    private ArrayList<Deck> decks;
    private int winScore;
    private int loseScore;
    private int drawScore;
    private ArrayList<Card> graveyard = new ArrayList<>();
    private int money;
    private int mana;


    public ArrayList<Card> getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(ArrayList<Card> graveyard) {
        this.graveyard = graveyard;
    }

    public static void addPlayer(Player player){
        players().add(player);

    }
    public static ArrayList<Player> players(){
        return players;
    }

    public void giveMoney() {

    }
    public long getMoney() {
        return money;

    }

    public void addHand(Hand hand){
        this.getHands().add(hand);

    }
    public void addDeck(Deck deck){
        this.getDecks().add(deck);

    }
    public void setName (String name){
        this.name = name;

    }
    public String getName(){
        return name;
    }

    public ArrayList<Hand> getHands() {
        return hands;
    }
    public ArrayList<Deck> getDecks() {
        return decks;
    }
    public void setWinScore(int winScore1) {
        this.winScore = winScore1;

    }
    public void setLoseScore(int loseScore1) {
        this.loseScore = loseScore1 ;
    }
    public void setDrawScore(int drawScore1) {
        this.drawScore = drawScore1;
    }
    public void setMana(int mana1){
        this.mana = mana1;
    }
    public void changeMana() {

    }
     public int getMana() {
        return mana;
     }

}