package org.mapledpmlab.type.skill.attackskill.zero;

public class ShadowStrike extends AssistSkill implements AlphaSkill {
    public ShadowStrike() {
        this.setName("쉐도우 스트라이크");
        this.setAttackCount(8L);
        this.setDamage(331.0);
        this.setDelay(270L);
        this.setAssistDelay(270L);
        this.setRelatedSkill(new ShadowStrikeBlade());
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(-7.0);
    }
}
