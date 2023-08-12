package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SavageAssault1 extends AttackSkill {
    public SavageAssault1() {
        this.setName("일도양단1");
        this.setAttackCount(6L);
        this.setCooldown(360.0);
        this.setDamage(6300.0);
        this.setDotDuration(2000L);
        this.setInterval(400L);
        this.setLimitAttackCount(5L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new SavageAssault2());
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
