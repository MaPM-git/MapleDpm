package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RavenDelay extends AttackSkill {
    public RavenDelay() {
        this.setName("레이븐");
        this.setDelay(600L);
        this.setCooldown(220.0);
    }
}
