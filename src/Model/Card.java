package Model;

import java.util.ArrayList;

public class Card {
    private static ArrayList<Card> cards;
    protected int id;
    protected boolean stun;
    protected boolean stunByMinion5;
    private boolean disarmFor1Turn;
    private int minion5Counter = 0;
    private int counterMinion18 = 0;
    protected int price;
    protected String activationTime;
    protected int type; // 0 hero | 1 spell | 2 minion
    protected String name;
    private int row;
    protected int x;
    protected int y;
    protected int healthPoint;
    private int column;
    private int numberOfPlayer;
    protected int attackPower;
    protected int rangeOfAttack;
    protected int manaPoint;
    protected int cost;
    protected String typeOfAttack;
    private boolean haveBeenUsed = false;
    private int counterMinion10 = 0;

//    public void setCounterMinion10(Card card) {
//        counterMinion10++;
//        if (i <= 4 && i != 0)
//            card.setHealthPoint(card.getHealthPoint() - 1);
//        if (counterMinion10 == 4) {
//            counterMinion10 = 0;
//        }
//    }
//
//    public void setCounterMinion18(Card card) {
//        counterMinion18++;
//        if (i <= 3 && i != 0)
//            card.setHealthPoint(card.getHealthPoint() - 1);
//        if (counterMinion18 == 3) {
//            counterMinion18 = 0;
//        }
//    }

    public void setDisarmFor1TurnTrue() {
        disarmFor1Turn = true;
    }

    public void setDisarmFor1TurnFalse() {
        disarmFor1Turn = false;
    }

    public boolean getDisarmFor1Turn() {
        return disarmFor1Turn;
    }

    public void setHaveBeenUsedTrue() {
        haveBeenUsed = true;
    }

    public String getActivationTime() {
        return activationTime;
    }

    public void addMinion5Counter() {
        this.minion5Counter++;
    }

    public int getMinion5Counter() {
        return minion5Counter;
    }

    public void setActivationTime(String activationTime) {
        this.activationTime = activationTime;
    }

    public void setHaveBeenUsedFalse() {
        haveBeenUsed = false;
    }

    public boolean getHaveBeenUsed() {
        return haveBeenUsed;
    }

    public void setStunTrue() {
        stun = true;
    }

    public void setStunFalse() {
        stun = false;
    }

    public boolean getStun() {
        return stun;
    }

    public boolean getStunByMinion5() {
        return stunByMinion5;
    }

    public void setStunByMinion5True() {
        stunByMinion5 = true;
    }

    public void setStunByMinion5False() {
        stunByMinion5 = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        y = y;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void move(int x, int y, int maxDistance) {
        int distance;
        distance = Math.abs(x - row) + Math.abs(y - column);
        if (distance <= maxDistance) {
            setRow(x);
            setColumn(y);
            //tu view bge mishe o shodo ina.
        } else {
            // tu view bege nmishe
        }
    }

    public int getRow() {
        return row;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getRangeOfAttack() {
        return rangeOfAttack;
    }

    public void setRangeOfAttack(int rangeOfAttack) {
        this.rangeOfAttack = rangeOfAttack;
    }

    public int getManaPoint() {
        return manaPoint;
    }

    public void setManaPoint(int manaPoint) {
        this.manaPoint = manaPoint;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTypeOfAttack() {
        return typeOfAttack;
    }

    public void setTypeOfAttack(String typeOfAttack) {
        this.typeOfAttack = typeOfAttack;
    }

    public void setHealthPoint(int healthPoint) {

        this.healthPoint = healthPoint;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void increaseHp(int number) {
        this.healthPoint+=number;
    }
    public void decreaseHp(int number) {
        this.healthPoint-=number;
    }
    public void increaseAp(int number) {
        this.attackPower+=number;
    }
    public void decreaseAp(int number) {
        this.healthPoint-=number;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    private int cardId;

    public static void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static Card searchCardByID(int ID) {
        for (Card card : Card.cards) {
            if (card.getCardId() == ID)
                return card;
        }
        return null;
    }


    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }
}

