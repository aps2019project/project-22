package Model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Minion extends Card {
    private String description;
    private boolean minion25Effect = false;
    private boolean minion26Effect = false;
    private boolean minion21Effect = false;
    private boolean item10 = false;
    private boolean item7 = false;
    private int minion22Effect = 0;
    private int minion23Effect = 0;
    private int minion24Effect = 0;
    private int sumOfPossetiveHealt = 0;
    private int sumOfPossetiveAttack = 0;
    private boolean disarm = false;
    private String specialPower;
    private static ArrayList<Minion> minions = new ArrayList<>();
    private ArrayList<Spell> spells = new ArrayList<>();

    public void setMinion21EffectTrue() {
        minion21Effect = true;
    }

    public void setItem7True() {
        item7 = true;
    }

    public void setItem7False() {
        item7 = false;
    }

    public void setItem10True() {
        item10 = true;
    }

    public void setItem10False() {
        item10 = false;
    }

    public boolean isMinion21Effect() {
        return minion21Effect;
    }

    public void setMinion21EffectFalse() {
        minion21Effect = false;
    }

    public void setStunTrue() {
        this.stun = true;
    }

    public void setStunFalse() {
        this.stun = false;
    }

    public boolean isMinion25Effect() {
        return minion25Effect;
    }

    public int getSumOfPossetiveHealt() {
        return sumOfPossetiveHealt;
    }

    public void setSumOfPossetiveHealt(int sumOfPossetiveHealt) {
        this.sumOfPossetiveHealt = sumOfPossetiveHealt;
    }

    public int getSumOfPossetiveAttack() {
        return sumOfPossetiveAttack;
    }

    public void setSumOfPossetiveAttack(int sumOfPossetiveAttack) {
        this.sumOfPossetiveAttack = sumOfPossetiveAttack;
    }

    public Minion(String image1,String image2,String image3,int ID, String name, int cost, int mana, int healthPoint, int attackPower, String typeOfAttack, int rangeOfAttack, String activationTime, String description) {
        id = ID;
        breath = new Image(image1);
        attack = new Image(image2);
        run = new Image(image3);
        this.cost = cost;
        setType(2);
        this.price = cost;
        this.healthPoint = healthPoint;
        this.manaPoint = mana;
        this.attackPower = attackPower;
        this.typeOfAttack = typeOfAttack;
        this.rangeOfAttack = rangeOfAttack;
        this.activationTime = activationTime;
        this.description = description;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setMinion25EffectTrue() {
        this.minion25Effect = true;
    }

    public void setMinion26EffectTrue() {
        this.minion26Effect = true;
    }

    public void setMinio25Or26PwersOr36(int i) {
        for (int k = 0; k < Cell.getCells().size(); k++) {
            if (Cell.getCells().get(k).getX() == this.x + 1 && Cell.getCells().get(k).getX() == this.y + 1 ||
                    Cell.getCells().get(k).getX() == this.x + 1 && Cell.getCells().get(k).getX() == this.y ||
                    Cell.getCells().get(k).getX() == this.x && Cell.getCells().get(k).getX() == this.y + 1 ||
                    Cell.getCells().get(k).getX() == this.x - 1 && Cell.getCells().get(k).getX() == this.y + 1 ||
                    Cell.getCells().get(k).getX() == this.x - 1 && Cell.getCells().get(k).getX() == this.y ||
                    Cell.getCells().get(k).getX() == this.x - 1 && Cell.getCells().get(k).getX() == this.y - 1 ||
                    Cell.getCells().get(k).getX() == this.x + 1 && Cell.getCells().get(k).getX() == this.y - 1 ||
                    Cell.getCells().get(k).getX() == this.x && Cell.getCells().get(k).getX() == this.y - 1) {

                if (i == 25 && Cell.getCells().get(k).getMinion() != null) {
                    Cell.getCells().get(k).getMinion().setMinion25EffectTrue();
                    this.minion25Effect = true;
                } else if (i == 26 && Cell.getCells().get(k).getMinion() != null) {
                    Cell.getCells().get(k).getMinion().setMinion26EffectTrue();
                    this.minion26Effect = true;
                    Cell.getCells().get(k).getMinion().setAttackPower(Cell.getCells().get(k).getMinion().getAttackPower() + 2);
                } else if (i == 36 && Cell.getCells().get(k).getMinion() != null)
                    Cell.getCells().get(k).getMinion().setStunTrue();
            }
        }
        if (i == 26) {
            this.attackPower = this.attackPower + 2;
            this.sumOfPossetiveAttack += 2;
        }
    }

    public void minion27Power(Minion minion) {
        minion.setAttackPower(minion.getAttackPower() + 1);
        minion.setSumOfPossetiveAttack(getSumOfPossetiveHealt() + 1);
    }

    public void minion31Power(Minion minion) {
        minion.setHealthPoint(minion.getHealthPoint() - 16);
    }

    public void setMinion25PowerFalse() {
        this.minion25Effect = false;
    }

    public void setMinion26PowerFalse() {
        this.minion26Effect = false;
    }

    public void useMinion25Power(Minion minion) {
        minion.setHealthPoint(minion.getHealthPoint() - 1);
        minion.setAttackPower(getAttackPower() + 2);
        minion.setSumOfPossetiveAttack(getSumOfPossetiveAttack() + 2);
    }

    public void voidFinishMinion25(Minion minion) {
        minion.setMinion25PowerFalse();
        minion.setHealthPoint(minion.getHealthPoint() + 1);
        minion.setSumOfPossetiveAttack(minion.getSumOfPossetiveAttack() + 1);
        minion.setAttackPower(getAttackPower() - 2);
    }

    public static ArrayList<Minion> getMinions() {
        return minions;
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

    public void minion17Power() {
        if (this.healthPoint == 0) {
            for (int k = 0; k < Cell.getCells().size(); k++) {
                if (Cell.getCells().get(k).getX() == this.x + 1 && Cell.getCells().get(k).getX() == this.y + 1 ||
                        Cell.getCells().get(k).getX() == this.x + 1 && Cell.getCells().get(k).getX() == this.y ||
                        Cell.getCells().get(k).getX() == this.x && Cell.getCells().get(k).getX() == this.y + 1 ||
                        Cell.getCells().get(k).getX() == this.x - 1 && Cell.getCells().get(k).getX() == this.y + 1 ||
                        Cell.getCells().get(k).getX() == this.x - 1 && Cell.getCells().get(k).getX() == this.y ||
                        Cell.getCells().get(k).getX() == this.x - 1 && Cell.getCells().get(k).getX() == this.y - 1 ||
                        Cell.getCells().get(k).getX() == this.x + 1 && Cell.getCells().get(k).getX() == this.y - 1 ||
                        Cell.getCells().get(k).getX() == this.x && Cell.getCells().get(k).getX() == this.y - 1) {
                    if (Cell.getCells().get(k).getMinion() != null) {
                        Cell.getCells().get(k).getMinion().setHealthPoint(Cell.getCells().get(k).getMinion().getHealthPoint() - 2);
                    }
                }
            }
        }
    }

    public void minion15Power() {
        healthPoint += 10;
        this.sumOfPossetiveHealt += 10;
    }


    public static void addMinion(Minion minion) {
        minions.add(minion);
    }

    public void minionPower21(Minion minion) {
        if (minion.getX() >= this.x - 2 && minion.getX() <= this.x + 2 && minion.getY() == this.y ||
                minion.getY() >= this.y - 2 && minion.getY() <= this.y && minion.getX() == this.x ||
                minion.getX() == this.x + 1 && minion.getY() == this.y + 1 || minion.getX() == this.x - 1 &&
                minion.getY() == this.y + 1 || minion.getX() == this.x - 1 && minion.getY() == this.y - 1 ||
                minion.getX() == this.x + 1 && minion.getY() == this.y - 1) {
            minion.setMinion21EffectTrue();
        } else
            minion.setMinion21EffectFalse();
    }

    public void setID(int ID) {
        id = ID;
    }

    public void minion22Power(Minion minion) {
        minion22Effect++;
        if (minion22Effect == 1 || minion22Effect > 3) {
            minion.setHealthPoint(minion.getHealthPoint() - 2);
        } else if (minion22Effect == 2) {
            minion.setHealthPoint(minion.getHealthPoint() - 6);
        } else
            minion.setHealthPoint(minion.getHealthPoint() - 4);
    }

    public boolean getItem10() {
        return item10;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setHealthPoint(int healthPoint) {
        if (minion21Effect) {
            this.healthPoint = healthPoint - 1;
        } else
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

    public void minion38Power(Hero hero) {
        hero.setHealthPoint(hero.getHealthPoint() - 6);
    }

    public void minion35Power(Minion minion) {
        minion.setHealthPoint(minion.getHealthPoint() - minion.getSumOfPossetiveHealt());
        minion.setAttackPower(minion.getAttackPower() - minion.getSumOfPossetiveAttack());
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
