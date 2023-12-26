package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DistortionFieldDelay extends AttackSkill {
    public DistortionFieldDelay() {
        this.setName("디스토션 필드");
        this.setDelayByAttackSpeed(900L);
    }
}
