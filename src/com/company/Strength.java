package com.company;


public class Strength extends Character implements SkillDamageCalculation {
    private int hpRegeneration;
    public Strength(int id, String name, String _class, int hpRegeneration) {
        super(id, name, _class, hpRegeneration);
        this.setStrengthAmount(hpRegeneration);
    }

    public int getStrengthAmount() {
        return hpRegeneration;
    }

    public void setStrengthAmount(int strengthAmount) {
        this.hpRegeneration = strengthAmount;
    }

    @Override
    public int calculation() {
        return  hpRegeneration * 10;
    }
}
