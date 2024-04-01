package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MemoryOfRootBeforeDelay extends AttackSkill {
    public MemoryOfRootBeforeDelay() {
        this.setName("근원의 기억(선딜)");
        this.setDelay(360L);
        this.setCooldown(120.0);
        this.setRelatedSkill(new MemoryOfRoot());
    }
}
