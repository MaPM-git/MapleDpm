package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LifeOrDeathSlash extends AttackSkill {
    public LifeOrDeathSlash() {
        this.setName("생사여탈(참격)");
        this.setAttackCount(7L);
        this.setCooldown(360.0);
        this.setDamage(1620.0);
        this.setDotDuration(3300L);
        this.setLimitAttackCount(8L);
        this.setInterval(412L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new LifeOrDeathJavelin());
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
