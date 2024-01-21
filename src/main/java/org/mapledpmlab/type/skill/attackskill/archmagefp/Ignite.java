package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Ignite extends AttackSkill {
    public Ignite() {
        this.setName("이그나이트");
        this.setDamage(40.0);
        this.setAttackCount(3L);
        this.setDotDuration(6000L);
        this.setInterval(1500L);
        this.addFinalDamage(3.4);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
