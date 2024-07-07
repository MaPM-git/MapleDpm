package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class OrderRestore extends AttackSkill {
    public OrderRestore() {
        this.setName("오더(리스토어)");
        this.setDamage(800.0);
        this.setAttackCount(2L);
        this.setCooldown(0.5);
        this.setDotDuration(30000L);
        this.setInterval(510L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyReuse(true);
    }
}
