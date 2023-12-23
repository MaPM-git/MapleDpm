package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DrillContainerDelay extends AttackSkill {
    public DrillContainerDelay() {
        this.setName("드릴 컨테이너");
        this.setDelayByAttackSpeed(660L);
        this.setCooldown(30.0);
        this.setRelatedSkill(new DrillContainer());
    }
}
