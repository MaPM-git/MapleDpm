package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MistralSpringDelay extends AttackSkill {
    public MistralSpringDelay() {
        this.setName("미스트랄 스프링");
        this.setDelay(4560L);
        this.setRelatedSkill(new MistralSpringNormal());
    }
}
