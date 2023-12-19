package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FuryOfIfritDelay extends AttackSkill {
    public FuryOfIfritDelay() {
        this.setName("퓨리 오브 이프리트");
        this.setCooldown(75.0);
        this.setDelay(480L);
        this.setRelatedSkill(new FuryOfIfrit());
    }
}
