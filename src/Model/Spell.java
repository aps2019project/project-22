package Model;

import java.util.ArrayList;

public class Spell extends Card{

    private int manaPoint;
    private String description;
    private Effect effect;
    private Buff buff;
    private ArrayList<Card> targetCommunityOfCards;
    private ArrayList<Cell> targetCommunityOfCells;

    public void setManaPoint(int manaPoint) {
        this.manaPoint = manaPoint;
    }

    public int getManaPoint() {
        return manaPoint;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public void applyEffect(){

    }
    public ArrayList<Card> getTargetCommunityOfCards(){
        return targetCommunityOfCards;
    }
    public ArrayList<Cell> getTargetCommunityOfCells(){
        return targetCommunityOfCells;
    }
    public void setTargetCommunityOfCards(ArrayList<Card> cards){

    }
    public void setTargetCommunityOfCells(ArrayList<Cell> cells){

    }


}
