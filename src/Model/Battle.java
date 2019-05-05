package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
    private static ArrayList<Battle> savedBattles = new ArrayList<>();
    private Player player1;
    private Player player2;
    Story storys;
    Minion targetMinion;
    Minion attackerMinion;
    Hero targetHero;
    Hero attackerHero;
    private boolean endGame = false;
    private boolean singlePlayer = false;
    private boolean turn = false;

    public static void addSaveBattle(Battle battle) {
        savedBattles.add(battle);
    }

    public static ArrayList getSavedBattle() {
        return savedBattles;
    }

    public void setBolleanTurnTrue() {
        turn = true;
    }

    public void setBooleanTurnFalse() {
        turn = false;
    }

    public void setPlayer1(Player player) {
        player1 = player;
    }

    public void setPlayer2(Player player) {
        player2 = player;
    }

    public void setBooleanSinglePlayerTrue() {
        singlePlayer = true;
    }

    public void setBooleanSinglePlayerFalse() {
        singlePlayer = false;
    }

    public void attachBack(Card card1, Card card2) {
        if (card2.getTypeOfAttack().matches("melee")) {
            if (card1.getX() >= card2.getX() - 1 && card1.getX() <= card2.getX() + 1 && card2.getY() == card1.getY() ||
                    card1.getY() >= card2.getY() - 1 && card1.getY() <= card2.getY() + 1 && card1.getX() == card2.getY() ||
                    card1.getY() == card2.getY() + 1 && card1.getX() == card2.getX() + 1 || card1.getX() == card2.getX() + 1 && card1.getY()
                    == card2.getY() - 1 || card1.getX() == card2.getX() - 1 && card2.getY() == card2.getY() + 1 || card1.getX() == card2.getX() - 1
                    && card1.getY() == card2.getY() - 1) {
                card1.setHealthPoint(card1.getHealthPoint() - card2.getAttackPower());
            }
        }else if (card2.getTypeOfAttack().matches("ranged")) {
            if (!(card1.getX() >= card2.getX() - 1 && card1.getX() <= card2.getX() + 1 && card2.getY() == card1.getY() ||
                    card1.getY() >= card2.getY() - 1 && card1.getY() <= card2.getY() + 1 && card1.getX() == card2.getY() ||
                    card1.getY() == card2.getY() + 1 && card1.getX() == card2.getX() + 1 || card1.getX() == card2.getX() + 1 && card1.getY()
                    == card2.getY() - 1 || card1.getX() == card2.getX() - 1 && card2.getY() == card2.getY() + 1 || card1.getX() == card2.getX() - 1
                    && card1.getY() == card2.getY() - 1)) {
                card1.setHealthPoint(card1.getHealthPoint() - card2.getAttackPower());
            }
        }else if (card2.getTypeOfAttack().matches("hybrid")) {
            card1.setHealthPoint(card1.getHealthPoint() - card2.getAttackPower());
        }
    }



