package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AfterimageShotActive extends AttackSkill {
    public AfterimageShotActive() {
        this.setName("잔영의 시");
        this.setAttackCount(3L);
        this.setCooldown(120.0);
        this.setDamage(880.0);
        this.setApplyFinalAttack(true);
        this.setDotDuration(30000L);
        this.setInterval(180L);
        this.setFinalDamage(1.6);       // 코어강화
    }
}
