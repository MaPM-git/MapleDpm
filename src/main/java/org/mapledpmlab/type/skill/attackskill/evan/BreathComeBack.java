package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BreathComeBack extends AttackSkill {
    public BreathComeBack() {
        this.setName("브레스-돌아와");
        this.setDamage(151.0);
        this.setAttackCount(1L);
        this.setDotDuration(30000L);
        this.setInterval(450L);
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
