package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SuperNova extends AttackSkill {
    public SuperNova() {
        this.setName("슈퍼 노바");
        this.setDamage(600.0);
        this.setAttackCount(3L);
        this.setCooldown(60.0);
        this.setDotDuration(12600L);
        this.setInterval(900L);
        this.setLimitAttackCount(14L);
        this.setDelayByAttackSpeed(600L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
