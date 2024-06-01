package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IfritDot extends AttackSkill {
    public IfritDot() {
        this.setName("이프리트(도트)");
        this.setDamage(143.0);
        this.setAttackCount(1L);
        this.setInterval(1000L);
        this.setDotDuration(4000L);     // 익스트림 매직
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
