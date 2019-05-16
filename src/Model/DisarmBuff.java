package Model;

public class DisarmBuff extends Buff {
    public DisarmBuff(int number, int turns, TimeOfBuff timeOfBuff) {
        super(number, turns, TypeOfBuff.NEGATIVE, timeOfBuff);
    }

    @Override
    public void applyBuff(Spell spellCard) {
        spellCard.setPermissionToCounterAttack(false);
    }
}
