package Model;

import java.util.Random;

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

    @Override
    public void applyBuff(Spell spellCard) {
        Random random=new Random(20);
        int rand=random.nextInt();
        if(rand%2==1){
            spellCard.increaseAp(rand);
        }else{
            spellCard.increaseHp(rand);
        }
    }
}
