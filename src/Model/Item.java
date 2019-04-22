package Model;

public class Item {
    private String description;
    private int price;
    private Effect effect;
    private String typeOfItem;

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

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
