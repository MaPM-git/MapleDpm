package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Thunderstroke extends AttackSkill {
    public Thunderstroke() {
        this.setName("낙뢰");
        this.setAttackCount(3L * 2);
        this.setDamage(380.0);
        this.addFinalDamage(0.855);         // 축뢰
        this.setAddDamage(40L);
        this.addIgnoreDefenseList(20L);
    }
}
