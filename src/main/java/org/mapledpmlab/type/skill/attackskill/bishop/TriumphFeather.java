package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TriumphFeather extends AttackSkill {
    public TriumphFeather() {
        this.setName("트라이엄프 페더");
        this.setDamage(570.0);
        this.setAttackCount(4L);
        this.setDelayByAttackSpeed(900L);
        this.setCooldown(180.0);
        this.setDotDuration(120000L);
        this.setInterval(500L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
