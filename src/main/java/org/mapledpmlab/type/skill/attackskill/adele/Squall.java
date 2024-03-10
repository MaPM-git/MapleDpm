package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Squall extends AttackSkill {
    public Squall() {
        this.setName("스콜");
        this.setDamage(1000.0);
        this.setAttackCount(12L);
        this.setCooldown(180.0);
        this.setDelayByAttackSpeed(900L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
