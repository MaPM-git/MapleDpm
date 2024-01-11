package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DefyingFateDelay extends AttackSkill {
    public DefyingFateDelay() {
        this.setName("디파잉 페이트");
        this.setDelay(3180L);
        this.setCooldown(360.0);
        this.setRelatedSkill(new DefyingFate());
    }
}
