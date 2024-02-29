package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Prominence extends AttackSkill {
    public Prominence() {
        this.setName("프로미넌스");
        this.setDamage(1000.0);
        this.setAttackCount(15L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setCooldown(60.0);
    }
}
