package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CovertShadow extends AttackSkill {
    public CovertShadow() {
        this.setName("커버트 쉐도우");
        this.setAttackCount(2L * 2);
        this.setDamage(150.0);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.setProp(60L);
    }
}
