package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeathTrigger extends AttackSkill {
    public DeathTrigger() {
        this.setName("데스 트리거");
        this.setDamage(715.0);
        this.setAttackCount(7L);
        this.setCooldown(45.0);
        this.setApplyFinalAttack(true);
        this.setDotDuration(360L * 4);
        this.setInterval(360L);
        this.setLimitAttackCount(4L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new DeathTriggerDelay());
    }
}
