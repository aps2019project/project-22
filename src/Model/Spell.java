package Model;

import java.util.ArrayList;

public class Spell extends Card {

    private static ArrayList<Spell> spells = new ArrayList<>();
    private int mana;
    private String cost;
    private String targetPointName;
    private String description;
    private Buff buff;
    private boolean permissionToAttackOrMove;
    private boolean permissionToCounterAttack;


    public static void addSpell(Spell spell) {
        Spell.getSpells().add(spell);
    }

    public static ArrayList<Spell> getSpells() {
        return spells;
    }

    public static void setSpells(ArrayList<Spell> spells) {
        Spell.spells = spells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTargetPointName() {
        return targetPointName;
    }

    public void setTargetPointName(String targetPointName) {
        this.targetPointName = targetPointName;
    }

    public Spell(int ID, String name, int price, int mana, String targetPointName, String description) {
        setType(1);
        this.setPermissionToAttackOrMove(true);
        this.setId(ID);
        this.setName(name);
        this.setPrice(price);
        this.setMana(mana);
        this.setTargetPointName(targetPointName);
        this.setDescription(description);
    }

    public static boolean checkIfACardIsASpell(String cardName) {
        for (Spell spell : Spell.getSpells()) {
            if (spell.getName().compareTo(cardName) == 0)
                return true;
        }
        return false;
    }


    public static Card getSpellByName(String spellName) {
        for (Spell spell : Spell.getSpells()) {
            if (spell.getName().compareTo(spellName) == 0)
                return spell;
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Buff getBuff() {
        return buff;
    }

    public void setBuff(Buff buff) {
        this.buff = buff;
    }

    public boolean isPermissionToAttackOrMove() {
        return permissionToAttackOrMove;
    }

    public void setPermissionToAttackOrMove(boolean permissionToAttackOrMove) {
        this.permissionToAttackOrMove = permissionToAttackOrMove;
    }

    public boolean isPermissionToCounterAttack() {
        return permissionToCounterAttack;
    }

    public void setPermissionToCounterAttack(boolean permissionToCounterAttack) {
        this.permissionToCounterAttack = permissionToCounterAttack;
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
        this.attackPower-=number;
    }
}
