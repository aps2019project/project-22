package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Collection {

    private String name;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Hero> heroes = new ArrayList<>();
    private ArrayList<Spell> spells = new ArrayList<>();
    private ArrayList<Minion> minions = new ArrayList<>();

    public int search(String name) {
        int number = 0;
        for (Hero hero : heroes) {
            number++;
            if (hero.getName().equals(name))
                return number;
        }
        for (Item item : items) {
            number++;
            if (item.getName().equals(name))
                return number;
        }
        for (Spell spell : spells) {
            number++;
            if (spell.getName().equals(name))
                return number;
        }
        for (Minion minion : minions) {
            number++;
            if (minion.getName().equals(name))
                return number;
        }
        return -1;
    }

    public void addHeroToCollection(Hero hero) {
        heroes.add(hero);
    }

    public void addSpellToCollection(Spell spell) {
        spells.add(spell);
    }

    public void addMinionToCollection(Minion minion) {
        minions.add(minion);
    }

    public void increaseNumberOfItems() {
        setNumberOfItems(getNumberOfItems() + 1);
    }

    private int numberOfItems;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addItem(Item item) {

        if (items.size() < 3)
            getItems().add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setCards() {

    }

    public void selectDeck(String name) {

    }

//    private String showAllDecks() {
//
//    }

    private void show() {

    }

    private void showDeck(String name) {

    }

//    private int search(String name) {
//
//    }

    public void save() {

    }

    public void createDeck(String name) {

    }

    public void deleteDeck(String name) {

    }

    private void add(int id, String name) {

    }

    private void remove(int id, String name) {

    }

//    private void checkValidateDeck(String name) {
//
//    }

    private void help() {

    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public ArrayList<Minion> getMinions() {
        return minions;
    }
}
