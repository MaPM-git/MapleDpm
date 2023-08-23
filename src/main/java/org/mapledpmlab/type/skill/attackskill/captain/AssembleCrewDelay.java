package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AssembleCrewDelay extends AttackSkill {
    public AssembleCrewDelay() {
        this.setName("어셈블 크루");
        this.setDelay(900L);
        this.setCooldown(120.0);
    }
}
