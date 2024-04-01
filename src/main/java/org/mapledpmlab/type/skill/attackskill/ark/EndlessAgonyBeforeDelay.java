package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EndlessAgonyBeforeDelay extends AttackSkill {
    public EndlessAgonyBeforeDelay() {
        this.setName("끝없는 고통(선딜)");
        this.setDelay(360L);
        this.setCooldown(60.0);
        this.setRelatedSkill(new EndlessAgony());
    }
}
