package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RapidThrowDelay extends AttackSkill {
    public RapidThrowDelay() {
        this.setName("래피드 스로우");
        this.setDelay(1800L);
        this.setRelatedSkill(new RapidThrowEnd());
    }
}
