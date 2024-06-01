package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LifeOrDeathJavelin extends AttackSkill {
    public LifeOrDeathJavelin() {
        this.setName("생사여탈(거대 표창)");
        this.setAttackCount(35L);
        this.setDamage(1158.0);
        this.setDotDuration(60000L);
        this.setInterval(1900L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
