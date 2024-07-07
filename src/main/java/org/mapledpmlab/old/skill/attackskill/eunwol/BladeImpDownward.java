package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeImpDownward extends AttackSkill {
    public BladeImpDownward() {
        this.setName("파쇄철조-하");
        this.setDamage(100.0);
        this.setAttackCount(4L);
        this.getMultiAttackInfo().add(630L);
    }
}
