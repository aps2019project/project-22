package Model;

public class Collectable extends Item {
    private String typeOfCollectableItem;

    public void readFromFileForCollectableItems(){

    }
    public String getTypeOfCollectableItem() {
        return typeOfCollectableItem;
    }

    public void setTypeOfCollectableItem(String typeOfCollectableItem) {
        this.typeOfCollectableItem = typeOfCollectableItem;
    }
}
