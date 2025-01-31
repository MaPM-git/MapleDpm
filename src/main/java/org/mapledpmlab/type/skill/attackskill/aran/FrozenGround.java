package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FrozenGround extends AttackSkill {
    public FrozenGround() {
        this.setName("프로즌 그라운드");
        this.setDamage(885.0);
        this.setAttackCount(4L);
        this.setDelayByAttackSpeed(750L);
        this.setCooldown(60.0);
        this.setDotDuration(60000L);
        this.setInterval(2000L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
