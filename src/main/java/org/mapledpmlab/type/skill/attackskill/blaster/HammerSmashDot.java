package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HammerSmashDot extends AttackSkill {
    public HammerSmashDot() {
        this.setName("해머 스매시(충격파)");
        this.setAttackCount(2L + 2);
        this.setDamage(150.0);
        this.setDotDuration(5000L);
        this.setInterval(1000L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
