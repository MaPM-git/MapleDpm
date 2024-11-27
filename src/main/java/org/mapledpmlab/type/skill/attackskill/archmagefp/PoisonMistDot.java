package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class PoisonMistDot extends DotAttackSkill {
    public PoisonMistDot() {
        this.setName("포이즌 미스트(도트)");
        this.setDamage(301.0);              // 미스트 이럽션
        this.setAttackCount(1L);
        this.setInterval(1000L);
        this.setDotDuration(12000L * 2);    // 익스트림 매직
        this.setRelatedSkill(new PoisonMist());
    }
}
