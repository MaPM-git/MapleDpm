package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JokerBeforeDelay extends AttackSkill {
    public JokerBeforeDelay() {
        this.setName("조커(선딜)");
        this.setDelayByAttackSpeed(540L);
        this.setCooldown(180.0);
        this.setRelatedSkill(new Joker());
    }
}
