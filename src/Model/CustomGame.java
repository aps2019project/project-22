package Model;

public class CustomGame extends Battle {
    public void setHero(Hero hero, Player player){
        player.setHero(hero);
    }
    public void checkForWinner(){
        if (mode == 1){
            if (player1.getHero().getHealthPoint() <= 0){
                player2.getAccount().setMoney(player2.getAccount().getMoney()+1000);

                endGame = true;
            }else if (player2.getHero().getHealthPoint() <= 0){
                player1.getAccount().setMoney(player1.getAccount().getMoney()+1000);
                endGame = true;
            }
        }else if (mode == 2){
            if (player1.getHowLongFlagsHasBeenKept() == 6){
                player1.getAccount().setMoney(player1.getAccount().getMoney()+1000);
                endGame = true;
            }else if (player2.getHowLongFlagsHasBeenKept() == 6){
                player2.getAccount().setMoney(player2.getAccount().getMoney()+1000);
                endGame = true;
            }
        }else if (mode == 3){
            if (player1.getHowManyFlag() == howManyFlags/2){
                player1.getAccount().setMoney(player1.getAccount().getMoney()+1000);
                endGame = true;
            }else if (player2.getHowManyFlag() == howManyFlags/2){
                player2.getAccount().setMoney(player2.getAccount().getMoney()+1000);
                endGame = true;
            }
        }
    }
}
