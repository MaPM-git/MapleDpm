package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarkSynthesis extends AttackSkill {
    public DarkSynthesis() {
        this.setName("다크 신서시스");
        this.setDamage(750.0 + 307);
        this.setAttackCount(12L);
        this.setCooldown(10.0);
        this.addFinalDamage(2.2);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(60L);
        this.setAddDamage(30L);
    }
}
