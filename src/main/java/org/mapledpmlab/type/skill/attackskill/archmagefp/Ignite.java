package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Ignite extends AttackSkill {
    public Ignite() {
        this.setName("이그나이트(10중첩)");
        this.setDamage(40.0);
        this.setAttackCount(3L);
        this.setInterval(150L);         // 10중첩으로 가정
        this.addFinalDamage(3.4);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