//    public void attack() {
//        int distance = 0;
//        if (attackerMinion.getX() > targetMinion.getX()) {
//            if (attackerMinion.getY() > targetMinion.getY())
//                distance = attackerMinion.getX() - targetMinion.getX() + attackerMinion.getY() - targetMinion.getY();
//            else
//                distance = attackerMinion.getX() - targetMinion.getX() + targetMinion.getY() - attackerMinion.getY();
//        } else {
//            if (attackerMinion.getY() > targetMinion.getY())
//                distance = targetMinion.getX() - attackerMinion.getX() + attackerMinion.getY() - targetMinion.getY();
//            else
//                distance = targetMinion.getX() - attackerMinion.getX() + targetMinion.getY() - attackerMinion.getY();
//        }
//
//        if (attackerMinion.getID() == 1 || attackerMinion.getID() == 4 || attackerMinion.getID() == 3 || attackerMinion.getID() == 7
//        || attackerMinion.getID() == 8 || attackerMinion.getID() == 9 || attackerMinion.getID() == 11 || attackerMinion.getID() == 13
//        || attackerMinion.getID() == 14 || attackerMinion.getID() == 16 || attackerMinion.getID() == 19 || attackerMinion.getID() == 33
//        || attackerMinion.getID() == 34) {
//            if (attackerMinion.getRangeOfAttack() <= distance) {
//                targetMinion.setHealthPoint(targetMinion.getHealthPoint() - attackerMinion.getAttackPower());
//                attachBack();
//            }
//        }else if (attackerMinion.getID() == 2){
//            targetMinion.setHealthPoint(targetMinion.getHealthPoint() - attackerMinion.getAttackPower());
//        }else if (attackerMinion.getID() == 5){
//            targetMinion.setHealthPoint(targetMinion.getHealthPoint() - attackerMinion.getAttackPower()-(5*targetMinion.getMinion5Counter()));
//            targetMinion.addMinion5Counter();
//        }else if (attackerMinion.getID() == 6){
//
//        }
    //}
    public int getDistance(int x1,int x,int y1,int y){
        int distance = 0;
        if (x1 > x) {
            if (y1 > y)
                distance = x1 - x + y1 - y;
            else
                distance = x1 - x + y - y1;
        } else {
            if (y1 > y)
                distance = x - x1 + y1 - y;
            else
                distance = x - x1 + y - y1;
        }
        return distance;
    }

    public void fight(Scanner scanner) {
        int isValid = 1;
        int card1ID = 0;
        int card2ID = 0;
        int validID = 0;
        int enemyId = 0;
        int IDNumber1 = 0;
        Player player = new Player();
        Player enemyPlayer = new Player();
        while (!endGame) {
            if (!turn) {
                player = player1;
                enemyPlayer = player2;
            } else {
                player = player2;
                enemyPlayer = player1;
            }
            String command = scanner.nextLine();

            if (command.indexOf("Select") != -1){
                String split[] = command.split("\\[");
                String split2[] = split[1].split("]");
                IDNumber1 = Integer.parseInt(split2[0]);
                for (int i = 0; i < player.getCardsInTheFiled().size(); i++) {
                    if (IDNumber1 == player.getCardsInTheFiled().get(i).getId()) {
                        validID = 1;
                        card1ID = i;
                        break;
                    }
                }
                if (validID == 0){
                    System.out.println("Invalid card id");
                }
            }else if (command.indexOf("Move to")!= -1){
                int x = command.charAt(9)-48;
                int y = command.charAt(11)-48;
                int distance = getDistance(player.getCardsInTheFiled().get(card1ID).getX(),x,player.getCardsInTheFiled().get(card1ID).getY(),y);
                if (distance <= 2){
                    player.getCardsInTheFiled().get(card1ID).setX(x);
                    player.getCardsInTheFiled().get(card1ID).setY(y);
                    System.out.println(IDNumber1+"moved to"+x+" "+y);
                }else
                    System.out.println("Invalid target");
            }else if (command.indexOf("Attack") != -1){
                String split[] = command.split("\\[");
                String split2[] = split[1].split("]");
                enemyId = Integer.parseInt(split2[0]);
                for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++) {
                    if (IDNumber1 == enemyPlayer.getCardsInTheFiled().get(i).getId()) {
                        validID = 1;
                        card2ID = i;
                        break;
                    }
                }
                if (IDNumber1 == 5){
                    enemyPlayer.getCardsInTheFiled().get(card2ID).addMinion5Counter();
                }
                if (validID == 0){
                    System.out.println("Invalid card id");
                }
                int distance = getDistance(player.getCardsInTheFiled().get(card1ID).getX(),enemyPlayer.getCardsInTheFiled().get(card2ID).getX()
                        ,player.getCardsInTheFiled().get(card1ID).getY(),enemyPlayer.getCardsInTheFiled().get(card2ID).getY());
                if (player.getCardsInTheFiled().get(card1ID).getStun() || player.getCardsInTheFiled().get(card1ID).getStunByMinion5()
                    || player.getCardsInTheFiled().get(card1ID).getHaveBeenUsed()){
                    System.out.println("Card with "+IDNumber1+" can't attack");
                }
                else if (player.getCardsInTheFiled().get(card1ID).getRangeOfAttack()== -1){
                    if (enemyPlayer.getCardsInTheFiled().get(card2ID).getX() >= player.getCardsInTheFiled().get(card1ID).getX() - 1 && enemyPlayer.getCardsInTheFiled().get(card2ID).getX() <= player.getCardsInTheFiled().get(card1ID).getX() + 1 && player.getCardsInTheFiled().get(card1ID).getY() == enemyPlayer.getCardsInTheFiled().get(card2ID).getY() ||
                            enemyPlayer.getCardsInTheFiled().get(card2ID).getY() >= player.getCardsInTheFiled().get(card1ID).getY() - 1 && enemyPlayer.getCardsInTheFiled().get(card2ID).getY() <= player.getCardsInTheFiled().get(card1ID).getY() + 1 && enemyPlayer.getCardsInTheFiled().get(card2ID).getX() == player.getCardsInTheFiled().get(card1ID).getY() ||
                            enemyPlayer.getCardsInTheFiled().get(card2ID).getY() == player.getCardsInTheFiled().get(card1ID).getY() + 1 && enemyPlayer.getCardsInTheFiled().get(card2ID).getX() == player.getCardsInTheFiled().get(card1ID).getX() + 1 || enemyPlayer.getCardsInTheFiled().get(card2ID).getX() == player.getCardsInTheFiled().get(card1ID).getX() + 1 && enemyPlayer.getCardsInTheFiled().get(card2ID).getY()
                            == player.getCardsInTheFiled().get(card1ID).getY() - 1 || enemyPlayer.getCardsInTheFiled().get(card2ID).getX() == player.getCardsInTheFiled().get(card1ID).getX() - 1 && player.getCardsInTheFiled().get(card1ID).getY() == player.getCardsInTheFiled().get(card1ID).getY() + 1 || enemyPlayer.getCardsInTheFiled().get(card2ID).getX() == player.getCardsInTheFiled().get(card1ID).getX() - 1
                            && enemyPlayer.getCardsInTheFiled().get(card2ID).getY() == player.getCardsInTheFiled().get(card1ID).getY() - 1) {
                        enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint()-
                                player.getCardsInTheFiled().get(card1ID).getAttackPower());
                        player.getCardsInTheFiled().get(card1ID).setHaveBeenUsedTrue();
                        attachBack(player.getCardsInTheFiled().get(card1ID), enemyPlayer.getCardsInTheFiled().get(card2ID));
                    }else
                        System.out.println("opponent minion is unavailable for attack");
                }else if (distance <= player.getCardsInTheFiled().get(card1ID).getRangeOfAttack()){
                    enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint()-
                            player.getCardsInTheFiled().get(card1ID).getAttackPower());
                    player.getCardsInTheFiled().get(card1ID).setHaveBeenUsedTrue();
                    attachBack(player.getCardsInTheFiled().get(card1ID),enemyPlayer.getCardsInTheFiled().get(card2ID));
                }else
                    System.out.println("opponent minion is unavailable for attack");
            }else if (command.indexOf("Attack combo") != -1){
                int mainCardID = 0;
                String split[] = command.split(" ");
                int checkForError = 0;
                    enemyId = Integer.parseInt(split[2]);
                    int card2Exist = 0;
                    for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size();i++){
                        if (enemyPlayer.getCardsInTheFiled().get(i).getId() == enemyId){
                            card2Exist = 1;
                            card2ID = i;
                        }
                    }
                    if (card2Exist == 0){
                        checkForError = 1;
                    }
                    for (int i = 3; i < split.length-1; i++){
                        IDNumber1 = Integer.parseInt(split[i]);
                        int cardExist = 0;
                        for (int j = 0; j < player.getCardsInTheFiled().size();j++){
                            if (player.getCardsInTheFiled().get(j).getId() == IDNumber1 && player.getCardsInTheFiled().get(j)
                            .getActivationTime().matches("combo")){
                                if (i == 3){
                                    mainCardID = j;
                                }
                                cardExist = 1;
                            }
                        }
                        if (cardExist == 0){
                            checkForError =1;
                            break;
                        }
                    }
                    if (checkForError == 0){
                        for (int i = 3; i < split.length-1; i++) {
                            IDNumber1 = Integer.parseInt(split[i]);
                            for (int j = 0; j < player.getCardsInTheFiled().size(); j++) {
                                if (player.getCardsInTheFiled().get(j).getId() == IDNumber1 ) {
                                    card1ID = j;
                                }
                                enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint()
                                -player.getCardsInTheFiled().get(card1ID).getAttackPower());
                            }
                        }
                        attachBack(player.getCardsInTheFiled().get(card1ID),enemyPlayer.getCardsInTheFiled().get(card2ID));
                    }else {
                        enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint()
                                -player.getCardsInTheFiled().get(mainCardID).getAttackPower());
                        attachBack(player.getCardsInTheFiled().get(mainCardID),enemyPlayer.getCardsInTheFiled().get(card2ID));
                    }
            }else if (command.matches("Use special power")){
                int x = command.charAt(19)-48;
                int y = command.charAt(21)-48;
                int isValidSpecialPower = 0;
                for (int i = 0; i < Cell.getCells().size(); i++){
                    if (Cell.getCells().get(i).getX() == x && Cell.getCells().get(i).getY() == y){
                        isValidSpecialPower = 1;
                        card1ID = i;
                    }
                }
                if (isValidSpecialPower == 0){
                    System.out.println("Invalid card");
                }else if (Cell.getCells().get(card1ID).getInsideCard().getManaPoint() >= player.getMana()){
                    System.out.println("invalid mana point");
                }else {
                    if (Cell.getCells().get(card1ID).getInsideCard().getId() > 0 && Cell.getCells().get(card1ID).getInsideCard().getId() <= 40){
                        if (Cell.getCells().get(card1ID).getInsideCard().getId() == 1 || Cell.getCells().get(card1ID).getInsideCard().getId() == 3 ||
                                Cell.getCells().get(card1ID).getInsideCard().getId() == 4 || Cell.getCells().get(card1ID).getInsideCard().getId() == 7 ||
                                Cell.getCells().get(card1ID).getInsideCard().getId() == 8 || Cell.getCells().get(card1ID).getInsideCard().getId() == 9 ||
                                Cell.getCells().get(card1ID).getInsideCard().getId() == 6 || Cell.getCells().get(card1ID).getInsideCard().getId() == 12 ||
                                Cell.getCells().get(card1ID).getInsideCard().getId() == 13 || Cell.getCells().get(card1ID).getInsideCard().getId() == 14 ||
                                Cell.getCells().get(card1ID).getInsideCard().getId() == 16 || Cell.getCells().get(card1ID).getInsideCard().getId() == 20 ||
                                Cell.getCells().get(card1ID).getInsideCard().getId() == 33 || Cell.getCells().get(card1ID).getInsideCard().getId() == 34 ||
                                Cell.getCells().get(card1ID).getInsideCard().getId() == 39 || Cell.getCells().get(card1ID).getInsideCard().getId() == 40 ||){
                            System.out.println("Minion dosn't have specia; power");
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 2){
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setStunByMinion5True();
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 5){
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled()
                            .get(card2ID).getHealthPoint()-(5*enemyPlayer.getCardsInTheFiled().get(card2ID).getMinion5Counter());
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 10){
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setDisarmFor1TurnTrue();
                            Cell.getCells().get(card1ID).getInsideCard().setCounterMinion10(enemyPlayer.getCardsInTheFiled().get(card2ID));
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 15){
                            Minion temp = (Minion)Cell.getCells().get(card1ID).getInsideCard();
                            temp.minion15Power();
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 17){
                            Minion temp = (Minion)Cell.getCells().get(card1ID).getInsideCard();
                            if (Cell.getCells().get(card1ID).getInsideCard().getHealthPoint() <= 0){
                                temp.minion17Power();
                            }
                        }else if ((Cell.getCells().get(card1ID).getInsideCard().getId() == 18)){
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setDisarmFor1TurnTrue();
                            Cell.getCells().get(card1ID).getInsideCard().setCounterMinion18(enemyPlayer.getCardsInTheFiled().get(card2ID));
                            //20 monde
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 21){
                            Minion temp = (Minion)Cell.getCells().get(card1ID).getInsideCard();
                            temp.minionPower21(temp);
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 25){
                            Minion temp = (Minion)Cell.getCells().get(card1ID).getInsideCard();
                            temp.useMinion25Power(temp);
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 26){
                            Minion temp = (Minion)Cell.getCells().get(card1ID).getInsideCard();
                            //monde inam
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 27){
                            for (int i = 0; i < player.getCardsInTheFiled().size();i++) {
                                Minion temp = (Minion)player.getCardsInTheFiled().get(i);
                                temp.minion27Power(temp);
                            }
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 31){
                            //monde
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 35){
                            Minion temp = (Minion)enemyPlayer.getCardsInTheFiled().get(card2ID);
                            temp.minion35Power(temp);
                        }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 36){
                            for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++){
                                if (enemyPlayer.getCardsInTheFiled().get(i).getX() >= player.getCardsInTheFiled().get(card1ID)
                                        .getX() - 1 && enemyPlayer.getCardsInTheFiled().get(i).getX() <= player.getCardsInTheFiled()
                                        .get(card1ID).getX() + 1 && player.getCardsInTheFiled().get(card1ID).getY() == enemyPlayer
                                        .getCardsInTheFiled().get(i).getY() || enemyPlayer.getCardsInTheFiled().get(i).getY()
                                        >= player.getCardsInTheFiled().get(card1ID).getY() - 1 && enemyPlayer.getCardsInTheFiled()
                                        .get(i).getY() <= player.getCardsInTheFiled().get(card1ID).getY() + 1 && enemyPlayer.getCardsInTheFiled()
                                        .get(i).getX() == player.getCardsInTheFiled().get(card1ID).getY() || enemyPlayer.
                                        getCardsInTheFiled().get(i).getY() == player.getCardsInTheFiled().get(card1ID).getY()
                                        + 1 && enemyPlayer.getCardsInTheFiled().get(i).getX() == player.getCardsInTheFiled().
                                        get(card1ID).getX() + 1 || enemyPlayer.getCardsInTheFiled().get(i).getX() == player.
                                        getCardsInTheFiled().get(card1ID).getX() + 1 && enemyPlayer.getCardsInTheFiled().get(i).getY()
                                        == player.getCardsInTheFiled().get(card1ID).getY() - 1 || enemyPlayer.getCardsInTheFiled()
                                        .get(i).getX() == player.getCardsInTheFiled().get(card1ID).getX() - 1 && player.getCardsInTheFiled()
                                        .get(card1ID).getY() == player.getCardsInTheFiled().get(card1ID).getY() + 1 || enemyPlayer.
                                        getCardsInTheFiled().get(i).getX() == player.getCardsInTheFiled().get(card1ID).getX() - 1
                                        && enemyPlayer.getCardsInTheFiled().get(i).getY() == player.getCardsInTheFiled().get(card1ID).getY() - 1) {
                                    enemyPlayer.getCardsInTheFiled().get(i).setStunByMinion5True();
                                }
                                }
                            }else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 37){
                            //baghiasho nemidonam
                        }
                    }
                }
            }else if (command.indexOf("Insert") != -1){
                int inValidCard = 0;
                String split[] = command.split(" ");
                int x = split[3].charAt(1)-48;
                int y = split[3].charAt(3)-48;
                for (int i = 0; i < player.getHand().getCardsInThisHand().size();i++){
                    if (player.getHand().getCardsInThisHand().get(i).getName().matches(split[1])){
                        inValidCard = 1;
                        card1ID = i;
                    }
                }
                if (inValidCard == 0){
                    System.out.println("Invalid card name");
                }
                else {
                    inValidCard = 0;
                    for (int i = 0; i < player.getCardsInTheFiled().size(); i++) {
                        int distance = getDistance(player.getCardsInTheFiled().get(i).getX(), x, player.getCardsInTheFiled().get(i).getY(), y);
                        if (distance == 1) {
                            inValidCard = 1;
                        }
                    }
                    if (inValidCard == 0) {
                        System.out.println("Invalid target");
                    }else {
                        if (player.getMana() <= player.getHand().getCardsInThisHand().get(card1ID).getManaPoint()){
                            System.out.println("You don't have enough mana");
                        }else {
                            //rajeb spellas

                        }
                    }
                }
            }
        }

    }
}

