package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class RoarOfDemonSword extends GaugeAttackSkill {
    public RoarOfDemonSword() {
        this.setName("레퀴엠(마검의 포효)");
        this.setDotDuration(2640L);
        this.setInterval(440L);
        this.setLimitAttackCount(6L);
        this.setAttackCount(14L);
        this.setDamage(9600.0);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setAddDamage(50L);
        this.setRelatedSkill(new RoarOfDemonSwordDelay());
        this.setApplyFinalAttack(true);
    }
}
