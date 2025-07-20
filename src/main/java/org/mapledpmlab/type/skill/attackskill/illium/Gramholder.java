package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Gramholder extends AttackSkill {
    public Gramholder() {
        this.setName("그람홀더");
        this.setDamage(1180.0);
        this.setDelay(210L);
        this.setAttackCount(15L);
        this.setCooldown(120.0);
        this.setDotDuration(12000L);
        this.setInterval(390L);
        this.setLimitAttackCount(29L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
