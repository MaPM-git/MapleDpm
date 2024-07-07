package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GroundZeroBombardment extends AttackSkill {
    public GroundZeroBombardment() {
        this.setName("그라운드 제로(대규모 폭격)");
        this.setAttackCount(15L);
        this.setDamage(2888.0);
        this.setDotDuration(30000L);
        this.setInterval(1200L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
    }
}
