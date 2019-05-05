package Model;

public class MatchHistory {
    private int time;
    private int numberOfWins;
    private String nameOfEnemy;
    private boolean isWin;

    public void setTime(int number) {
        this.time = number;
    }

    public void setNumberOfWins(int number) {
        this.numberOfWins = number;
    }


    public int getTime() {
        return time;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }


    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public String getNameOfEnemy() {
        return nameOfEnemy;
    }

    public void setNameOfEnemy(String nameOfEnemy) {
        this.nameOfEnemy = nameOfEnemy;
    }
}
