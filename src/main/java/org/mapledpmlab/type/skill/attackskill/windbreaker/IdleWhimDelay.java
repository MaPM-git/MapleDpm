package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IdleWhimDelay extends AttackSkill {
    public IdleWhimDelay() {
        this.setName("아이들 윔");
        this.setDelay(600L);
        this.setCooldown(10.0);
        this.setRelatedSkill(new IdleWhimFirst());
    }
}
