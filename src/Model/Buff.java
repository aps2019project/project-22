package Model;

public class Buff extends Effect {
    private boolean limitedTime;
    private String type;

    public void setLimitedTime(boolean position) {
        limitedTime = position;
    }

    public boolean isLimitedTime() {
        return limitedTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void applyBuff() {
        switch (type) {
            case "Holy buff":
                holyBuff();
                break;
            case "Power buff":
                powerBuff();
                break;
            case "Posion buff":
                posionBuff();
                break;
            case "Weakness buff":
                weaknessBuff();
                break;
            case "Stun buff":
                stunBuff();
                break;
            case "Disarm buff":
                disarmBuff();
                break;
        }

    }

    private void posionBuff() {
    }

    private void stunBuff() {
    }

    private void weaknessBuff() {
    }

    private void disarmBuff() {
    }

    private void powerBuff() {
    }

    private void holyBuff() {
    }
}
