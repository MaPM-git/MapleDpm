package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonZoneDot extends AttackSkill {
    public PoisonZoneDot() {
        this.setName("포이즌 리젼(도트)");
        this.setDamage(204.0);
        this.setAttackCount(1L);
        this.setInterval(1000L);
        this.setDotDuration(10000L * 2);    // 익스트림 매직
        this.addFinalDamage(2.8);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
