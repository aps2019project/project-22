package Model;

import java.util.ArrayList;

public class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
    protected int id;
    protected boolean stun;
    private boolean disarmFor1Turn;
    private int attackPointByItem = 0;
    private int minion5Counter = 0;
    private int counterMinion18 = 0;
    private int howLongItem9 = 0;
    private int howManyHolyBuff = 0;
    private int hero65Power = 0;
    private int howLongHaveBeenStun = 0;
    private int howLongHaveBeenDisarmed = 0;
    protected int price;
    private int tempAttackPower = 0;
    private int tempHealtPoint = 0;
    protected String activationTime;
    protected int type; // 0 hero | 1 spell | 2 minion
    protected String name;
    private boolean haveBeenMoved = false;
    protected int x;
    protected int y;
    protected int healthPoint;
    private int numberOfPlayer;
    protected int attackPower;
    protected int rangeOfAttack;
    protected int manaPoint;
    private boolean item12 = false;
    protected int cost;
    protected String typeOfAttack;
    private boolean haveBeenUsed = false;
    private int counterMinion10 = 0;
    private boolean item15 = false;
    private boolean flag = false;
    public void setItem12True(){
        item12 = true;
    }
    public void setItem12False(){
        item12 = false;
    }
    public boolean getItem12(){
        return item12;
    }
    public void setFlagTrue(){
        flag = true;
    }
    public void setFlagFalse(){
        flag = false;
    }
    public boolean getFlag(){
        return flag;
    }
    public void setItem15True(){
        item15 = true;
    }
    public void setItem15False(){
        item15 = false;
    }
    public boolean getItem15(){
        return item15;
    }

    public int getAttackPointByItem() {
        return attackPointByItem;
    }

    public void setAttackPointByItem(int attackPointByItem) {
        this.attackPointByItem = attackPointByItem;
    }

    public int getHowLongItem9() {
        return howLongItem9;
    }
    public void checkItem9(){
        if (howLongItem9 == 2){
            howLongItem9 = 0;
        }
    }
    public void setHowLongItem9(int howLongItem9) {
        this.howLongItem9 = howLongItem9;
    }

    public void setHaveBeenMovedTrue(){
        haveBeenMoved = true;
    }
    public void setHaveBeenMovedFalse(){
        haveBeenMoved = false;
    }
    public boolean getHaveBeenMoved(){
        return haveBeenMoved;
    }
    public void setCounterMinion10(Card card){
        counterMinion10++;
        if (counterMinion10 <5 && counterMinion10 != 0)
         card.setHealthPoint(card.getHealthPoint()-1);
        if (counterMinion10 == 4){
            card.setHealthPoint(card.getHealthPoint()+4);
            counterMinion10 = 0;
        }
    }
    public void getCardInfo(Card card){}
    public void setCounterHero65(Card card){
        hero65Power++;
        if (hero65Power <4 && hero65Power != 0)
            card.setHealthPoint(card.getHealthPoint()-1);
        if (hero65Power == 3){
            card.setHealthPoint(card.getHealthPoint()+3);
            hero65Power = 0;
        }
    }

    public int getHowLongHaveBeenStun() {
        return howLongHaveBeenStun;
    }

    public void setHowLongHaveBeenStun(int howLongHaveBeenStun) {
        this.howLongHaveBeenStun = howLongHaveBeenStun;
        if (this.howLongHaveBeenStun == 2){
            this.stun = false;
        }
    }

    public int getHowLongHaveBeenDisarmed() {
        return howLongHaveBeenDisarmed;
    }

    public void setHowLongHaveBeenDisarmed(int howLongHaveBeenDisarmed) {
        this.howLongHaveBeenDisarmed = howLongHaveBeenDisarmed;
        if (this.howLongHaveBeenDisarmed == 2){
            this.disarmFor1Turn = false;
        }
    }

    public int getHowManyHolyBuff() {
        return howManyHolyBuff;
    }

    public void setHowManyHolyBuff(int howManyHolyBuff) {
        this.howManyHolyBuff = howManyHolyBuff;
    }

    public int getTempAttackPower() {
        return tempAttackPower;
    }

    public void setTempAttackPower(int tempAttackPower) {
        this.tempAttackPower = tempAttackPower;
    }

    public int getTempHealtPoint() {
        return tempHealtPoint;
    }

    public void setTempHealtPoint(int tempHealtPoint) {
        this.tempHealtPoint = tempHealtPoint;
    }
    public int getCounterMinion18(){
        return counterMinion18;
    }
    public int getHero65Power(){
        return hero65Power;
    }
    public int getCounterMinion10(){
        return counterMinion10;
    }
    public void setCounterMinion18(Card card){
        counterMinion18++;
        if (counterMinion18 <4 && counterMinion18 != 0)
            card.setHealthPoint(card.getHealthPoint()-1);
        if (counterMinion18 == 3){
            card.setHealthPoint(card.getHealthPoint()+3);
            counterMinion18 = 0;
        }
    }
    public void setDisarmFor1TurnTrue(){
        disarmFor1Turn = true;
    }
    public void setDisarmFor1TurnFalse(){
        disarmFor1Turn = false;
    }
    public boolean getDisarmFor1Turn(){
        return disarmFor1Turn;
    }
    public void setHaveBeenUsedTrue(){
        haveBeenUsed = true;
    }
    public String getActivationTime() {
        return activationTime;
    }
    public void addMinion5Counter(){
        this.minion5Counter++;
    }

    public int getMinion5Counter() {
        return minion5Counter;
    }

    public void setActivationTime(String activationTime) {
        this.activationTime = activationTime;
    }

    public void setHaveBeenUsedFalse(){
        haveBeenUsed = false;
    }
    public boolean getHaveBeenUsed(){
        return haveBeenUsed;
    }
    public void setStunTrue(){
        stun = true;
    }
    public void setStunFalse(){
        stun = false;
    }
    public boolean getStun(){
        return stun;
    }
    public boolean getStunByMinion5(){
        return stun;
    }
    public void setStunByMinion5True(){
        stun = true;
    }
    public void setStunByMinion5False(){
        stun = false;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public void setId(int id){
        this.id =id;
    }

    public int getId() {
        return id;
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

    public static Card searchCardByID(int ID){
        for(Card card : Card.cards) {
            if (card.getId() == ID)
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

