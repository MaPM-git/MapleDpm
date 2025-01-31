package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpritPunch1 extends AttackSkill {
    public SpritPunch1() {
        this.setName("천귀야참(1타)");
        this.setDelayByAttackSpeed(720L);
        this.setAttackCount(10L);
        this.setDamage(2415.0);
        this.setCooldown(20.0);
    }
}
