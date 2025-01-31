package org.mapledpmlab.type.skill.attackskill.zero;

public class GigaCrash extends AssistSkill implements BetaSkill {
    public GigaCrash() {
        this.setName("기가 크래시");
        this.setAttackCount(6L);
        this.setDamage(400.0 + 60);
        //this.setDelayByAttackSpeed(630L);
        this.setDelay(420L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(450L);
    }
}
