package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Freezer extends AttackSkill {
    public Freezer() {
        this.setName("프리져");
        this.setAttackCount(3L);
        this.setDamage(480.0);
        this.setDelay(600L);
        this.setCooldown(225.0);
        this.setDotDuration(220000L);
        this.setInterval(3030L);
        this.setFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
