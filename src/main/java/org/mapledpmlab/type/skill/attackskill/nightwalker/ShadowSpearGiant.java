package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShadowSpearGiant extends AttackSkill {
    public ShadowSpearGiant() {
        this.setName("쉐도우 스피어(거대한 창)");
        this.setAttackCount(6L);
        this.setDamage(880.0);
        this.setCooldown(3.9);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
