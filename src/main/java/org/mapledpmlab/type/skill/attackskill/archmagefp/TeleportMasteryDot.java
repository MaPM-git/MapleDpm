package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class TeleportMasteryDot extends DotAttackSkill {
    public TeleportMasteryDot() {
        this.setName("텔레포트 마스터리(도트)");
        this.setDamage(98.0);
        this.setAttackCount(1L);
        this.setInterval(2000L);
        this.setDotDuration(4000L * 2); // 익스트림 매직
    }
}
