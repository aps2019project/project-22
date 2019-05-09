package Model;

import java.util.ArrayList;
import java.util.Random;

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
    private Integer[][] oneEnemyForce( int x, int y, int id) {
        return force(x, y, id);
    }

    private Integer[][] force(int x, int y, int id) {
        Cell cell = Cell.getCellByxy(x, y);
        if (cell.getInsideCard() != null) {
            if (cell.getInsideCard().getId() == id) return null;
            Integer[][] integers = new Integer[1][2];
            integers[0][0] = x;
            integers[0][1] = y;
            return integers;
        }
        return null;
    }

    private Integer[][] oneOwnForce( int x, int y, int id) {
        return force(x, y, id);
    }
    private Integer[][] ownHero( int id) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                Cell cell = Cell.getCellByxy(i,j);
                if (cell.getInsideCard() != null && cell.getInsideCard() instanceof Hero) {
                    if (cell.getInsideCard().getId() != id) continue;
                    Integer[][] integers = new Integer[1][2];
                    integers[0][0] = i;
                    integers[0][1] = j;
                    return integers;
                }
            }
        }
        return null;
    }
    private Integer[][] enemyHero( int id) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                Cell cell = Cell.getCellByxy(i,j);
                if (cell.getInsideCard()!= null && cell.getInsideCard() instanceof Hero) {
                    if (cell.getInsideCard().getId() == id) continue;
                    Integer[][] integers = new Integer[1][2];
                    integers[0][0] = i;
                    integers[0][1] = j;
                    return integers;
                }
            }
        }
        return null;
    }
    private Integer[][] allEnemyForce(int id) {
        Integer[][] integers = new Integer[15][2];
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                Cell cell =Cell.getCellByxy(i,j);
                if (cell.getInsideCard().getId() !=id) {
                    integers[index][0] = i;
                    integers[index][1] = j;
                    index++;
                }
            }
        }
        return integers;
    }
    private Integer[][] oneOwnOrEnemyForce( int x, int y) {
        Cell cell = Cell.getCellByxy(x,y);
        if (cell.getInsideCard() != null) {
            Integer[][] integers = new Integer[1][2];
            integers[0][0] = x;
            integers[0][1] = y;
            return integers;
        }
        return null;
    }

    private Integer[][] allEnemyInOneColumn( int x, int y, int id) {
        if (x < 0 || x > 9) return null;
        Integer[][] integers = new Integer[5][2];
        int ind = 0;
        for (int j = 0; j < 5; j++) {
            Cell cell = Cell.getCellByxy(x,j);
            if (cell.getInsideCard() == null) continue;
            if (cell.getInsideCard().getId() ==id) {
                integers[ind][0] = x;
                integers[ind][1] = y;
                ind++;
            }
        }
        return integers;
    }

    private Integer[][] oneEnemyMinion( int x, int y, int id) {
        Cell cell = Cell.getCellByxy(x,y);
        if (cell.getInsideCard() != null) {
            if (cell.getInsideCard() instanceof Hero) return null;
            if (cell.getInsideCard().getId() !=id) {
                Integer[][] integers = new Integer[1][2];
                integers[0][0] = x;
                integers[0][1] = y;
                return integers;
            }
        }
        return null;
    }

    private Integer[][] oneOwnMinion( int x, int y, int id) {
        Cell cell = Cell.getCellByxy(x,y);
        if (cell.getInsideCard() != null) {
            if (cell.getInsideCard() instanceof Hero) return null;
            if (cell.getInsideCard().getId()==id) {
                Integer[][] integers = new Integer[1][2];
                integers[0][0] = x;
                integers[0][1] = y;
                return integers;
            }
        }
        return null;
    }

    private Integer[][] oneRandomMinionAroundOwnHero(Battle battle, int id) {
        int[] a = battle.getPosition(battle.getEnemyHero().getId());
        int[][] b = new int[8][2];
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                if (Math.abs(a[0] - i) > 1) continue;
                if (Math.abs(a[1] - j) > 1) continue;
                Cell cell = Cell.getCellByxy(i,j);
                if (cell.getInsideCard() == null) continue;
                if (cell.getInsideCard() instanceof Hero) continue;
                if (cell.getInsideCard().getId() == id) continue;
                b[index][0] = i;
                b[index][1] = j;
                index++;
            }
        }
        int random = new Random().nextInt(index);
        Integer[][] c = new Integer[1][2];
        c[0][0] = b[random][0];
        c[0][1] = b[random][1];
        return c;
    }

    public void increaseHP(int number) {
        this.healthPoint+=number;
    }

    public void decreaseHP(int number) {
        this.healthPoint -=number;
    }

    public void increaseAP(int number) {
        this.attackPower+=number;
    }

    public void decreaseAP(int number) {
        this.attackPower-=number;
    }
}
