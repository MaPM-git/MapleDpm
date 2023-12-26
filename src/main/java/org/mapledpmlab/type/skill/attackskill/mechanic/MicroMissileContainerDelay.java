package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MicroMissileContainerDelay extends AttackSkill {
    public MicroMissileContainerDelay() {
        this.setName("마이크로 미사일 컨테이너");
        this.setDelay(540L);
        this.setRelatedSkill(new MicroMissileContainer());
        this.setCooldown(25.0);
    }
}
