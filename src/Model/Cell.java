package Model;

import java.util.ArrayList;

public class Cell {
    private static ArrayList<Cell> cells;
    private int x;
    private int y;
    private Card card;
    private ArrayList<Spell> spells;
    private ArrayList<Integer> effectTime;

    public static ArrayList<Cell> getCells() {
        return cells;
    }

    public static void addCells(Cell cell) {
        cells.add(cell);
    }


    public ArrayList<Integer> getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(ArrayList<Integer> effectTime) {
        this.effectTime = effectTime;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    public void power(){

    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }
    public void addSpell(Spell spell){
        spells.add(spell);
    }
    public void deleteSpell(){

    }
}
