package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class StormBreakTornado extends AttackSkill {
    public StormBreakTornado() {
        this.setName("스톰 브레이크(소용돌이)");
        this.setAttackCount(4L);
        this.setDamage(535.0);
        this.setDotDuration(3000L);
        this.setInterval(500L);
        this.setRelatedSkill(new StormBreakElectricity());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}

