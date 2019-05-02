package Model;

public class Flag  {
    private Card card;
    private Cell cell;
    private boolean isUsed = false;


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }



    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }


    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public void useBy(Card card) {
        this.setCard(card);
        this.setCell( null);
        this.setUsed( true);
    }
    public void byACertainCell(Cell cell) {
        this.setCell( cell);
        this.setCard(null);
        this.setUsed( false);
    }

}
