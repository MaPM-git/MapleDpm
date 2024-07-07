package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RapidThrowBeforeDelay extends AttackSkill {
    public RapidThrowBeforeDelay() {
        this.setName("래피드 스로우");
        this.setDelay(240L);
        this.setCooldown(90.0);
        this.setRelatedSkill(new RapidThrow());
    }
}
