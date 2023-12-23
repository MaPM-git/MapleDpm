package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WildVulcanTypeXFirstDelay extends AttackSkill {
    public WildVulcanTypeXFirstDelay() {
        this.setName("와일드 발칸 Type X(선딜)");
        this.setDelay(720L);
        this.setRelatedSkill(new WildVulcanTypeX());
    }
}
