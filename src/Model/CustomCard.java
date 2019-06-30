package Model;

public class CustomCard extends Card {
    private String targetPointName;
    private Buff buff;
    private String specialPower;
    private Spell spell;
    private boolean specialPowerActivated = false;

    public CustomCard(String name, int type, String targetPointName, Buff buff, int ap, int hp,
                      String typeOfAttack, int range, String specialPower, String specialPowerActivated, int price, Spell spell) {
        this.setName(name);
        this.setType(type);
        this.setId(spell.id);
        this.setTargetPointName(targetPointName);
        this.setBuff(buff);
        this.setAttackPower(ap);
        this.setHealthPoint(hp);
        this.setTypeOfAttack(typeOfAttack);
        this.setRangeOfAttack(range);
        this.setSpecialPower(specialPower);
        if (specialPowerActivated.equals("true"))
            this.setSpecialPowerActivated(true);
        this.setPrice(price);
        this.setCost(price);
        this.setSpell(spell);
    }

    public String getTargetPointName() {
        return targetPointName;
    }

    public void setTargetPointName(String targetPointName) {
        this.targetPointName = targetPointName;
    }

    public Buff getBuff() {
        return buff;
    }

    public void setBuff(Buff buff) {
        this.buff = buff;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }

    public boolean isSpecialPowerActivated() {
        return specialPowerActivated;
    }

    public void setSpecialPowerActivated(boolean specialPowerActivated) {
        this.specialPowerActivated = specialPowerActivated;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }
}
