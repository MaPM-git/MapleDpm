package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Thunderstroke extends AttackSkill {
    public Thunderstroke() {
        this.setName("낙뢰");
        this.setAttackCount(3L);
        this.setDamage(190.0);
        this.addFinalDamage(1.71);          // 축뢰
    }
}
