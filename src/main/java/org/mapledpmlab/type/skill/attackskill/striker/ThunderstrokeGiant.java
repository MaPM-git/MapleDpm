package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ThunderstrokeGiant extends AttackSkill {
    public ThunderstrokeGiant() {
        this.setName("거대 벼락");
        this.setAttackCount(5L);
        this.setDamage(340.0 + 360);
        this.addFinalDamage(1.71);          // 축뢰
        this.setAddDamage(40L);
        this.addIgnoreDefenseList(20L);
    }
}
