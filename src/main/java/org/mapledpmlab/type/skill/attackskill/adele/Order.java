package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Order extends AttackSkill {
    public Order() {
        this.setName("오더");
        this.setDamage(800.0);
        this.setAttackCount(2L);
        this.setCooldown(60.0);
        this.setDotDuration(60000L);
        this.setInterval(510L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyCooldownReduction(false);
    }
}
