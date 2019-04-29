package Model;

import java.util.ArrayList;

public class Cell {
    private static int[] rowsOfCells=new int[5];
    private static int[] columnsOfCells=new int[9];
    private ArrayList<Spell> spells;
    private ArrayList<Integer> effectTime;
    private int x;
    private int y;
    private Card card;

    public static int[] getRowsOfCells() {
        return rowsOfCells;
    }

    public static void setRowsOfCells(int[] rowsOfCells) {
        Cell.rowsOfCells = rowsOfCells;
    }

    public static int[] getColumnsOfCells() {
        return columnsOfCells;
    }

    public static void setColumnsOfCells(int[] columnsOfCells) {
        Cell.columnsOfCells = columnsOfCells;
    }



    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
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
