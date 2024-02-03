package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SonicBlowBeforeDelay extends AttackSkill {
    public SonicBlowBeforeDelay() {
        this.setName("소닉 블로우(선딜)");
        this.setDelay(780L);
        this.setCooldown(45.0);
        this.setRelatedSkill(new SonicBlow());
    }
}
