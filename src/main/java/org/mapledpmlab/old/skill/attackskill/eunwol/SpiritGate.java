package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.old.skill.buffskill.eunwol.SpiritGateBuff;

public class SpiritGate extends AttackSkill {
    public SpiritGate() {
        this.setName("귀문진");
        this.setDamage(495.0);
        this.setAttackCount(12L);
        this.setDelay(990L);
        this.setCooldown(60.0);
        this.setDotDuration(32040L);
        this.setInterval((1230L + 1440) / 2);   // 1335
        this.setLimitAttackCount(24L);
        this.addFinalDamage(1.6);               // 코어 강화
        this.setRelatedSkill(new SpiritGateBuff());
    }
}
