package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MemoryOfRoot extends AttackSkill {
    public MemoryOfRoot() {
        this.setName("근원의 기억");
        this.setDamage(880.0);
        this.setAttackCount(6L);
        this.setDelay(840L);
        this.setDotDuration(840L);
        this.setInterval(210L);
        this.setLimitAttackCount(4L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setRelatedSkill(new MemoryOfRootFinish());
    }
}
