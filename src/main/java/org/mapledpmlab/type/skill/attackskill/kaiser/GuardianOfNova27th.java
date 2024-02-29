package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GuardianOfNova27th extends AttackSkill {
    public GuardianOfNova27th() {
        this.setName("가디언 오브 노바(27대)");
        this.setDamage(1950.0);
        this.setAttackCount(2L);
        this.setDotDuration(45000L);
        this.setInterval(1680L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
