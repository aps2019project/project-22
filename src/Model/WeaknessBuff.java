package Model;

import java.util.Random;

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

    @Override
    public void applyBuff(Spell spellCard) {
        Random random=new Random(20);
        int rand=random.nextInt();
        if(rand%2==0){
            spellCard.decreaseAp(rand);
        }else{
            spellCard.decreaseHp(rand);
        }
    }
}