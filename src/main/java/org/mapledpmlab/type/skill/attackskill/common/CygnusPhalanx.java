package org.mapledpmlab.type.skill.attackskill.common;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CygnusPhalanx extends AttackSkill {
    public CygnusPhalanx() {
        this.setName("시그너스 팔랑크스");
        this.setAttackCount(1L);
        this.setDamage(990.0);
        this.setCooldown(30.0);
        this.setDotDuration(30000L);
        this.setInterval(240L);
        this.setLimitAttackCount(70L);
        this.setRelatedSkill(new CygnusPhalanxDelay());
    }
}
