package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Lightning extends AttackSkill {
    public Lightning() {
        this.setName("신뇌합일(번개)");
        this.setAttackCount(7L * 2);
        this.setDamage(880.0);
        this.setCooldown(3.0);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(0.855);         // 축뢰
    }
}
