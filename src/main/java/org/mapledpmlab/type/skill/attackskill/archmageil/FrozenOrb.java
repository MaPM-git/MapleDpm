package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FrozenOrb extends AttackSkill {
    public FrozenOrb() {
        this.setName("프로즌 오브");
        this.setDamage(224.0);
        this.setAttackCount(1L);
        this.setCooldown(5.0);
        this.setDotDuration(5000L);
        this.setInterval(210L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new FrozenOrbDelay());
        this.setApplyFinalAttack(true);
    }
}
