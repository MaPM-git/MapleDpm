package org.mapledpmlab.type.skill.attackskill.zero;

public class MoonStrike extends AssistSkill implements AlphaSkill {
    public MoonStrike() {
        this.setName("문 스트라이크");
        this.setAttackCount(6L);
        this.setDamage(191.0);
        //this.setDelayByAttackSpeed(510L);
        this.setDelay(330L);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(390L);
    }
}
