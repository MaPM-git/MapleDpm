package org.mapledpmlab.type.skill.attackskill.zero;

public class RollingCurve extends AssistSkill implements AlphaSkill {
    public RollingCurve() {
        this.setName("롤링 커브");
        this.setAttackCount(12L);
        this.setDamage(600.0);
        //this.setDelayByAttackSpeed(1260L);
        this.setDelay(720L);
        this.setAssistDelay(720L);
        this.setRelatedSkill(new RollingCurveBlade());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setMove(true);
        this.setGaugeCharge(-13.0);
    }
}
