package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Smite extends AttackSkill {
    public Smite() {
        this.setName("스마이트");
        this.setAttackCount(6L);
        this.setCooldown(120.0);
        this.setDamage(500.0);
        this.setDelayByAttackSpeed(1320L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
