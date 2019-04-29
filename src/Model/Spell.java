package Model;

import java.util.ArrayList;

public class Spell extends Card {

    private int manaPoint;
    private String description;
    private Effect effect;
    private int disarm;
    private boolean destroyNegativeBuffsOfItSelfAndPosetiveBuffsOfEnemy;

    public boolean isDestroyNegativeBuffsOfItSelfAndPosetiveBuffsOfEnemy() {
        return destroyNegativeBuffsOfItSelfAndPosetiveBuffsOfEnemy;
    }

    public void setDestroyNegativeBuffsOfItSelfAndPosetiveBuffsOfEnemy(boolean destroyNegativeBuffsOfItSelfAndPosetiveBuffsOfEnemy) {
        this.destroyNegativeBuffsOfItSelfAndPosetiveBuffsOfEnemy = destroyNegativeBuffsOfItSelfAndPosetiveBuffsOfEnemy;
    }


    public int getDisarm() {
        return disarm;
    }

    public void setDisarm(int disarm) {
        this.disarm = disarm;
    }


    public Buff getBuff() {
        return buff;
    }

    public void setBuff(Buff buff) {
        this.buff = buff;
    }

    private Buff buff;

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

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

    public void applyEffect() {

    }

    public ArrayList<Card> getTargetCommunityOfCards() {
        return targetCommunityOfCards;
    }

    public ArrayList<Cell> getTargetCommunityOfCells() {
        return targetCommunityOfCells;
    }

    public void setTargetCommunityOfCards(ArrayList<Card> cards) {

    }

    public void setTargetCommunityOfCells(ArrayList<Cell> cells) {

    }
}
