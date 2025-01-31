package org.mapledpmlab.type.skill.attackskill.zero;

public class UpperSlash extends AssistSkill implements BetaSkill {
    public UpperSlash() {
        this.setName("어퍼 슬래시");
        this.setAttackCount(6L);
        this.setDamage(307.0);
        //this.setDelayByAttackSpeed(930L);
        this.setDelay(390L);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(720L);
    }
}
