package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class FlameSweepDot extends DotAttackSkill {
    public FlameSweepDot() {
        this.setName("플레임 스윕(도트)");
        this.setDamage(435.0);
        this.setAttackCount(1L);
        this.setDotDuration(10000L);    // 익스트림 매직
        this.setInterval(1000L);
        this.setAddDamage(10L);         // 플레임 스윕-리인포스
    }
}
