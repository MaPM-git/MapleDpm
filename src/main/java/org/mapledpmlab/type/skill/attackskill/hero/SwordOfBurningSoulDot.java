package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SwordOfBurningSoulDot extends AttackSkill {
    public SwordOfBurningSoulDot() {
        this.setName("소드 오브 버닝 소울(영혼의 검)");
        this.setAttackCount(6L);
        this.setDamage(675.0);
        this.setDotDuration(75000L);
        this.setFinalDamage(1.6);
        this.setInterval(1000L);
    }
}
