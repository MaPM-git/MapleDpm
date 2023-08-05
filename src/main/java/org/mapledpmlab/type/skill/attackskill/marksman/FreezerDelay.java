package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FreezerDelay extends AttackSkill {
    public FreezerDelay() {
        this.setName("프리져");
        this.setDelay(600L);
        this.setCooldown(220.0);
    }
}
