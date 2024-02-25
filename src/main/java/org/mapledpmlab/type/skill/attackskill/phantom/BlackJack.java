package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlackJack extends AttackSkill {
    public BlackJack() {
        this.setName("블랙잭");
        this.setAttackCount(1L);
        this.setDamage(1320.0);
        this.setDotDuration(180L * 6);
        this.setInterval(60L);
        this.setLimitAttackCount(18L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
