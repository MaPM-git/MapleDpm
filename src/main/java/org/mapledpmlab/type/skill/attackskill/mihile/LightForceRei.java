package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LightForceRei extends AttackSkill {
    public LightForceRei() {
        this.setName("라이트 포스레이");
        this.setApplyFinalAttack(true);
        this.setAttackCount(12L);
        this.setDamage(2055.0);
        this.setDotDuration(690L);
        this.setInterval(115L);
        this.setLimitAttackCount(6L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new LightForceReiDelay());
    }
}
