package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GuardianOfNova extends AttackSkill {
    public GuardianOfNova() {
        this.setName("가디언 오브 노바");
        this.setDelay(600L);
        this.setCooldown(120.0);
        this.setRelatedSkill(new GuardianOfNova6th());
    }
}
