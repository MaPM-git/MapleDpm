package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Ignite extends AttackSkill {
    public Ignite() {
        this.setName("이그나이트");
        this.setDamage(75.0);
        this.setAttackCount(3L);
        this.setDotDuration(4000L);
        this.setInterval(660L);
        this.setLimitAttackCount(3L);
        this.addFinalDamage(3.4);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
