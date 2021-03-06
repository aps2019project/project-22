package Model;

public class StunBuff extends Buff {
    public StunBuff(int number, int turns, TimeOfBuff timeOfBuff) {
        super(number, turns, TypeOfBuff.NEGATIVE, timeOfBuff);
    }

    @Override
    public void applyBuff(Spell spellCard) {
        spellCard.setPermissionToAttackOrMove(false);
    }
}
