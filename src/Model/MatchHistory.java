package Model;

public class MatchHistory {
    private int time;
    private int numberOfWins;
    private String name;

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

}
