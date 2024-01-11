package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlackJackFinal extends AttackSkill {
    public BlackJackFinal() {
        this.setName("블랙잭(막타)");
        this.setAttackCount(6L);
        this.setDamage(1760.0);
        this.setDotDuration(1L * 3);
        this.setInterval(1L);
        this.setLimitAttackCount(3L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
