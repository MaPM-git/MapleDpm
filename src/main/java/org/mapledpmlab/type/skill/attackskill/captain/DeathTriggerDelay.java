package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeathTriggerDelay extends AttackSkill {
    public DeathTriggerDelay() {
        this.setName("데스 트리거");
        this.setDelay(360L * 4);
    }
}
