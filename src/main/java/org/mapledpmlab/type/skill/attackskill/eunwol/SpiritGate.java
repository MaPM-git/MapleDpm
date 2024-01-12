package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritGate extends AttackSkill {
    public SpiritGate() {
        this.setName("귀문진");
        this.setDamage(495.0);
        this.setAttackCount(6L);
        this.setDotDuration(32040L);
        this.setInterval((1230L + 1440) / 2);   // 1335
        this.setLimitAttackCount(24L);
        this.addFinalDamage(1.6);               // 코어 강화
    }
}
