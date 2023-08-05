package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PiercingCyclone extends AttackSkill {
    public PiercingCyclone() {
        this.setName("피어스 사이클론");
        this.setDamage(1040.0);
        this.setAttackCount(12L);
        this.setCooldown(180.0);
        this.addIgnoreDefenseList(50L);
        this.setRelatedSkill(new PiercingCycloneFinish());
        this.setApplyFinalAttack(true);
        this.setInterval(215L);
        this.setDotDuration(4500L);
        this.setLimitAttackCount(20L);
        this.setFinalDamage(1.6);   // 코어 강화
    }
}
