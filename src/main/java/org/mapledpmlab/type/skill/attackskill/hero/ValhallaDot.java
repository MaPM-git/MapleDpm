package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ValhallaDot extends AttackSkill {
    public ValhallaDot() {
        this.setName("발할라(검격)");
        this.setAttackCount(6L);
        this.setDamage(520.0);
        this.setDotDuration(30000L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setLimitAttackCount(12L);
        this.setProp(100L);
        this.setInterval(120L);
    }
}
