package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Infinite extends AttackSkill {
    public Infinite() {
        this.setName("인피니트");
        this.setDamage(770.0);
        this.setAttackCount(2L);
        this.setDelay(540L);
        this.setCooldown(180.0);
        this.setDotDuration(30000L);
        this.setInterval(57L);
        this.setLimitAttackCount(526L);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
