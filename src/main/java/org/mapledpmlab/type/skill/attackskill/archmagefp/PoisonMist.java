package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonMist extends AttackSkill {
    public PoisonMist() {
        this.setName("포이즌 미스트");
        this.setDamage(301.0);              // 미스트 이럽션
        this.setAttackCount(1L);
        this.setInterval(1000L);
        this.setDotDuration(12000L * 2);    // 익스트림 매직
    }
}
