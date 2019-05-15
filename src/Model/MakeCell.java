package Model;

public class MakeCell {
    public static void make() {
        Cell[] cells = new Cell[45];
        int i = 0;
        for (int j = 1; j <= 5; j++) {
            for (int k = 1; k <= 9; k++) {
                cells[i] = new Cell();
                cells[i].setX(j);
                cells[i].setY(k);
                Cell.addCells(cells[i]);
                i++;
            }
        }
    }
}