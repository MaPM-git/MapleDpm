package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JokerFirstDelay extends AttackSkill {
    public JokerFirstDelay() {
        this.setName("조커(선딜)");
        this.setDelayByAttackSpeed(700L);
        this.setCooldown(180.0);
        this.setRelatedSkill(new Joker());
    }
}
