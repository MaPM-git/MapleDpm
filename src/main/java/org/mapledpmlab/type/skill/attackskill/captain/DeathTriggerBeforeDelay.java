package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeathTriggerBeforeDelay extends AttackSkill {
    public DeathTriggerBeforeDelay() {
        this.setName("데스 트리거(선딜)");
        this.setDelayByAttackSpeed(690L);
        this.setCooldown(45.0);
        this.setRelatedSkill(new DeathTriggerLoopDelay());
    }
}
