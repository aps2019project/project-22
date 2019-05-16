package Model;

import java.util.ArrayList;

public class Collection {

    private String name;
    private ArrayList<Item> items = new ArrayList<>(3);
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

    public void save() {
        //save

    }

    public void createDeck(String name) {

    }

    public void deleteDeck(String name) {

    }

    private void add(int id, String name) {

    }

    private void remove(int id, String name) {

    }

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

    public boolean searchById(int id) {
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getId() == id)
                return true;
        }
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getId() == id)
                return true;
        }
        for (int i = 0; i < minions.size(); i++) {
            if (minions.get(i).getId() == id)
                return true;
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id)
                return true;
        }
        return false;
    }

    public int getPriceById(int id) {
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getId() == id) {
                return spells.get(i).getPrice();
            }
        }
        for (int i = 0; i < minions.size(); i++) {
            if (minions.get(i).getId() == id) {
                return minions.get(i).getPrice();
            }
        }
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getId() == id) {
                return heroes.get(i).getPrice();
            }
        }

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return items.get(i).getPrice();
            }
        }
        return -1;
    }

    public Item searchItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id)
                return items.get(i);
        }
        return null;
    }

    public Hero searchHero(int id) {
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getId() == id)
                return heroes.get(i);
        }
        return null;
    }

    public Spell searchSpell(int id) {
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getId() == id)
                return spells.get(i);
        }
        return null;
    }

    public Minion searchMinion(int id) {
        for (int i = 0; i < minions.size(); i++) {
            if (minions.get(i).getId() == id)
                return minions.get(i);
        }
        return null;
    }

    public void removeItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                return;
            }
        }
    }

    public void removeHero(int id) {
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getId() == id) {
                heroes.remove(i);
                return;
            }
        }
    }

    public void removeSpell(int id) {
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getId() == id) {
                spells.remove(i);
                return;
            }
        }
    }

    public void removeMinion(int id) {
        for (int i = 0; i < minions.size(); i++) {
            if (minions.get(i).getId() == id) {
                minions.remove(i);
                return;
            }
        }
    }
}