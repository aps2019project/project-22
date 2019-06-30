package Model;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

import java.awt.*;
import java.util.ArrayList;

public class Shop {
    private static int newId = 90;
    private static ArrayList<Hero> heroes = new ArrayList<>();
    private static ArrayList<Spell> spells = new ArrayList<>();
    private static ArrayList<Minion> minions = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<Card> cards = new ArrayList<>();

    static {
        MakeHero.make();
        MakeSpell.make();
        MakeMinions.make();
        MakeItems.make();
    }

    public static void sell(String idS, Account account,Group root) {
        Label label = new Label("this card/item isn't in your collection.");
        label.setFont(Font.font(23));
        Label sell = new Label("sold");
        sell.setFont(Font.font(23));
        sell.relocate(419,196);
        label.relocate(419,196);
        try {
            int id = Integer.parseInt(idS);
            if (!account.getCollection().searchById(id)) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        root.getChildren().addAll(label);
                    }
                });
                return;
            }
            account.increaseMoney(account.getCollection().getPriceById(id));
            if (account.getCollection().searchItem(id) != null) {
                items.add(account.getCollection().searchItem(id));
                account.getCollection().removeItem(id);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        root.getChildren().addAll(sell);
                    }
                });
            } else if (account.getCollection().searchHero(id) != null) {
                heroes.add(account.getCollection().searchHero(id));
                cards.add(account.getCollection().searchHero(id));
                account.getCollection().removeHero(id);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        root.getChildren().addAll(sell);
                    }
                });
            } else if (account.getCollection().searchSpell(id) != null) {
                spells.add(account.getCollection().searchSpell(id));
                cards.add(account.getCollection().searchSpell(id));
                account.getCollection().removeSpell(id);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        root.getChildren().addAll(sell);
                    }
                });
            } else if (account.getCollection().searchMinion(id) != null) {
                minions.add(account.getCollection().searchMinion(id));
                cards.add(account.getCollection().searchMinion(id));
                account.getCollection().removeMinion(id);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        root.getChildren().addAll(sell);
                    }
                });
            }
        }catch (Exception e){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    root.getChildren().addAll(label);
                }
            });
        }

    }

    private static String getNameById(int id) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getId() == id)
                return cards.get(i).getName();
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id)
                return items.get(i).getName();
        }
        return "";
    }


    private static int searchById(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return id;
            }
        }
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getId() == id) {
                return id;
            }
        }
        return -1;
    }

    public static int searchByName(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                return items.get(i).getId();
            }
        }
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getName().equals(name)) {
                return cards.get(i).getId();
            }
        }
        return -1;
    }

    public static int getPriceByName(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                return items.get(i).getPrice();
            }
        }
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getName().equals(name)) {
                return cards.get(i).getPrice();
            }
        }
        return -1;
    }

    public static Item searchItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                return items.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public static ArrayList<Spell> getSpells() {
        return spells;
    }

    public static ArrayList<Minion> getMinions() {
        return minions;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static int getNewId() {
        newId++;
        return newId;
    }

    public static void addMinion(Minion newMinion) {
        minions.add(newMinion);
        cards.add(newMinion);
    }

    public static void addHero(Hero newHero) {
        heroes.add(newHero);
        cards.add(newHero);
    }

    public static void addItem(Item item) {
        Item newItem = new Item(getNewId(), item.getName(), item.getPrice(), item.getDescription());
        items.add(newItem);
    }

    public static void addSpell(Spell spell) {
        Spell newSpell = new Spell(getNewId(), spell.getName(), spell.getPrice(), spell.getManaPoint(),
                spell.getTargetPointName(), spell.getDescription());
        spells.add(newSpell);
        cards.add(newSpell);
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static String buy(String name, Account account, ImageView[] iv, Label[] label, int num, Group root) {
        if (searchByName(name) == -1) {
            return ("this card/item isn't in shop.");
        }
        if (getPriceByName(name) > account.getMoney()) {
            return ("Insufficient money");
        }
        if (account.getCollection().getItems().size() >= 3 && searchItem(name) != null) {
            return("your items is full.");
        }
        if (searchItem(name) != null) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    root.getChildren().remove(label[num]);
                    root.getChildren().remove(iv[num]);
                }
            });
            account.decreaseMoney(searchItem(name).getPrice());
            account.getCollection().addItem(searchItem(name));
            removeItem(name);

        } else if (searchMinion(name) != null) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    root.getChildren().remove(iv[num]);
                    root.getChildren().remove(label[num]);
                }
            });
            account.decreaseMoney(searchMinion(name).getPrice());
            account.getCollection().addMinionToCollection(searchMinion(name));
            removeMinion(name);
            removeCards(name);
        } else if (searchSpell(name) != null) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    root.getChildren().remove(iv[num]);
                    root.getChildren().remove(label[num]);
                }
            });
            account.decreaseMoney(searchSpell(name).getPrice());
            account.getCollection().addSpellToCollection(searchSpell(name));
            removeSpell(name);
            removeCards(name);

        } else if (searchHero(name) != null) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    root.getChildren().remove(iv[num]);
                    root.getChildren().remove(label[num]);
                }
            });
            account.decreaseMoney(searchHero(name).getPrice());
            account.getCollection().addHeroToCollection((searchHero(name)));
            removeHero(name);
            removeCards(name);

        }
        return "Successful.";
    }

    private static void removeCards(String name) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getName().equals(name)) {
                cards.remove(i);
                return;
            }
        }
    }

    private static void removeHero(String name) {
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getName().equals(name)) {
                heroes.remove(i);
                return;
            }
        }
    }

    private static Hero searchHero(String name) {
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getName().equals(name)) {
                return heroes.get(i);
            }
        }
        return null;
    }

    private static void removeSpell(String name) {
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getName().equals(name)) {
                spells.remove(i);
                return;
            }
        }
    }

    private static Spell searchSpell(String name) {
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getName().equals(name)) {
                return spells.get(i);
            }
        }
        return null;
    }

    private static void removeMinion(String name) {
        for (int i = 0; i < minions.size(); i++) {
            if (minions.get(i).getName().equals(name)) {
                minions.remove(i);
                return;
            }
        }
    }

    private static void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
                return;
            }
        }
    }

    private static Minion searchMinion(String name) {
        for (int i = 0; i < minions.size(); i++) {
            if (minions.get(i).getName().equals(name)) {
                return minions.get(i);
            }
        }
        return null;
    }

    public static void showAllCardsAndItems() {
        int number = 1;
        System.out.println("Heroes :");
        for (int i = 0; i < Shop.getHeroes().size(); i++) {
            System.out.println("\t" + number + " : Name : " + Shop.getHeroes().get(i).getName() + " - AP : " +
                    Shop.getHeroes().get(i).getAttackPower() + " - HP : " + Shop.getHeroes().get(i).
                    getHealthPoint() + " - Class : " + Shop.getHeroes().get(i).getTypeOfAttack() +
                    " - Special power: " + "attack" + " - price: " + Shop.getHeroes().get(i).getPrice());
            number++;
        }
        number = 1;
        System.out.println("Items :");
        for (int i = 0; i < Shop.getItems().size(); i++) {
            System.out.println("\t" + number + " : Name : " + Shop.getItems().get(i).getName() + " Desc: " +
                    Shop.getItems().get(i).getDescription() + " - price: " + Shop.getItems().get(i).getPrice());
            number++;
        }
        number = 1;
        System.out.println("Cards :");
        for (int i = 0; i < Shop.getSpells().size(); i++) {
            System.out.println("\t" + number + " : Type : Spell - Name : " + Shop.getSpells().get(i).getName() +
                    " - MP : " + Shop.getSpells().get(i).getManaPoint() + " - " +
                    Shop.getSpells().get(i).getDescription() + " - price: " + Shop.getSpells().get(i).getPrice());
            number++;
        }
        for (int i = 0; i < Shop.getMinions().size(); i++) {
            System.out.println("\t" + number + " : Type : Minion - Name : " + Shop.getMinions().get(i).getName()
                    + " - Class: " + Shop.getMinions().get(i).getTypeOfAttack() + " - AP : " + Shop.
                    getMinions().get(i).getAttackPower() + " - HP : " + Shop.getMinions().get(i).getHealthPoint()
                    + " - MP : " + Shop.getMinions().get(i).getManaPoint() + " - Special power : " +
                    Shop.getMinions().get(i).getSpecialPower() + " - price: " + Shop.getMinions().get(i).getPrice());
            number++;
        }
    }
}