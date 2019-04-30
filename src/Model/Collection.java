package Model;

import java.util.ArrayList;

public class Collection {

    private String name;
    private ArrayList<Item> items;
    private ArrayList<Card> cards;

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
        getItems().add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setCards() {

    }

    public ArrayList<Card> getCards() {
        return cards;

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

    private void save() {

    }

    private void createDeck(String name) {

    }

    private void deleteDeck(String name) {

    }

    private void add(int id, String name) {

    }

    private void remove(int id, String name) {

    }

    private void checkValidateDeck(String name) {

    }

    private void help() {

    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}
