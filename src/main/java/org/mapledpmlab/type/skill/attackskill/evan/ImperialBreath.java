package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ImperialBreath extends AttackSkill {
    public ImperialBreath() {
        this.setName("임페리얼 브레스");
        this.setDamage(1320.0);
        this.setAttackCount(7L);
        this.setDotDuration(5000L);
        this.setInterval(240L);
        this.setLimitAttackCount(16L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
