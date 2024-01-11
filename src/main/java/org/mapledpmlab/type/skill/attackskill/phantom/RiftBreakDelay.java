package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RiftBreakDelay extends AttackSkill {
    public RiftBreakDelay() {
        this.setName("리프트 브레이크");
        this.setDelayByAttackSpeed(990L);
        this.setCooldown(30.0);
    }
}
