package org.mapledpmlab.type.skill.attackskill.zero;

public class EarthBreakElectricity extends AssistSkill implements BetaSkill {
    public EarthBreakElectricity() {
        this.setName("어스 브레이크(전기 지역)");
        this.setAttackCount(1L);
        this.setDamage(545.0 + 60);
        this.setDotDuration(5000L);
        this.setInterval(1000L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
