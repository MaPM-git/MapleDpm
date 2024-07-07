package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class FireAuraDot extends DotAttackSkill {
    public FireAuraDot() {
        this.setName("파이어 오라(도트)");
        this.setDamage(500.0);
        this.setAttackCount(1L);
        this.setDotDuration(60000L);    // 익스트림 매직
        this.setInterval(1000L);
    }
}
