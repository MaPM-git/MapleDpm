package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IdleWhimDot extends AttackSkill {
    public IdleWhimDot() {
        this.setName("아이들 윔(도트)");
        this.setAttackCount(1L);
        this.setDamage(1100.0);
        this.setDotDuration(9000L);
        this.setInterval(1000L);
        this.setLimitAttackCount(9L);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
