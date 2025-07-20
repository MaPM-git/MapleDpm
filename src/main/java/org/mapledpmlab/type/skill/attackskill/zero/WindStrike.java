package org.mapledpmlab.type.skill.attackskill.zero;

public class WindStrike extends AssistSkill implements AlphaSkill {
    public WindStrike() {
        this.setName("윈드 스트라이크");
        this.setAttackCount(8L);
        this.setDamage(355.0 + 60);
        this.setDelay(240L);
        this.setAssistDelay(240L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(-19.0);
    }
}
