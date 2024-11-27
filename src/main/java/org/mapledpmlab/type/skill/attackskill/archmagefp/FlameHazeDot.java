package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class FlameHazeDot extends DotAttackSkill {
    public FlameHazeDot() {
        this.setName("플레임 헤이즈(도트)");
        this.setDamage(325.0);
        this.setAttackCount(1L);
        this.setInterval(1000L);
        this.setDotDuration(10000L * 2);    // 익스트림 매직
        this.setRelatedSkill(new PoisonMistDot());
    }
}
