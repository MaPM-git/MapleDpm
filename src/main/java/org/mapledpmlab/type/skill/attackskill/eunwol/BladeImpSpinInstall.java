package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeImpSpinInstall extends AttackSkill {
    public BladeImpSpinInstall() {
        this.setName("파쇄철조-회(정령집속)");
        this.setDamage(160.0);
        this.setAttackCount(1L);
        this.setDotDuration(630L);
        this.setInterval(630L / 4);
        this.setLimitAttackCount(4L);
    }
}
