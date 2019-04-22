package Model;

import java.util.ArrayList;

public class Card {
    private static ArrayList<Card> cards;
    private String type;
    private int price;

    public void addCard(Card card){
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    public void setType(){
        //enum
    }

    public String getType() {
        return type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

