package Model;

import java.util.ArrayList;
import java.util.Random;

public class Item {
    public static ArrayList<Item> items = new ArrayList<>();
    private String description;
    private String name;
    private int price;
    private int id;
    private String typeOfItem;
    private String typeOfCollectableItem;
    private Card cardOfUsableItem;
    private ArrayList<Item> itemsOfUsableItem = new ArrayList<>();


    public void item1(int turn, Player player) {
        if (turn == 1) {
            player.setMana(player.getMana() + 1);
        }
        if (turn == 2) {
            player.setMana(player.getMana() + 1);
        }
        if (turn == 3) {
            player.setMana(player.getMana() + 1);
        }
    }

    public void item2(Hero hero) {
        hero.setHowManyHolyBuff(hero.getHowManyHolyBuff() + 12);
    }

    public void item3(Card card) {
        card.setDisarmFor1TurnTrue();
    }

    public void item4(Player player) {
        Random rand = new Random();
        int n = rand.nextInt(player.getCardsInTheFiled().size());
        player.getCardsInTheFiled().get(n).setHealthPoint(player.getCardsInTheFiled().get(n).getHealthPoint() + 6);
    }

    public void item6(Hero hero) {
        if (hero.getTypeOfAttack().matches("ranged") || hero.getTypeOfAttack().matches("hybrid")) {
            hero.setAttackPower(hero.getAttackPower() - 2);
        }
    }

    public void item5(Player player) {
        while (true) {
            Random rand = new Random();
            int n = rand.nextInt(player.getCardsInTheFiled().size());
            if (player.getCardsInTheFiled().get(n).getTypeOfAttack().matches("ranged") || player.getCardsInTheFiled().get(n).getTypeOfAttack().matches("hybrid")) {
                player.getCardsInTheFiled().get(n).setAttackPower(player.getCardsInTheFiled().get(n).getAttackPower() + 2);
                break;
            }
        }
    }

    public void item7(Player player) {
        while (true) {
            Random rand = new Random();
            int n = rand.nextInt(player.getCardsInTheFiled().size());
            if (player.getCardsInTheFiled().get(n).getTypeOfAttack().matches("ranged") || player.getCardsInTheFiled().get(n).getTypeOfAttack().matches("hybrid")
                    && player.getCardsInTheFiled().get(n).getId() <= 40) {
                Minion temp = (Minion) player.getCardsInTheFiled().get(n);
                temp.setAttackPower(temp.getAttackPower() + 3);
                temp.setSumOfPossetiveAttack(3);
                break;
            }
        }
    }

    public void item9(Player player) {
        while (true) {
            Random rand = new Random();
            int n = rand.nextInt(player.getCardsInTheFiled().size());
            if (player.getCardsInTheFiled().get(n).getId() <= 40) {
                player.getCardsInTheFiled().get(n).setHowManyHolyBuff(player.getCardsInTheFiled().get(n).getHowManyHolyBuff() + 12);
                player.getCardsInTheFiled().get(n).setHowLongItem9(player.getCardsInTheFiled().get(n).getHowLongItem9() + 1);
                break;
            }
        }
    }

    public void item10(Player player) {
        while (true) {
            Random rand = new Random();
            int n = rand.nextInt(player.getCardsInTheFiled().size());
            if (player.getCardsInTheFiled().get(n).getId() <= 40) {
                Minion temp = (Minion) player.getCardsInTheFiled().get(n);
                temp.setItem10True();
                break;
            }
        }
    }

    public void item11(Player player) {
        Random rand = new Random();
        int n = rand.nextInt(player.getCardsInTheFiled().size());
        player.getCardsInTheFiled().get(n).setAttackPower(player.getCardsInTheFiled().get(n).getAttackPower() + 2);
    }

    public void item13(Player player) {
        Random rand = new Random();
        int n = rand.nextInt(player.getCardsInTheFiled().size());
        player.getCardsInTheFiled().get(n).setAttackPower(player.getCardsInTheFiled().get(n).getAttackPower() + 2);
    }

    public void item14(Player player) {
        player.setMana(player.getMana() + 1);
    }

    public void item20(Player player) {
        for (int i = 0; i < player.getCardsInTheFiled().size(); i++) {
            if (player.getCardsInTheFiled().get(i).getTypeOfAttack().matches("melee")) {
                player.getCardsInTheFiled().get(i).setAttackPower(player.getCardsInTheFiled().get(i).getAttackPower() + 5);
            }
        }
    }

    public Item(int id, String name, int price, String description) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setDescription(description);
        if (price == -1) {
            this.setTypeOfItem("Collectable");
        } else {
            this.setTypeOfItem("Usable");
        }
    }

    public void showItemInfo() {
        System.out.println("name : "+this.name+" id : "+this.id+" description : "+description );
    }

    public static void addItem(Item item) {
        items.add(item);
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public void applyType() {

    }

    public void applyEffect() {

    }

    public void applyItem(String typeOfItem) {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    public void setTypeOfItem(String typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfCollectableItem() {
        return typeOfCollectableItem;
    }

    public void setTypeOfCollectableItem(String typeOfCollectableItem) {
        this.typeOfCollectableItem = typeOfCollectableItem;
    }

    public Card getCardOfUsableItem() {
        return cardOfUsableItem;
    }

    public void setCardOfUsableItem(Card cardOfUsableItem) {
        this.cardOfUsableItem = cardOfUsableItem;
    }

    public ArrayList<Item> getItemsOfUsableItem() {
        return itemsOfUsableItem;
    }

    public void setItemsOfUsableItem(ArrayList<Item> itemsOfUsableItem) {
        this.itemsOfUsableItem = itemsOfUsableItem;
    }
}
