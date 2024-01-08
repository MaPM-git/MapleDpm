package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiberationOrbActive extends AttackSkill {
    public LiberationOrbActive() {
        this.setName("리버레이션 오브(액티브)");
        this.setDamage(1430.0 + 165 * 7);
        this.setAttackCount(10L);
        this.setCooldown(0.9);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
