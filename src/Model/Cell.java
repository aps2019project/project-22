package Model;

import java.util.ArrayList;

public class Cell {

    private static int[] rowsOfCells=new int[5];
    private static int[] columnsOfCells=new int[9];
    private ArrayList<Spell> spells;
    private ArrayList<Integer> effectTime;
    private int x;
    private int y;
    private Flag flag;
    private Card cardInside;
    private static ArrayList<Cell> cells;
    private Minion minion;
    private  Hero hero;

    public Minion getMinion() {
        return minion;
    }
    public static ArrayList<Cell> getCells() {
        return cells;
    }
    public static void addCells(Cell cell) {
        cells.add(cell);
    }
    public void setMinion(Minion minion) {
        this.minion = minion;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Card getInsideCard() {
        return cardInside;
    }

    public void setInsideCard(Card insideCard) {
        this.cardInside = insideCard;
    }
    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }
    public boolean isEmpty() {
        return this.getInsideCard() == null;
    }

    public boolean put(Card card) {
        if(this.isEmpty() || card == null)
            return false;
        this.setInsideCard(card);
        if(this.getFlag() != null) {
            this.getFlag().useBy(card);

        }
        return true;
    }
    public Card pick() {
        Card card = this.getInsideCard();
        this.setInsideCard(null);
        return card;
    }


    public static void setRowsOfCells(int[] rowsOfCells) {
        Cell.rowsOfCells = rowsOfCells;
    }

    public static int[] getRowsOfCells() {
        return rowsOfCells;
    }

    public static void setColumnsOfCells(int[] columnsOfCells) {
        Cell.columnsOfCells = columnsOfCells;
    }

    public static int[] getColumnsOfCells() {
        return columnsOfCells;
    }



    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }
    public ArrayList<Spell> getSpells() {
        return spells;
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

    public void power(){

    }
    public void addSpell(Spell spell){
        spells.add(spell);
    }
    public void deleteSpell(){


    }
}
