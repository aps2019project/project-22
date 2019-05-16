package Model;

public class PoisionBuff extends Buff {
    public PoisionBuff(int number, int turns, TimeOfBuff timeOfBuff) {
        super(number, turns, TypeOfBuff.NEGATIVE, timeOfBuff);
    }

    @Override
    public void applyBuff(Spell spellCard) {
        spellCard.decreaseHP(1);
    }
}
