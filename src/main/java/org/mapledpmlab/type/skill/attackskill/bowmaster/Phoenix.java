package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Phoenix extends AttackSkill {
    public Phoenix() {
        this.setName("피닉스");
        this.setAttackCount(1L);
        this.setDamage(390.0);
        this.setDotDuration(220000L);
        this.setInterval(1710L);
        this.setFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
