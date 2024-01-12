package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeathMark extends AttackSkill {
    public DeathMark() {
        this.setName("사혼 각인");
        this.setDamage(715.0);
        this.setAttackCount(1L);
        this.setDotDuration(720L);
        this.setInterval(720L / 3);
        this.setLimitAttackCount(3L);
        this.setRelatedSkill(new DeathMarkDot());
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
