package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeathTrigger extends AttackSkill {
    public DeathTrigger() {
        this.setName("데스 트리거");
        this.setDamage(780.0);
        this.setAttackCount(7L);
        this.setApplyFinalAttack(true);
        this.setDotDuration(600L * 4);
        this.setInterval(600L);
        this.setLimitAttackCount(4L);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
