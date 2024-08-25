package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeImp extends AttackSkill {
    public BladeImp() {
        this.setName("파쇄철조");
        this.setAttackCount(4L);
        this.setDamage(155.0);
        this.setDelayByAttackSpeed(630L);
        this.addFinalDamage(4.0);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
