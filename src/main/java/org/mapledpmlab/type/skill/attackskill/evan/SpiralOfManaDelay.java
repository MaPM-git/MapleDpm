package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiralOfManaDelay extends AttackSkill {
    public SpiralOfManaDelay() {
        this.setName("스파이럴 오브 마나");
        this.setCooldown(3.5);
        this.setDelay(360L);
    }
}
