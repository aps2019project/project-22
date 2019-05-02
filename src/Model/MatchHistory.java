package Model;

public class MatchHistory {
    private int time;
    private int numberOfWins;
    private String name;
    private boolean isWin;

    public void setTime(int number) {
        this.time = number;
    }

    public void setNumberOfWins(int number) {
        this.numberOfWins = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public String getName() {
        return name;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }
}
