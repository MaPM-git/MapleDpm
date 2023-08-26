package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonZoneDelay extends AttackSkill {
    public PoisonZoneDelay() {
        this.setName("포이즌 리젼");
        this.setDelayByAttackSpeed(990L);
        this.setCooldown(30.0);
        this.setRelatedSkill(new PoisonZoneDot());
        this.setApplyFinalAttack(true);
    }
}
