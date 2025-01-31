package org.mapledpmlab.type.skill.attackskill.zero;

public class FrontSlash extends AssistSkill implements BetaSkill {
    public FrontSlash() {
        this.setName("프론트 슬래시");
        this.setAttackCount(6L);
        this.setDamage(346.0);
        //this.setDelayByAttackSpeed(840L);
        this.setDelay(450L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(630L);
    }
}
