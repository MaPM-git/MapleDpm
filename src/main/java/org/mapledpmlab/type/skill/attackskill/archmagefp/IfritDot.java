package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class IfritDot extends DotAttackSkill {
    public IfritDot() {
        this.setName("이프리트(도트)");
        this.setDamage(215.0);
        this.setAttackCount(1L);
        this.setInterval(1000L);
        this.setDotDuration(4000L);     // 익스트림 매직
    }
}
