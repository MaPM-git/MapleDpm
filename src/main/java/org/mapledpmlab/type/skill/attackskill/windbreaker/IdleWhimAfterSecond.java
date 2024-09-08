package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IdleWhimAfterSecond extends AttackSkill {
    public IdleWhimAfterSecond() {
        this.setName("아이들 윔(첫타 이후)");
        this.setAttackCount(5L);
        this.setDamage(925.0);
        for (int i = 0; i < 9; i++) {
            this.getMultiAttackInfo().add(0L);
        }
        this.addFinalDamage(0.85);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new IdleWhimDot());
    }
}
