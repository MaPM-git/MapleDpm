package org.mapledpmlab.type.skill.attackskill.zero;

public class StormBreak extends AssistSkill implements AlphaSkill {
    public StormBreak() {
        this.setName("스톰 브레이크");
        this.setAttackCount(10L);
        this.setDamage(475.0 + 60);
        this.setDelay(270L);
        this.setAssistDelay(270L);
        this.setRelatedSkill(new StormBreakTornado());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(-21.0);
    }
}
