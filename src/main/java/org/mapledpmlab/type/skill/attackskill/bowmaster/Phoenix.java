package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Phoenix extends AttackSkill {
    public Phoenix() {
        this.setName("피닉스");
        this.setAttackCount(1L);
        this.setDamage(975.0);
        this.setDelay(600L);
        this.setCooldown(220.0);
        this.setDotDuration(220000L);
        this.setInterval(3030L);
        this.setFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
