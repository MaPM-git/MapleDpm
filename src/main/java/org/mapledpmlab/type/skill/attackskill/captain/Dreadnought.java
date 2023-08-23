package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Dreadnought extends AttackSkill {
    public Dreadnought() {
        this.setName("드레드노트");
        this.setDamage(7200.0);
        this.setAttackCount(10L);
        this.setCooldown(360.0);
        this.setApplyFinalAttack(true);
        this.setDotDuration(4740L);
        this.setInterval(430L);
        this.setLimitAttackCount(11L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new DreadnoughtDelay());
    }
}
