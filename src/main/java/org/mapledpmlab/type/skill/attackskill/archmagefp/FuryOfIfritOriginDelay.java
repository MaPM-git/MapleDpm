package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FuryOfIfritOriginDelay extends AttackSkill {
    public FuryOfIfritOriginDelay() {
        this.setName("퓨리 오브 이프리트(6차 이후)");
        this.setCooldown(75.0);
        this.setDelayByAttackSpeed(480L);
        this.setRelatedSkill(new FuryOfIfritOrigin());
    }
}
