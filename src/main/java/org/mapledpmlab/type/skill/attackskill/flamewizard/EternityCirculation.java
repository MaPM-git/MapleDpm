package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EternityCirculation extends AttackSkill {
    public EternityCirculation() {
        this.setName("이터니티(순환의 불꽃)");
        this.setAttackCount(12L);
        this.setCooldown(360.0);
        this.setDamage(10800.0);
        this.setDotDuration(30000L);
        this.setInterval(1800L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new EternityDelay());
    }
}
