package com.company;

public class Agility extends Character implements SkillDamageCalculation {
    private int evasion;
    public Agility(int id,String name, String _class, int evasion){
        super(id,name, _class, evasion);
        this.setAgilityAmount(evasion);
    }

    public int getAgilityAmount() {
        return evasion;
    }

    public void setAgilityAmount(int agilityAmount) {
        this.evasion = agilityAmount;
    }

    @Override
    public int calculation() {
        return evasion * 8;
    }
}
