package Model;

public class CustomGame extends Battle {

    public void setMode(int number) {
        mode = number;
    }

    public String setCoustomGame(String string) {
        String split[] = string.split(" ");
        if (player1.getAccount().searchDeckByName(split[ 0]) == null) {
            return ("Invalid Deck name");
        } else
            player1.setMainDeck(player1.getAccount().searchDeckByName(split[0]));
        mode = Integer.parseInt(split[1]);
        if (mode == 3) {
            howManyFlags = Integer.parseInt(split[2]);
        }
        return "Successful.";
    }


}
