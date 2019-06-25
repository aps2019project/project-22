package Model;

public class CustomCard extends Card {
    private String targetPointName;
    private Buff buff;
    private String specialPower;
    private boolean specialPowerActivated = false;

    public CustomCard(String name, int type, String targetPointName, Buff buff, int ap, int mp,
                      String typeOfAttack, int range, String specialPower, boolean specialPowerActivated, int price) {
        this.setName(name);
        this.setType(type);
        this.setTargetPointName(targetPointName);
        this.setBuff(buff);
        this.setAttackPower(ap);
        this.setManaPoint(mp);
        this.setTypeOfAttack(typeOfAttack);
        this.setRangeOfAttack(range);
        this.setSpecialPower(specialPower);
        this.setSpecialPowerActivated(specialPowerActivated);
        this.setPrice(price);
        this.setCost(price);
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
}
