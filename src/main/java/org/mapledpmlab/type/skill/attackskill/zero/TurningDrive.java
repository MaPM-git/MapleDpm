package org.mapledpmlab.type.skill.attackskill.zero;

public class TurningDrive extends AssistSkill implements BetaSkill {
    public TurningDrive() {
        this.setName("터닝 드라이브");
        this.setAttackCount(6L);
        this.setDamage(465.0);
        //this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setDelay(360L);
        this.setAssistDelay(540L);
    }
}
