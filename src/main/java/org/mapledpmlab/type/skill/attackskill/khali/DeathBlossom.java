package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeathBlossom extends AttackSkill {
    public DeathBlossom() {
        this.setName("데스 블로섬");
        this.setDamage(700.0);
        this.setAttackCount(6L);
        this.setCooldown(90.0);
        this.setDelayByAttackSpeed(810L);
        this.setDotDuration(30000L);
        this.setInterval(2010L);
        this.setLimitAttackCount(14L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
