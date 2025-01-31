package org.mapledpmlab.type.skill.attackskill.zero;

public class WindStrike extends AssistSkill implements AlphaSkill {
    public WindStrike() {
        this.setName("윈드 스트라이크");
        this.setAttackCount(8L);
        this.setDamage(400.0 + 30);
        //this.setDelayByAttackSpeed(810L);
        this.setDelay(480L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(630L);
    }
}
