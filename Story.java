package Model;

public class Story extends Battle {
    int level;
    public void setLevel(int level) {
        this.level = level;
        mode = level;
    }

    public void setPlayer2Deck(Player player2, Deck deck){
        player2.setMainDeck(deck);
    }
    public void checkForWinner(){
        if (level == 1){
            if (player1.getHero().getHealthPoint() <= 0){
                player2.getAccount().setMoney(player2.getAccount().getMoney()+500);

                endGame = true;
            }else if (player2.getHero().getHealthPoint() <= 0){
                player1.getAccount().setMoney(player1.getAccount().getMoney()+500);
                endGame = true;
            }
        }else if (level == 2){
            if (player1.getHowLongFlagsHasBeenKept() == 6){
                player1.getAccount().setMoney(player1.getAccount().getMoney()+1000);
                endGame = true;
            }else if (player2.getHowLongFlagsHasBeenKept() == 6){
                player2.getAccount().setMoney(player2.getAccount().getMoney()+1000);
                endGame = true;
            }
        }else if (level == 3){
            if (player1.getHowManyFlag() == howManyFlags/2){
                player1.getAccount().setMoney(player1.getAccount().getMoney()+1500);
                endGame = true;
            }else if (player2.getHowManyFlag() == howManyFlags/2){
                player2.getAccount().setMoney(player2.getAccount().getMoney()+1500);
                endGame = true;
            }
        }
    }

}
