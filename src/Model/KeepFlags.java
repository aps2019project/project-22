package Model;

public class KeepFlags {
    int finishTime;
    int howLongFlagsHasBeenKeptByPlayer1 = 0;
    int howLongFlagsHasBeenKeptByPlayer2 = 0;

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void setHowLongFlagsHasBeenKeptByPlayer1() {
        this.howLongFlagsHasBeenKeptByPlayer1++;
    }

    public void setHowLongFlagsHasBeenKeptByPlayer2() {
        this.howLongFlagsHasBeenKeptByPlayer2++;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void resetPlayer1Time() {
        howLongFlagsHasBeenKeptByPlayer1 = 0;
    }

    public void resetPlayer2Time() {
        howLongFlagsHasBeenKeptByPlayer2 = 0;
    }

    public int getHowLongFlagsHasBeenKeptByPlayer1() {
        return howLongFlagsHasBeenKeptByPlayer1;
    }

    public int getHowLongFlagsHasBeenKeptByPlayer2() {
        return howLongFlagsHasBeenKeptByPlayer2;
    }
}
