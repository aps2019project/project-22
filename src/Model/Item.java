package Model;

import java.util.ArrayList;

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


    public Item(int id, String name, int price,String description) {
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


    public void readFromFile() {

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
