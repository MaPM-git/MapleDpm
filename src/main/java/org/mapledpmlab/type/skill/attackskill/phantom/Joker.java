package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Joker extends AttackSkill {
    public Joker() {
        this.setName("조커");
        this.setAttackCount(3L);
        this.setDamage(770.0);
        this.setDelay(6300L);
        this.setDotDuration(6300L);
        this.setInterval(45L);
        this.setLimitAttackCount(140L);
        this.setRelatedSkill(new JokerAfterDelay());
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
