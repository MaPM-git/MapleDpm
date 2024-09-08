package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IdleWhimFirst extends AttackSkill {
    public IdleWhimFirst() {
        this.setName("아이들 윔(첫타)");
        this.setAttackCount(5L);
        this.setDelay(600L);
        this.setDamage(925.0);
        this.setCooldown(10.0);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new IdleWhimAfterSecond());
    }
}
