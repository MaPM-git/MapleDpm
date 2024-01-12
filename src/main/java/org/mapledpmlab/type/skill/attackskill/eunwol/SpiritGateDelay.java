package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritGateDelay extends AttackSkill {
    public SpiritGateDelay() {
        this.setName("귀문진");
        this.setDelay(990L);
        this.setCooldown(60.0);
        this.setRelatedSkill(new SpiritGate());
    }
}
