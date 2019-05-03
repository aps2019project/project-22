package Model;

public class PowerBuff extends Buff {
    private TypeOfPowers type;
    public PowerBuff(int number, TypeOfPowers type, int turns, TimeOfBuff buffTImeType){
        super(number, turns, TypeOfBuff.NEGATIVE, buffTImeType);
        this.type = type;
    }
    public TypeOfPowers getType() {
        return type;
    }

    public void setType(TypeOfPowers type) {
        this.type = type;
    }

}
