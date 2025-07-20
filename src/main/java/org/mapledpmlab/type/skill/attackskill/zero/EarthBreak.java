package org.mapledpmlab.type.skill.attackskill.zero;

public class EarthBreak extends AssistSkill implements BetaSkill {
    public EarthBreak() {
        this.setName("어스 브레이크");
        this.setAttackCount(10L);
        this.setDamage(545.0 + 60);
        //this.setDelayByAttackSpeed(1170L);
        this.setDelay(330L);
        this.setAssistDelay(330L);
        this.setRelatedSkill(new EarthBreakShockWave());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(-19.0);
    }
}
