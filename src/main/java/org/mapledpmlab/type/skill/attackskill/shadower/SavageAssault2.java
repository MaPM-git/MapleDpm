package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SavageAssault2 extends AttackSkill {
    public SavageAssault2() {
        this.setName("일도양단2");
        this.setAttackCount(6L);
        this.setCooldown(360.0);
        this.setDamage(7200.0);
        this.setDotDuration(1500L);
        this.setLimitAttackCount(5L);
        this.setInterval(300L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new SavageAssault3());
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
