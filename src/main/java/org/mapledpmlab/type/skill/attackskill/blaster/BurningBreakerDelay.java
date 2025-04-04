package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BurningBreakerDelay extends AttackSkill {
    public BurningBreakerDelay() {
        this.setName("버닝 브레이커");
        this.setDelayByAttackSpeed(900L);
        this.setRelatedSkill(new BurningBreakerRush());
        this.setCooldown(100.0);
    }
}
