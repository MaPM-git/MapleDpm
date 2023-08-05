package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FireAura extends AttackSkill {
    public FireAura() {
        this.setName("파이어 오라");
        this.setDamage(400.0);
        this.setAttackCount(2L);
        this.setDotDuration(1000000000L);
        this.setInterval(3000L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
