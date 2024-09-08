package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PiercingCycloneKeydown extends AttackSkill {
    public PiercingCycloneKeydown() {
        this.setName("피어스 사이클론");
        this.setDamage(800.0);
        this.setAttackCount(8L);
        this.addIgnoreDefenseList(50L);
        this.setRelatedSkill(new PiercingCycloneKeydownDelay());
        this.setApplyFinalAttack(true);
        this.setInterval(140L);
        this.setDotDuration(3640L);
        this.setLimitAttackCount(26L);
        this.setFinalDamage(1.6);   // 코어 강화
    }
}
