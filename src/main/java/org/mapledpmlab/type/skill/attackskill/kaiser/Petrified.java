package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Petrified extends AttackSkill {
    public Petrified() {
        this.setName("페트리파이드");
        this.setDamage(400.0);
        this.setAttackCount(1L);
        this.setDelayByAttackSpeed(450L);
        this.setCooldown(60.0);
        this.setDotDuration(60000L);
        this.setInterval(3000L);
        this.addFinalDamage(2.8);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
