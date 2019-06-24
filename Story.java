package Model;

public class Story extends Battle {
    int level;

    public void setLevel(int level) {
        this.level = level;
        mode = level;
    }

    public void setPlayer2Deck(Player player2, Deck deck) {
        player2.setMainDeck(deck);
    }


}
