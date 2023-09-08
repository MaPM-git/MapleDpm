package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IdleWhimFirst extends AttackSkill {
    public IdleWhimFirst() {
        this.setName("아이들 윔(첫타)");
        this.setAttackCount(3L);
        this.setDamage(1210.0);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new IdleWhimAfterSecond());
    }
}
