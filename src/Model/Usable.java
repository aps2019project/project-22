package Model;

import java.util.AbstractList;

public class Usable extends Item {
private Card card;
private AbstractList<Item> items;

    public AbstractList<Item> getItems() {
        return items;
    }

    public void setItems(AbstractList<Item> items) {
        this.items = items;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
