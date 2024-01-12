package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeathMarkDot extends AttackSkill {
    public DeathMarkDot() {
        this.setName("사혼 각인(죽음의 표식)");
        this.setDamage(255.0);
        this.setAttackCount(1L);
        this.setDotDuration(15000L);
        this.setInterval(1000L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
