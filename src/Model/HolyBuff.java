package Model;

public class HolyBuff extends Buff{
    public HolyBuff(int number, int turns, TimeOfBuff timeOfBuff) {
        super(number, turns, TypeOfBuff.POSITIVE, timeOfBuff);
    }
}
