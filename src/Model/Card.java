package Model;

import java.util.ArrayList;

public class Card {
    private static ArrayList<Card> cards;
    protected int id;
    protected int price;
    protected int type; // 0 hero | 1 spell | 2 minion
    protected String name;
    private int row;
    private int column;
    private int numberOfPlayer;

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id){
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public void move(int x, int y, int maxDistance) {
        int distance;
        distance = Math.abs(x - row) + Math.abs(y - column);
        if (distance <= maxDistance) {
            setRow(x);
            setColumn(y);
            //tu view bge mishe o shodo ina.
        }
        else{
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

    public static void addCard(Card card) {
        cards.add(card);
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static Card searchCardByID(int ID){
        for(Card card : Card.cards) {
            if (card.getCardId() == ID)
                return card;
        }
        return null;
    }


    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }
}

