package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FrozenOrb extends AttackSkill {
    public FrozenOrb() {
        this.setName("프로즌 오브");
        this.setDamage(428.0);
        this.setAttackCount(1L);
        this.setCooldown(5.0);
        this.setDelayByAttackSpeed(900L);
        this.setDotDuration(5000L);
        this.setInterval(210L);
        this.setLimitAttackCount(20L);
        this.setAddDamage(20L);         // 프로즌 오브-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
