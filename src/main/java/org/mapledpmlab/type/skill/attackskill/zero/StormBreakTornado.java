package org.mapledpmlab.type.skill.attackskill.zero;

public class StormBreakTornado extends AssistSkill {
    public StormBreakTornado() {
        this.setName("스톰 브레이크(소용돌이)");
        this.setAttackCount(4L);
        this.setDamage(535.0 + 60);
        this.setDotDuration(1000L);
        this.setInterval(500L);
        this.setLimitAttackCount(2L);
        this.setRelatedSkill(new StormBreakElectricity());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}

