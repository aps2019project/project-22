package Model;

public class CustomGame extends Battle {
    public void setHero(Hero hero, Player player) {
        player.setHero(hero);
    }

    public void setMode(int number) {
        mode = number;
    }

    public void setCoustomGame(String string) {
        String split[] = string.split(" ");
        player1.setMainDeck(Deck.searchDeckByName(split[2]));
        mode = Integer.parseInt(split[3]);
        if (mode == 3) {
            howManyFlags = Integer.parseInt(split[4]);
        }
    }


}
