package Model;

import java.util.ArrayList;

public class Minion extends Card {

    private static ArrayList<Minion> minions = new ArrayList<>();
    private int healthPoint;
    private int attackPower;
    private int manaPoint;
    private int rangeOfAttack;
    private int cost;
    private int nationality;
    private String specialPower;
    private String typeOfAttack;
    private String activationTime;

    public Minion(int ID, int cost, int mana, int healthPoint, int attackPower, String typeOfAttack, int rangeOfAttack, String activationTime, int nationality) {
        setType("Minion");
        this.setNationality(nationality);
        this.setId(ID);
        this.setCost(cost);
        this.setHealthPoint(healthPoint);
        this.setManaPoint(mana);
        this.setAttackPower(attackPower);
        this.setTypeOfAttack(typeOfAttack);
        this.setRangeOfAttack(rangeOfAttack);
        this.setActivationTime(activationTime);
    }

    public static void addMinion(Minion minion) {
        getMinions().add(minion);
    }

    public static ArrayList<Minion> getMinions() {
        return minions;
    }

    public static void setMinions(ArrayList<Minion> minions) {
        Minion.minions = minions;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
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

    public int getManaPoint() {
        return manaPoint;
    }

    public void setManaPoint(int manaPoint) {
        this.manaPoint = manaPoint;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }

    public String getTypeOfAttack() {
        return typeOfAttack;
    }

    public void setTypeOfAttack(String typeOfAttack) {
        this.typeOfAttack = typeOfAttack;
    }

    public int getRangeOfAttack() {
        return rangeOfAttack;
    }

    public void setRangeOfAttack(int rangeOfAttack) {
        this.rangeOfAttack = rangeOfAttack;
    }

    public String getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(String activationTime) {
        this.activationTime = activationTime;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }
}
