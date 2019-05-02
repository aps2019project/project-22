package Model;

import java.util.ArrayList;

public class Hero extends Card {
    public static ArrayList<Hero> heroes = new ArrayList<>();
    private int healthPoint;
    private int attackPower;
    private int rangeOfAttack;
    private int manaPoint;
    private int cooldown;
    private String typeOfHero;
    private String typeOfAttack;
    private Spell specialPower;

    public Hero(int id, String name, int price, int healthPoint, int attackPower, String typeOfAttack,
                int rangeOfAttack, int manaPoint, int cooldown) {
        setType(0);
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setHealthPoint(healthPoint);
        this.setAttackPower(attackPower);
        this.setTypeOfAttack(typeOfAttack);
        this.setRangeOfAttack(rangeOfAttack);
        this.setManaPoint(manaPoint);
        this.setCooldown(cooldown);
    }

    public static void addHero(Hero hero) {
        heroes.add(hero);
    }

    public static ArrayList<Hero> getHeros() {
        return heroes;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public Spell getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(Spell specialPower) {
        this.specialPower = specialPower;
    }


    public String getTypeOfHero() {
        return typeOfHero;
    }

    public void setTypeOfHero(String typeOfHero) {
        this.typeOfHero = typeOfHero;
    }

    public int getRangeOfAttack() {
        return rangeOfAttack;
    }

    public void setRangeOfAttack(int rangeOfAttack) {
        this.rangeOfAttack = rangeOfAttack;
    }


    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void applyType() {

    }

    public String getTypeOfAttack() {
        return typeOfAttack;
    }

    public void setTypeOfAttack(String typeOfAttack) {
        this.typeOfAttack = typeOfAttack;
    }

    public int getManaPoint() {
        return manaPoint;
    }

    public void setManaPoint(int manaPoint) {
        this.manaPoint = manaPoint;
    }
}
