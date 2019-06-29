package Model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Hero extends Card {
    private static ArrayList<Hero> heroes = new ArrayList<>();
    private int healthPoint;
    private int attackPower;
    private int price;
    private int rangeOfAttack;
    private int howLongHasBeenCool = 0;
    private int cooldown;

    private boolean item17 = false;
    private String typeOfHero;
    private Spell specialPower;
    private boolean hero65Activated = false;
    private boolean specialPowerActivated = false;

    public void setSpecialPowerActivatedTrue() {
        specialPowerActivated = true;
    }

    public void setSpecialPowerActivatedFalse() {
        specialPowerActivated = false;
    }

    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void timer(Hero hero) {
        if (specialPowerActivated) {
            hero.setHowLongHasBeenCool(hero.getHowLongHasBeenCool() + 1);
            if (hero.getId() == 68 || hero.getId() == 67 || hero.getId() == 64 || hero.getId() == 61) {
                if (hero.getHowLongHasBeenCool() == 2) {
                    hero.setHowLongHasBeenCool(0);
                    hero.setSpecialPowerActivatedFalse();
                }
            } else if (hero.getId() == 62) {
                if (hero.getHowLongHasBeenCool() == 8) {
                    hero.setHowLongHasBeenCool(0);
                    hero.setSpecialPowerActivatedFalse();
                }
            } else if (hero.getId() == 66) {
                if (hero.getHowLongHasBeenCool() == 3) {
                    hero.setHowLongHasBeenCool(0);
                    hero.setSpecialPowerActivatedFalse();
                }
            } else if (hero.getId() == 63) {
                if (hero.getHowLongHasBeenCool() == 1) {
                    hero.setHowLongHasBeenCool(0);
                    hero.setSpecialPowerActivatedFalse();
                }
            }
        }
    }

    public Hero(String image1, String image2, String image3, int id, String name, int price, int healthPoint, int attackPower, String typeOfAttack,
                int rangeOfAttack, int manaPoint, int cooldown) {
        breath = new Image(image1);
        attack = new Image(image2);
        run = new Image(image3);
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


    public void setItem17True() {
        item17 = true;
    }

    public void setItem17False() {
        item17 = false;
    }

    public boolean getItem17() {
        return item17;
    }

    public void setHero65ActivatedTrue() {
        hero65Activated = true;
    }

    public void setHero65ActivatedFalse() {
        hero65Activated = false;
    }

    public boolean gethero65Activated() {
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

    public void applyType() {

    }
}
