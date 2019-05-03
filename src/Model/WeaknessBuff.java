package Model;

public class WeaknessBuff extends Buff{
    private TypeOfPowers type;
    public WeaknessBuff(int number, TypeOfPowers type, int turns, TimeOfBuff timeOfBuff){
        super(number, turns, TypeOfBuff.NEGATIVE, timeOfBuff);
        this.type = type;
    }

    public TypeOfPowers getType() {
        return type;
    }

    public void setType(TypeOfPowers type) {
        this.type = type;
    }
}