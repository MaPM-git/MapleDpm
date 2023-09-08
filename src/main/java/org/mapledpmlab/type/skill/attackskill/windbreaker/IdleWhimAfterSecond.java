package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IdleWhimAfterSecond extends AttackSkill {
    public IdleWhimAfterSecond() {
        this.setName("아이들 윔(첫타 이후)");
        this.setAttackCount(3L);
        this.setDamage(1210.0);
        this.setDotDuration(9L);
        this.setInterval(1L);
        this.setLimitAttackCount(9L);
        this.addFinalDamage(0.85);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new IdleWhimDot());
    }
}
