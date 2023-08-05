package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FuryOfIfritOriginDelay extends AttackSkill {
    public FuryOfIfritOriginDelay() {
        this.setCooldown(75.0);
        this.setDelayByAttackSpeed(480L);
        this.setRelatedSkill(new FuryOfIfritOrigin());
    }
}
