package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class DotPunisherDot extends DotAttackSkill {
    public DotPunisherDot() {
        this.setName("도트 퍼니셔(도트)");
        this.setDamage(290.0);
        this.setAttackCount(1L);
        this.setDotDuration(16000L);    // 익스트림 매직
        this.setInterval(1000L);
        this.setRelatedSkill(new DotPunisherAfterSecond());
    }
}
