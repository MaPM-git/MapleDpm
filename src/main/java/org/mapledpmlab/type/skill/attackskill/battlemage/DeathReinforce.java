package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeathReinforce extends AttackSkill {
    public DeathReinforce() {
        this.setName("데스(강화)");
        this.setDamage(1475.0);
        this.setAttackCount(14L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
