package org.mapledpmlab.type.skill.attackskill.zero;

public class EarthBreakShockWave extends AssistSkill implements BetaSkill {
    public EarthBreakShockWave() {
        this.setName("어스 브레이크(충격파)");
        this.setAttackCount(10L);
        this.setDamage(455.0 + 30);
        this.setDelayByAttackSpeed(390L);
        this.setAssistDelay(390L);
        this.setRelatedSkill(new EarthBreakElectricity());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
