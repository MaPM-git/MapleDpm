package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeathTriggerLoopDelay extends AttackSkill {
    public DeathTriggerLoopDelay() {
        this.setName("데스 트리거(발사)");
        this.setDotDuration(90L * 7);
        this.setInterval(90L);
        this.setLimitAttackCount(7L);
        this.setRelatedSkill(new DeathTriggerAfterDelay());
    }
}
