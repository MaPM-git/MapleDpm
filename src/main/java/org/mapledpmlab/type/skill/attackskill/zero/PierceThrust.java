package org.mapledpmlab.type.skill.attackskill.zero;

public class PierceThrust extends AssistSkill implements AlphaSkill {
    public PierceThrust() {
        this.setName("피어스 쓰러스트");
        this.setAttackCount(6L);
        this.setDamage(170.0);
        this.setDelay(300L);
        this.setAssistDelay(300L);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(-5.0);
    }
}
