package Model;

public class CollectFlags {
    int numberOfAllFlags;
    int numberOfCollectedFlagsByPlayer1 = 0;
    int numberOfCollectedFlagsByPlayer2 = 0;

    public int getNumberOfAllFlags() {
        return numberOfAllFlags;
    }

    public void setNumberOfAllFlags(int numberOfAllFlags) {
        this.numberOfAllFlags = numberOfAllFlags;
    }

    public int getNumberOfCollectedFlagsByPlayer1() {
        return numberOfCollectedFlagsByPlayer1;
    }

    public void setNumberOfCollectedFlagsByPlayer1() {
        this.numberOfCollectedFlagsByPlayer1++;
    }

    public int getNumberOfCollectedFlagsByPlayer2() {
        return numberOfCollectedFlagsByPlayer2;
    }

    public void setNumberOfCollectedFlagsByPlayer2() {
        this.numberOfCollectedFlagsByPlayer2++;
    }
}
