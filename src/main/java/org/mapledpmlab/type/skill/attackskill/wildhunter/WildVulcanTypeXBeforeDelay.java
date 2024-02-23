package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WildVulcanTypeXBeforeDelay extends AttackSkill {
    public WildVulcanTypeXBeforeDelay() {
        this.setName("와일드 발칸 Type X(선딜)");
        this.setDelay(540L);
        this.setCooldown(120.0);
        this.setRelatedSkill(new WildVulcanTypeX());
    }
}
