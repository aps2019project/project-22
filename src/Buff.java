package Model;

public class Buff extends Effect {
    private boolean limitedTime;
    private String type;

    public void setLimitedTime(boolean position){
        limitedTime=position;
    }

    public boolean isLimitedTime() {
        return limitedTime;
    }

    public void setType(String type) {
        this.type=type;
    }

    public String getType() {
        return type;
    }
    public void applyBuff(){
        if(type.equals("Holy Buff")){

        } else if()

    }
}
