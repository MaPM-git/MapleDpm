package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WindCutterTornado extends AttackSkill {
    public WindCutterTornado() {
        this.setName("윈드 커터(소용돌이)");
        this.setAttackCount(3L);
        this.setDamage(175.0);
        this.setDotDuration(1000L);
        this.setInterval(500L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
