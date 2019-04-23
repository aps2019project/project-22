package Model;


public class Player extends Account {

    private static Arraylist<Player> players;
    private String name;
    private Arraylist<Hand> hands;
    private Arraylist<Deck> decks;
    private int winScore;
    private int loseScore;
    private int drawScore;
    private int money;
    private int mana;

    public static void addPlayer(Player player){

    }
    public static Arraylist<Player> players(){
        return players;
    }

    public void giveMoney() {

    }
    public void getMoney() {

    }

    public void addHand(Hand hand){

    }
    public void addDeck(Deck deck){

    }
    public void setName (String name){

    }
    public String getName(){
        return name;
    }

    public Arraylist<Hand> getHands() {
        return hands;
    }
    public Arraylist<Deck> getDecks() {
        return decks;
    }
    public void setWinScore() {

    }
    public void setLoseScore() {

    }
    public void setDrawScore() {

    }
    public void setMana(){

    }
    public void changeMana() {

    }
     public int getMana() {
        return mana;
     }

}