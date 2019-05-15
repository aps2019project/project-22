package Model;

import View.Show;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private static ArrayList<Battle> savedBattles = new ArrayList<>();
    protected Player player1;
    private int player1Turns = 0;
    private int player2Turn = 0;
    protected Player player2;
    protected int howManyFlags = 0;
    protected int mode;
    protected boolean endGame = false;
    private boolean singlePlayer = false;
    private boolean turn = false;

    public int getHowManyFlags() {
        return howManyFlags;
    }

    public void setHowManyFlags(int howManyFlags) {
        this.howManyFlags = howManyFlags;
    }

    public int getPlayer1Turns() {
        return player1Turns;
    }

    public int getPlayer2Turn() {
        return player2Turn;
    }

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
        if (card2.getDisarmFor1Turn() == false) {
            int attackPower = 0;
            if (card1.getHowManyHolyBuff() > card2.getAttackPower()) {
                card1.setHowManyHolyBuff(card1.getHowManyHolyBuff() - card2.getAttackPower());
            } else {
                attackPower = card2.getAttackPower() - card1.getHowManyHolyBuff();
                card1.setHowManyHolyBuff(0);
            }
            if (card2.getTypeOfAttack().matches("melee") || card2.getId() == 28) {
                if (card1.getX() >= card2.getX() - 1 && card1.getX() <= card2.getX() + 1 && card2.getY() == card1.getY() ||
                        card1.getY() >= card2.getY() - 1 && card1.getY() <= card2.getY() + 1 && card1.getX() == card2.getY() ||
                        card1.getY() == card2.getY() + 1 && card1.getX() == card2.getX() + 1 || card1.getX() == card2.getX() + 1 && card1.getY()
                        == card2.getY() - 1 || card1.getX() == card2.getX() - 1 && card2.getY() == card2.getY() + 1 || card1.getX() == card2.getX() - 1
                        && card1.getY() == card2.getY() - 1) {
                    card1.setHealthPoint(card1.getHealthPoint() - attackPower);
                }
            } else if (card2.getTypeOfAttack().matches("ranged")) {
                if (!(card1.getX() >= card2.getX() - 1 && card1.getX() <= card2.getX() + 1 && card2.getY() == card1.getY() ||
                        card1.getY() >= card2.getY() - 1 && card1.getY() <= card2.getY() + 1 && card1.getX() == card2.getY() ||
                        card1.getY() == card2.getY() + 1 && card1.getX() == card2.getX() + 1 || card1.getX() == card2.getX() + 1 && card1.getY()
                        == card2.getY() - 1 || card1.getX() == card2.getX() - 1 && card2.getY() == card2.getY() + 1 || card1.getX() == card2.getX() - 1
                        && card1.getY() == card2.getY() - 1)) {
                    card1.setHealthPoint(card1.getHealthPoint() - attackPower);
                }
            } else if (card2.getTypeOfAttack().matches("hybrid")) {
                card1.setHealthPoint(card1.getHealthPoint() - attackPower);
            }
        }
    }

    public int getDistance(int x1, int x2, int y1, int y2) {
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }

    public void fight(Scanner scanner) {
        int isValid = 1;
        int card1ID = 0;
        int card2ID = 0;
        int validID = 0;
        int enemyId = 0;
        int IDNumber1 = 0;
        int itemIDNumber = 0;
        String command = "";
        Player player = new Player();
        Player enemyPlayer = new Player();
        if (mode == 3) {
            for (int i = 0; i < howManyFlags; i++) {
                int inVvalid = 0;
                Random rand = new Random();
                int x = rand.nextInt(9) + 1;
                int y = rand.nextInt(5) + 1;
                for (int j = 0; j < Cell.getCells().size(); j++) {
                    if (Cell.getCells().get(j).getX() == x && Cell.getCells().get(j).getY() == y && Cell.getCells().get(j).getFlag() == false) {
                        inVvalid = 1;
                        Cell.getCells().get(j).setFlagTrue();
                    }
                }
                if (inVvalid == 0)
                    i--;
            }
        } else if (mode == 2) {
            Random rand = new Random();
            int x = rand.nextInt(9) + 1;
            int y = rand.nextInt(5) + 1;
            for (int j = 0; j < Cell.getCells().size(); j++) {
                if (Cell.getCells().get(j).getX() == x && Cell.getCells().get(j).getY() == y && Cell.getCells().get(j).getFlag() == false) {
                    Cell.getCells().get(j).setFlagTrue();
                }
            }
        }
        while (!endGame) {
            if (!turn) {
                player = player1;
                player1Turns++;
                enemyPlayer = player2;
            } else {
                player = player2;
                player2Turn++;
                enemyPlayer = player1;
            }
            if (player.getItem8()) {
                player.setMana(player.getMana() + 3);
                player.setItem8False();
            }
            if (enemyPlayer.getItem8()) {
                enemyPlayer.setMana(enemyPlayer.getMana() + 3);
                enemyPlayer.setItem8False();
            }
            Item tempItem = new Item(71, "taje danaii", 300, "increase one unit mana in 3 turns ");
            for (int i = 0; i < player.getCollectibleItems().size(); i++) {
                if (player.getCollectibleItems().get(i).getId() == 74) {
                    tempItem.item4(player);
                } else if (player.getCollectibleItems().get(i).getId() == 75) {
                    tempItem.item5(player);
                } else if (player.getCollectibleItems().get(i).getId() == 77) {
                    tempItem.item7(player);
                } else if (player.getCollectibleItems().get(i).getId() == 78) {
                    player.setItem8True();
                } else if (player.getCollectibleItems().get(i).getId() == 79) {
                    tempItem.item9(player);
                } else if (player.getCollectibleItems().get(i).getId() == 80) {
                    tempItem.item10(player);
                } else if (player.getCollectibleItems().get(i).getId() == 81) {
                    tempItem.item11(player);
                } else if (player.getCollectibleItems().get(i).getId() == 83) {
                    tempItem.item13(player);
                } else if (player.getCollectibleItems().get(i).getId() == 90) {
                    tempItem.item20(player);
                }
            }
            if (player.getMainDeck().getItem().getId() == 1) {
                if (player == player1)
                    tempItem.item1(player1Turns, player1);
                else
                    tempItem.item1(player2Turn, player2);
            } else if (player.getMainDeck().getItem().getId() == 72) {
                tempItem.item2(player.getHero());
            } else if (player.getMainDeck().getItem().getId() == 76) {
                tempItem.item6(enemyPlayer.getHero());
            } else if (player.getMainDeck().getItem().getId() == 84) {
                tempItem.item14(player);
            }
            for (int i = 0; i < player.getCardsInTheFiled().size(); i++) {
                if (player.getCardsInTheFiled().get(i).getItem12()) {
                    player.getCardsInTheFiled().get(i).setAttackPower(player.getCardsInTheFiled().get(i).getAttackPower() + 2);
                    player.getCardsInTheFiled().get(i).setItem12False();
                }
                if (player.getCardsInTheFiled().get(i).getCounterMinion10() != 0) {
                    player.getCardsInTheFiled().get(i).setCounterMinion10(player.getCardsInTheFiled().get(i));
                }
                if (player.getCardsInTheFiled().get(i).getCounterMinion18() != 0) {
                    player.getCardsInTheFiled().get(i).setCounterMinion18(player.getCardsInTheFiled().get(i));
                }
                if (player.getCardsInTheFiled().get(i).getHero65Power() != 0) {
                    player.getCardsInTheFiled().get(i).setCounterHero65(player.getCardsInTheFiled().get(i));
                }
                if (player.getCardsInTheFiled().get(i).getId() == 15) {
                    Minion temp = (Minion) player.getCardsInTheFiled().get(i);
                    temp.minion15Power();
                } else if (player.getCardsInTheFiled().get(i).getId() == 25) {
                    for (int j = 0; j < player.getCardsInTheFiled().size(); j++) {
                        if (player.getCardsInTheFiled().get(i).getX() + 1 >= player.getCardsInTheFiled().get(j).getX() &&
                                player.getCardsInTheFiled().get(i).getX() - 1 <= player.getCardsInTheFiled().get(j).getX() &&
                                player.getCardsInTheFiled().get(i).getY() == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getY() + 1 >= player.getCardsInTheFiled().get(j).getY() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 <= player.getCardsInTheFiled().get(j).getY() &&
                                        player.getCardsInTheFiled().get(i).getX() == player.getCardsInTheFiled().get(j).getX() ||
                                player.getCardsInTheFiled().get(i).getX() + 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() + 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() - 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() + 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() + 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() - 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 == player.getCardsInTheFiled().get(j).getY()) {
                            if (player.getCardsInTheFiled().get(j).getId() > 0 && player.getCardsInTheFiled().get(j).getId() <= 40) {
                                player.getCardsInTheFiled().get(j).setHealthPoint(player.getCardsInTheFiled().get(j).getHealthPoint() - 1);
                                player.getCardsInTheFiled().get(j).setAttackPower(player.getCardsInTheFiled().get(j).getAttackPower() + 2);
                                player.getCardsInTheFiled().get(j).setTempAttackPower(player.getCardsInTheFiled().get(j).getTempAttackPower() + 2);
                                player.getCardsInTheFiled().get(j).setTempHealtPoint(player.getCardsInTheFiled().get(j).getTempHealtPoint() - 1);
                            }

                        }
                    }
                } else if (player.getCardsInTheFiled().get(i).getId() == 26) {
                    for (int j = 0; j < player.getCardsInTheFiled().size(); j++) {
                        if (player.getCardsInTheFiled().get(i).getX() + 1 >= player.getCardsInTheFiled().get(j).getX() &&
                                player.getCardsInTheFiled().get(i).getX() - 1 <= player.getCardsInTheFiled().get(j).getX() &&
                                player.getCardsInTheFiled().get(i).getY() == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getY() + 1 >= player.getCardsInTheFiled().get(j).getY() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 <= player.getCardsInTheFiled().get(j).getY() &&
                                        player.getCardsInTheFiled().get(i).getX() == player.getCardsInTheFiled().get(j).getX() ||
                                player.getCardsInTheFiled().get(i).getX() + 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() + 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() - 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() + 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() + 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() - 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 == player.getCardsInTheFiled().get(j).getY()) {
                            if (player.getCardsInTheFiled().get(j).getId() > 0 && player.getCardsInTheFiled().get(j).getId() <= 40) {
                                player.getCardsInTheFiled().get(j).setHowManyHolyBuff(player.getCardsInTheFiled().get(j).getHowManyHolyBuff() + 1);
                                player.getCardsInTheFiled().get(j).setAttackPower(player.getCardsInTheFiled().get(j).getAttackPower() + 2);
                            }
                        }
                    }
                } else if (player.getCardsInTheFiled().get(i).getId() == 27) {
                    for (int j = 0; j < player.getCardsInTheFiled().size(); j++) {
                        if (player.getCardsInTheFiled().get(j).getId() > 0 && player.getCardsInTheFiled().get(j).getId() <= 40) {
                            player.getCardsInTheFiled().get(j).setAttackPower(player.getCardsInTheFiled().get(j).getAttackPower() + 1);
                        }
                    }
                } else if (player.getCardsInTheFiled().get(i).getId() == 37) {
                    player.getCardsInTheFiled().get(i).setHowManyHolyBuff(player.getCardsInTheFiled().get(i).getHowManyHolyBuff() + 12);
                }
            }
            player = enemyPlayer;
            for (int i = 0; i < player.getCollectibleItems().size(); i++) {
                if (player.getCollectibleItems().get(i).getId() == 74) {
                    tempItem.item4(player);
                } else if (player.getCollectibleItems().get(i).getId() == 75) {
                    tempItem.item5(player);
                } else if (player.getCollectibleItems().get(i).getId() == 77) {
                    tempItem.item7(player);
                } else if (player.getCollectibleItems().get(i).getId() == 78) {
                    player.setItem8True();
                } else if (player.getCollectibleItems().get(i).getId() == 79) {
                    tempItem.item9(player);
                } else if (player.getCollectibleItems().get(i).getId() == 80) {
                    tempItem.item10(player);
                } else if (player.getCollectibleItems().get(i).getId() == 81) {
                    tempItem.item11(player);
                } else if (player.getCollectibleItems().get(i).getId() == 83) {
                    tempItem.item13(player);
                } else if (player.getCollectibleItems().get(i).getId() == 90) {
                    tempItem.item20(player);
                }
            }
            if (player.getMainDeck().getItem().getId() == 1) {
                if (player == player1)
                    tempItem.item1(player1Turns, player1);
                else
                    tempItem.item1(player2Turn, player2);
            } else if (player.getMainDeck().getItem().getId() == 72) {
                tempItem.item2(player.getHero());
            } else if (player.getMainDeck().getItem().getId() == 76) {
                tempItem.item6(enemyPlayer.getHero());
            } else if (player.getMainDeck().getItem().getId() == 84) {
                tempItem.item14(player);
            }
            for (int i = 0; i < player.getCardsInTheFiled().size(); i++) {
                if (player.getCardsInTheFiled().get(i).getItem12()) {
                    player.getCardsInTheFiled().get(i).setAttackPower(player.getCardsInTheFiled().get(i).getAttackPower() + 2);
                    player.getCardsInTheFiled().get(i).setItem12False();
                }
                if (player.getCardsInTheFiled().get(i).getCounterMinion10() != 0) {
                    player.getCardsInTheFiled().get(i).setCounterMinion10(player.getCardsInTheFiled().get(i));
                }
                if (player.getCardsInTheFiled().get(i).getCounterMinion18() != 0) {
                    player.getCardsInTheFiled().get(i).setCounterMinion18(player.getCardsInTheFiled().get(i));
                }
                if (player.getCardsInTheFiled().get(i).getHero65Power() != 0) {
                    player.getCardsInTheFiled().get(i).setCounterHero65(player.getCardsInTheFiled().get(i));
                }
                if (player.getCardsInTheFiled().get(i).getId() == 15) {
                    Minion temp = (Minion) player.getCardsInTheFiled().get(i);
                    temp.minion15Power();
                } else if (player.getCardsInTheFiled().get(i).getId() == 25) {
                    for (int j = 0; j < player.getCardsInTheFiled().size(); j++) {
                        if (player.getCardsInTheFiled().get(i).getX() + 1 >= player.getCardsInTheFiled().get(j).getX() &&
                                player.getCardsInTheFiled().get(i).getX() - 1 <= player.getCardsInTheFiled().get(j).getX() &&
                                player.getCardsInTheFiled().get(i).getY() == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getY() + 1 >= player.getCardsInTheFiled().get(j).getY() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 <= player.getCardsInTheFiled().get(j).getY() &&
                                        player.getCardsInTheFiled().get(i).getX() == player.getCardsInTheFiled().get(j).getX() ||
                                player.getCardsInTheFiled().get(i).getX() + 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() + 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() - 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() + 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() + 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() - 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 == player.getCardsInTheFiled().get(j).getY()) {
                            if (player.getCardsInTheFiled().get(j).getId() > 0 && player.getCardsInTheFiled().get(j).getId() <= 40) {
                                player.getCardsInTheFiled().get(j).setHealthPoint(player.getCardsInTheFiled().get(j).getHealthPoint() - 1);
                                player.getCardsInTheFiled().get(j).setAttackPower(player.getCardsInTheFiled().get(j).getAttackPower() + 2);
                                player.getCardsInTheFiled().get(j).setTempAttackPower(player.getCardsInTheFiled().get(j).getTempAttackPower() + 2);
                                player.getCardsInTheFiled().get(j).setTempHealtPoint(player.getCardsInTheFiled().get(j).getTempHealtPoint() - 1);
                            }

                        }
                    }
                } else if (player.getCardsInTheFiled().get(i).getId() == 26) {
                    for (int j = 0; j < player.getCardsInTheFiled().size(); j++) {
                        if (player.getCardsInTheFiled().get(i).getX() + 1 >= player.getCardsInTheFiled().get(j).getX() &&
                                player.getCardsInTheFiled().get(i).getX() - 1 <= player.getCardsInTheFiled().get(j).getX() &&
                                player.getCardsInTheFiled().get(i).getY() == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getY() + 1 >= player.getCardsInTheFiled().get(j).getY() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 <= player.getCardsInTheFiled().get(j).getY() &&
                                        player.getCardsInTheFiled().get(i).getX() == player.getCardsInTheFiled().get(j).getX() ||
                                player.getCardsInTheFiled().get(i).getX() + 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() + 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() - 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() + 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() + 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 == player.getCardsInTheFiled().get(j).getY() ||
                                player.getCardsInTheFiled().get(i).getX() - 1 == player.getCardsInTheFiled().get(j).getX() &&
                                        player.getCardsInTheFiled().get(i).getY() - 1 == player.getCardsInTheFiled().get(j).getY()) {
                            if (player.getCardsInTheFiled().get(j).getId() > 0 && player.getCardsInTheFiled().get(j).getId() <= 40) {
                                player.getCardsInTheFiled().get(j).setHowManyHolyBuff(player.getCardsInTheFiled().get(j).getHowManyHolyBuff() + 1);
                                player.getCardsInTheFiled().get(j).setAttackPower(player.getCardsInTheFiled().get(j).getAttackPower() + 2);
                            }
                        }
                    }
                } else if (player.getCardsInTheFiled().get(i).getId() == 37) {
                    player.getCardsInTheFiled().get(i).setHowManyHolyBuff(player.getCardsInTheFiled().get(i).getHowManyHolyBuff() + 12);
                }
            }
            if (!turn) {
                player = player1;
                enemyPlayer = player2;
            } else {
                player = player2;
                enemyPlayer = player1;
            }
            if (player1Turns == 2) {
                player.setMana(4);
            } else if (player1Turns == 3) {
                player.setMana(5);
            } else if (player1Turns == 4) {
                player.setMana(6);
            } else if (player1Turns == 5) {
                player.setMana(7);
            } else if (player1Turns == 6) {
                player.setMana(8);
            } else if (player1Turns == 7) {
                player.setMana(9);
            } else if (player1Turns >= 8) {
                player.setMana(9);
            }
            if (player.getFlag()) {
                player.setHowLongFlagsHasBeenKept(player.getHowLongFlagsHasBeenKept() + 1);
            } else if (enemyPlayer.getFlag()) {
                enemyPlayer.setHowLongFlagsHasBeenKept(enemyPlayer.getHowLongFlagsHasBeenKept() + 1);
            }
            int counter = -1;
            Random rand10 = new Random();
            int randomForCommand = rand10.nextInt(player2.getCardsInTheFiled().size());
            while (true) {
                counter++;
                if (singlePlayer == false || player == player1)
                    command = scanner.nextLine();
                else {
                    if (counter == 0) {
                        command = "Select " + player2.getCardsInTheFiled().get(randomForCommand).getId();
                    } else if (counter == 1) {
                        Random rand2 = new Random();
                        int x = rand2.nextInt(5) + 1;
                        Random rand3 = new Random();
                        int y = rand3.nextInt(9) + 1;
                        command = "Move to(" + x + "" + y + ")";
                    } else if (counter == 2) {
                        Random rand2 = new Random();
                        int enemy = rand2.nextInt(player1.getCardsInTheFiled().size());
                        if (player2.getCardsInTheFiled().get(randomForCommand).getActivationTime().matches("combo")) {
                            command = "Attack combo " + enemy + " ";
                            for (int i = 0; i < player2.getCardsInTheFiled().size(); i++) {
                                if (player2.getCardsInTheFiled().get(i).getActivationTime().matches("combo") &&
                                        player2.getCardsInTheFiled().get(i).getId() != player2.getCardsInTheFiled().get(randomForCommand).getId()) {
                                    command = command + player2.getCardsInTheFiled().get(i).getId() + " ";
                                }
                            }
                        } else
                            command = "Attack " + enemy;
                    } else if (counter == 3) {
                        Random rand2 = new Random();
                        int x = rand2.nextInt(5) + 1;
                        Random rand3 = new Random();
                        int y = rand3.nextInt(9) + 1;
                        command = "Use special power (" + x + "" + "y";
                    } else if (counter == 4) {
                        Random rand4 = new Random();
                        int interCard = rand4.nextInt(player2.getHand().getCardsInThisHand().size());
                        Random rand2 = new Random();
                        int x = rand2.nextInt(5) + 1;
                        Random rand3 = new Random();
                        int y = rand3.nextInt(9) + 1;
                        command = "Insert " + player2.getHand().getCardsInThisHand().get(interCard).getName() + " " + x + "," + y;
                    } else if (counter == 5) {
                        command = "End Turn";
                    }
                }


                if (command.indexOf("Select") != -1) {
                    String split[] = command.split("\\[");
                    String split2[] = split[1].split("]");
                    IDNumber1 = Integer.parseInt(split2[0]);
                    for (int i = 0; i < player.getCardsInTheFiled().size(); i++) {
                        if (IDNumber1 == player.getCardsInTheFiled().get(i).getId() && player.getCardsInTheFiled().get(i).getStunByMinion5() == false) {
                            validID = 1;
                            card1ID = i;
                            break;
                        }
                    }
                    for (int i = 0; i < player.getCollectibleItems().size(); i++) {
                        if (player.getCollectibleItems().get(i).getId() == IDNumber1) {
                            validID = 1;
                            itemIDNumber = i;
                        }
                    }
                    if (validID == 0) {
                        System.out.println("Invalid card id");
                    }
                } else if (command.indexOf("Move to") != -1) {
                    int x = command.charAt(9) - 48;
                    int y = command.charAt(11) - 48;
                    int valid = 0;
                    int distance = getDistance(player.getCardsInTheFiled().get(card1ID).getX(), x, player.getCardsInTheFiled().get(card1ID).getY(), y);
                    for (int i = 0; i < Cell.getCells().size(); i++) {
                        if (Cell.getCells().get(i).getX() == x && Cell.getCells().get(i).getY() == y && Cell.getCells().get(i).getInsideCard() == null) {
                            valid = 1;
                            if (Cell.getCells().get(i).getFlag()) {
                                player.getCardsInTheFiled().get(card1ID).setFlagTrue();
                                player.setFlagTrue();
                                Cell.getCells().get(i).setFlagFalse();

                                if (mode == 2) {
                                    player.setHowLongFlagsHasBeenKept(1);
                                } else if (mode == 3) {
                                    player.setHowManyFlag(player.getHowManyFlag() + 1);
                                }

                            }
                        }
                    }

                    if (distance <= 2 && valid == 1) {
                        player.getCardsInTheFiled().get(card1ID).setX(x);
                        player.getCardsInTheFiled().get(card1ID).setY(y);
                        System.out.println(IDNumber1 + " moved to " + x + " " + y);
                        player.getCardsInTheFiled().get(card1ID).setHaveBeenMovedTrue();
                    } else
                        System.out.println("Invalid target");
                } else if (command.indexOf("Attack") != -1) {

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

                    if (validID == 0) {
                        System.out.println("Invalid card id");
                    }
                    if (player.getMainDeck().getItem().getId() == 73 && player.getCardsInTheFiled().get(card1ID) == player.getHero()
                            && player.getHero().getTypeOfAttack().matches("ranged") || player.getHero().getTypeOfAttack().matches("hybrid")) {
                        enemyPlayer.getCardsInTheFiled().get(card2ID).setDisarmFor1TurnTrue();
                    }
                    if (player.getMainDeck().getItem().getId() == 82) {
                        Random rand = new Random();
                        int n = rand.nextInt(enemyPlayer.getCardsInTheFiled().size());
                        enemyPlayer.getCardsInTheFiled().get(n).setAttackPower(enemyPlayer.getCardsInTheFiled().get(n).getAttackPower() - 2);
                        enemyPlayer.getCardsInTheFiled().get(n).setItem12True();
                    } else if (player.getMainDeck().getItem().getId() == 87) {
                        enemyPlayer.getCardsInTheFiled().get(card2ID).setDisarmFor1TurnTrue();
                    } else if (player.getMainDeck().getItem().getId() == 86) {
                        Random rand = new Random();
                        int n = rand.nextInt(enemyPlayer.getCardsInTheFiled().size());
                        enemyPlayer.getCardsInTheFiled().get(n).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(n).getHealthPoint() - 1);
                    }

                    if (player.getCardsInTheFiled().get(card1ID).getId() > 0 && player.getCardsInTheFiled().get(card1ID).getId() <= 40) {
                        int attackPower = 0;
                        if (enemyPlayer.getCardsInTheFiled().get(card2ID).getHowManyHolyBuff() > player.getCardsInTheFiled().get(card1ID).getAttackPower()) {
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setHowManyHolyBuff(enemyPlayer.getCardsInTheFiled().get(card2ID).getHowManyHolyBuff() -
                                    player.getCardsInTheFiled().get(card1ID).getAttackPower());
                        } else {
                            attackPower = player.getCardsInTheFiled().get(card1ID).getAttackPower() - enemyPlayer.getCardsInTheFiled().get(card2ID).getHowManyHolyBuff();
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setHowManyHolyBuff(0);
                        }
                        if (player.getCardsInTheFiled().get(card1ID).getId() == 1 || player.getCardsInTheFiled().get(card1ID).getId() == 3 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 4 || player.getCardsInTheFiled().get(card1ID).getId() == 7 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 8 || player.getCardsInTheFiled().get(card1ID).getId() == 9 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 6 || player.getCardsInTheFiled().get(card1ID).getId() == 12 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 13 || player.getCardsInTheFiled().get(card1ID).getId() == 14 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 16 || player.getCardsInTheFiled().get(card1ID).getId() == 20 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 33 || player.getCardsInTheFiled().get(card1ID).getId() == 34 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 39 || player.getCardsInTheFiled().get(card1ID).getId() == 40 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 15 || player.getCardsInTheFiled().get(card1ID).getId() == 17 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 21 || player.getCardsInTheFiled().get(card1ID).getId() == 25 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 26 || player.getCardsInTheFiled().get(card1ID).getId() == 27 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 28 || player.getCardsInTheFiled().get(card1ID).getId() == 29 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 30 || player.getCardsInTheFiled().get(card1ID).getId() == 31 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 36 || player.getCardsInTheFiled().get(card1ID).getId() == 37 ||
                                player.getCardsInTheFiled().get(card1ID).getId() == 38) {
                        } else if (player.getCardsInTheFiled().get(card1ID).getId() == 2) {

                            enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint() -
                                    player.getCardsInTheFiled().get(card1ID).getAttackPower());
                            player.getCardsInTheFiled().get(card1ID).setHaveBeenUsedTrue();
                        } else if (player.getCardsInTheFiled().get(card1ID).getId() == 5) {
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled()
                                    .get(card2ID).getHealthPoint() - player.getCardsInTheFiled().get(card1ID).getAttackPower() -
                                    (5 * enemyPlayer.getCardsInTheFiled().get(card2ID).getMinion5Counter()));
                            enemyPlayer.getCardsInTheFiled().get(card2ID).addMinion5Counter();
                            player.getCardsInTheFiled().get(card1ID).setHaveBeenUsedTrue();
                            attachBack(player.getCardsInTheFiled().get(card1ID), enemyPlayer.getCardsInTheFiled().get(card2ID));
                        } else if (player.getCardsInTheFiled().get(card1ID).getId() == 10) {
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setDisarmFor1TurnTrue();
                            player.getCardsInTheFiled().get(card1ID).setCounterMinion10(enemyPlayer.getCardsInTheFiled().get(card2ID));
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint() -
                                    player.getCardsInTheFiled().get(card1ID).getAttackPower());
                            player.getCardsInTheFiled().get(card1ID).setHaveBeenUsedTrue();
                            attachBack(player.getCardsInTheFiled().get(card1ID), enemyPlayer.getCardsInTheFiled().get(card2ID));

                        } else if (player.getCardsInTheFiled().get(card1ID).getId() == 18) {
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setDisarmFor1TurnTrue();
                            player.getCardsInTheFiled().get(card1ID).setCounterMinion18(enemyPlayer.getCardsInTheFiled().get(card2ID));
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint() -
                                    player.getCardsInTheFiled().get(card1ID).getAttackPower());
                            player.getCardsInTheFiled().get(card1ID).setHaveBeenUsedTrue();
                            attachBack(player.getCardsInTheFiled().get(card1ID), enemyPlayer.getCardsInTheFiled().get(card2ID));
                            //20 monde

                        } else if (player.getCardsInTheFiled().get(card1ID).getId() == 32) {
                            if (enemyPlayer.getCardsInTheFiled().get(card2ID).getAttackPower() < player.getCardsInTheFiled().get(card1ID).getAttackPower()) {
                                enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint() -
                                        player.getCardsInTheFiled().get(card1ID).getAttackPower());
                                player.getCardsInTheFiled().get(card1ID).setHaveBeenUsedTrue();
                                attachBack(player.getCardsInTheFiled().get(card1ID), enemyPlayer.getCardsInTheFiled().get(card2ID));
                            }
                        } else if (player.getCardsInTheFiled().get(card1ID).getId() == 35) {
                            Minion temp = (Minion) enemyPlayer.getCardsInTheFiled().get(card2ID);
                            temp.minion35Power(temp);
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint() -
                                    player.getCardsInTheFiled().get(card1ID).getAttackPower());
                            player.getCardsInTheFiled().get(card1ID).setHaveBeenUsedTrue();
                            attachBack(player.getCardsInTheFiled().get(card1ID), enemyPlayer.getCardsInTheFiled().get(card2ID));
                        }
                        if (player.getCardsInTheFiled().get(card1ID).getHealthPoint() <= 0) {
                            if (player.getMainDeck().getItem().getId() == 89) {
                                for (int i = 0; i < player.getCardsInTheFiled().size(); i++) {
                                    player.getCardsInTheFiled().get(i).setAttackPower(player.getCardsInTheFiled().get(i).getAttackPower() + 1);
                                }
                            }
                            if (player.getCardsInTheFiled().get(card1ID).getFlag()) {
                                player.getCardsInTheFiled().get(card1ID).setFlagFalse();
                                player.setFlagFalse();
                                enemyPlayer.getCardsInTheFiled().get(card2ID).setFlagTrue();
                                if (mode == 2) {
                                    player.setHowLongFlagsHasBeenKept(0);
                                    enemyPlayer.setHowLongFlagsHasBeenKept(1);
                                } else if (mode == 3) {
                                    player.setHowManyFlag(player.getHowManyFlag() - 1);
                                    enemyPlayer.setHowManyFlag(enemyPlayer.getHowManyFlag() + 1);
                                }
                            }
                            if (player.getCardsInTheFiled().get(card1ID).getId() <= 40) {
                                Minion temp = (Minion) player.getCardsInTheFiled().get(card1ID);
                                if (temp.getItem10()) {
                                    Random rand = new Random();
                                    int n = rand.nextInt(enemyPlayer.getCardsInTheFiled().size());
                                    enemyPlayer.getCardsInTheFiled().get(n).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(n).getHealthPoint() -
                                            player.getCardsInTheFiled().get(card1ID).getAttackPower());
                                }
                            }
                            if (player.getCardsInTheFiled().get(card1ID).getId() == 17) {
                                Minion temp = (Minion) player.getCardsInTheFiled().get(card1ID);
                                temp.minion17Power();
                            } else if (player.getCardsInTheFiled().get(card1ID).getId() == 38) {
                                Minion temp = (Minion) player.getCardsInTheFiled().get(card1ID);
                                temp.minion38Power(enemyPlayer.getHero());
                            }
                            player.getCardsInTheFiled().remove(player.getCardsInTheFiled().get(card1ID));
                        }
                        if (enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint() <= 0) {
                            if (enemyPlayer.getMainDeck().getItem().getId() == 89) {
                                for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++) {
                                    enemyPlayer.getCardsInTheFiled().get(i).setAttackPower(enemyPlayer.getCardsInTheFiled().get(i).getAttackPower() + 1);
                                }
                            }
                            if (enemyPlayer.getCardsInTheFiled().get(card2ID).getFlag()) {
                                enemyPlayer.getCardsInTheFiled().get(card2ID).setFlagFalse();
                                enemyPlayer.setFlagFalse();
                                player.getCardsInTheFiled().get(card1ID).setFlagTrue();
                                if (mode == 2) {
                                    enemyPlayer.setHowLongFlagsHasBeenKept(0);
                                    player.setHowLongFlagsHasBeenKept(1);
                                } else if (mode == 3) {
                                    enemyPlayer.setHowManyFlag(enemyPlayer.getHowManyFlag() - 1);
                                    player.setHowManyFlag(player.getHowManyFlag() + 1);
                                }
                            }
                            if (player.getCardsInTheFiled().get(card1ID).getId() <= 40) {
                                Minion temp = (Minion) player.getCardsInTheFiled().get(card1ID);
                                if (temp.getItem10()) {
                                    Random rand = new Random();
                                    int n = rand.nextInt(enemyPlayer.getCardsInTheFiled().size());
                                    enemyPlayer.getCardsInTheFiled().get(n).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(n).getHealthPoint() -
                                            player.getCardsInTheFiled().get(card1ID).getAttackPower());
                                }
                            }
                            if (enemyPlayer.getCardsInTheFiled().get(card2ID).getId() == 17) {
                                Minion mnvfdjnvdfvndkfvnjkd = (Minion) enemyPlayer.getCardsInTheFiled().get(card2ID);
                                mnvfdjnvdfvndkfvnjkd.minion17Power();
                            } else if (enemyPlayer.getCardsInTheFiled().get(card2ID).getId() == 38) {
                                Minion temp = (Minion) player.getCardsInTheFiled().get(card2ID);
                                temp.minion38Power(player.getHero());
                            }
                            enemyPlayer.getCardsInTheFiled().remove(enemyPlayer.getCardsInTheFiled().get(card2ID));
                        }
                    } else if (player.getCardsInTheFiled().get(card1ID).getId() == 65) {
                        Hero temp = (Hero) player.getCardsInTheFiled().get(card1ID);
                        if (temp.gethero65Activated()) {
                            temp.setCounterHero65(enemyPlayer.getCardsInTheFiled().get(card2ID));
                        }
                        enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).
                                getHealthPoint() - player.getCardsInTheFiled().get(card1ID).getAttackPower());
                        attachBack(player.getCardsInTheFiled().get(card1ID), enemyPlayer.getCardsInTheFiled().get(card2ID));
                    } else {
                        enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).
                                getHealthPoint() - player.getCardsInTheFiled().get(card1ID).getAttackPower());
                        attachBack(player.getCardsInTheFiled().get(card1ID), enemyPlayer.getCardsInTheFiled().get(card2ID));
                    }


                    int distance = getDistance(player.getCardsInTheFiled().get(card1ID).getX(), enemyPlayer.getCardsInTheFiled().get(card2ID).getX()
                            , player.getCardsInTheFiled().get(card1ID).getY(), enemyPlayer.getCardsInTheFiled().get(card2ID).getY());
                    if (player.getCardsInTheFiled().get(card1ID).getStun() || player.getCardsInTheFiled().get(card1ID).getStunByMinion5()
                            || player.getCardsInTheFiled().get(card1ID).getHaveBeenUsed()) {
                        System.out.println("Card with " + IDNumber1 + " can't attack");
                    } else if (player.getCardsInTheFiled().get(card1ID).getRangeOfAttack() == -1) {
                        if (enemyPlayer.getCardsInTheFiled().get(card2ID).getX() >= player.getCardsInTheFiled().get(card1ID).getX() - 1 && enemyPlayer.getCardsInTheFiled().get(card2ID).getX() <= player.getCardsInTheFiled().get(card1ID).getX() + 1 && player.getCardsInTheFiled().get(card1ID).getY() == enemyPlayer.getCardsInTheFiled().get(card2ID).getY() ||
                                enemyPlayer.getCardsInTheFiled().get(card2ID).getY() >= player.getCardsInTheFiled().get(card1ID).getY() - 1 && enemyPlayer.getCardsInTheFiled().get(card2ID).getY() <= player.getCardsInTheFiled().get(card1ID).getY() + 1 && enemyPlayer.getCardsInTheFiled().get(card2ID).getX() == player.getCardsInTheFiled().get(card1ID).getY() ||
                                enemyPlayer.getCardsInTheFiled().get(card2ID).getY() == player.getCardsInTheFiled().get(card1ID).getY() + 1 && enemyPlayer.getCardsInTheFiled().get(card2ID).getX() == player.getCardsInTheFiled().get(card1ID).getX() + 1 || enemyPlayer.getCardsInTheFiled().get(card2ID).getX() == player.getCardsInTheFiled().get(card1ID).getX() + 1 && enemyPlayer.getCardsInTheFiled().get(card2ID).getY()
                                == player.getCardsInTheFiled().get(card1ID).getY() - 1 || enemyPlayer.getCardsInTheFiled().get(card2ID).getX() == player.getCardsInTheFiled().get(card1ID).getX() - 1 && player.getCardsInTheFiled().get(card1ID).getY() == player.getCardsInTheFiled().get(card1ID).getY() + 1 || enemyPlayer.getCardsInTheFiled().get(card2ID).getX() == player.getCardsInTheFiled().get(card1ID).getX() - 1
                                && enemyPlayer.getCardsInTheFiled().get(card2ID).getY() == player.getCardsInTheFiled().get(card1ID).getY() - 1) {
                            enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint() -
                                    player.getCardsInTheFiled().get(card1ID).getAttackPower());
                            player.getCardsInTheFiled().get(card1ID).setHaveBeenUsedTrue();
                            attachBack(player.getCardsInTheFiled().get(card1ID), enemyPlayer.getCardsInTheFiled().get(card2ID));
                        } else
                            System.out.println("opponent minion is unavailable for attack");
                    } else if (distance <= player.getCardsInTheFiled().get(card1ID).getRangeOfAttack()) {
                        enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint() -
                                player.getCardsInTheFiled().get(card1ID).getAttackPower());
                        player.getCardsInTheFiled().get(card1ID).setHaveBeenUsedTrue();
                        attachBack(player.getCardsInTheFiled().get(card1ID), enemyPlayer.getCardsInTheFiled().get(card2ID));
                    } else
                        System.out.println("opponent minion is unavailable for attack");
                } else if (command.indexOf("Attack combo") != -1) {
                    int mainCardID = 0;
                    String split[] = command.split(" ");
                    int checkForError = 0;
                    enemyId = Integer.parseInt(split[2]);
                    int card2Exist = 0;
                    for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++) {
                        if (enemyPlayer.getCardsInTheFiled().get(i).getId() == enemyId) {
                            card2Exist = 1;
                            card2ID = i;
                        }
                    }
                    if (card2Exist == 0) {
                        checkForError = 1;
                    }
                    for (int i = 3; i < split.length - 1; i++) {
                        IDNumber1 = Integer.parseInt(split[i]);
                        int cardExist = 0;
                        for (int j = 0; j < player.getCardsInTheFiled().size(); j++) {
                            if (player.getCardsInTheFiled().get(j).getId() == IDNumber1 && player.getCardsInTheFiled().get(j)
                                    .getActivationTime().matches("combo")) {
                                if (i == 3) {
                                    mainCardID = j;
                                }
                                cardExist = 1;
                            }
                        }
                        if (cardExist == 0) {
                            checkForError = 1;
                            break;
                        }
                    }
                    if (checkForError == 0) {
                        for (int i = 3; i < split.length - 1; i++) {
                            IDNumber1 = Integer.parseInt(split[i]);
                            for (int j = 0; j < player.getCardsInTheFiled().size(); j++) {
                                if (player.getCardsInTheFiled().get(j).getId() == IDNumber1) {
                                    card1ID = j;
                                }
                                enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint()
                                        - player.getCardsInTheFiled().get(card1ID).getAttackPower());
                            }
                        }
                        attachBack(player.getCardsInTheFiled().get(card1ID), enemyPlayer.getCardsInTheFiled().get(card2ID));
                    } else {
                        enemyPlayer.getCardsInTheFiled().get(card2ID).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(card2ID).getHealthPoint()
                                - player.getCardsInTheFiled().get(mainCardID).getAttackPower());
                        attachBack(player.getCardsInTheFiled().get(mainCardID), enemyPlayer.getCardsInTheFiled().get(card2ID));
                    }
                } else if (command.matches("Use special power")) {
                    int x = command.charAt(19) - 48;
                    int y = command.charAt(21) - 48;
                    int isValidSpecialPower = 0;
                    for (int i = 0; i < Cell.getCells().size(); i++) {
                        if (Cell.getCells().get(i).getX() == x && Cell.getCells().get(i).getY() == y) {
                            isValidSpecialPower = 1;
                            card1ID = i;
                        }
                    }
                    if (isValidSpecialPower == 0) {
                        System.out.println("Invalid card");
                    } else if (Cell.getCells().get(card1ID).getInsideCard().getManaPoint() >= player.getMana()) {
                        System.out.println("invalid mana point");
                    } else {
                        if (Cell.getCells().get(card1ID).getInsideCard().getId() == 61) {
                            Cell.getCells().get(card1ID).getInsideCard().setAttackPower(Cell.getCells().get(card1ID).getInsideCard().getAttackPower() + 4);
                        } else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 62) {
                            System.out.println("Inter card ID");
                            int idNum = scanner.nextInt();
                            int valid = 0;
                            for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++) {
                                if (enemyPlayer.getCardsInTheFiled().get(i).getId() == idNum) {
                                    enemyPlayer.getCardsInTheFiled().get(i).setStunByMinion5True();
                                    valid = 1;
                                    break;
                                }
                            }
                            if (valid == 0) {
                                System.out.println("Invalid card ID");
                            }
                        } else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 63) {
                            System.out.println("Inter card ID");
                            int idNum = scanner.nextInt();
                            int valid = 0;
                            for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++) {
                                if (enemyPlayer.getCardsInTheFiled().get(i).getId() == idNum) {
                                    enemyPlayer.getCardsInTheFiled().get(i).setDisarmFor1TurnTrue();
                                    valid = 1;
                                    break;
                                }
                            }
                            if (valid == 0) {
                                System.out.println("Invalid card ID");
                            }
                        } else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 65) {
                            for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++) {
                                Hero temp = (Hero) Cell.getCells().get(card1ID).getInsideCard();
                                temp.setHero65ActivatedTrue();
                            }
                        } else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 66) {
                            //vaghti spello zadim
                        } else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 67) {
                            for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++) {
                                if (enemyPlayer.getCardsInTheFiled().get(i).getY() == Cell.getCells().get(card1ID).getInsideCard().getY()) {
                                    enemyPlayer.getCardsInTheFiled().get(i).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(i).getHealthPoint() - 4);
                                }
                            }
                        } else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 68) {
                            //bade spell
                        } else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 69) {
                            Cell.getCells().get(card1ID).getInsideCard().setHowManyHolyBuff(Cell.getCells().get(card1ID).getInsideCard().getHowManyHolyBuff() + 3);
                        } else if (Cell.getCells().get(card1ID).getInsideCard().getId() == 70) {
                            System.out.println("Hero dosn't have special power");
                        }
                    }
                } else if (command.indexOf("Show hand") != -1) {
                    int number = 1;
                    for (int i = 0; i < player.getHand().getCardsInThisHand().size(); i++) {
                        if (player.getHand().getCardsInThisHand().get(i).getType() == 1) {//spell
                            System.out.println(number + ". Type: Spell - Name: " + player.getHand().getCardsInThisHand()
                                    .get(i).getName() + " - Mana: " + player.getHand().getCardsInThisHand().get(i).getManaPoint());
                            number++;
                        } else if (player.getHand().getCardsInThisHand().get(i).getType() == 2) {//minion
                            System.out.println(number + ". Type: Minion - Name: " + player.getHand().getCardsInThisHand()
                                    .get(i).getName() + " - Mana: " + player.getHand().getCardsInThisHand().get(i).getManaPoint());
                            number++;
                        }
                    }
                } else if (command.indexOf("Insert") != -1) {
                    int inValidCard = 0;
                    String split[] = command.split("\\s+");
                    int x = split[3].charAt(1) - 48;
                    int y = split[3].charAt(3) - 48;
                    for (int i = 0; i < player.getHand().getCardsInThisHand().size(); i++) {
                        if (player.getHand().getCardsInThisHand().get(i).getName().matches(split[1])) {
                            inValidCard = 1;
                            card1ID = i;
                        }
                    }
                    if (inValidCard == 0) {
                        System.out.println("Invalid card name");
                    } else {
                        inValidCard = 0;
                        for (int i = 0; i < player.getCardsInTheFiled().size(); i++) {
                            int distance = getDistance(player.getCardsInTheFiled().get(i).getX(), x, player.getCardsInTheFiled().get(i).getY(), y);
                            if (distance == 1 || player.getCardsInTheFiled().get(i).getX() == x + 1 && player.getCardsInTheFiled().get(i).getY() == y + 1
                                    || player.getCardsInTheFiled().get(i).getX() == x - 1 && player.getCardsInTheFiled().get(i).getY() == y + 1 ||
                                    player.getCardsInTheFiled().get(i).getX() == x + 1 && player.getCardsInTheFiled().get(i).getY() == y + 1 ||
                                    player.getCardsInTheFiled().get(i).getX() == x + 1 && player.getCardsInTheFiled().get(i).getY() == y - 1 ||
                                    player.getCardsInTheFiled().get(i).getX() == x - 1 && player.getCardsInTheFiled().get(i).getY() == y - 1) {
                                inValidCard = 1;
                            }
                        }
                        if (inValidCard == 0) {
                            System.out.println("Invalid target");
                        } else {
                            if (player.getMana() <= player.getHand().getCardsInThisHand().get(card1ID).getManaPoint()) {
                                System.out.println("You don't have enough mana");
                            } else {
                                Cell.insertCard(player.getHand().getCardsInThisHand().get(card1ID), x, y);
                                player.getHand().getCardsInThisHand().get(card1ID).setY(y);
                                player.getHand().getCardsInThisHand().get(card1ID).setX(x);
                                player.addCardsInTheFile(player.getHand().getCardsInThisHand().get(card1ID));
                                player.getHand().getCardsInThisHand().remove(player.getHand().getCardsInThisHand().get(card1ID));
                                Random rand = new Random();
                                int n = rand.nextInt(20);
                                player.getHand().addCard(player.getMainDeck().getCardsOfDeck().get(n));
                                if (player.getMainDeck().getItem().getId() == 84) {
                                    enemyPlayer.getHero().setHealthPoint(enemyPlayer.getHero().getHealthPoint() - 1);
                                } else if (player.getMainDeck().getItem().getId() == 89) {
                                    if (player.getHand().getCardsInThisHand().get(card1ID).getId() <= 40) {
                                        player.getHand().getCardsInThisHand().get(card1ID).setHowManyHolyBuff(player.getHand().getCardsInThisHand().get(card1ID).getHowManyHolyBuff() + 1);
                                    }
                                }
                                if (player.getHand().getCardsInThisHand().get(card1ID).getId() == 21) {
                                    for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++) {
                                        if (enemyPlayer.getCardsInTheFiled().get(i).getId() <= 40) {
                                            Minion temp = (Minion) enemyPlayer.getCardsInTheFiled().get(i);
                                            temp.minionPower21(temp);
                                        }
                                    }
                                } else if (player.getHand().getCardsInThisHand().get(card1ID).getId() == 31) {
                                    for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++) {
                                        if (enemyPlayer.getCardsInTheFiled().get(i).getId() <= 40) {
                                            enemyPlayer.getCardsInTheFiled().get(i).setHealthPoint(enemyPlayer.getCardsInTheFiled().get(i).getHealthPoint() - 16);
                                            if (enemyPlayer.getCardsInTheFiled().get(i).getHealthPoint() <= 0) {
                                                if (enemyPlayer.getCardsInTheFiled().get(i).getId() == 17) {
                                                    Minion temp = (Minion) enemyPlayer.getCardsInTheFiled().get(i);
                                                    temp.minion17Power();
                                                } else if (enemyPlayer.getCardsInTheFiled().get(i).getId() == 38) {
                                                    Minion temp = (Minion) player.getCardsInTheFiled().get(i);
                                                    temp.minion38Power(player.getHero());
                                                }
                                                enemyPlayer.getCardsInTheFiled().remove(enemyPlayer.getCardsInTheFiled().get(i));
                                            }
                                        }
                                    }
                                } else if (player.getHand().getCardsInThisHand().get(card1ID).getId() == 36) {
                                    for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++) {
                                        if (enemyPlayer.getCardsInTheFiled().get(i).getId() <= 40) {
                                            if (enemyPlayer.getCardsInTheFiled().get(i).getX() >= player.getHand().getCardsInThisHand().get(card1ID).getX() - 1 &&
                                                    enemyPlayer.getCardsInTheFiled().get(i).getX() <= player.getHand().getCardsInThisHand().get(card1ID).getX() + 1 &&
                                                    enemyPlayer.getCardsInTheFiled().get(i).getY() == player.getHand().getCardsInThisHand().get(card1ID).getY() ||
                                                    enemyPlayer.getCardsInTheFiled().get(i).getY() >= player.getHand().getCardsInThisHand().get(card1ID).getY() - 1 &&
                                                            enemyPlayer.getCardsInTheFiled().get(i).getY() <= player.getHand().getCardsInThisHand().get(card1ID).getX() + 1 &&
                                                            enemyPlayer.getCardsInTheFiled().get(i).getX() == player.getHand().getCardsInThisHand().get(card1ID).getX() ||
                                                    enemyPlayer.getCardsInTheFiled().get(i).getX() == player.getHand().getCardsInThisHand().get(card1ID).getX() - 1 &&
                                                            enemyPlayer.getCardsInTheFiled().get(i).getY() == player.getHand().getCardsInThisHand().get(card1ID).getY() - 1 ||
                                                    enemyPlayer.getCardsInTheFiled().get(i).getX() == player.getHand().getCardsInThisHand().get(card1ID).getX() - 1 &&
                                                            enemyPlayer.getCardsInTheFiled().get(i).getY() == player.getHand().getCardsInThisHand().get(card1ID).getY() + 1 ||
                                                    enemyPlayer.getCardsInTheFiled().get(i).getX() == player.getHand().getCardsInThisHand().get(card1ID).getX() - 1 &&
                                                            enemyPlayer.getCardsInTheFiled().get(i).getY() == player.getHand().getCardsInThisHand().get(card1ID).getY() ||
                                                    enemyPlayer.getCardsInTheFiled().get(i).getX() == player.getHand().getCardsInThisHand().get(card1ID).getX() + 1 &&
                                                            enemyPlayer.getCardsInTheFiled().get(i).getY() == player.getHand().getCardsInThisHand().get(card1ID).getY() - 1 ||
                                                    enemyPlayer.getCardsInTheFiled().get(i).getX() == player.getHand().getCardsInThisHand().get(card1ID).getX() + 1 &&
                                                            enemyPlayer.getCardsInTheFiled().get(i).getY() == player.getHand().getCardsInThisHand().get(card1ID).getY() + 1 ||
                                                    enemyPlayer.getCardsInTheFiled().get(i).getX() == player.getHand().getCardsInThisHand().get(card1ID).getX() + 1 &&
                                                            enemyPlayer.getCardsInTheFiled().get(i).getY() == player.getHand().getCardsInThisHand().get(card1ID).getY() ||
                                                    enemyPlayer.getCardsInTheFiled().get(i).getX() == player.getHand().getCardsInThisHand().get(card1ID).getX() &&
                                                            enemyPlayer.getCardsInTheFiled().get(i).getY() == player.getHand().getCardsInThisHand().get(card1ID).getY() - 1 ||
                                                    enemyPlayer.getCardsInTheFiled().get(i).getX() == player.getHand().getCardsInThisHand().get(card1ID).getX() &&
                                                            enemyPlayer.getCardsInTheFiled().get(i).getY() == player.getHand().getCardsInThisHand().get(card1ID).getY() + 1) {
                                                enemyPlayer.getCardsInTheFiled().get(i).setStunByMinion5True();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (command.matches("End turn")) {
                    for (int i = 0; i < player.getCardsInTheFiled().size(); i++) {
                        if (player.getCardsInTheFiled().get(i).getDisarmFor1Turn())
                            player.getCardsInTheFiled().get(i).setHowLongHaveBeenDisarmed(player.getCardsInTheFiled().get(i).getHowLongHaveBeenDisarmed() + 1);
                        if (player.getCardsInTheFiled().get(i).getStunByMinion5())
                            player.getCardsInTheFiled().get(i).setHowLongHaveBeenStun(player.getCardsInTheFiled().get(i).getHowLongHaveBeenStun() + 1);
                    }
                    player = enemyPlayer;
                    for (int i = 0; i < player.getCardsInTheFiled().size(); i++) {
                        if (player.getCardsInTheFiled().get(i).getDisarmFor1Turn())
                            player.getCardsInTheFiled().get(i).setHowLongHaveBeenDisarmed(player.getCardsInTheFiled().get(i).getHowLongHaveBeenDisarmed() + 1);
                        if (player.getCardsInTheFiled().get(i).getStunByMinion5())
                            player.getCardsInTheFiled().get(i).setHowLongHaveBeenStun(player.getCardsInTheFiled().get(i).getHowLongHaveBeenStun() + 1);
                    }
                    if (turn == true)
                        turn = false;
                    else
                        turn = true;
                    break;
                } else if (command.indexOf("Show menu") != -1) {
                    Show.showBattleMenu(this, scanner);
                } else if (command.indexOf("Help") != -1) {
                    System.out.println("You can move");
                    for (int i = 0; i < player.getCardsInTheFiled().size(); i++) {
                        if (player.getCardsInTheFiled().get(i).getHaveBeenMoved() == false) {
                            player.getCardsInTheFiled().get(i).getCardInfo(player.getCardsInTheFiled().get(i));
                        }
                    }
                    System.out.println("Cards you can attack on");
                    for (int i = 0; i < enemyPlayer.getCardsInTheFiled().size(); i++) {
                        enemyPlayer.getCardsInTheFiled().get(i).getCardInfo(enemyPlayer.getCardsInTheFiled().get(i));
                    }
                    System.out.println("you can insert Cards into the field");
                    for (int i = 0; i < player.getHand().getCardsInThisHand().size(); i++) {
                        if (player.getMana() >= player.getHand().getCardsInThisHand().get(i).getManaPoint()) {
                            player.getHand().getCardsInThisHand().get(i).getCardInfo(player.getHand().getCardsInThisHand().get(i));
                        }
                    }
                } else if (command.indexOf("End game") != -1) {
                    return;
                } else if (command.indexOf("Show collectables") != -1) {
                    for (int i = 0; i < player.getCollectibleItems().size(); i++)
                        player.getCollectibleItems().get(i).showItemInfo();
                } else if (command.indexOf("Show info") != -1) {
                    player.getCollectibleItems().get(itemIDNumber).showItemInfo();
                } else if(command.indexOf("exit") != -1) {
                    return;
                }
            }
        }
        System.out.println("Game end");
    }

    public int[] getPosition(int cardId) {
        int[] result = new int[2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                Cell cell = Cell.getCellByxy(i, j);
                if (cell.getInsideCard() != null && cell.getInsideCard().getId() == cardId) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    private Player getEnemyPlayer() {
        if (turn == false) {
            return this.player1;
        }
        return this.player2;
    }

    public Hero getEnemyHero() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                Cell cell = Cell.getCellByxy(i, j);
                if (cell.getInsideCard().getId() == (getEnemyPlayer().getHero().id)) {
                    continue;
                }
                if (cell.getInsideCard() instanceof Hero) {
                    return (Hero) cell.getInsideCard();
                }
            }
        }
        return null;
    }

}


