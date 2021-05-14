package com.company;



public class Magic extends Character implements SkillDamageCalculation {
    private int mnRegeneration;
    public Magic(int id, String name, String _class, int mnRegeneration){
        super(id, name, _class, mnRegeneration);
        this.setIntelligenceAmount(mnRegeneration);
    }

    public int getIntelligenceAmount() {
        return mnRegeneration;
    }

    public void setIntelligenceAmount(int intelligenceAmount) {
        this.mnRegeneration = intelligenceAmount;
    }

    @Override
    public int calculation() {
        return mnRegeneration * 5;
    }
}
