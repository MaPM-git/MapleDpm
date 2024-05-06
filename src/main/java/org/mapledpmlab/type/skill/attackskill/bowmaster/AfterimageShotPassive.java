package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AfterimageShotPassive extends AttackSkill {
    public AfterimageShotPassive() {
        this.setName("잔영의 시(패시브)");
        this.setAttackCount(3L);
        this.setDamage(880.0);
        //this.setApplyFinalAttack(true);
        this.setDotDuration(1000L);
        this.setInterval(180L);
        this.setFinalDamage(1.6);       // 코어강화
        this.setCooldown(1.0);
    }
}
