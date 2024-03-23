package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Gramholder extends AttackSkill {
    public Gramholder() {
        this.setName("그람홀더");
        this.setDamage(1100.0);
        this.setDelay(210L);
        this.setAttackCount(12L);
        this.setCooldown(180.0);
        this.setDotDuration(40000L);
        this.setInterval(3030L);
        this.setLimitAttackCount(13L);
        this.addFinalDamage(1.6);   // 코어강화
        this.addFinalDamage(2.0);
    }
}
