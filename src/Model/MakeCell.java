package Model;

public class MakeCell {
    public static void make(){
        Cell[] cells = new Cell[45];
        for (int i = 0; i < 45; i++) {
            cells[i].setX(i);
            cells[i].setY(i);
            Cell.addCells(cells[i]);
        }
    }
}
