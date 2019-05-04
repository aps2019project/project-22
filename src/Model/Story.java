package Model;

public class Story extends Battle {
    int level;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPlayer2Deck(Player player2, Deck deck){
        player2.setDeck(deck);
    }
    public void playLevel1(){

    }

}
