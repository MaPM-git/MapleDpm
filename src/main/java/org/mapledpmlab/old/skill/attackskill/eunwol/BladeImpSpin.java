package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.old.skill.buffskill.eunwol.BladeImpBuff;

public class BladeImpSpin extends AttackSkill {
    public BladeImpSpin() {
        this.setName("파쇄철조-회");
        this.setDamage(160.0);
        this.setAttackCount(4L);
        this.setDelayByAttackSpeed(630L);
        this.setRelatedSkill(new BladeImpBuff());
    }
}
