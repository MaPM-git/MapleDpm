package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Ruin extends AttackSkill {
    public Ruin() {
        this.setName("루인(소환)");
        this.setDamage(550.0);
        this.setDelayByAttackSpeed(780L);
        this.setAttackCount(6L);
        this.setDotDuration(2640L);
        this.setInterval(120L);
        this.setLimitAttackCount(12L);
        this.setCooldown(60.0);
        this.addFinalDamage(1.6);   // 코어강화
        this.setRelatedSkill(new RuinFinish());
    }
}
