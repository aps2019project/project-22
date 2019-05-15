package Model;

import java.util.ArrayList;

public class Cell {

    private static Card[] rowsOfCells = new Card[5];
    private static Card[] columnsOfCells = new Card[9];
    private ArrayList<Spell> spells = new ArrayList<>();
    private ArrayList<Integer> effectTime = new ArrayList<>();
    private int x;
    private int y;
    private boolean flag;
    private Card cardInside;
    private static ArrayList<Cell> cells = new ArrayList<>();
    private Minion minion;
    private Hero hero;

    public static void insertCard(Card card, int x, int y) {
        rowsOfCells[x] = card;
        columnsOfCells[y] = card;
    }

    public void setFlagTrue() {
        flag = true;
    }

    public void setFlagFalse() {
        flag = false;
    }

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

    public boolean getFlag() {
        return flag;
    }

    public void addCard(Card card) {
        cardInside = card;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isEmpty() {
        return this.getInsideCard() == null;
    }

    public boolean put(Card card) {
        if (this.isEmpty() || card == null)
            return false;
        this.setInsideCard(card);

        return true;
    }

    public Card pick() {
        Card card = this.getInsideCard();
        this.setInsideCard(null);
        return card;
    }
    public static Cell getCellByxy(int x, int y) {
        for (Cell cell : cells) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }
        return null;
    }

    public static void setRowsOfCells(Card[] rowsOfCells) {
        Cell.rowsOfCells = rowsOfCells;
    }

    public static Card[] getRowsOfCells() {
        return rowsOfCells;
    }

    public static void setColumnsOfCells(Card[] columnsOfCells) {
        Cell.columnsOfCells = columnsOfCells;
    }

    public static Card[] getColumnsOfCells() {
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

    public void power() {

    }

    public void addSpell(Spell spell) {
        spells.add(spell);
    }
}