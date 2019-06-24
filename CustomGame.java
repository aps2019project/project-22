package Model;

public class CustomGame extends Battle {

    public void setMode(int number) {
        mode = number;
    }

    public void setCoustomGame(String string) {
        String split[] = string.split(" ");
        if (player1.getAccount().searchDeckByName(split[2]) == null){
            System.out.printf("Invalid Deck name");
        }else
            player1.setMainDeck(player1.getAccount().searchDeckByName(split[2]));
        mode = Integer.parseInt(split[3]);
        if (mode == 3) {
            howManyFlags = Integer.parseInt(split[4]);
        }
    }


}
