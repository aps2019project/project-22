package Model;

import java.util.ArrayList;

public class Card {
    private static ArrayList<Card> cards;
    private String type;
    private int price;
    private int row;
    private int column;


    public void move(int x, int y, int maxDistance) {
        int distance;
        distance = Math.abs(x - row) + Math.abs(y - column);
        if (distance <= maxDistance) {
            setRow(x);
            setColumn(y);
            //tu view bge mishe o shodo ina.
        } else {
            // tu view bege nmishe
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }


    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    private int cardId;

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setType() {
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

