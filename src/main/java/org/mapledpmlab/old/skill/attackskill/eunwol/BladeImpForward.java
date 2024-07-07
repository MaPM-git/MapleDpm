package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeImpForward extends AttackSkill {
    public BladeImpForward() {
        this.setName("파쇄철조-전");
        this.setDamage(110.0);
        this.setAttackCount(4L);
        this.getMultiAttackInfo().add(720L);
    }
}
