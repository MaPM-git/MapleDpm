package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CreateThunderChainHugeLightning extends AttackSkill {
    public CreateThunderChainHugeLightning() {
        this.setName("창뇌연격(거대 번개)");
        this.setAttackCount(6L);
        this.setDamage(1650.0);
        this.setDotDuration(3L);
        this.setInterval(1L);
        this.setLimitAttackCount(3L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.71);          // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
    }
}
