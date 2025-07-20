package org.mapledpmlab.type.skill.attackskill.zero;

public class GigaCrash extends AssistSkill implements BetaSkill {
    public GigaCrash() {
        this.setName("기가 크래시");
        this.setAttackCount(6L);
        this.setDamage(360.0 + 60);
        this.setDelay(240L);
        this.setAssistDelay(240L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(-15.0);
    }
}
