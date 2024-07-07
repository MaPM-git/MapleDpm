package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BoostEndHuntersTargetingBeforeDelay extends AttackSkill {
    public BoostEndHuntersTargetingBeforeDelay() {
        this.setName("부스트 엔드-헌터즈 타겟팅(선딜)");
        this.setDelayByAttackSpeed(990L);
        this.setCooldown(30.0);
        this.setRelatedSkill(new BoostEndHuntersTargeting());
    }
}
