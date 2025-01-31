package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CovertShadowEdge extends AttackSkill {
    public CovertShadowEdge() {
        this.setName("쉐도우 엣지");
        this.setAttackCount(4L * 2);
        this.setDamage(160.0);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.setProp(100L);
    }
}
