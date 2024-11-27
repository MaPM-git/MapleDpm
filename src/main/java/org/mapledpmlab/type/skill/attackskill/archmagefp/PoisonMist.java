package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonMist extends AttackSkill {
    public PoisonMist() {
        this.setName("포이즌 미스트");
        this.setDamage(270.0);
        this.setAttackCount(1L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
