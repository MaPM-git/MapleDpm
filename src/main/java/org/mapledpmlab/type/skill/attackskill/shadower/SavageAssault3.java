package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SavageAssault3 extends AttackSkill {
    public SavageAssault3() {
        this.setName("일도양단3");
        this.setAttackCount(7L);
        this.setCooldown(360.0);
        this.setDamage(8400.0);
        this.setDotDuration(1600L);
        this.setLimitAttackCount(8L);
        this.setInterval(200L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new SavageAssaultDelay());
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
