package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BreakComeBack extends AttackSkill {
    public BreakComeBack() {
        this.setName("브레이크-돌아와");
        this.setDamage(330.0);
        this.setAttackCount(3L);
        this.setDotDuration(5000L);
        this.setInterval(320L);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
