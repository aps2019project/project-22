package Model;

public abstract class Buff {

    private int friendOrEnemy;
    private  int delay;
    private  String effectValue;
    private String type;
    private Spell spellCard;
    private String nameOfBuff;
    protected int number;
    protected int turns;
    protected TypeOfBuff typeOfBuff;
    protected TimeOfBuff timeOfBuff;

    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public TypeOfBuff getTypeOfBuff() {
        return typeOfBuff;
    }

    public void setTypeOfBuff(TypeOfBuff typeOfBuff) {
        this.typeOfBuff = typeOfBuff;
    }

    public TimeOfBuff getTimeOfBuff() {
        return timeOfBuff;
    }

    public void setTimeOfBuff(TimeOfBuff timeOfBuff) {
        this.timeOfBuff = timeOfBuff;
    }

    public Buff(int number, int turns, TypeOfBuff buffType, TimeOfBuff buffTImeType) {
        this.number = number;
        this.turns = turns;
        this.typeOfBuff = buffType;
        this.timeOfBuff = buffTImeType;
    }

    public Buff(String name,String effectValue, int last, String buffType, int delay,int friendOrEnemy) {
        this.name=name;
        this.effectValue=effectValue;
        this.turns = last;
        this.type = buffType;
        this.delay =delay;
        this.friendOrEnemy=friendOrEnemy;
    }

    public abstract void applyBuff(Spell spellCard);

    public void decrementTurns() {
        this.setTurns(this.turns--);
    }

    public String getNameOfBuff() {
        return nameOfBuff;
    }

    public void setNameOfBuff(String nameOfBuff) {
        this.nameOfBuff = nameOfBuff;
    }

    public Spell getSpellCard() {
        return spellCard;
    }

    public void setSpellCard(Spell spellCard) {
        this.spellCard = spellCard;
    }

    public String getEffectValue() {
        return effectValue;
    }

    public void setEffectValue(String effectValue) {
        this.effectValue = effectValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getFriendOrEnemy() {
        return friendOrEnemy;
    }

    public void setFriendOrEnemy(int friendOrEnemy) {
        this.friendOrEnemy = friendOrEnemy;
    }
}