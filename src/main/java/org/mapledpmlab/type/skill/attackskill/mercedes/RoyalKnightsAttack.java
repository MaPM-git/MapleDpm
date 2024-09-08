package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RoyalKnightsAttack extends AttackSkill {
    public RoyalKnightsAttack() {
        this.setName("로얄 나이츠");
        this.setAttackCount(4L);
        this.setDamage(1120.0);
        this.setDotDuration(30000L);
        this.setInterval(1400L);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
