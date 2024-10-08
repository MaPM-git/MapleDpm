package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BreakComeBack extends AttackSkill {
    public BreakComeBack() {
        this.setName("브레이크-돌아와");
        this.setDamage(330.0);
        this.setAttackCount(3L);
        this.setDotDuration(5000L);
        this.setInterval(500L);
        this.setLimitAttackCount(9L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
