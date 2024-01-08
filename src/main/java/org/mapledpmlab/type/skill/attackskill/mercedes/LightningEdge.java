package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LightningEdge extends AttackSkill {
    public LightningEdge() {
        this.setName("라이트닝 엣지");
        this.setAttackCount(3L);
        this.setDamage(425.0);
        this.setDelayByAttackSpeed(840L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
