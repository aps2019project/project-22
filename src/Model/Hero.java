package Model;

import java.awt.*;
import java.util.ArrayList;

public class Hero extends Card{
    private static ArrayList<Hero> heroes=new ArrayList<>();
     private int healthPoint;
    private int attackPower;
    private int price;
    private int rangeOfAttack;
    private int mp;
    private int howLongHasBeenCool = 0;
    private int cooldown;
    private boolean item17 = false;
    private String typeOfHero;
    private Spell specialPower;
    private boolean hero65Activated = false;

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


    public void setItem17True(){
        item17 = true;
    }
    public void setItem17False(){
        item17 = false;
    }
    public boolean getItem17(){
        return item17;
    }
    public void setHero65ActivatedTrue(){
        hero65Activated = true;
    }
    public void setHero65ActivatedFalse(){
        hero65Activated = false;
    }
    public boolean gethero65Activated(){
        return hero65Activated;
    }
    public int getHowLongHasBeenCool() {
        return howLongHasBeenCool;
    }

    public void setHowLongHasBeenCool(int howLongHasBeenCool) {
        this.howLongHasBeenCool = howLongHasBeenCool;
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

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void applyType(){

    }
}
