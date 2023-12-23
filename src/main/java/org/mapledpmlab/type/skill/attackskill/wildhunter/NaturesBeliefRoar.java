package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class NaturesBeliefRoar extends AttackSkill {
    public NaturesBeliefRoar() {
        this.setName("네이쳐스 빌리프(포효)");
        this.setAttackCount(14L);
        this.setDamage(9800.0);
        this.setLimitAttackCount(5L);
        this.setDotDuration(1200L);
        this.setInterval(240L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new NaturesBeliefRoarDelay());
    }
}
