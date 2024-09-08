package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Joker extends AttackSkill {
    public Joker() {
        this.setName("조커");
        this.setAttackCount(3L);
        this.setDamage(820.0);
        this.setDelay(4440L);
        this.setDotDuration(4440L);
        this.setInterval(30L);
        this.setLimitAttackCount(148L);
        this.setRelatedSkill(new JokerAfterDelay());
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
