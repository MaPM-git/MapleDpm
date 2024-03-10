package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Creation extends AttackSkill {
    public Creation(Long etherSword) {
        this.setName("크리에이션");
        this.setDamage(200.0 + 240 + 273);
        this.setAttackCount(etherSword);
        this.setCooldown(1.5);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyReuse(true);
    }
}
